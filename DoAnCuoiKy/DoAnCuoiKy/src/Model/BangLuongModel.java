package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ConnectDatabase;

public class BangLuongModel {
	private static Connection conn;
	private static ConnectDatabase connectDB;
	private ResultSet resultSet;
	private Statement statement;

	public BangLuongModel() {
		connectDB = new ConnectDatabase();
	}

	public DefaultTableModel getDB_Laptop() throws ClassNotFoundException, SQLException {
		DefaultTableModel table = new DefaultTableModel(
				new Object[][] {

				}, new String[] {
						"Mã nhân viên", "Tên nhân viên", "Lương cứng", "Lương thưởng", "Tổng lương (nghìn đồng) "
				});

		Vector v;
		Laptop lap;
		Connection conn = ConnectDatabase.getConnection();
		if(conn == null) {
			JOptionPane.showMessageDialog(null, "Can't connect database");
			return table;
		}
		String sql = "SELECT * from nhanvien";
		DonHangModel dhm = new DonHangModel();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			double tongLuong = 0;
			while (rs.next()) {
				v = new Vector();
				
				v.add(rs.getString("maNhanVien"));
				v.add(rs.getString("tenNhanVien"));
				v.add(rs.getDouble("luongCung"));
				v.add(rs.getDouble("luongThuong"));
				
				v.add((dhm.findKPI(rs.getString("maNhanVien"))*rs.getDouble("luongThuong")+rs.getDouble("luongCung")));
			
				table.addRow(v);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không thể lấy được dữ liệu từ database");
			ex.printStackTrace();
		}
		return table;
	}
}