package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import javax.swing.JOptionPane;

public class ConnectDatabase {

	public static Connection getConnection() throws SQLException, 
	ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/quanlycuahang";
		String user = "root";
		String pw = "123456";
		
		 return getConnection(url, user, pw);
	}
	// load driver
	public static Connection getConnection(String url, String user, String pw) throws SQLException, 
	ClassNotFoundException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(url, user, pw);
			return conn;
		}catch (SQLNonTransientConnectionException e) {
			JOptionPane.showMessageDialog(null, "MySQL đang bị giới hạn số lượng Connection hãy tắt bớt cửa sổ và khởi động lại chương trình!", "About", JOptionPane.INFORMATION_MESSAGE);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
