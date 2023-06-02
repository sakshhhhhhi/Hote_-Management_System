package hotel_management;
import javax.swing.*; 

import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

	public HotelManagementSystem() {
//		setSize(1366,768);
//		setLocation(100,100);
		setBounds(0,0,1366,768);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel3.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1366, 768);
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430, 1000, 500);
		text.setForeground(Color.orange);
		text.setFont(new Font("canva sans",Font.BOLD,50));
        // Applying the border to the label
		image.add(text);
		
		JButton next = new JButton("NEXT");
		next.setBounds(1150, 650, 150, 50);
		next.setBackground(Color.orange);
		next.setFont(new Font("Monospaced",Font.BOLD,30));
//		next.setBackground(Color.WHITE);
//		next.setForeground(Color.BLACK);
        next.addActionListener(this);
		   image.add(next);
		
		
		
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			text.setVisible(true);
		
		try {
			Thread.sleep(500);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
		
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
		
	}

	public static void main(String[] args) {
		new HotelManagementSystem();
	

	}

}
