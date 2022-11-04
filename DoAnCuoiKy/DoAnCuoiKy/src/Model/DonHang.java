package Model;

import java.sql.Date;

public class DonHang {
	private String maDH;
	private Date ngayTao;
	private String maNV;
	private String maKH;
	private String thanhToan;
	private String ghiChu;
	private double thanhTien;

	public DonHang(String maDH, Date ngayTao, String maNV, String ghiChu, String thanhToan, String maKH, double thanhTien) {
		this.maDH = maDH;
		this.ngayTao = ngayTao;
		this.maNV = maNV;
		this.ghiChu = ghiChu;
		this.thanhToan = thanhToan;
		this.maKH = maKH;
		this.thanhTien = thanhTien;
	}
	public DonHang() {
		this.maDH = "Unknown";
		this.ngayTao = null;
		this.maNV = "Unknown";
		this.ghiChu = "Unknown";
		this.thanhToan = "Unknown";
		this.maKH = "Unknown";
		this.thanhTien = 0;
	}
	
	void setMaDH (String maDH) {
		this.maDH = maDH;
	}
	void setNgayTao (Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	void setmaNV(String maNV) {
		this.maNV = maNV;
	}
	void setGhiChu (String ghiChu) {
		this.ghiChu = ghiChu;
	}
	void setThanhToan (String thanhToan) {
		this.thanhToan = thanhToan;
	}
	void setMaKH (String maKH) {
		this.maKH = maKH;
	}	
	void setThanhTien (double maKH) {
		this.thanhTien = thanhTien;
	}
	
	public String getMaKH () {
		return maKH;
	}	
	public String getMaDH () {
		return maDH;
	}
	public Date getNgayTao () {
		return ngayTao;
	}
	public String getmaNV() {
		return maNV;
	}
	public String getGhiChu () {
		return ghiChu;
	}	
	public String getThanhToan () {
		return thanhToan;
	}	
	public double getThanhTien() {
		return thanhTien;
	}

	@Override
	public String toString() {
		return "Mã đơn hàng: "+maDH+"\nNgày tạo: "+ngayTao+"\nMã nhân viên: "+maNV+
				"\nGhi chú: "+ghiChu+"\nThanh toán: "+thanhToan+"\nMã khách hàng: "+maKH+"\nThành tiền: "+thanhTien;
	}
}
