package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDatabase;

public class DonHangModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;

	static ArrayList <DonHang> lsDonHang = new ArrayList<DonHang>();

	public DonHangModel(){
		connectDB = new ConnectDatabase();
	}

	public DefaultTableModel getDB_DonHang() throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"Mã đơn hàng", "Ngày tạo", "Tên nhân viên", "Tên khách hàng",
						"Thanh Toán", "Thành tiền (nghìn đồng)", "Ghi chú"
				});

		Vector v;
		DonHang lap;
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return table;
		}
		String sql = "SELECT * from donhang";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				v = new Vector();
				// String maDH, Date ngayTao, String maNV, String ghiChu, String thanhToan, String maKH
				lap = new DonHang(rs.getString("maDH"), rs.getDate("ngayTao"), rs.getString("maNV"), rs.getString("ghiChu")
						, rs.getString("thanhToan"), rs.getString("maKH"), rs.getDouble("thanhTien"));

				v.add(rs.getString("maDH"));
				v.add(rs.getDate("ngayTao"));
				v.add(NhanVienModel.find(rs.getString("maNV")).getTenNV());
				v.add(KhachHangModel.find(rs.getString("maKH")).getTenKH());
				v.add(rs.getString("thanhToan"));
				v.add(rs.getDouble("thanhTien"));
				v.add(rs.getString("ghiChu"));
				lsDonHang.add(lap);
				table.addRow(v);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database");
			ex.printStackTrace();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra với database - Thiếu thông tin");
		}
		conn.close();
		return table;
	}
	public static void delete(String ma) {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM donhang WHERE (maDH = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			pstmt.executeUpdate();
			for(int i=0; i<lsDonHang.size(); i++) {
				if (ma.equals(lsDonHang.get(i).getMaDH())) {
					lsDonHang.remove(i);
				}
			}
			pstmt.close();
			conn.close();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static void deleteByNV(String maNV) {
		try {
			deleteCTDHByMaNV(maNV);
			conn = ConnectDatabase.getConnection();
			String sql = "DELETE FROM donhang WHERE (maNV = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maNV);
			pstmt.executeUpdate();
			for(int i=0; i<lsDonHang.size(); i++) {
				if (maNV.equals(lsDonHang.get(i).getmaNV())) {
					lsDonHang.remove(i);
				}
			}
			pstmt.close();
			conn.close();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Cập nhật đơn hàng khi xóa mã nhân viên thất bại!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	public static void deleteCTDHByMaNV(String maNV) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from DonHang WHERE (maNV = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maNV);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ChiTietDonHangModel.deleteByDH(rs.getString("maDH"));
			}
			pstmt.close();
			conn.close();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
	}
	public static void add(String maDH, Date ngayTao, String maNV, String ghiChu, String thanhToan, String maKH, double thanhTien) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			DonHang cus = new DonHang(maDH, ngayTao, maNV, ghiChu, thanhToan, maKH, thanhTien);
			String sql = "INSERT INTO donhang Values(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maDH);
			pstmt.setDate(2, ngayTao);
			pstmt.setString(3, maNV);
			pstmt.setString(4, maKH);
			pstmt.setString(5, thanhToan);
			pstmt.setString(6, ghiChu);
			pstmt.setDouble(7, thanhTien);
			pstmt.executeUpdate();
			lsDonHang.add(cus);
			pstmt.close();
			conn.close();
		}catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Không thể thêm vì mã đơn hàng đã tồn tại!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void update(String ma, String maDH, Date ngayTao, String maNV, String ghiChu, String thanhToan, String maKH, double thanhTien) throws ClassNotFoundException, SQLException {
		try {
			conn = ConnectDatabase.getConnection();
			DonHang cus = new DonHang(maDH, ngayTao, maNV, ghiChu, thanhToan, maKH, thanhTien);
			String sql = "UPDATE donhang SET maDH = ?, ngayTao = ?, maNV = ?, ghiChu = ?, thanhToan = ?, maKH = ?, thanhTien = ? WHERE (maDH = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, maDH);
			pstmt.setDate(2, ngayTao);
			pstmt.setString(3, maNV);
			pstmt.setString(4, ghiChu);
			pstmt.setString(5, thanhToan);
			pstmt.setString(6, maKH);
			pstmt.setDouble(7, thanhTien);
			pstmt.setString(8, ma);
			pstmt.executeUpdate();
			boolean flag = false;
			for(DonHang s : lsDonHang) {
				if (s.getMaDH().equals(ma)) {
					s=cus;
					flag=true;
				}
			}
			if(flag == false)
				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			pstmt.close();
			conn.close();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Không thể thêm vì mã đơn hàng đã tồn tại!", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static DonHang find(String ma) throws SQLException, ClassNotFoundException {
		try {
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from DonHang WHERE (maDH = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				DonHang cus = new DonHang(rs.getString("maDH"), rs.getDate("ngayTao"), rs.getString("maNV"), rs.getString("ghiChu"), rs.getString("thanhToan"), rs.getString("maKH"), rs.getDouble("thanhTien"));
				return cus;
			}
			pstmt.close();
			conn.close();
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return null;
	}
	public static int findKPI (String ma) throws SQLException, ClassNotFoundException {
		try {
			int count = 0;
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from DonHang WHERE (maNV = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				count+=rs.getDouble("thanhTien");
			}
			pstmt.close();
			conn.close();
			return count;
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return 0;
	}
	public static int findKPISoMay (String ma) throws SQLException, ClassNotFoundException {
		try {
			int count = 0;
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from DonHang WHERE (maNV = ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String sql2 = "SELECT * from chitietdonhang WHERE (maDonHang = ?);";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, rs.getString("maDH"));
				ResultSet rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					count= count + rs2.getInt("soLuong");
				}
			}
			pstmt.close();
			conn.close();
			return count;
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return 0;
	}
	public static int addPriceItem (String maDH, String maLaptop, int soLuong) throws SQLException, ClassNotFoundException {
		try {
			int count = 0;
			conn = ConnectDatabase.getConnection();
			double thanhTien = LaptopModel.find(maLaptop).getGiaBan()*soLuong;
			thanhTien= thanhTien + find(maDH).getThanhTien();
			String sql2 = "UPDATE donhang SET thanhTien = ? WHERE (maDH = ?);";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setDouble(1, thanhTien);
			pstmt2.setString(2, maDH);
			pstmt2.executeUpdate();
			pstmt2.close();
			conn.close();
			return count;
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên để thêm sản phẩm!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return 0;
	}
	public static int deletePriceItem (String maDH, String maLaptop) throws SQLException, ClassNotFoundException {
		try {
			int count = 0;
			conn = ConnectDatabase.getConnection();
			String sql3 = "SELECT * from chitietdonhang WHERE maDonHang = ? AND maLaptop = ? ;";
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setString(1, maDH);
			pstmt3.setString(2, maLaptop);
			ResultSet rs3 = pstmt3.executeQuery();
			double thanhTien = 0;
			if (rs3.next())
				thanhTien = LaptopModel.find(maLaptop).getGiaBan()*rs3.getInt("soLuong");
			else
				JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết đơn hàng có mã đơn hàng và mã laptop như trên để xóa sản phẩm!", "About", JOptionPane.INFORMATION_MESSAGE);
			thanhTien=find(maDH).getThanhTien()-thanhTien;
			String sql2 = "UPDATE donhang SET thanhTien = ? WHERE (maDH = ?);";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setDouble(1, thanhTien);
			pstmt2.setString(2, maDH);
			pstmt2.executeUpdate();
			pstmt2.close();
			conn.close();
			return count;
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên để xóa sản phẩm!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return 0;
	}

	public static ArrayList<ThongKeTongTienNV> getDataForTKTongTien() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongTienNV> lsSoLuong = new ArrayList();

		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return null;
		}
		String sql = "SELECT * from donhang";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			boolean isExit = false;
			while (rs.next()) {
				lsSoLuong.add(new ThongKeTongTienNV(rs.getString("maNV"), findKPI(rs.getString("maNV"))));
			}
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database để thực hiện thống kê doanh số");
			ex.printStackTrace();
		}
		return lsSoLuong;
	}

	public static ArrayList<ThongKeSoMay> getDataForTKSoMay() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeSoMay> lsSoLuong = new ArrayList();

		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return null;
		}
		String sql = "SELECT * from donhang";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			boolean isExit = false;
			while (rs.next()) {
				lsSoLuong.add(new ThongKeSoMay(rs.getString("maNV"), findKPISoMay(rs.getString("maNV"))));
			}
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database để thực hiện thống kê doanh số");
			ex.printStackTrace();
		}
		return lsSoLuong;
	}

	public static ArrayList<ThongKeTongThu> getDataForTKTongThu6Thang() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongThu> lsSoLuong = new ArrayList();
		LocalDate star = LocalDate.now();
		long count = 1;
		while (count<=6) {
			lsSoLuong.add(new ThongKeTongThu("Tháng "+String.valueOf(star.getMonthValue()), findKPITongThuTheoNgay(star.plusMonths(-1), star)));
			count++;
			star = star.plusMonths(-1);
		}
		return lsSoLuong;
	}
	public static double findKPITongThuTheoNgay (LocalDate batDau, LocalDate ketThuc) throws SQLException, ClassNotFoundException {
		try {
			double count = 0;
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from DonHang WHERE (ngayTao BETWEEN ? AND ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(batDau));
			pstmt.setDate(2, Date.valueOf(ketThuc));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				count= count + rs.getDouble("thanhTien");
			}
			pstmt.close();
			conn.close();
			return count;
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return 0;
	}
	public static ArrayList<ThongKeTongThu> getDataForTKTongMay6Thang() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongThu> lsSoLuong = new ArrayList();
		LocalDate star = LocalDate.now();
		long count = 1;
		while (count<=6) {
			lsSoLuong.add(new ThongKeTongThu("Tháng "+String.valueOf(star.getMonthValue()), findKPITongMayTheoNgay(star.plusMonths(-1), star)));
			count++;
			star = star.plusMonths(-1);
		}
		return lsSoLuong;
	}
	public static double findKPITongMayTheoNgay (LocalDate batDau, LocalDate ketThuc) throws SQLException, ClassNotFoundException {
		try {
			double count = 0;
			conn = ConnectDatabase.getConnection();
			String sql = "SELECT * from DonHang WHERE (ngayTao BETWEEN ? AND ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(batDau));
			pstmt.setDate(2, Date.valueOf(ketThuc));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String sql2 = "SELECT * from chitietdonhang WHERE (maDonHang = ?);";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, rs.getString("maDH"));
				ResultSet rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					count= count + rs2.getInt("soLuong");
				}
			}
			pstmt.close();
			conn.close();
			return count;
		}catch(NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
			n.printStackTrace();
		}
		return 0;
	}
	public static ArrayList<ThongKeTongThu> getDataForTKTongThuTheoTuan() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongThu> lsSoLuong = new ArrayList();
		LocalDate star = LocalDate.now();
		long count = 1;
		while (count<=30) {
			lsSoLuong.add(new ThongKeTongThu(String.valueOf(star.getDayOfWeek()), findKPITongMayTheoNgay(star, star)));
			count++;
			star = star.plusDays(-1);
		}
		ArrayList<ThongKeTongThu> lsReturn = new ArrayList();
		lsReturn.add(lsSoLuong.get(0));
		lsReturn.add(lsSoLuong.get(1));
		lsReturn.add(lsSoLuong.get(2));
		lsReturn.add(lsSoLuong.get(3));
		lsReturn.add(lsSoLuong.get(4));
		lsReturn.add(lsSoLuong.get(5));
		lsReturn.add(lsSoLuong.get(6));
		for (int i=7; i<30; i++) {
			if (i==7 || i ==14 || i==21 || i== 28)
				lsReturn.get(0).setTongThu(lsReturn.get(0).getTongThu()+lsSoLuong.get(i).getTongThu());
			else if (i==8 || i ==15 || i==22 || i== 29)
				lsReturn.get(1).setTongThu(lsReturn.get(1).getTongThu()+lsSoLuong.get(i).getTongThu());
			else if (i==9 || i ==16 || i==23)
				lsReturn.get(2).setTongThu(lsReturn.get(2).getTongThu()+lsSoLuong.get(i).getTongThu());
			else if (i==10 || i ==17 || i==24)
				lsReturn.get(3).setTongThu(lsReturn.get(3).getTongThu()+lsSoLuong.get(i).getTongThu());
			else if (i==11 || i ==18 || i==25)
				lsReturn.get(4).setTongThu(lsReturn.get(4).getTongThu()+lsSoLuong.get(i).getTongThu());
			else if (i==12 || i ==19 || i==26)
				lsReturn.get(5).setTongThu(lsReturn.get(5).getTongThu()+lsSoLuong.get(i).getTongThu());
			else if (i==13 || i ==20 || i==27)
				lsReturn.get(6).setTongThu(lsReturn.get(6).getTongThu()+lsSoLuong.get(i).getTongThu());
		}
		return lsReturn;
	}
}