package Model;

public class KhachHang extends Nguoi {
	private String maKH;
	private String tenKH;
	private String sdt;
	private String email;
	private String diaChi;

	public KhachHang(String maKH, String tenKH, String sdt, String email, String diaChi) {
		this.tenKH = tenKH;
		this.maKH = maKH;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
	}
	public KhachHang() {
		this.tenKH = "Unknown";
		this.maKH = "Unknown";
		this.sdt = "Unknown";
		this.email = "Unknown";
		this.diaChi = "Unknown";
	}
	
	void setTenKH (String tenKH) {
		this.tenKH = tenKH;
	}
	void setMaKH (String maKH) {
		this.maKH = maKH;
	}
	void setSdt (String sdt) {
		this.sdt = sdt;
	}
	void setEmail (String email) {
		this.email = email;
	}
	void setDiaChi (String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getMaKH () {
		return maKH;
	}	
	public String getTenKH () {
		return tenKH;
	}	
	public String getSdt() {
		return sdt;
	}
	public String getEmail () {
		return email;
	}	
	public String getDiaChi () {
		return diaChi;
	}	

	@Override
	public String toString() {
		return "Mã khách hàng: "+maKH+"\nTên khách hàng: "+tenKH+"\nSố điện thoại: "+sdt+"\nEmail: "+email+"\nĐịa chỉ: "+diaChi;
	}
	@Override
	public void inThongTin() {
		System.out.println(maKH);
		System.out.println(tenKH);
		System.out.println(email);
		System.out.println(diaChi);
	}
}
