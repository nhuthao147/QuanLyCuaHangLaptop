package Model;

import java.util.Scanner;

public class Laptop extends SanPham {
	private String maSo;
	private String ten;
	private double giaBan;
	private String hangSX;
	private String cpu;
	private int ram;
	private String kichThuocManHinh;
	private int soLuong;

	public Laptop(String maSo, String ten, double giaBan, String hangSX, String cpu, int ram, String kichThuocManHinh, int soLuong) {
		super(maSo, ten, giaBan, soLuong);
		this.maSo = maSo;
		this.ten = ten;
		this.giaBan = giaBan;
		this.hangSX = hangSX;
		this.cpu = cpu;
		this.ram = ram;
		this.kichThuocManHinh = kichThuocManHinh;
		this.soLuong = soLuong;
	}
	public Laptop() {
		super("LP00", "Unknown", 0, 0);
		this.maSo = "LP00";
		this.ten = "Unknown";
		this.giaBan = 0;
		this.hangSX = "Unknown";
		this.cpu = "Unknown";
		this.ram = 0;
		this.kichThuocManHinh = "Unknown";
		this.soLuong = 0;
	}
	
	void setMaSo (String maSo) {
		this.maSo = maSo;
	}
	void setTen(String ten) {
		this.ten = ten;
	}
	void setGiaBan (double giaBan) {
		this.giaBan = giaBan;
	}
	void setHangSX (String hangSX) {
		this.hangSX = hangSX;
	}
	void setCpu (String cpu) {
		this.cpu = cpu;
	}
	void setRam (int ram) {
		this.ram = ram;
	}
	void setKichThuocManHinh (String kichThuocManHinh) {
		this.kichThuocManHinh = kichThuocManHinh;
	}
	void setSoLuong (int soLuong) {
		this.soLuong = soLuong;
	}
	
	public String getMaSo () {
		return maSo;
	}	
	public String getTen () {
		return ten;
	}	
	public double getGiaBan () {
		return giaBan;
	}	
	public String getHangSX () {
		return hangSX;
	}	
	public String getCpu () {
		return cpu;
	}	
	public int getRam () {
		return ram;
	}	
	public String getKichThuocManHinh () {
		return kichThuocManHinh;
	}	
	public int getSoLuong () {
		return soLuong;
	}

	@Override
	public String toString() {
		return "Mã laptop: "+maSo+"\nTên: "+ten+"\nGiá bán: "+giaBan+"\nHãng sản xuất: "+hangSX+"\nCPU: "+cpu+"\nRam: "+ram+"\nKích thước màn hình: "+kichThuocManHinh+"\nSố Lượng: "+soLuong;
	}
	@Override
	public void inThongTin() {
		System.out.println(maSo);
		System.out.println(ten);
		System.out.println(giaBan);
		System.out.println(hangSX);
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(kichThuocManHinh);
		System.out.println(soLuong);
	}

}
