package taindata;
import java.sql.*;
public class DBCon {
private static Connection con;
private DBCon(){}
static{
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","srikanth");
	
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public static Connection getCon(){
	return con;
}
}
