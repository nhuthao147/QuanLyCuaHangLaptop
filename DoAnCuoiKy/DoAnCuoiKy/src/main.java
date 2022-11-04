import java.awt.EventQueue;

import GUI.frmDangNhap;
import GUI.frmQuanLyChoNhanVien;
import GUI.frmTimLaptop;

public class main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDangNhap frame = new frmDangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
