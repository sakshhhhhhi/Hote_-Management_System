package hotel_management;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
	JButton add,cancel;
	JTextField tfprice,tfroom;
	JComboBox typecombo,availablecombo,cleancombo;

	public AddRooms() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel heading = new JLabel("ADD ROOMS");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,18);
		add(heading);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblroomno.setBounds(60,80,150,18);
		add(lblroomno);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,82,150,22);
		add(tfroom);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblavailable.setBounds(60,130,150,18);
		add(lblavailable);
		
		String availableOptions[]= {"Select","Available","Occupied"};
		availablecombo = new JComboBox(availableOptions);
		availablecombo.setBounds(200,130,150,24);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		JLabel lblclean = new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblclean.setBounds(60,180,150,20);
		add(lblclean);
		
		String cleanOptions[]= {"Select","Dirty","Clean"};
		cleancombo = new JComboBox(cleanOptions);
		cleancombo.setBounds(200,180,150,24);
		cleancombo.setBackground(Color.white);
		add(cleancombo);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblprice.setBounds(60,230,150,20);
		add(lblprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(200,230,150,22);
		add(tfprice);
		
		JLabel lbltype = new JLabel("Bed Type");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
		lbltype.setBounds(60,280,150,20);
		add(lbltype);
		
		String bedOptions[]= {"Select","Single Bed","Double Bed"};
		typecombo = new JComboBox(bedOptions);
		typecombo.setBounds(200,280,150,24);
		typecombo.setBackground(Color.white);
		add(typecombo);
		
		add = new JButton("Add Room");
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(220,350,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel4.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(400,45,380,300);
		add(image);
			
		setBounds(330,200,840,470);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== add) {
			String roomnumber=tfroom.getText();
			String availability= (String) availablecombo.getSelectedItem();
			String status= (String) cleancombo.getSelectedItem();
			String price =tfprice.getText();
			String type =(String)typecombo.getSelectedItem();
			try {
				Conn conn =new Conn();
				String str ="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
				 conn.s.executeUpdate(str);
				 
				 JOptionPane.showMessageDialog(null, "New Room Added Successfully");
				 setVisible(false);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new AddRooms();

	}

}
