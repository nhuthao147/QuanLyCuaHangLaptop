package Model;

import java.sql.Date;

public class ThongKeTongThu {

	public ThongKeTongThu(String ten, double tongThu) {
		this.ten = ten;
		this.tongThu = tongThu;
	}
	private String ten;
	private double tongThu;
	public double getTongThu() {
		return tongThu;
	}
	public void setTongThu(double tongThu) {
		this.tongThu = tongThu;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}

}
