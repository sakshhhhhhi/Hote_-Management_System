package hotel_management;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class Addemployees extends JFrame implements ActionListener{
	JTextField tfname,tfphone,tfage,tfsalary,tfemail,tfaadhar;
	JRadioButton rbmale,rbfemale;
	JButton submit;
	JComboBox cbjob;

	public Addemployees() {
		setLayout(null);
		
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60, 30, 120, 30);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblname);
		
		tfname =new JTextField();
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60, 80, 120, 30);
		lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblage);
		
		tfage =new JTextField();
		tfage.setBounds(200,80,150,30);
		add(tfage);
		
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(60, 130, 120, 30);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200,130,70,30);
		rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbmale.setBackground(Color.white);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280,130,120,30);
		rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbfemale.setBackground(Color.white);
		add(rbfemale);
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60, 180, 120, 30);
		lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lbljob);
		
		String str[]= {"Select","Front Desk","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountants"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200,180,150,30);
		cbjob.setBackground(Color.white);
		add(cbjob);
		
		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(60, 230, 120, 30);
		lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblsalary);
		
		tfsalary =new JTextField();
		tfsalary.setBounds(200,230,150,30);
		add(tfsalary);
		
		JLabel lblphone = new JLabel("PHONE");
		lblphone.setBounds(60, 280, 120, 30);
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblphone);
		
		tfphone =new JTextField();
		tfphone.setBounds(200,280,150,30);
		add(tfphone);
		
		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(60, 330, 120, 30);
		lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblemail);
		
		tfemail =new JTextField();
		tfemail.setBounds(200,330,150,30);
		add(tfemail);
		
		JLabel lblaadhar = new JLabel("AADHAR");
		lblaadhar.setBounds(60, 380, 120, 30);
		lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblaadhar);
		
		tfaadhar =new JTextField();
		tfaadhar.setBounds(200,380,150,30);
		add(tfaadhar);
		
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(200, 430, 150, 30);
		submit.setFont(new Font("Tahoma",Font.PLAIN,17));
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+("/src/hotel_management/icons/hotel234.jpg"));
		JLabel image =new JLabel(i1);
		image.setBounds(400,45,380,380);
		add(image);
		
		getContentPane().setBackground(Color.white);
		setBounds(350,200,850,540);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String name =tfname.getText();
		String age =tfage.getText();
		String salary =tfsalary.getText();
		String phone =tfphone.getText();
		String email =tfemail.getText();
		String aadhar =tfaadhar.getText();
		String gender =null;
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name should not be empty");
		}
		
		if(age.equals("")) {
			JOptionPane.showMessageDialog(null, "Age should not be empty");
		}
		
		if(salary.equals("")) {
			JOptionPane.showMessageDialog(null, "Salary should not be empty");
		}
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(null, "Phone should not be empty");
		}
		
		if(email.equals("")&& includes("@")&& includes(".com"))
				{
			JOptionPane.showMessageDialog(null, "Email should be correct");
		}
		
		if(aadhar.equals("")) {
			JOptionPane.showMessageDialog(null, "Aadhar should not be empty");
		}
		
		if(rbmale.isSelected()) {
			gender="Male";
		}
		else if (rbfemale.isSelected()){
			gender="Female";
		}
		String job = (String) cbjob.getSelectedItem();
		
		try {
			Conn conn = new Conn();
			
			String query = "insert into employeee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			
			conn.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Employee Added Successfully");
			setVisible(false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private boolean includes(String string) {
		return false;
	}
	public static void main(String[] args) {
		new Addemployees();

	}

}
