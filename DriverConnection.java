package shopping;

import java.sql.Connection;
import java.sql.DriverManager;

public class DriverConnection {
private static Connection con;
private DriverConnection(){}
static 
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public static Connection getCon()
{
	return con;
}
}
