package shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
public Connection con;
public PreparedStatement ps;
	public boolean validate(String Uname,String Pass){
		try {
			con=DriverConnection.getCon();
			ps=con.prepareStatement("select * from userreg4pm1 where uname=? and pass=?");
			ps.setString(1, Uname);
			ps.setString(2, Pass);
			ResultSet rs=ps.executeQuery();
			return rs.next();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
