package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import entity.User;

public class FindToken {
	public static User findToken(int idUser, String token) throws SQLException {
		Connection con = DBContext.getJDBCConnection();
		
		String sql = "select ecom.user.id, ecom.user.name, ecom.user.email, ecom.user.passwordHash, ecom.user.imgPic, ecom.user.isSeller, ecom.user.paidBack, ecom.user.phone, ecom.user.address, ecom.user.receiveEmail "
				+ "from ecom.user "
				+ "inner join ecom.login_token "
				+ "on ecom.user.id = ecom.login_token.idUser "
				+ "where ecom.login_token.idUser = ? "
				+ "and ecom.login_token.token = ?;";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setInt(1, idUser);
		preparedStatement.setString(2, token);
		
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
