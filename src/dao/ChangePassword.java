package dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import context.DBContext;

public class ChangePassword {
	public static void changePassword(int id, String newPassword) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
		Connection con = DBContext.getJDBCConnection();
		
		String sql = "update ecom.user set passwordHash = ? where id = ?;";
		
		String hash = control.HashPassword.generateStorngPasswordHash(newPassword);
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setString(1, hash);
		preparedStatement.setInt(2, id);
		
		preparedStatement.executeUpdate();
	}
}
