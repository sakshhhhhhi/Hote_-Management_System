package hotel_management;
import java.sql.*;
public class Conn {
	Connection c;
	Statement s;

	public Conn() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c =DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","Sakshi@23");
			s =c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] rags) {
//		// TODO Auto-generated method stub
//
//	}

}
