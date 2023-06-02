package hotel_management;
import javax.swing.*;
import java.awt.*;

public class DashBoard extends JFrame {
	

	public DashBoard() {
		setBounds(0,0, 1550, 1000);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel.jpg"));
		Image i2 =i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550, 1000);
		add(image);
		JLabel text = new JLabel (" THE KUMAR GROUP WELCOMES YOU");
		text.setBounds(350, 80, 1000, 50);
		text.setFont(new Font("Monospaced",Font.BOLD,46));
		text.setForeground(Color.black);
		image.add(text);
		
		JMenuBar mb =new JMenuBar();
		mb.setBounds(0,0,1550,30);
		image.add(mb);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setFont(new Font("Monospaced",Font.BOLD,15));
		mb.add(hotel);
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new DashBoard();

	}

}
