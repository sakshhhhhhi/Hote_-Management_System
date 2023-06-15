package hotel_management;

import java.awt.Color;

import javax.swing.*;


public class Reception extends JFrame{

	Reception() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JButton newCustomer =new JButton("New Customer Form");
		newCustomer.setBounds(10, 30, 200, 30);
		newCustomer.setBackground(Color.black);
		newCustomer.setForeground(Color.white);
		add(newCustomer);
		
		JButton rooms =new JButton("Rooms");
		rooms.setBounds(10, 70, 200, 30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		add(rooms);
		
		JButton Department =new JButton("Department");
		Department.setBounds(10, 110, 200, 30);
		Department.setBackground(Color.black);
		Department.setForeground(Color.white);
		add(Department);
		
		JButton allEmployee =new JButton("Employee Info");
		allEmployee.setBounds(10, 150, 200, 30);
		allEmployee.setBackground(Color.black);
		allEmployee.setForeground(Color.white);
		add(allEmployee);
		
		JButton customer =new JButton("Customer Info");
		customer.setBounds(10, 190, 200, 30);
		customer.setBackground(Color.black);
		customer.setForeground(Color.white);
		add(customer);
		
		JButton managerInfo =new JButton("Manager Info");
		managerInfo.setBounds(10, 230, 200, 30);
		managerInfo.setBackground(Color.black);
		managerInfo.setForeground(Color.white);
		add(managerInfo);
		
		JButton checkout =new JButton("Checkout");
		checkout.setBounds(10, 270, 200, 30);
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		add(checkout);
		
		JButton update =new JButton("Update Status");
		update.setBounds(10, 310, 200, 30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		
		JButton roomStatus =new JButton("Update Room Status");
		roomStatus.setBounds(10, 350, 200, 30);
		roomStatus.setBackground(Color.black);
		roomStatus.setForeground(Color.white);
		add(roomStatus);
		
		JButton pickup =new JButton("Pick-Up Service");
		pickup.setBounds(10, 390, 200, 30);
		pickup.setBackground(Color.black);
		pickup.setForeground(Color.white);
		add(pickup);
		
		JButton searchRoom =new JButton("Search Room");
		searchRoom.setBounds(10, 430, 200, 30);
		searchRoom.setBackground(Color.black);
		searchRoom.setForeground(Color.white);
		add(searchRoom);
		
		JButton logout =new JButton("Logout");
		logout.setBounds(10, 470, 200, 30);
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		add(logout);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel2345.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(250,85,500,296);
		add(image);
		
		
		setBounds(350,200,800,570);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Reception();

	}

}
