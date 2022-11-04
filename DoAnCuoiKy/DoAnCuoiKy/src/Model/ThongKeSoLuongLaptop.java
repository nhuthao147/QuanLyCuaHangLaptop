package Model;

public class ThongKeSoLuongLaptop {
	public ThongKeSoLuongLaptop(String maLaptop, int soLuong) {
		this.maLaptop = maLaptop;
		this.soLuong = soLuong;
	}

	private String maLaptop;
	private int soLuong;

	public ThongKeSoLuongLaptop() {
	}

	public String getMaLaptop() {
		return maLaptop;
	}

	public void setMaLaptop(String tenLaptop) {
		this.maLaptop = tenLaptop;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
