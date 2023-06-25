package hotel_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class Checkout extends JFrame implements ActionListener{
	Choice ccustomer;
	JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
	JButton checkout,back;
	Checkout(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("CHECK-OUT");
		text.setBounds(130,20,150,30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		add(text);
		
		JLabel lblid = new JLabel("Customer id");
		lblid.setBounds(30,80,100,30);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200,86,150,25);
		add(ccustomer);
		
		
		
		JLabel lblroom = new JLabel("Room No");
		lblroom.setBounds(30,130,100,30);
		add(lblroom);
		
		lblroomnumber = new JLabel();
		lblroomnumber.setBounds(200,130,100,30);
		add(lblroomnumber);
		
		JLabel lblcheckin = new JLabel("Check-in Time");
		lblcheckin.setBounds(30,180,100,30);
		add(lblcheckin);
		
		lblcheckintime = new JLabel();
		lblcheckintime.setBounds(200,180,140,30);
		add(lblcheckintime);
		
		JLabel lblcheckout = new JLabel("Check-out Time");
		lblcheckout.setBounds(30,230,100,30);
		add(lblcheckout);
		
		Date date =new Date();
		lblcheckouttime = new JLabel(""+date);
		lblcheckouttime.setBounds(200,230,140,30);
		add(lblcheckouttime);
		
		checkout = new JButton("SUBMIT");
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.setBounds(50,280,120,30);
		checkout.addActionListener(this);
		add(checkout);
		
		back = new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(180,280,120,30);
		back.addActionListener(this);
		add(back);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from customer");
			while(rs.next()) {
				ccustomer.add(rs.getString("number"));
				lblroomnumber.setText(rs.getString("number"));
				lblcheckintime.setText(rs.getString("checkintime"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		setBounds(600,200,380,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==checkout) {
			String query ="delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
			String query2="update room set availability ='Available' where roomnumber='"+lblroomnumber.getText()+"'";
			try {
				Conn c = new Conn ();
				c.s.executeUpdate(query);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "Checkout done");
				setVisible(false);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new Reception();
		}
	}
	
	
	public static void main(String[]args) {
		new Checkout();
	}

}

