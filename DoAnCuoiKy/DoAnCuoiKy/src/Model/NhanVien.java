package Model;

import java.sql.Date;

public class NhanVien extends Nguoi {
	private String maNV;
	private String tenNV;
	private String sdt;
	private String diaChi;
	private double luongCung;
	private double luongThuong;


	public NhanVien(String maNV, String tenNV, String sdt, String diaChi, double luongCung, double luongThuong) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.luongCung = luongCung;
		this.luongThuong = luongThuong;
	}
	public NhanVien() {
		this.maNV = "Unknown";
		this.tenNV = "Unknown";
		this.sdt = "Unknown";
		this.diaChi = "Unknown";
		this.luongCung = 0;
		this.luongThuong = 0;
	}

	void setMaNV (String maNV) {
		this.maNV = maNV;
	}
	void setTenNV (String tenNV) {
		this.tenNV = tenNV;
	}
	void setSdt (String sdt) {
		this.sdt = sdt;
	}
	void setDiaChi (String diaChi) {
		this.diaChi = diaChi;
	}
	void setLuongCung (double luongCung) {
		this.luongCung = luongCung;
	}
	void setLuongThuong (double luongThuong) {
		this.luongThuong = luongThuong;
	}

	String getMaNV () {
		return maNV;
	}	
	public String getTenNV () {
		return tenNV;
	}
	String getSdt () {
		return sdt;
	}
	String getDiaChi () {
		return diaChi;
	}	
	double getLuongCung () {
		return luongCung;
	}	
	double getLuongThuong () {
		return luongThuong;
	}

	@Override
	public String toString() {
		return "Mã nhân viên: "+maNV+"\nTên nhân viên: "+tenNV+"\nSố điện thoại: "+sdt+
				"\nĐịa chỉ: "+diaChi+"\nLương cứng: "+luongCung+"\nLương thưởng: "+luongThuong;
	}
	@Override
	public void inThongTin() {
		System.out.println(maNV);
		System.out.println(tenNV);
		System.out.println(sdt);
		System.out.println(diaChi);
		System.out.println(luongCung);
		System.out.println(luongThuong);
	}
}
