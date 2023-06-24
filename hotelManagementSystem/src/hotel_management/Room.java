package hotel_management;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import src.net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener {
	JTable table;
	JButton back;

	Room() {
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel21.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(500,45,600,450);
		add(image);
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(0,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availability");
		l2.setBounds(100,10,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(200,10,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(300,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(400,10,100,20);
		add(l5);
		
		table=new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		
		try {
			Conn c =new Conn();
			ResultSet rs = c.s.executeQuery("Select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		back = new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(180,500,120,30);
		add(back);
		
		
		setBounds(300,200,1050,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
		
	}

	public static void main(String[] args) {
		new Room();

	}

}
