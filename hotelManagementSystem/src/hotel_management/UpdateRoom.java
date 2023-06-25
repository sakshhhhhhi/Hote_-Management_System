package hotel_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom  extends JFrame implements ActionListener{
	Choice ccustomer;
	JTextField tfroom,tfavailability,tfstatus;
	JButton check,update,back;
	UpdateRoom(){
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("UPDATE ROOM STATUS ");
		text.setFont(new Font("Tahoma",Font.PLAIN,25));
		text.setBounds(200,20,400,30);
		text.setForeground(Color.black);
		add(text);
		
		JLabel lblid = new JLabel("Customer id");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200,80,150,25);
		add(ccustomer);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from customer");
			while(rs.next()) {
				ccustomer.add(rs.getString("number"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblroom = new JLabel("Room No");
		lblroom.setBounds(30,130,100,20);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,130,150,25);
		add(tfroom);
		
		JLabel lblname = new JLabel("Availibilty");
		lblname.setBounds(30,180,100,20);
		add(lblname);
		
		tfavailability = new JTextField();
		tfavailability.setBounds(200,180,150,25);
		add(tfavailability);
		
		
		JLabel lblcheckin = new JLabel("Clean Status");
		lblcheckin.setBounds(30,230,100,20);
		add(lblcheckin);
		
		tfstatus = new JTextField();
		tfstatus.setBounds(200,230,150,25);
		add(tfstatus);
		
		
		check = new JButton("CHECK");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setBounds(30,300,100,30);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("UPDATE");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setBounds(150,300,100,30);
		update.addActionListener(this);
		add(update);
		
		
		
		back = new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(270,300,100,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel6.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(400,70,280,200);
		add(image);
		
		setBounds(300,200,700,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== check ) {
			String id =ccustomer.getSelectedItem();
			String query = "Select * from customer where number ='"+id+"'";
			try {
				Conn c = new Conn();
				ResultSet rs =c.s.executeQuery(query);
				while(rs.next()) {
					tfroom.setText(rs.getString("room"));
						
				}
				
				ResultSet rs2=c.s.executeQuery("Select * from room where roomnumber = '"+tfroom.getText()+"'");
				while(rs2.next()) {
					tfavailability.setText(rs2.getString("availability"));
					tfstatus.setText(rs2.getString("cleaning_status"));
				}
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			
		}
		else if(ae.getSource()==update) {
			String number =ccustomer.getSelectedItem();
			String room =tfroom.getText();
			String available =tfavailability.getText();
			String status =tfstatus.getText();
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate("Update room set availability ='"+available+"',cleaning_status ='"+status+"'where roomnumber='"+room+"'");
				
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				
				setVisible(false);
				new Reception();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else{
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[]args) {
		new UpdateRoom();
	}

}

