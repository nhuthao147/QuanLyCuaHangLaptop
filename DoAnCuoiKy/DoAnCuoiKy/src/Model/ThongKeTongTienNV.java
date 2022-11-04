package Model;

public class ThongKeTongTienNV {
	public ThongKeTongTienNV(String maNV, double tongTien) {
		this.maNV = maNV;
		this.tongTien = tongTien;
	}

	private String maNV;
	private double tongTien;

	public ThongKeTongTienNV() {
	}

	public String getmaNV() {
		return maNV;
	}

	public void setmaNV(String tenLaptop) {
		this.maNV = tenLaptop;
	}

	public double gettongTien() {
		return tongTien;
	}

	public void settongTien(double tongTien) {
		this.tongTien = tongTien;
	}

}