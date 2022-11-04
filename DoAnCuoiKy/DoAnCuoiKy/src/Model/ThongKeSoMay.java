package Model;

public class ThongKeSoMay {
	public ThongKeSoMay(String maNV, int soLuong) {
		this.maNV = maNV;
		this.soLuong = soLuong;
	}

	private String maNV;
	private int soLuong;

	public ThongKeSoMay() {
	}

	public String getmaNV() {
		return maNV;
	}

	public void setmaNV(String tenLaptop) {
		this.maNV = tenLaptop;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
