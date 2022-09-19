package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import context.DBContext;

public class ChangeAvatar {
	public static void changeAvatar(int id, String filePath) throws SQLException {
		Connection con = DBContext.getJDBCConnection();
		
		String sql = "update ecom.user set imgPic = ? where id = ?;";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setString(1, filePath);
		preparedStatement.setInt(2, id);
		
		preparedStatement.executeUpdate();
	}
}
