package collagev1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
@WebServlet("/test")
public class registerDao {

	public static boolean registerDetail(int registerID,String name,String college,String email,String password,String department) {
		boolean rStatus= false;
	try
	{
//		String url="jdbc:mysql://localhost:3306/student";
//		String uname="root";
//		String pass="super";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection(url,uname,pass);
		String db = "student";
		Connection con =database.connect(db);
		String query="insert into studentdetail values(?,?,?,?,?,?,current_date());";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,registerID);  
		st.setString(2,name);
		st.setString(3,college);
		st.setString(4,email);
		st.setString(5,password);
		st.setString(6,department);
		st.executeUpdate();
		rStatus=true;
		
		
		
		
		
	}catch(Exception e)
	{
		System.out.println(e);
	}
		
		
		
		
		
		return rStatus;
	}
	
	public static boolean ercheck(int registerID,String email) {
		boolean Status= false;
		try
		{
			String url="jdbc:mysql://localhost:3306/student";
			String uname="root";
			String pass="super";
			String query="select registerID , email from studentdetail where registerID=? or email=?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1,registerID); 
			st.setString(2,email);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				Status=false;
			}else
			{
				Status = true;
			}
			
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		
		
		return Status;
		
		
		
		
	}
	
	
//	public static void main(String args[]) {
//		int registerID=79878;
//		String name="sumit";
//		String college="megnath";
//		String email="sjfkg@gmail.com";
//		String password="iwuriw";
//		System.out.println(registerDao.ercheck(registerID,email));
//		
//	}
	
}
