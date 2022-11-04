package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.DangNhapModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public frmDangNhap() {
		
		DangNhapModel dnm = new DangNhapModel();
		
		setTitle("Đăng nhập Quản lý cửa hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Đóng");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmngChngTrnh = new JMenuItem("Đóng chương trình");
		mntmngChngTrnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmngChngTrnh);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 494, 313);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(15, 76, 146, 28);
		panel.add(lblNewLabel);
		
		textUserName = new JTextField();
		textUserName.setBounds(176, 74, 289, 36);
		panel.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(15, 122, 146, 28);
		panel.add(lblMtKhu);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int chucVu = dnm.login(textUserName.getText(), textPassword.getText());
					if (chucVu == 1) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									frmQuanLyChoAdmin frame = new frmQuanLyChoAdmin();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else if (chucVu == 2) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									frmQuanLyChoNhanVien frame = new frmQuanLyChoNhanVien();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else {
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
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(176, 203, 146, 45);
		panel.add(btnNewButton);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(176, 120, 289, 36);
		panel.add(textPassword);
	}
}
