package hotel_management;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {
	JTable table;
	JButton back,submit;
	Choice typeofcar;
	JCheckBox available;

	PickUp() {
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text =new JLabel("PICK-UP SERVICE");
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setBounds(400,30,200,30);
		add(text);
		
		JLabel lblbed = new JLabel ("Car Type");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		typeofcar = new Choice();
		typeofcar.setBounds(150,100,200,25);
		add(typeofcar);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from drivers");
			while(rs.next()) {
				typeofcar.add(rs.getString("car_model"));
			}
			
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
		
		available = new JCheckBox("Only display Available Cars");
		available.setBounds(650,100,200,25);
		available.setBackground(Color.WHITE);
		add(available);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(10,160,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(155,160,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(295,160,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Car Company");
		l4.setBounds(440,160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Car Model");
		l5.setBounds(580,160,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Availability");
		l6.setBounds(725,160,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Destination");
		l7.setBounds(865,160,100,20);
		add(l7);
		
		table=new JTable();
		table.setBounds(10,200,1000,300);
		add(table);
		
		try {
			Conn c =new Conn();
			ResultSet rs = c.s.executeQuery("Select * from drivers");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		submit.setBounds(300,520,120,30);
		add(submit);
		
		
		back = new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(500,520,120,30);
		add(back);
		
		
		setBounds(300,200,1000,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			try {
				String query1 ="select * from drivers where car_model= '"+typeofcar.getSelectedItem()+"'";
				String query2 ="select * from drivers where availability='Available'AND car_model ='"+typeofcar.getSelectedItem()+"'";
				Conn conn = new Conn();
				ResultSet rs ;
				if(available.isSelected()) {
					rs =conn.s.executeQuery(query2);
				}
				else {
					rs =conn.s.executeQuery(query1);
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));
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

	public static void main(String[] args) {
		new PickUp();

	}
}