package hotel_management;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class AddDrivers extends JFrame implements ActionListener{
	JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
	JComboBox gendercombo,availablecombo;
	JButton add,cancel;

	public AddDrivers() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel heading = new JLabel("ADD DRIVERS");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,18);
		add(heading);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblname.setBounds(60,80,150,24);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200,82,150,24);
		add(tfname);
		
		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblage.setBounds(60,130,150,24);
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(200,130,150,24);
		add(tfage);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblgender.setBounds(60,180,150,24);
		add(lblgender);
		
		String GenderOptions[]= {"Select","Female","Male"};
		gendercombo = new JComboBox(GenderOptions);
		gendercombo.setFont(new Font("Tahoma",Font.PLAIN,16));
		gendercombo.setBackground(Color.white);
		gendercombo.setBounds(200, 180, 150, 24);
		add(gendercombo);
		
		JLabel lblcompany = new JLabel("Car Company");
		lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcompany.setBounds(60,230,150,24);
		add(lblcompany);
		
		tfcompany = new JTextField();
		tfcompany.setBounds(200,230,150,24);
		add(tfcompany);
		
		JLabel lblmodel = new JLabel("Car Model");
		lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblmodel.setBounds(60,280,150,24);
		add(lblmodel);
		
		tfmodel = new JTextField();
		tfmodel.setBounds(200,280,150,24);
		add(tfmodel);
		
		
	
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblavailable.setBounds(60,330,150,24);
		add(lblavailable );
		
		String availableOptions[]= {"Select","Available","Occupied"};
		availablecombo = new JComboBox(availableOptions);
		availablecombo.setFont(new Font("Tahoma",Font.PLAIN,16));
		availablecombo.setBackground(Color.white);
		availablecombo.setBounds(200, 330, 150, 24);
		add(availablecombo);
		
		JLabel lbllocation = new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbllocation.setBounds(60,380,150,24);

		add(lbllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(200,380,150,24);
		add(tflocation);
		
		add = new JButton("Add Driver");
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(60,440,130,30);
		add.addActionListener(this);
		add(add);
		
		cancel = new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(220,440,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel5.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(400,100,380,300);
		add(image);
		
		setBounds(330,200,840,540);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		
			if(ae.getSource()==add) {
				
				String name =tfname.getText();
				String age =tfage.getText();
				String gender =(String) gendercombo.getSelectedItem();
				String car_company = tfcompany.getText();
				String car_model =tfmodel.getText();
				String availability=(String)availablecombo.getSelectedItem();
				String location = tflocation.getText();
				try {
					Conn conn =new Conn();
					String str ="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+car_company+"','"+car_model+"','"+availability+"','"+location+"')";
					conn.s.executeUpdate(str);
					 
					 JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
					 setVisible(false);
			}
			
			
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new AddDrivers();

	}

}
