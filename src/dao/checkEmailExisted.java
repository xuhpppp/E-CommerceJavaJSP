package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;

public class checkEmailExisted {
	//0 = email non-exist
	
	public static int check(String email) throws SQLException {
		String emailCheck = "";
		
		Connection con = DBContext.getJDBCConnection();
		
		String sql = "select * from ecom.user where email = ?";
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setString(1, email);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			emailCheck = rs.getString("email");
		}
		
		if (emailCheck.equals("")) {
			return 0;
		} else {
			return 1;
		}
	}
}