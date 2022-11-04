package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDatabase;

public class NhanVienModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;

	static ArrayList <NhanVien> lsNhanVien = new ArrayList<NhanVien>();

	public NhanVienModel(){
		connectDB = new ConnectDatabase();
	}
	
	public DefaultTableModel getDB_NhanVien() throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Địa chỉ", "Lương cứng", "Lương thưởng"
				});

		NhanVien cus;
		Vector v;
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return table;
		}
		String sql = "SELECT * from nhanvien";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				v=new Vector();
				cus = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("sdt"), rs.getString("diaChi"), rs.getDouble("luongCung"),  rs.getDouble("luongThuong"));
				
				v.add(rs.getString("maNhanVien"));		
				v.add(rs.getString("tenNhanVien"));		
				v.add(rs.getString("sdt"));		
				v.add(rs.getString("diaChi"));		
				v.add(rs.getDouble("luongCung"));		
				v.add(rs.getDouble("luongThuong"));
				table.addRow(v);
				lsNhanVien.add(cus);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database");
			ex.printStackTrace();
		}
		return table;
	}
	public static void delete(String ma) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM NhanVien WHERE (maNhanVien = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();
			for(int i=0; i<lsNhanVien.size(); i++) {
				if (ma.equals(lsNhanVien.get(i).getMaNV())) {
					lsNhanVien.remove(i);
				}
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static void add(String maNV, String tenNV, String sdt, String diaChi, double luongCung, double luongThuong) throws ClassNotFoundException, SQLException {
		conn = ConnectDatabase.getConnection();
		NhanVien cus = new NhanVien(maNV, tenNV, sdt, diaChi, luongCung, luongThuong);
		String sql = "INSERT INTO NhanVien Values(?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, maNV);
		pstmt.setString(2, tenNV);
		pstmt.setString(3, sdt);
		pstmt.setString(4, diaChi);
		pstmt.setDouble(5, luongCung);
		pstmt.setDouble(6, luongThuong);
		pstmt.executeUpdate();
		lsNhanVien.add(cus);
	}
	public static void update(String ma, String maNV, String tenNV, String sdt, String diaChi, double luongCung, double luongThuong) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			NhanVien cus = new NhanVien(maNV, tenNV, sdt, diaChi, luongCung, luongThuong);
			String sql = "UPDATE NhanVien SET maNhanVien = ?, tenNhanVien = ?, sdt = ?, diaChi = ?, luongCung = ?, luongThuong = ? WHERE (maNhanVien = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maNV);
			pstmt.setString(2, tenNV);
			pstmt.setString(3, sdt);
			pstmt.setString(4, diaChi);
			pstmt.setDouble(5, luongCung);
			pstmt.setDouble(6, luongThuong);
			pstmt.setString(7, ma);
			pstmt.executeUpdate();
			boolean flag = false;
			for(NhanVien s : lsNhanVien) {
				if (s.getMaNV().equals(ma)) {
					s=cus;
					flag=true;
				}
			}
			if(flag == false)
				JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}
	public static NhanVien find(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from nhanVien WHERE (maNhanVien = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				NhanVien lap = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), 
						rs.getString("sdt"), rs.getString("diaChi"), rs.getDouble("luongCung"),  rs.getDouble("luongThuong"));
				return lap;
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
}
