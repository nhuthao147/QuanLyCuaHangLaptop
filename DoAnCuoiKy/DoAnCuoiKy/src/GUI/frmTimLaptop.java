package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.TimLaptopModel;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmTimLaptop extends JFrame {

	private JPanel contentPane;
	private JTextField textTen;
	private JTextField textHangSX;
	private JTextField textCpu;
	private JTextField textRam;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public frmTimLaptop() {
		
		TimLaptopModel tlm = new TimLaptopModel();
		
		setTitle("Tìm kiếm Laptop");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(0, 0, 625, 310);
		contentPane.add(tabbedPane);
		
		JPanel panelTen = new JPanel();
		tabbedPane.addTab("Tìm theo tên", new ImageIcon("C:\\icon\\name.png"), panelTen, null);
		panelTen.setLayout(null);
		
		textTen = new JTextField();
		textTen.setBounds(106, 75, 302, 41);
		panelTen.add(textTen);
		textTen.setColumns(10);
		
		JButton btnTimTen = new JButton("Tìm");
		btnTimTen.setIcon(new ImageIcon("C:\\icon\\find.png"));
		btnTimTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textTen.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số sản phẩm cần tìm!");
				}
				try {
					tlm.timTheoTen(textTen.getText());
				} catch(NullPointerException n) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
					n.printStackTrace();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTimTen.setBounds(198, 132, 117, 29);
		panelTen.add(btnTimTen);
		
		JPanel panelHang = new JPanel();
		tabbedPane.addTab("Tìm theo Hãng", new ImageIcon("C:\\icon\\brand.png"), panelHang, null);
		panelHang.setLayout(null);
		
		textHangSX = new JTextField();
		textHangSX.setColumns(10);
		textHangSX.setBounds(104, 90, 302, 41);
		panelHang.add(textHangSX);
		
		JButton btnTimHang = new JButton("Tìm");
		btnTimHang.setIcon(new ImageIcon("C:\\icon\\find.png"));
		btnTimHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textHangSX.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,	"Vui lòng nhập hãng sản phẩm cần tìm!");
				}
				try {
					tlm.timTheoHangSX(textHangSX.getText());
				} catch(NullPointerException n) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có hãng như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
					n.printStackTrace();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTimHang.setBounds(196, 147, 117, 29);
		panelHang.add(btnTimHang);
		
		JPanel panelGia = new JPanel();
		tabbedPane.addTab("Tìm theo giá", new ImageIcon("C:\\icon\\price.png"), panelGia, null);
		panelGia.setLayout(null);
		
		JTextField textGiaBan = new JTextField();
		textGiaBan.setColumns(10);
		textGiaBan.setBounds(106, 100, 302, 41);
		panelGia.add(textGiaBan);
		
		JButton btnTimGia = new JButton("Tìm");
		btnTimGia.setIcon(new ImageIcon("C:\\icon\\find.png"));
		btnTimGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textGiaBan.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,	"Vui lòng nhập giá sản phẩm cần tìm!");
				}
				try {
					tlm.timTheoGiaBan(Double.parseDouble(textGiaBan.getText()));
				} catch(NullPointerException n) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có giá như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
					n.printStackTrace();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTimGia.setBounds(198, 157, 117, 29);
		panelGia.add(btnTimGia);
		
		JPanel panelCpu = new JPanel();
		tabbedPane.addTab("Tìm theo CPU", new ImageIcon("C:\\icon\\cpu.png"), panelCpu, null);
		panelCpu.setLayout(null);
		
		textCpu = new JTextField();
		textCpu.setColumns(10);
		textCpu.setBounds(109, 95, 302, 41);
		panelCpu.add(textCpu);
		
		JButton btnTimCpu = new JButton("Tìm");
		btnTimCpu.setIcon(new ImageIcon("C:\\icon\\find.png"));
		btnTimCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textCpu.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,	"Vui lòng nhập cpu sản phẩm cần tìm!");
				}
				try {
					tlm.timTheoCpu(textCpu.getText());
				} catch(NullPointerException n) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có cpu như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
					n.printStackTrace();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTimCpu.setBounds(201, 152, 117, 29);
		panelCpu.add(btnTimCpu);
		
		JPanel panelRam = new JPanel();
		tabbedPane.addTab("Tìm theo Ram", new ImageIcon("C:\\icon\\ram.png"), panelRam, null);
		panelRam.setLayout(null);
		
		textRam = new JTextField();
		textRam.setColumns(10);
		textRam.setBounds(108, 101, 302, 41);
		panelRam.add(textRam);
		
		JButton btnTimRam = new JButton("Tìm");
		btnTimRam.setIcon(new ImageIcon("C:\\icon\\find.png"));
		btnTimRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textRam.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,	"Vui lòng nhập ram sản phẩm cần tìm!");
				}
				try {
					tlm.timTheoRam(Integer.parseInt(textRam.getText()));
				} catch(NullPointerException n) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có ram như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
					n.printStackTrace();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTimRam.setBounds(200, 158, 117, 29);
		panelRam.add(btnTimRam);
	}
}
