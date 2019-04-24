package empreg;
import java.sql.*;
public class DBConnection4 {
private static Connection con;
private DBConnection4(){}
static
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");


	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static Connection getCon(){
	return con;
}
}
