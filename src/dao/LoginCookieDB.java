package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import context.DBContext;

public class LoginCookieDB {
	public static String generateToken() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
		
		StringBuilder sb = new StringBuilder(16);
		
		for (int i = 0; i < 16; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
  
            sb.append(AlphaNumericString.charAt(index));
        }
		
		return sb.toString();
	}
	
	public static void insertLoginCookie(int idUser, String token) throws SQLException {
		Connection con = DBContext.getJDBCConnection();
		
		deleteLoginCookie(idUser);
		
		String sql = "insert into ecom.login_token(idUser, token) values (?, ?)";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setInt(1, idUser);
		preparedStatement.setString(2, token);
		
		preparedStatement.executeUpdate();
	}
	
	public static void deleteLoginCookie(int idUser) throws SQLException {
		Connection con = DBContext.getJDBCConnection();
		
		String sql = "delete from ecom.login_token where idUser = ?";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setInt(1, idUser);
		
		preparedStatement.executeUpdate();
	}
}
