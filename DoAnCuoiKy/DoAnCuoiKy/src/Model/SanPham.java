package Model;

public abstract class SanPham {

	private String maSo;
	private String ten;
	private double giaBan;
	private int soLuong;

	protected SanPham(String maSo, String ten, double giaBan, int soLuong) {
		this.maSo = maSo;
		this.ten = ten;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}

	public abstract void inThongTin();
}
