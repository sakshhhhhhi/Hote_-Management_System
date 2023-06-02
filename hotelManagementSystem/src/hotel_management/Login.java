package hotel_management;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class Login extends JFrame implements ActionListener {
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	

	public Login() {
		getContentPane().setBackground(Color.orange);
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40, 20, 100, 30);
		add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 70, 100, 30);
		add(pass);
		
		username = new JTextField();
		username.setBounds(150, 20, 100, 30);
		add(username);
		
		password = new JPasswordField();
		password.setBounds(150, 70, 100, 30);
		add(password);
		
		login = new JButton("Login");
		login.setBounds(40, 150, 120, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 150, 120, 30);
		cancel.setBackground(Color.red);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
 //    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/HotelManagement/icons/login2.png"));
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/login3.png"));
		
//		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
//     	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i1);
		image.setBounds(350,20,200,200);
		add(image);
		
		setBounds(500,200,600,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) {
			String user=username.getText();
			String pass=password.getText();
			
			try {
				Conn c = new Conn();
				String query ="select * from login where username = '"+ user + "'and password = '"+pass+ "'";
				
				ResultSet rs = c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new DashBoard();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					setVisible(false);
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(ae.getSource()== cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Login();

	}

}
