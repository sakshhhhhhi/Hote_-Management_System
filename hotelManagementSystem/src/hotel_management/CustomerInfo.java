package hotel_management;


	import javax.swing.*;

	import net.proteanit.sql.DbUtils;

	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;
	import src.net.proteanit.sql.*;


	public class CustomerInfo extends JFrame implements ActionListener {
		JTable table;
		JButton back;

		CustomerInfo() {
			
			getContentPane().setBackground(Color.white);
			setLayout(null);
			
			JLabel l1 = new JLabel("Document Type");
			l1.setBounds(0,10,100,20);
			add(l1);
			
			JLabel l2 = new JLabel("Number");
			l2.setBounds(125,10,100,20);
			add(l2);
			
			JLabel l3 = new JLabel("Name");
			l3.setBounds(250,10,100,20);
			add(l3);
			
			JLabel l4 = new JLabel("Gender");
			l4.setBounds(375,10,100,20);
			add(l4);
			
			JLabel l5 = new JLabel("Country");
			l5.setBounds(500,10,100,20);
			add(l5);
			
			JLabel l6 = new JLabel("Room No.");
			l6.setBounds(625,10,100,20);
			add(l6);
			
			JLabel l7 = new JLabel("Check-in time");
			l7.setBounds(750,10,100,20);
			add(l7);
			
			JLabel l8 = new JLabel("Deposit");
			l8.setBounds(875,10,100,20);
			add(l8);
			
			
			
			table=new JTable();
			table.setBounds(0,40,1000,400);
			add(table);
			
			try {
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery("Select * from customer");
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			back = new JButton("BACK");
			back.setBackground(Color.black);
			back.setForeground(Color.white);
			back.addActionListener(this);
			back.setBounds(420,500,120,30);
			add(back);
			
			
			setBounds(300,200,1000,600);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new Reception();
			
		}

		public static void main(String[] args) {
			new CustomerInfo();

		}

	}
