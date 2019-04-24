package shopping;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
public class ProductDao {

	
	public Collection getProducts(){
		try {
		Connection con=DriverConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from products");
			ResultSet rs=ps.executeQuery();
			ArrayList products=new ArrayList ();
			while(rs.next())
			{
				ProductBean pb=new ProductBean();
				pb.setPCode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPprice(rs.getFloat(3));
				pb.setPquantity(rs.getInt(4));
				products.add(pb);
			}
			return products;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
