package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDatabase;

public class KhachHangModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;

	static ArrayList <KhachHang> lsLaptop = new ArrayList<KhachHang>();

	public KhachHangModel() {
		connectDB = new ConnectDatabase();
	}

	public static void add(String maKH, String tenKH, String sdt, String email, String diaChi) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			KhachHang lap = new KhachHang(maKH, tenKH, sdt, email, diaChi);
			String sql = "INSERT INTO khachhang Values(?, ?, ?, ?, ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maKH);
			pstmt.setString(2, tenKH);
			pstmt.setString(3, sdt);
			pstmt.setString(4, email);
			pstmt.setString(5, diaChi);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			lsLaptop.add(lap);
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void delete(String ma) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM KhachHang WHERE (tenKH = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();			
			boolean flag = false;
			for(int i=0; i<lsLaptop.size(); i++) {
				if (ma.equals(lsLaptop.get(i).getMaKH())) {
					lsLaptop.remove(i);
					flag = true;
				}
			}
			if (flag == false)
				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public DefaultTableModel getDB_KhachHang() throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"Mã khách Hàng", "Tên khách hàng", "Số điện thoại", "Email",
						"Địa chỉ"
				});

		Vector v;
		KhachHang lap;
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return table;
		}
		String sql = "SELECT * from KhachHang";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				v = new Vector();
				lap = new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getString("sdt"), rs.getString("email"),
						rs.getString("diaChi"));
				v.add(rs.getString("maKH"));
				v.add(rs.getString("tenKH"));
				v.add(rs.getString("sdt"));
				v.add(rs.getString("email"));
				v.add(rs.getString("diaChi"));
				lsLaptop.add(lap);
				table.addRow(v);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database");
			ex.printStackTrace();
		}
		return table;
	}
	public static void update(String ma, String maKH, String tenKH, String sdt, String email, String diaChi) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			KhachHang lap = new KhachHang(maKH, tenKH, sdt, email, diaChi);
			String sql = "UPDATE KhachHang SET maKH = ?, tenKH = ?, sdt = ?, email = ?, diaChi = ? WHERE (maKH = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maKH);
			pstmt.setString(2, tenKH);
			pstmt.setString(3, sdt);
			pstmt.setString(4, email);
			pstmt.setString(5, diaChi);
			pstmt.setString(6, ma);
			pstmt.executeUpdate();
			boolean flag = false;
			for(KhachHang s : lsLaptop) {
				if (s.getMaKH().equals(ma)) {
					s=lap;
					flag=true;
				}
			}
			if(flag == false)
				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);

		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}

	public static KhachHang find(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from KhachHang WHERE (maKH = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				KhachHang lap = new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getString("sdt"), rs.getString("email"),
						rs.getString("diaChi"));
				return lap;
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
}
