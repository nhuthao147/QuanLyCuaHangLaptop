package Model;

public abstract class Nguoi {
	private String ten;
	private String sdt;
	private String diaChi;

	public Nguoi(String ten, String sdt, String diaChi) {
		this.ten = ten;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public Nguoi() {
		this.ten = "Unknown";
		this.sdt = "Unknown";
		this.diaChi = "Unknown";
	}

	public abstract void inThongTin();
}
