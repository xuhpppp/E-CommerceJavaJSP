package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import entity.User;

public class FindUser {
	public static User findUser(String email) throws SQLException {

		Connection con = DBContext.getJDBCConnection();
		
		String sql = "select * from ecom.user where email = ?";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setString(1, email);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			return new User(rs.getInt("id"),
							rs.getString("name"),
							rs.getString("email"),
							rs.getString("passwordHash"),
							rs.getString("imgPic"),
							rs.getInt("isSeller"),
							rs.getDouble("paidBack"),
							rs.getString("phone"),
							rs.getString("address"),
							rs.getInt("receiveEmail"));
		}
		
		return null;
	}
}
