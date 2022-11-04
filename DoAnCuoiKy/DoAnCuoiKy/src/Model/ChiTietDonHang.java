package Model;

public class ChiTietDonHang {

	private String maDH;
	private String tenLaptop;
	private int soLuong;
	
	public ChiTietDonHang( String maDH, String tenLaptop, int soLuong) {
		this.maDH = maDH;
		this.tenLaptop = tenLaptop;
		this.soLuong = soLuong;
	}
	public ChiTietDonHang(String tenLaptop, int soLuong) {
		this.tenLaptop = tenLaptop;
		this.soLuong = soLuong;
	}
	public ChiTietDonHang() {
		this.tenLaptop ="Unknown";
		this.soLuong = 0;
	}
	
	public void setMaDH ( String maDH) {
		this.maDH = maDH;
	}
	public void setTenLaptop (String tenLaptop) {
		this.tenLaptop = tenLaptop;
	}	
	public void setSoLuong (int soLuong) {
		this.soLuong = soLuong;
	}
	
	String getMaDH() {
		return maDH;
	}
	String getTenLaptop() {
		return tenLaptop;
	}
	int getSoLuong() {
		return soLuong;
	}
	
	@Override
	public String toString() {
		return "Mã đơn hàng: "+maDH+"\nTên Laptop: "+tenLaptop+
				"\nSố lượng: "+soLuong;
	}
}
