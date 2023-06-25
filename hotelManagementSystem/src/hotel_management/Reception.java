package hotel_management;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;


public class Reception extends JFrame implements ActionListener{
	JButton newCustomer,rooms , Department, allEmployee,managerInfo, customer,searchRoom,update,roomStatus,pickup,checkout,logout;

	Reception() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		newCustomer =new JButton("New Customer Form");
		newCustomer.setBounds(10, 30, 200, 30);
		newCustomer.setBackground(Color.black);
		newCustomer.setForeground(Color.white);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		rooms =new JButton("Rooms");
		rooms.setBounds(10, 70, 200, 30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);
		
		Department =new JButton("Department");
		Department.setBounds(10, 110, 200, 30);
		Department.setBackground(Color.black);
		Department.setForeground(Color.white);
		Department.addActionListener(this);
		add(Department);
		
		allEmployee =new JButton("Employee Info");
		allEmployee.setBounds(10, 150, 200, 30);
		allEmployee.setBackground(Color.black);
		allEmployee.setForeground(Color.white);
		allEmployee.addActionListener(this);
		add(allEmployee);
		
		customer =new JButton("Customer Info");
		customer.setBounds(10, 190, 200, 30);
		customer.setBackground(Color.black);
		customer.setForeground(Color.white);
		customer.addActionListener(this);
		add(customer);
		
		managerInfo =new JButton("Manager Info");
		managerInfo.setBounds(10, 230, 200, 30);
		managerInfo.setBackground(Color.black);
		managerInfo.setForeground(Color.white);
		managerInfo.addActionListener(this);
		add(managerInfo);
		
		checkout =new JButton("Checkout");
		checkout.setBounds(10, 270, 200, 30);
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		
		update =new JButton("Update Status");
		update.setBounds(10, 310, 200, 30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		roomStatus =new JButton("Update Room Status");
		roomStatus.setBounds(10, 350, 200, 30);
		roomStatus.setBackground(Color.black);
		roomStatus.setForeground(Color.white);
		roomStatus.addActionListener(this);
		add(roomStatus);
		
		pickup =new JButton("Pick-Up Service");
		pickup.setBounds(10, 390, 200, 30);
		pickup.setBackground(Color.black);
		pickup.setForeground(Color.white);
		pickup.addActionListener(this);
		add(pickup);
		
		searchRoom =new JButton("Search Room");
		searchRoom.setBounds(10, 430, 200, 30);
		searchRoom.setBackground(Color.black);
		searchRoom.setForeground(Color.white);
		searchRoom.addActionListener(this);
		add(searchRoom);
		
		logout =new JButton("Logout");
		logout.setBounds(10, 470, 200, 30);
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel2345.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(250,85,500,296);
		add(image);
		
		
		setBounds(350,200,800,570);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==newCustomer) {
			setVisible(false);
			new AddCustomer();
		}
		else if(ae.getSource()==rooms) {
			setVisible(false);
			new Room();
		}
		else if(ae.getSource()==Department) {
			setVisible(false);
			new Department();
		}
		else if(ae.getSource()==allEmployee) {
			setVisible(false);
			new EmployeeInfo();
		}
		else if(ae.getSource()==managerInfo) {
			setVisible(false);
			new ManagerInfo();
		}
		else if(ae.getSource()==customer) {
			setVisible(false);
			new CustomerInfo();
		}
		else if (ae.getSource()==searchRoom) {
			setVisible(false);
			new SearchRoom();
		}
		else if (ae.getSource()==update) {
			setVisible(false);
			new UpdateCheck();
		}
		else if (ae.getSource()==roomStatus) {
			setVisible(false);
			new UpdateRoom();
		}
		else if (ae.getSource()==pickup) {
			setVisible(false);
			new PickUp();
		}
		else if (ae.getSource()==checkout) {
			setVisible(false);
        	new Checkout();
		}
		else if (ae.getSource()==logout) {
			setVisible(false);
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Reception();

	}

}
