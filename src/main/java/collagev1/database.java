package collagev1;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
	
	public static Connection connect(String database) {
		Connection con=null;
		try {
		String url="jdbc:mysql://localhost:3306/"+database;
		String uname="root";
		String pass="super";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pass);
		
		}catch (Exception e)
		{
			
			System.out.println(e);
			return null;
		}
		return con;
	}
	
	
	
	
	
	
	

}
