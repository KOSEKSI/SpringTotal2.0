package shopping;
import java.sql.*;
public class UpdateDetails {
	public Connection con=DriverConnection.getCon();
	public int updateRecord(int pquan,String pcode){
		try
		{
			PreparedStatement ps=con.prepareStatement("update products set pquantity=pquantity-? where pcode=?");
			ps.setInt(1, pquan);
			ps.setString(2, pcode);
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
