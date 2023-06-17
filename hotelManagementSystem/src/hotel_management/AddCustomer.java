package hotel_management;

import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	JComboBox comboid;
	JTextField tfnumber,tfname,tfcountry,tfdeposit;
	JRadioButton rmale,rfemale; 
	Choice croom;
	JLabel checkintime;
	JButton add,back;
	

    AddCustomer() {
    	getContentPane().setBackground(Color.white);
    	setLayout(null);
    	
    	JLabel text = new JLabel("NEW CUSTOMER FORM");
    	text.setBounds(100, 20, 300, 30);
    	text.setFont(new Font("Tahoma",Font.PLAIN,20));
    	add(text);
    	
    	JLabel lblid = new JLabel("ID Type");
    	lblid.setBounds(35, 80, 100, 25);
    	lblid.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lblid);
    	
    	String options[]= {"Select","Aadhar Card","Passport","Driving License","Voter-id Card","PAN Card"};
    	comboid =new JComboBox(options);
    	comboid.setBounds(200, 80, 150, 25);
    	comboid.setBackground(Color.white);
    	add(comboid);
    	
    	JLabel lblnumber = new JLabel("Number");
    	lblnumber.setBounds(35, 120, 100, 20);
    	lblnumber.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lblnumber);
    	
    	tfnumber = new JTextField();
    	tfnumber.setBounds(200,120,150,25);
    	add(tfnumber);
    	
    	JLabel lblname = new JLabel("Name");
    	lblname.setBounds(35, 160, 100, 20);
    	lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lblname);
    	
    	tfname = new JTextField();
    	tfname.setBounds(200,160,150,25);
    	add(tfname);
    	
    	JLabel lblgender = new JLabel("Gender");
    	lblgender.setBounds(35, 200, 100, 20);
    	lblgender.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lblgender);
    	
    	rmale =new JRadioButton("Male");
    	rmale.setBackground(Color.white);
    	rmale.setBounds(200,200,60,25);
    	add(rmale);
    	
    	rfemale =new JRadioButton("Female");
    	rfemale.setBackground(Color.white);
    	rfemale.setBounds(270,200,100,25);
    	add(rfemale);
    	
    	JLabel lblcountry = new JLabel("Country");
    	lblcountry.setBounds(35, 240, 100, 20);
    	lblcountry.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lblcountry);
    	
    	tfcountry = new JTextField();
    	tfcountry.setBounds(200,240,150,25);
    	add(tfcountry);
    	
    	JLabel lblroom = new JLabel("Room Number");
    	lblroom.setBounds(35, 280, 150, 20);
    	lblroom.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lblroom);
    	
    	croom =new Choice();
    	
    	try {
    		Conn conn = new Conn();
    		String query ="Select * from room where availability ='Available' ";
    		ResultSet rs =conn.s.executeQuery(query);
    		while(rs.next()) {
    			croom.add(rs.getString("roomnumber"));
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	croom.setBounds(200,280,150,25);
    	add(croom);
    	
    	JLabel lbltime = new JLabel("Check-in Time");
    	lbltime.setBounds(35, 320, 150, 20);
    	lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lbltime);
    	
    	Date date = new Date();
    	
    	checkintime = new JLabel(""+ date);
    	checkintime.setBounds(200, 320, 150, 25);
    	checkintime.setFont(new Font("Tahoma",Font.BOLD,13));
    	add(checkintime);
    	
    	JLabel lbldeposit = new JLabel("Deposit");
    	lbldeposit.setBounds(35, 360, 150, 20);
    	lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,18));
    	add(lbldeposit);
    	
    	tfdeposit = new JTextField();
    	tfdeposit.setBounds(200,360,150,25);
    	add(tfdeposit);
    	
    	add = new JButton("ADD");
    	add.setBackground(Color.black);
    	add.setForeground(Color.white);
    	add.addActionListener(this);
    	add.setBounds(50,410,120,30);
    	
    	add(add);
    	
    	back = new JButton("BACK");
    	back.setBackground(Color.black);
    	back.setForeground(Color.white);
    	back.setBounds(200,410,120,30);
    	back.addActionListener(this);
    	add(back);
    	
    	ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel23456.png"));
		JLabel image =new JLabel(i1);
		image.setBounds(400,130,300,200);
		add(image);

    	
		setBounds(350,200,800,500);
		setVisible(true);
	}
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()== add) {
    		String id = (String) comboid.getSelectedItem();
    		String number =tfnumber.getText();
    		String name =tfname.getText();
    		String gender =null;
    		if(rmale.isSelected()) {
    			gender="Male";
    		}
    		else {
    			gender="Female";
    		}
    		String country =tfcountry.getText();
    		String room =croom.getSelectedItem();
    		String time =checkintime.getText();
    		String deposit =tfdeposit.getText();
    		try {
    			String query ="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
    		    String query2="update room set availability ='Occupied' where roomnumber ='"+room+"'";
    		    Conn conn = new Conn();
    		    conn.s.executeUpdate(query);
    		    conn.s.executeUpdate(query2);
    		    
    		    JOptionPane.showMessageDialog(null, "New Customer Added Sucessfully");
    		    
    		    setVisible(false);
    		    new Reception();
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	else if(ae.getSource()==back) {
    		setVisible(false);
		    new Reception();
    	}
    }

	public static void main(String[] args) {
		new AddCustomer();

	}

}
