package dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import context.DBContext;
import control.HashPassword;

public class SignUpAccount {
	public static void signup(String name, String email, String password, String receiveEmail) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
		Connection con = DBContext.getJDBCConnection();
		
		String sql = "insert into ecom.user(name, email, passwordHash, receiveEmail) values (?, ?, ?, ?)";
		
		//hash password
		String passwordHash = HashPassword.generateStorngPasswordHash(password);
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, passwordHash);
		preparedStatement.setInt(4, receiveEmail == null ? 0 : 1);
		
		preparedStatement.executeUpdate();
	}
}
