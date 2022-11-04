package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ConnectDatabase;

public class DangNhapModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;

	public DangNhapModel(){
		connectDB = new ConnectDatabase();
	}

	public static int login(String userName, String password) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from login WHERE (userName = ? AND password = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getString("chucVu").equals("nhanvien"))
					return 2;
				else if (rs.getString("chucVu").equals("admin"))
					return 1;
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không chính xác!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không chính xác", "About", JOptionPane.INFORMATION_MESSAGE);
		return 0;
	}

	public static void delete(String ma) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM login WHERE (userName = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();
			deleteNV(ma);
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm tài khoản có username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Không tìm tài khoản có username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void deleteNV(String ma) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM dangnhap_nhanvien WHERE (userName = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm tài khoản có username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Không tìm tài khoản có username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void addNoLink(String userName, String passWord) throws ClassNotFoundException, SQLException {
		conn = ConnectDatabase.getConnection();
		String sql = "INSERT INTO login Values(?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "nhanvien");
		pstmt.setString(2, userName);
		pstmt.setString(3, passWord);
		pstmt.executeUpdate();
	}	
	public static void addLinked(String userName, String passWord, String maNV) throws ClassNotFoundException, SQLException {
		conn = ConnectDatabase.getConnection();
		String sql = "INSERT INTO login Values(?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "nhanvien");
		pstmt.setString(2, userName);
		pstmt.setString(3, passWord);
		addLinkedNV(userName, maNV);
		pstmt.executeUpdate();
	}
	public static void addLinkedNV(String userName,String maNV) throws ClassNotFoundException, SQLException {
		conn = ConnectDatabase.getConnection();
		String sql = "INSERT INTO dangnhap_nhanvien Values(?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, maNV);
		pstmt.executeUpdate();
	}
	public static void addAdmin(String userName, String passWord) throws ClassNotFoundException, SQLException {
		conn = ConnectDatabase.getConnection();
		String sql = "INSERT INTO login Values(?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "admin");
		pstmt.setString(2, userName);
		pstmt.setString(3, passWord);
		pstmt.executeUpdate();
	}	
	public static void update(String maNV, String username,  String password) throws ClassNotFoundException, SQLException {
		try {
			deleteAccount(maNV);
			addLinked(username, password, maNV);
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}
	public static void deleteAccount(String maNV) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from dangnhap_nhanvien WHERE (maNV = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maNV);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deleteLoginByMaUsername(rs.getString("username"));
			}
			sql = "DELETE FROM dangnhap_nhanvien WHERE (maNV = ?);";
			PreparedStatement pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, maNV);
			pstmt2.executeUpdate();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}
	public static void deleteLoginByMaUsername(String ma) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM login WHERE (userName = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();
			deleteNV(ma);
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm tài khoản có username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Không tìm tài khoản có username như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
