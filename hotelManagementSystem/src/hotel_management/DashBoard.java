package hotel_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener{
	

	public DashBoard() {
		setBounds(0,0, 1550, 1000);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel23.jpg"));
		Image i2 =i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550, 1000);
		add(image);
		JLabel text = new JLabel (" THE KUMAR GROUP WELCOMES YOU");
		text.setBounds(350, 80, 1000, 50);
		text.setFont(new Font("Monospaced",Font.BOLD,46));
		text.setForeground(Color.white);
		image.add(text);
		
		JMenuBar mb =new JMenuBar();
		mb.setBounds(0,0,1550,30);
		image.add(mb);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setFont(new Font("Monospaced",Font.BOLD,15));
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.red);
		admin.setFont(new Font("Monospaced",Font.BOLD,15));
		mb.add(admin);
		
		JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		addrooms.addActionListener(this);
		admin.add(addrooms);
		
		JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
		adddrivers.addActionListener(this);
		admin.add(adddrivers);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new Addemployees();
		}
		else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDrivers();
		}
		else if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
	}

	public static void main(String[] args) {
		new DashBoard();

	}

}
