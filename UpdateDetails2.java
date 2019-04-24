package shopping;
import java.sql.*;
public class UpdateDetails2 {
	public Connection con=DriverConnection.getCon();
	public int updateRecord(String pcode,String pname,long pprice,int pquan){
		try
		{
			PreparedStatement ps=con.prepareStatement("update products set pquantity=?,pname=?,pprice=? where pcode=?");
			ps.setInt(1, pquan);
			ps.setString(2, pname);
			ps.setLong(3, pprice);
			ps.setString(4, pcode);
			int k=ps.executeUpdate();
			if(k>=1){
			return k;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}