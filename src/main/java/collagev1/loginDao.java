package collagev1;


import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
public class loginDao {

	public static boolean Logincheck(int userregID,String userpass) throws ServletException, IOException
	{
		boolean status=false; 
		
			try {
//			String url="jdbc:mysql://localhost:3306/student";
//			String uname="root";
//			String pass="super";
			
			//String query="select * from login where emaildb='" +useremail+ "'and passdb='"+userpass+"'";
			//String data="";
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url,uname,pass);
			//Statement st=con.createStatement();
				
				
				
			String db = "student";
			Connection con =database.connect(db);
			String query="select registerID , email from studentdetail where registerID=? and password=?";	
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1,userregID);  
			st.setString(2,userpass); 
			ResultSet rs=st.executeQuery();
			status=rs.next();
			}catch(Exception e){
				System.out.println(e);
			}
			
		
		return status;
		
		
		
		
	}
	
	
}
