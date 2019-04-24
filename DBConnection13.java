package userreg1;
import java.sql.*;
public class DBConnection13 {
	private static Connection con;
	private DBConnection13(){}
	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon(){
		return con;
	}
}
