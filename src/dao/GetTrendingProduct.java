package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import context.DBContext;
import entity.Product;

public class GetTrendingProduct {
	//product with same size will display only once
	
	public List<Product> getTrendingProduct() throws SQLException {
		List<Product> list = new ArrayList<Product>();
		
		Connection con = DBContext.getJDBCConnection();
		
		Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM ecom.product group by groupID order by id desc limit 8;");
		
		while (rs.next()) {
			list.add(new Product(rs.getInt("id"),
								 rs.getInt("groupId"),
								 rs.getString("name"),
								 rs.getString("imgPath"),
								 rs.getString("description"),
								 rs.getDouble("cost"),
								 rs.getInt("salePercentage"),
								 rs.getInt("idSeller"),
								 rs.getInt("storage"),
								 rs.getInt("timesBought"),
								 rs.getString("size")));
		}
		
		return list;
	}
}
