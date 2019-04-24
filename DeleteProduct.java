package shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProduct {
    public Connection con=DriverConnection.getCon();
	public boolean delOperation(String pcode) throws Exception{
		PreparedStatement ps=con.prepareStatement("delete from products where pcode=?");
		ps.setString(1, pcode);
		int k=ps.executeUpdate();
		if(k>=1){
			return true;
		}
		return false;
	}
}
