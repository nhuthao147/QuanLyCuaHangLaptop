package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import DAO.ConnectDatabase;

public class TimLaptopModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;
	
	public TimLaptopModel() {
		connectDB = new ConnectDatabase();
	}
	public static Laptop timTheoRam(int ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from laptop WHERE (ram = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Laptop lap = new Laptop(rs.getString("maSo"), rs.getString("ten"), rs.getDouble("giaBan"), rs.getString("hangSX"),
						rs.getString("cpu"), rs.getInt("ram"), rs.getString("kichThuocManHinh"), rs.getInt("soLuong"));
				JOptionPane.showMessageDialog(null,	lap);
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
	public static Laptop timTheoCpu(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from laptop WHERE (cpu = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Laptop lap = new Laptop(rs.getString("maSo"), rs.getString("ten"), rs.getDouble("giaBan"), rs.getString("hangSX"),
						rs.getString("cpu"), rs.getInt("ram"), rs.getString("kichThuocManHinh"), rs.getInt("soLuong"));
				JOptionPane.showMessageDialog(null,	lap.toString());
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
	public static Laptop timTheoHangSX(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from laptop WHERE (hangSX = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Laptop lap = new Laptop(rs.getString("maSo"), rs.getString("ten"), rs.getDouble("giaBan"), rs.getString("hangSX"),
						rs.getString("cpu"), rs.getInt("ram"), rs.getString("kichThuocManHinh"), rs.getInt("soLuong"));
				JOptionPane.showMessageDialog(null,	lap.toString());
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
	public static Laptop timTheoGiaBan(double ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from laptop WHERE (giaBan = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Laptop lap = new Laptop(rs.getString("maSo"), rs.getString("ten"), rs.getDouble("giaBan"), rs.getString("hangSX"),
						rs.getString("cpu"), rs.getInt("ram"), rs.getString("kichThuocManHinh"), rs.getInt("soLuong"));
				JOptionPane.showMessageDialog(null,	lap.toString());
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
	public static Laptop timTheoTen(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from laptop WHERE (ten = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Laptop lap = new Laptop(rs.getString("maSo"), rs.getString("ten"), rs.getDouble("giaBan"), rs.getString("hangSX"),
						rs.getString("cpu"), rs.getInt("ram"), rs.getString("kichThuocManHinh"), rs.getInt("soLuong"));
				JOptionPane.showMessageDialog(null,	lap.toString());
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
}
