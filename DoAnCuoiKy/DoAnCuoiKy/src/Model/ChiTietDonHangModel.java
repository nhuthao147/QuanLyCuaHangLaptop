package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDatabase;

public class ChiTietDonHangModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;

	static ArrayList <ChiTietDonHang> lsDonHang = new ArrayList<ChiTietDonHang>();

	public ChiTietDonHangModel() {
		connectDB = new ConnectDatabase();
	}

	public DefaultTableModel getDB_CTDH() throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"STT", "Tên laptop", "Số lượng", "Thành tiền (nghìn đồng)"
				});

		ChiTietDonHang cus;
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return table;
		}
		String sql = "SELECT * from chitietdonhang";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				cus = new ChiTietDonHang(rs.getString("madonhang"), rs.getString("maLaptop"), rs.getInt("soLuong"));
				Object thanhTien = LaptopModel.find(rs.getString("maLaptop")).getGiaBan()*rs.getInt("soLuong");
				String ThanhTien = thanhTien.toString();
				String[] item = {String.valueOf(rs.getInt("stt")), LaptopModel.find(rs.getString("maLaptop")).getTen(), rs.getString("soLuong"), ThanhTien};
				
				table.addRow(item);
				lsDonHang.add(cus);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database");
			ex.printStackTrace();
		}
		return table;
	}
	public DefaultTableModel getDB_ChiTiet1DH(String maDH) throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"STT", "Tên laptop", "Số lượng", "Thành tiền (nghìn đồng)"
				});

		ChiTietDonHang cus;
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return table;
		}
		String sql = "SELECT * from chitietdonhang WHERE madonhang = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maDH);
			ResultSet rs = pstmt.executeQuery();
	
			while (rs.next()) {
				cus = new ChiTietDonHang(rs.getString("madonhang"), rs.getString("maLaptop"), rs.getInt("soLuong"));
				Object thanhTien = LaptopModel.find(rs.getString("maLaptop")).getGiaBan()*rs.getInt("soLuong");
				String ThanhTien = thanhTien.toString();
				String[] item = {String.valueOf(rs.getInt("stt")), LaptopModel.find(rs.getString("maLaptop")).getTen(), rs.getString("soLuong"), ThanhTien};
				
				table.addRow(item);
				lsDonHang.add(cus);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database");
			ex.printStackTrace();
		}
		return table;
	}
	public DefaultTableModel getNewChiTietDH () throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"STT", "Tên laptop", "Số lượng", "Thành tiền (nghìn đồng)"
				});
		return table;
	}
	public static void delete(String maDH, String maLaptop) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM chitietdonhang WHERE maLaptop = ? AND maDonHang = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maLaptop);
			pstmt.setString(2, maDH);
			pstmt.executeUpdate();
			for(int i=0; i<lsDonHang.size(); i++) {
				if (maLaptop.equals(lsDonHang.get(i).getTenLaptop()) && maDH.equals(lsDonHang.get(i).getMaDH())) {
					lsDonHang.remove(i);
				}
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void deleteByDH(String ma) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM chitietdonhang WHERE (madonhang = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();
			for(int i=0; i<lsDonHang.size(); i++) {
				if (ma.equals(lsDonHang.get(i).getTenLaptop())) {
					lsDonHang.remove(i);
				}
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void add(String maDH, String maLaptop, int soLuong) throws ClassNotFoundException, SQLException {
		conn = ConnectDatabase.getConnection();
		ChiTietDonHang cus = new ChiTietDonHang(maDH, maLaptop, soLuong);
		String sql = "INSERT INTO chitietdonhang Values(?, ?, ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setString(2, maDH);
		pstmt.setString(3, maLaptop);
		pstmt.setInt(4, soLuong);
		pstmt.executeUpdate();
		lsDonHang.add(cus);
	}/*
	public static void update(String ma, String maDH , String maLaptop, int soLuong) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			ChiTietDonHang cus = new ChiTietDonHang(maLaptop, soLuong, donGia);
			String sql = "UPDATE chitietdonhang SET stt = ?, maLaptop = ?, SoLuong = ?, DonGia = ? WHERE (stt = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(stt));
			pstmt.setString(2, maLaptop);
			pstmt.setInt(3, soLuong);
			pstmt.setDouble(4, donGia);
			pstmt.setInt(5, Integer.parseInt(ma));
			pstmt.executeUpdate();
			boolean flag = false;
			for(ChiTietDonHang s : lsDonHang) {
				if (s.getStt() == Integer.parseInt(ma)) {
					s=cus;
					flag=true;
				}
			}
			if(flag == false)
				JOptionPane.showMessageDialog(null, "Không tìm thấy laptop có stt như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy laptop có stt như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}*/
	public static void update(String ma, String maLaptop) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			ChiTietDonHang cus = new ChiTietDonHang("", maLaptop, 0);
			String sql = "UPDATE chitietdonhang SET maLaptop = ? WHERE (stt = ?);";
			LaptopModel lpm = new LaptopModel();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maLaptop);
			pstmt.setInt(2, Integer.parseInt(ma));
			pstmt.executeUpdate();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy laptop như ComboBox!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}

	public static ArrayList<ThongKeSoLuongLaptop> getDataForTK() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeSoLuongLaptop> lsSoLuong = new ArrayList();
		
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return null;
		}
		String sql = "SELECT * from chitietdonhang";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			boolean isExit = false;
			while (rs.next()) {
				String sql2 = "SELECT * from DonHang WHERE (maDH = ? AND (ngayTao BETWEEN ? AND ?));";
				PreparedStatement pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, rs.getString("madonhang"));
				pstmt.setDate(3, Date.valueOf(LocalDate.now()));
				pstmt.setDate(2, Date.valueOf(LocalDate.now().plusMonths(-3)));
				ResultSet rs2 = pstmt.executeQuery();
				if(rs2.next()) {
					isExit = false;
					for (ThongKeSoLuongLaptop temp : lsSoLuong) {
						if (temp.getMaLaptop().equals(rs.getString("maLaptop"))) {
							temp.setSoLuong(temp.getSoLuong()+rs.getInt("soLuong"));
							isExit = true;
							break;
						}
					}
					if (isExit == false)
						lsSoLuong.add(new ThongKeSoLuongLaptop(rs.getString("maLaptop"), rs.getInt("soLuong")));
				}
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database để thực hiện thống kê doanh số");
			ex.printStackTrace();
		}
			return lsSoLuong;
	}
/*	public static ChiTietDonHang find(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from chitietdonhang WHERE (stt = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(ma));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				ChiTietDonHang cus = new ChiTietDonHang(rs.getString("maLaptop"), rs.getInt("soLuong"), rs.getDouble("donGia"));
				return cus;
			}
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy stt hàng hóa như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}*/
}