package collagev1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class addEventDao {

	
	public static boolean addEvent(int registerID,String name,String eventname,String college,String pname,String department,String eventdetail) {
		boolean status=false;
		try
		{
			String url="jdbc:mysql://localhost:3306/student";
			String uname="root";
			String pass="super";
			String query="insert into eventlist values(?,?,?,?,?,?,?,current_date(),current_time(),0);";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1,registerID);
			st.setString(2,name);
			st.setString(3,eventname);
			st.setString(4,college);
			st.setString(5,pname);
			st.setString(6,department);
			st.setString(7,eventdetail);
			st.executeUpdate();
			status=true;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			status=false;
		}
		
		
		
		
		return status;
	}
	
	
//	public static void main(String args[]) {
//	int registerID=79878;
//	String name;
//	String eventname;
//	String college;
//	String pname;
//	String department;
//	String eventdetail;
//	System.out.println(registerDao.ercheck(registerID,email));
	
//}
	
	
}
