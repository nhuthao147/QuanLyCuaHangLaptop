package Model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDatabase;

public class LaptopModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;

	static ArrayList <Laptop> lsLaptop = new ArrayList<Laptop>();

	public LaptopModel() {
		connectDB = new ConnectDatabase();
	}

	public static DefaultTableModel getDB_Laptop() throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"Mã số", "Tên", "Giá bán (nghìn đồng)", "Hãng sản xuất",
						"CPU", "Ram", "Kích thước màn hình", "Số lượng"
				});

		Vector v;
		Laptop lap;
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return table;
		}
		String sql = "SELECT * from Laptop";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				v = new Vector();
				lap = new Laptop(rs.getString("maSo"), rs.getString("ten"), rs.getDouble("giaBan"), rs.getString("hangSX"),
						rs.getString("cpu"), rs.getInt("ram"), rs.getString("kichThuocManHinh"), rs.getInt("soLuong"));
				v.add(rs.getString("maSo"));
				v.add(rs.getString("ten"));
				v.add(rs.getDouble("giaBan"));
				v.add(rs.getString("hangSX"));
				v.add(rs.getString("cpu"));
				v.add(rs.getInt("ram"));
				v.add(rs.getString("kichThuocManHinh"));
				v.add(rs.getInt("soLuong"));
				lsLaptop.add(lap);
				table.addRow(v);
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
			String sql = "DELETE FROM laptop WHERE (MaSo = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();
			boolean flag = false;
			for(int i=0; i<lsLaptop.size(); i++) {
				if (ma.equals(lsLaptop.get(i).getMaSo())) {
					lsLaptop.remove(i);
					flag = true;
				}
			}
			if (flag == false)
				JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static void add(String maSo, String ten, double giaBan, String hangSX, String cpu, int ram, String kichThuocManHinh, int soLuong) throws ClassNotFoundException, SQLException {
		conn = ConnectDatabase.getConnection();
		Laptop lap = new Laptop(maSo, ten, giaBan, hangSX, cpu, ram, kichThuocManHinh, soLuong);
		String sql = "INSERT INTO laptop Values(?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lap.getMaSo());
		pstmt.setString(2, lap.getTen());
		pstmt.setDouble(3, lap.getGiaBan());
		pstmt.setString(4, lap.getHangSX());
		pstmt.setString(5, lap.getCpu());
		pstmt.setInt(6, lap.getRam());
		pstmt.setString(7, lap.getKichThuocManHinh());
		pstmt.setInt(8, lap.getSoLuong());
		pstmt.executeUpdate();
		lsLaptop.add(lap);
	}
	public static void update(String ma, String maSo, String ten, double giaBan, String hangSX, String cpu, int ram, String kichThuocManHinh, int soLuong) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			Laptop lap = new Laptop(maSo, ten, giaBan, hangSX, cpu, ram, kichThuocManHinh, soLuong);
			String sql = "UPDATE laptop SET maSo = ?, ten = ?, giaBan = ?, hangSX = ?, cpu = ?, ram = ?, kichThuocManHinh = ?, soLuong = ? WHERE (maSo = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lap.getMaSo());
			pstmt.setString(2, lap.getTen());
			pstmt.setDouble(3, lap.getGiaBan());
			pstmt.setString(4, lap.getHangSX());
			pstmt.setString(5, lap.getCpu());
			pstmt.setInt(6, lap.getRam());
			pstmt.setString(7, lap.getKichThuocManHinh());
			pstmt.setInt(8, lap.getSoLuong());
			pstmt.setString(9, ma);
			pstmt.executeUpdate();
			boolean flag = false;
			for(Laptop s : lsLaptop) {
				if (s.getMaSo().equals(ma)) {
					s=lap;
					flag=true;
				}
			}
			if(flag == false)
				JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);

		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}

	public static Laptop find(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from laptop WHERE (MaSo = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Laptop lap = new Laptop(rs.getString("maSo"), rs.getString("ten"), rs.getDouble("giaBan"), rs.getString("hangSX"),
						rs.getString("cpu"), rs.getInt("ram"), rs.getString("kichThuocManHinh"), rs.getInt("soLuong"));
				return lap;
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
	public static void update(String ma, int soLuong) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "UPDATE laptop SET soLuong = ? WHERE (maSo = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, find(ma).getSoLuong()+soLuong);
			pstmt.setString(2, ma);
			pstmt.executeUpdate();
			boolean flag = false;
			for(Laptop s : lsLaptop) {
				if (s.getMaSo().equals(ma)) {
					s.setSoLuong(s.getSoLuong()+soLuong);
					flag=true;
				}
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}
}
