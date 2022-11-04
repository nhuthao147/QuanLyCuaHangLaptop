package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import DAO.ConnectDatabase;
import Model.NhanVienModel;
import Model.ThongKeSoLuongLaptop;
import Model.ThongKeSoMay;
import Model.ThongKeTongThu;
import Model.ThongKeTongTienNV;
import Model.ChiTietDonHangModel;
import Model.DangNhapModel;
import Model.DonHang;
import Model.DonHangModel;
import Model.KhachHang;
import Model.KhachHangModel;
import Model.Laptop;
import Model.LaptopModel;
import Model.NhanVien;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmQuanLyChoAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textMa;
	private JTextField textTen;
	private JTextField textSdtNV;
	private JTextField textDiaChiNV;
	private JTextField textLuongCung;
	private JTextField textLuonThuong;
	private JTextField textUsername;
	private JTextField textMaDH;
	private JTextField textGhiChu;
	private JTextField textNgayTao;
	private JTextField textThanhToan;
	private JTextField textTenNV;
	private JComboBox comboBoxMaNV;
	private JComboBox comboBoxMaKH;
	private JComboBox comboBoxMaNV2;
	private JComboBox comboBoxMaKH2;
	private JComboBox comboBoxMaLaptop;
	private JTextField textTenKH1;
	private JTextField textDiaChi1;
	private JTextField textEmail1;
	private JTextField textSdt1;
	private JTextField textMaDH2;
	private JTextField textSoLuong;
	private JTextField textTenKH;
	private JTextField textTenLaptop;
	private JTextField textMaKH1;
	private JTextField textNgayTao2;
	private JTextField textTenNV2;
	private JTextField textGhiChu2;
	private JTextField textThanhToan2;
	private JTextField textTenKH2;
	private JTextField textUsernameAd;
	private JPasswordField passwordAd;
	private JPasswordField passwordAdConf;
	private JPasswordField textPassword;
	private JFreeChart pieChart;
	private ChartPanel chartPanel;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public frmQuanLyChoAdmin() {
		NhanVienModel nvm = new NhanVienModel();
		DangNhapModel dnm = new DangNhapModel();

		DonHangModel dhm = new DonHangModel();
		ChiTietDonHangModel ctdhm = new ChiTietDonHangModel();
		KhachHangModel khm = new KhachHangModel();

		ArrayList <NhanVien> lsLaptop = new ArrayList<NhanVien>();
		String sql = "SELECT * from laptop";
		// Tao connection
		try {

			ConnectDatabase conn = new ConnectDatabase();
			Statement stmt = ConnectDatabase.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 1165, 735);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			contentPane.add(tabbedPane, BorderLayout.CENTER);

			JPanel panel = new JPanel();
			tabbedPane.addTab("Quản lý nhân viên", new ImageIcon("C:\\icon\\employee.jpg"), panel, null);
			panel.setLayout(null);

			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBounds(15, 0, 950, 347);
			panel.add(panel_2);

			textMa = new JTextField();
			textMa.setColumns(10);
			textMa.setBounds(248, 16, 338, 26);
			panel_2.add(textMa);

			JLabel lblNewLabel = new JLabel("Mã nhân viên:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(15, 19, 185, 23);
			panel_2.add(lblNewLabel);

			JLabel lblHngSnXut = new JLabel("Tên nhân viên");
			lblHngSnXut.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHngSnXut.setBounds(15, 61, 185, 23);
			panel_2.add(lblHngSnXut);

			textTen = new JTextField();
			textTen.setColumns(10);
			textTen.setBounds(248, 58, 338, 26);
			panel_2.add(textTen);

			JLabel lblMT = new JLabel("Số điện thoại:");
			lblMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMT.setBounds(15, 100, 185, 23);
			panel_2.add(lblMT);

			textSdtNV = new JTextField();
			textSdtNV.setColumns(10);
			textSdtNV.setBounds(248, 97, 338, 26);
			panel_2.add(textSdtNV);

			JLabel lblGiBn = new JLabel("Địa chỉ:");
			lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGiBn.setBounds(15, 139, 185, 23);
			panel_2.add(lblGiBn);

			textDiaChiNV = new JTextField();
			textDiaChiNV.setColumns(10);
			textDiaChiNV.setBounds(248, 136, 541, 26);
			panel_2.add(textDiaChiNV);

			textLuongCung = new JTextField();
			textLuongCung.setColumns(10);
			textLuongCung.setBounds(248, 178, 338, 26);
			panel_2.add(textLuongCung);

			JLabel lblCpu = new JLabel("Lương cứng");
			lblCpu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCpu.setBounds(15, 181, 185, 23);
			panel_2.add(lblCpu);

			JLabel lblRam = new JLabel("Thưởng hoa hồng:");
			lblRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRam.setBounds(15, 223, 218, 23);
			panel_2.add(lblRam);

			textLuonThuong = new JTextField();
			textLuonThuong.setColumns(10);
			textLuonThuong.setBounds(248, 220, 338, 26);
			panel_2.add(textLuonThuong);

			JLabel lblKchThcMn = new JLabel("Tên đăng nhập:");
			lblKchThcMn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblKchThcMn.setBounds(15, 262, 185, 23);
			panel_2.add(lblKchThcMn);

			textUsername = new JTextField();
			textUsername.setColumns(10);
			textUsername.setBounds(248, 259, 338, 26);
			panel_2.add(textUsername);

			JLabel lblSLng = new JLabel("Mật khẩu:");
			lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSLng.setBounds(15, 301, 185, 23);
			panel_2.add(lblSLng);

			textPassword = new JPasswordField();
			textPassword.setBounds(248, 301, 338, 25);
			panel_2.add(textPassword);

			JButton btnCpNhtTi = new JButton("Cập nhật tài khoản");
			btnCpNhtTi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (textMa.getText().length()==0 || textUsername.getText().length()==0 || textPassword.getText().length()==0)
						JOptionPane.showMessageDialog(null,	"Vui lòng nhập đầy đủ mã nhân viên của tài khoản cần sửa, tên đăng nhập và mật khẩu mới!");
					try {
						dnm.update(textMa.getText(), textUsername.getText(), textPassword.getText());
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Cập nhật tài khoản đăng nhập thành công!", "About", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnCpNhtTi.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnCpNhtTi.setBounds(604, 259, 185, 26);
			panel_2.add(btnCpNhtTi);

			JScrollPane scrollPaneDSNhanVien = new JScrollPane();
			scrollPaneDSNhanVien.setBounds(0, 360, 977, 231);
			panel.add(scrollPaneDSNhanVien);

			final JTable table = new JTable();
			/*			table.getTableHeader().setFont(new Font("Segoe UI", 1, 16));
			table.getColumnModel().getColumn(0).setPreferredWidth(10);

			table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			 */			
			scrollPaneDSNhanVien.setViewportView(table);
			table.setModel(nvm.getDB_NhanVien());
			//			table.setCellSelectionEnabled(true);

			JPanel panel_1_1 = new JPanel();
			panel_1_1.setLayout(null);
			panel_1_1.setBounds(15, 607, 947, 57);
			panel.add(panel_1_1);

			JButton btnThoat = new JButton("Thoát");
			btnThoat.setIcon(new ImageIcon("C:\\icon\\exit.jpg"));
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
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
			});
			btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThoat.setBounds(809, 16, 123, 35);
			panel_1_1.add(btnThoat);

			JButton btnSua = new JButton("Sửa");
			btnSua.setIcon(new ImageIcon("C:\\icon\\edit.png"));
			btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String ma=JOptionPane.showInputDialog("Nhập mã nhân viên cần sửa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số nhân viên cần sửa!");
						nvm.update(ma, textMa.getText(), textTen.getText(), textSdtNV.getText(), textDiaChiNV.getText(),
								Double.parseDouble(textLuongCung.getText()), Double.parseDouble(textLuonThuong.getText()));
						table.setModel(nvm.getDB_NhanVien());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (NumberFormatException nu) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin mới của nhân viên trước khi sửa", "About", JOptionPane.INFORMATION_MESSAGE);
					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
				}
			});
			btnSua.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSua.setBounds(671, 16, 123, 35);
			panel_1_1.add(btnSua);

			JButton btnXoa = new JButton("Xóa");
			btnXoa.setIcon(new ImageIcon("C:\\icon\\delete.png"));
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String ma=JOptionPane.showInputDialog("Nhập mã nhân viên cần xóa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số nhân viên cần xóa!");
						nvm.delete(ma);
						table.setModel(nvm.getDB_NhanVien());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnXoa.setBounds(533, 16, 123, 35);
			panel_1_1.add(btnXoa);

			JButton btnThem = new JButton("Thêm");
			btnThem.setIcon(new ImageIcon("C:\\icon\\add.png"));
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (textMa.getText().length()==0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số nhân viên cần thêm!");
						nvm.add(textMa.getText(), textTen.getText(), textSdtNV.getText(), textDiaChiNV.getText(),
								Double.parseDouble(textLuongCung.getText()), Double.parseDouble(textLuonThuong.getText()));
						dnm.addLinked(textUsername.getText(), textPassword.getText(), textMa.getText());
						table.setModel(nvm.getDB_NhanVien());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem.setBounds(395, 16, 123, 35);
			panel_1_1.add(btnThem);

			JButton btnTim = new JButton("Tìm (mã)");
			btnTim.setIcon(new ImageIcon("C:\\icon\\find.png"));
			btnTim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ma=JOptionPane.showInputDialog("Nhập mã nhân viên cần tìm: ");
					if(ma.length() == 0) {
						JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số nhân viên cần tìm!");
					}
					try {
						JOptionPane.showMessageDialog(null,	nvm.find(ma).toString());
						table.setModel(nvm.getDB_NhanVien());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnTim.setBounds(243, 16, 137, 35);
			panel_1_1.add(btnTim);

			JButton btnTnhLng = new JButton("Tính lương");
			btnTnhLng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								frmBangLuong frame = new frmBangLuong();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			btnTnhLng.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnTnhLng.setBounds(0, 16, 137, 35);
			panel_1_1.add(btnTnhLng);


			JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Thống kê hiệu suất", new ImageIcon("C:\\icon\\statistical.png"), tabbedPane_2, null);

			pieChart = createChart(createDataset());
			chartPanel = new ChartPanel(pieChart);
			tabbedPane_2.addTab("Thông kê laptop", null, chartPanel, null);
			chartPanel.setLayout(null);

			JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.BOTTOM);
			tabbedPane_2.addTab("Thống kê nhân viên", null, tabbedPane_3, null);

			ChartPanel chartPanel_1 = new ChartPanel(createChartTongTien());
			chartPanel_1.setPreferredSize(new java.awt.Dimension(560, 367));
			chartPanel_1.setLayout(null);
			tabbedPane_3.addTab("Doanh thu", null, chartPanel_1, null);

			ChartPanel chartPanel_1_1 = new ChartPanel(createChartSoMay());
			chartPanel_1_1.setLayout(null);
			chartPanel_1_1.setPreferredSize(new Dimension(560, 367));
			tabbedPane_3.addTab("Số lượng máy", null, chartPanel_1_1, null);

			JTabbedPane tabbedPane_3_1 = new JTabbedPane(JTabbedPane.BOTTOM);
			tabbedPane_2.addTab("Thống kê cửa hàng", null, tabbedPane_3_1, null);


			ChartPanel chartPanel_3 = new ChartPanel(createChartTongThu());
			chartPanel_3.setPreferredSize(new java.awt.Dimension(560, 367));
			chartPanel_3.setLayout(null);
			tabbedPane_3_1.addTab("Doanh thu", null, chartPanel_3, null);

			ChartPanel chartPanel_3_1 = new ChartPanel(createChartTongMay());
			chartPanel_3_1.setLayout(null);
			chartPanel_3_1.setPreferredSize(new Dimension(560, 367));
			tabbedPane_3_1.addTab("Số lượng máy", null, chartPanel_3_1, null);

			ChartPanel chartPanel_3_2 = new ChartPanel(createChartTheoTuan());
			chartPanel_3_1.setLayout(null);
			chartPanel_3_1.setPreferredSize(new Dimension(560, 367));
			tabbedPane_3_1.addTab("Số lượng máy theo tuần", null, chartPanel_3_2, null);

			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("Quản lý đơn hàng", new ImageIcon("C:\\icon\\order.png"), panel_1, null);
			panel_1.setLayout(null);

			JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_1.setBounds(0, 0, 975, 664);
			panel_1.add(tabbedPane_1);

			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			tabbedPane_1.addTab("Đơn hàng", null, panel_3, null);

			textMaDH = new JTextField();
			textMaDH.setColumns(10);
			textMaDH.setBounds(175, 16, 196, 26);
			panel_3.add(textMaDH);

			JLabel lblNewLabel_1 = new JLabel("Mã Đơn Hàng");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(15, 19, 157, 23);
			panel_3.add(lblNewLabel_1);

			JLabel lblKhachHang = new JLabel("Nhân viên");
			lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblKhachHang.setBounds(15, 61, 157, 23);
			panel_3.add(lblKhachHang);

			JLabel lblMT_1 = new JLabel("Ghi chú");
			lblMT_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMT_1.setBounds(15, 145, 157, 23);
			panel_3.add(lblMT_1);

			textGhiChu = new JTextField();
			textGhiChu.setColumns(10);
			textGhiChu.setBounds(175, 142, 760, 26);
			panel_3.add(textGhiChu);

			JLabel lblGiBn_1 = new JLabel("Ngày tạo");
			lblGiBn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGiBn_1.setBounds(448, 19, 92, 23);
			panel_3.add(lblGiBn_1);

			textNgayTao = new JTextField();
			textNgayTao.setColumns(10);
			textNgayTao.setBounds(547, 19, 388, 26);
			panel_3.add(textNgayTao);

			textThanhToan = new JTextField();
			textThanhToan.setColumns(10);
			textThanhToan.setBounds(175, 184, 196, 26);
			panel_3.add(textThanhToan);

			JLabel lblPhone = new JLabel("Thanh toán bằng");
			lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhone.setBounds(15, 187, 157, 23);
			panel_3.add(lblPhone);

			comboBoxMaNV = new JComboBox();
			comboBoxMaNV.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					try {
						loadThongTinNV();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			comboBoxMaNV.setBounds(175, 58, 196, 26);
			panel_3.add(comboBoxMaNV);

			textTenNV = new JTextField();
			textTenNV.setForeground(Color.BLACK);
			textTenNV.setEnabled(false);
			textTenNV.setColumns(10);
			textTenNV.setBackground(SystemColor.info);
			textTenNV.setBounds(386, 61, 549, 26);
			panel_3.add(textTenNV);

			JLabel lblNewLabel_1_1 = new JLabel("*Nhập dưới dạng yyyy-mm-dd");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_1_1.setBounds(745, 0, 205, 20);
			panel_3.add(lblNewLabel_1_1);

			JScrollPane scrollPaneDSDonHang = new JScrollPane();
			scrollPaneDSDonHang.setBounds(0, 256, 977, 301);
			panel_3.add(scrollPaneDSDonHang);

			final JTable tableDSDonHang = new JTable();
			/*			table.getTableHeader().setFont(new Font("Segoe UI", 1, 16));
			table.getColumnModel().getColumn(0).setPreferredWidth(10);

			table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			 */			
			scrollPaneDSDonHang.setViewportView(tableDSDonHang);
			tableDSDonHang.setModel(dhm.getDB_DonHang());

			JPanel panel_1_2 = new JPanel();
			panel_1_2.setLayout(null);
			panel_1_2.setBounds(15, 557, 947, 57);
			panel_3.add(panel_1_2);

			JButton btnThoat_1 = new JButton("Thoát");
			btnThoat_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
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
			});
			btnThoat_1.setIcon(new ImageIcon("C:\\icon\\exit.jpg"));
			btnThoat_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThoat_1.setBounds(808, 16, 124, 35);
			panel_1_2.add(btnThoat_1);

			JButton btnSua_1 = new JButton("Sửa");
			btnSua_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String ma=JOptionPane.showInputDialog("Nhập mã đơn hàng cần sửa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần sửa!");
						dhm.update(ma, textMaDH.getText(), Date.valueOf(textNgayTao.getText()), comboBoxMaNV.getSelectedItem().toString(),
								textGhiChu.getText(), textThanhToan.getText(), comboBoxMaKH.getSelectedItem().toString(), 0);
						tableDSDonHang.setModel(dhm.getDB_DonHang());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (NumberFormatException nu) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin mới của đơn hàng trước khi sửa", "About", JOptionPane.INFORMATION_MESSAGE);
					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
				}
			});
			btnSua_1.setIcon(new ImageIcon("C:\\icon\\edit.png"));
			btnSua_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSua_1.setBounds(528, 16, 125, 35);
			panel_1_2.add(btnSua_1);

			JButton btnXoa_1 = new JButton("Xóa");
			btnXoa_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						String ma=JOptionPane.showInputDialog("Nhập mã đơn hàng cần xóa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần xóa!");
						dhm.delete(ma);
						tableDSDonHang.setModel(dhm.getDB_DonHang());
						ctdhm.deleteByDH(ma);
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnXoa_1.setIcon(new ImageIcon("C:\\icon\\delete.png"));
			btnXoa_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnXoa_1.setBounds(388, 16, 125, 35);
			panel_1_2.add(btnXoa_1);

			JButton btnThem_1 = new JButton("Thêm");
			btnThem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						if (textMaDH.getText().length()==0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần thêm!");
						dhm.add(textMaDH.getText(), Date.valueOf(textNgayTao.getText()), comboBoxMaNV.getSelectedItem().toString(),
								textGhiChu.getText(), textThanhToan.getText(), comboBoxMaKH.getSelectedItem().toString(), 0);
						tableDSDonHang.setModel(dhm.getDB_DonHang());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnThem_1.setIcon(new ImageIcon("C:\\icon\\add_order.png"));
			btnThem_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem_1.setBounds(248, 16, 125, 35);
			panel_1_2.add(btnThem_1);

			JButton btnTim_1 = new JButton("Tìm");
			btnTim_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ma=JOptionPane.showInputDialog("Nhập mã đơn hàng cần tìm: ");
					if(ma.length() == 0) {
						JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số đơn hàng cần tìm!");
					}
					try {
						JOptionPane.showMessageDialog(null,	dhm.find(ma).toString());
						tableDSDonHang.setModel(dhm.getDB_DonHang());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnTim_1.setIcon(new ImageIcon("C:\\icon\\find.png"));
			btnTim_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnTim_1.setBounds(668, 16, 125, 35);
			panel_1_2.add(btnTim_1);

			JLabel lblKhchHng = new JLabel("Khách hàng");
			lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblKhchHng.setBounds(15, 103, 157, 23);
			panel_3.add(lblKhchHng);

			comboBoxMaKH = new JComboBox();
			comboBoxMaKH.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					try {
						loadThongTinKH();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			});
			comboBoxMaKH.setBounds(175, 100, 196, 26);
			panel_3.add(comboBoxMaKH);

			textTenKH = new JTextField();
			textTenKH.setForeground(Color.BLACK);
			textTenKH.setEnabled(false);
			textTenKH.setColumns(10);
			textTenKH.setBackground(SystemColor.info);
			textTenKH.setBounds(386, 103, 549, 26);
			panel_3.add(textTenKH);

			JLabel lblNewLabel_1_1_2 = new JLabel("Danh sách đơn hàng");
			lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
			lblNewLabel_1_1_2.setBounds(15, 236, 205, 20);
			panel_3.add(lblNewLabel_1_1_2);

			JButton btnThem_1_2 = new JButton("Refresh");
			btnThem_1_2.setIcon(new ImageIcon("C:\\icon\\refresh.jpg"));
			btnThem_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						tableDSDonHang.setModel(dhm.getDB_DonHang());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnThem_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem_1_2.setBounds(812, 230, 123, 26);
			panel_3.add(btnThem_1_2);
			table.setModel(nvm.getDB_NhanVien());
			//			table.setCellSelectionEnabled(true);

			JPanel panel_4 = new JPanel();
			tabbedPane_1.addTab("Chi tiết đơn hàng", null, panel_4, null);
			panel_4.setLayout(null);

			textMaDH2 = new JTextField();
			textMaDH2.setColumns(10);
			textMaDH2.setBounds(172, 16, 243, 26);
			panel_4.add(textMaDH2);

			JLabel lblNewLabel_1_2 = new JLabel("Mã Đơn Hàng");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1_2.setBounds(15, 16, 157, 23);
			panel_4.add(lblNewLabel_1_2);

			JLabel lblGiBn_1_2 = new JLabel("Số lượng");
			lblGiBn_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGiBn_1_2.setBounds(15, 329, 92, 23);
			panel_4.add(lblGiBn_1_2);

			textSoLuong = new JTextField();
			textSoLuong.setColumns(10);
			textSoLuong.setBounds(172, 329, 243, 26);
			panel_4.add(textSoLuong);

			JLabel lblPhone_2 = new JLabel("Tên laptop");
			lblPhone_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhone_2.setBounds(15, 288, 157, 23);
			panel_4.add(lblPhone_2);

			JScrollPane scrollPaneDSChiTietDH = new JScrollPane();
			scrollPaneDSChiTietDH.setBounds(0, 407, 977, 171);
			panel_4.add(scrollPaneDSChiTietDH);

			comboBoxMaLaptop = new JComboBox();
			comboBoxMaLaptop.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					try {
						loadThongTinLaptop();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			comboBoxMaLaptop.setBounds(172, 291, 243, 26);
			panel_4.add(comboBoxMaLaptop);

			final JTable tableDSChiTietDH = new JTable();
			/*			table.getTableHeader().setFont(new Font("Segoe UI", 1, 16));
			table.getColumnModel().getColumn(0).setPreferredWidth(10);

			table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			 */			
			scrollPaneDSChiTietDH.setViewportView(tableDSChiTietDH);
			tableDSChiTietDH.setModel(ctdhm.getNewChiTietDH());

			JPanel panel_1_2_1 = new JPanel();
			panel_1_2_1.setLayout(null);
			panel_1_2_1.setBounds(0, 573, 947, 57);
			panel_4.add(panel_1_2_1);

			JButton btnThoat_1_1 = new JButton("Thoát");
			btnThoat_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
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
			});
			btnThoat_1_1.setIcon(new ImageIcon("C:\\icon\\exit.jpg"));
			btnThoat_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThoat_1_1.setBounds(808, 16, 124, 35);
			panel_1_2_1.add(btnThoat_1_1);

			JButton btnXoa_1_1 = new JButton("Xóa laptop");
			btnXoa_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String ma=JOptionPane.showInputDialog("Nhập mã laptop cần xóa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập tên laptop cần xóa!");
						else {
							if (textSoLuong.getText().length() == 0) {
								JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng cần xóa vào ô số lượng!", "About", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								dhm.deletePriceItem(textMaDH2.getText(), ma);
								ctdhm.delete(textMaDH2.getText(), ma);
								tableDSChiTietDH.setModel(ctdhm.getDB_ChiTiet1DH(textMaDH2.getText()));
								tableDSDonHang.setModel(dhm.getDB_DonHang());
								LaptopModel.update(ma, Integer.parseInt(textSoLuong.getText()));
							}
						}
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnXoa_1_1.setIcon(new ImageIcon("C:\\icon\\delete.png"));
			btnXoa_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnXoa_1_1.setBounds(631, 16, 162, 35);
			panel_1_2_1.add(btnXoa_1_1);

			JButton btnThem_1_1 = new JButton("Thêm laptop");
			btnThem_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (textMaDH2.getText().length()==0 || textSoLuong.getText().length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần thêm!");
						if (LaptopModel.find(comboBoxMaLaptop.getSelectedItem().toString()).getSoLuong()<Integer.parseInt(textSoLuong.getText())) {
							JOptionPane.showMessageDialog(null, "Không đủ số lượng của loại laptop trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							ctdhm.add(textMaDH2.getText(), 
									comboBoxMaLaptop.getSelectedItem().toString(), Integer.parseInt(textSoLuong.getText()));
							dhm.addPriceItem(textMaDH2.getText(), comboBoxMaLaptop.getSelectedItem().toString(), Integer.parseInt(textSoLuong.getText()));
							tableDSChiTietDH.setModel(ctdhm.getDB_ChiTiet1DH(textMaDH2.getText()));
							tableDSDonHang.setModel(dhm.getDB_DonHang());
							LaptopModel.update(comboBoxMaLaptop.getSelectedItem().toString(), -Integer.parseInt(textSoLuong.getText()));
						}
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnThem_1_1.setIcon(new ImageIcon("C:\\icon\\add.png"));
			btnThem_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem_1_1.setBounds(447, 16, 169, 35);
			panel_1_2_1.add(btnThem_1_1);

			textTenLaptop = new JTextField();
			textTenLaptop.setForeground(Color.BLACK);
			textTenLaptop.setEnabled(false);
			textTenLaptop.setColumns(10);
			textTenLaptop.setBackground(SystemColor.info);
			textTenLaptop.setBounds(430, 288, 494, 26);
			panel_4.add(textTenLaptop);

			JLabel lblGiBn_1_3 = new JLabel("Ngày tạo");
			lblGiBn_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGiBn_1_3.setBounds(445, 19, 92, 23);
			panel_4.add(lblGiBn_1_3);

			textNgayTao2 = new JTextField();
			textNgayTao2.setColumns(10);
			textNgayTao2.setBounds(544, 19, 388, 26);
			panel_4.add(textNgayTao2);

			JLabel lblNewLabel_1_1_1 = new JLabel("*Nhập dưới dạng yyyy-mm-dd");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_1_1_1.setBounds(742, 0, 205, 20);
			panel_4.add(lblNewLabel_1_1_1);

			JLabel lblKhachHang_1 = new JLabel("Nhân viên");
			lblKhachHang_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblKhachHang_1.setBounds(12, 61, 157, 23);
			panel_4.add(lblKhachHang_1);

			comboBoxMaNV2 = new JComboBox();
			comboBoxMaNV2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					try {
						loadThongTinNV2();
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			});
			comboBoxMaNV2.setBounds(172, 58, 196, 26);
			panel_4.add(comboBoxMaNV2);

			textTenNV2 = new JTextField();
			textTenNV2.setForeground(Color.BLACK);
			textTenNV2.setEnabled(false);
			textTenNV2.setColumns(10);
			textTenNV2.setBackground(SystemColor.info);
			textTenNV2.setBounds(383, 61, 549, 26);
			panel_4.add(textTenNV2);

			JLabel lblKhchHng_1 = new JLabel("Khách hàng");
			lblKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblKhchHng_1.setBounds(12, 103, 157, 23);
			panel_4.add(lblKhchHng_1);

			JLabel lblMT_1_2 = new JLabel("Ghi chú");
			lblMT_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMT_1_2.setBounds(12, 145, 157, 23);
			panel_4.add(lblMT_1_2);

			JLabel lblPhone_3 = new JLabel("Thanh toán bằng");
			lblPhone_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhone_3.setBounds(12, 187, 157, 23);
			panel_4.add(lblPhone_3);

			comboBoxMaKH2 = new JComboBox();
			comboBoxMaKH2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					try {
						loadThongTinKH2();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			comboBoxMaKH2.setBounds(172, 100, 196, 26);
			panel_4.add(comboBoxMaKH2);

			textGhiChu2 = new JTextField();
			textGhiChu2.setColumns(10);
			textGhiChu2.setBounds(172, 142, 760, 26);
			panel_4.add(textGhiChu2);

			textThanhToan2 = new JTextField();
			textThanhToan2.setColumns(10);
			textThanhToan2.setBounds(172, 184, 243, 26);
			panel_4.add(textThanhToan2);

			textTenKH2 = new JTextField();
			textTenKH2.setForeground(Color.BLACK);
			textTenKH2.setEnabled(false);
			textTenKH2.setColumns(10);
			textTenKH2.setBackground(SystemColor.info);
			textTenKH2.setBounds(383, 103, 549, 26);
			panel_4.add(textTenKH2);

			JLabel lblNewLabel_1_1_1_1 = new JLabel("Danh sách sản phẩm");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
			lblNewLabel_1_1_1_1.setBounds(15, 371, 205, 20);
			panel_4.add(lblNewLabel_1_1_1_1);

			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_5.setBounds(0, 0, 987, 266);
			panel_4.add(panel_5);
			panel_5.setLayout(null);

			JButton btnTimChiTiet = new JButton("Xem đơn hàng");
			btnTimChiTiet.setBounds(500, 220, 217, 30);
			panel_5.add(btnTimChiTiet);
			btnTimChiTiet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						setCTDH();
						tableDSChiTietDH.setModel(ctdhm.getDB_ChiTiet1DH(textMaDH2.getText()));
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}catch(NullPointerException e1) {
						JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần xem!");
					}
				}
			});
			btnTimChiTiet.setIcon(new ImageIcon("C:\\icon\\read.png"));
			btnTimChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 18));

			JButton btnIn = new JButton("Thêm đơn hàng");
			btnIn.setBounds(196, 220, 217, 30);
			panel_5.add(btnIn);
			btnIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (textMaDH2.getText().length()==0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần thêm!");
						dhm.add(textMaDH2.getText(), Date.valueOf(textNgayTao2.getText()), comboBoxMaNV2.getSelectedItem().toString(),
								textGhiChu2.getText(), textThanhToan2.getText(), comboBoxMaKH2.getSelectedItem().toString(), 0);
						tableDSDonHang.setModel(dhm.getDB_DonHang());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}catch(NullPointerException e1) {
						JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần thêm!");
					}
					JOptionPane.showMessageDialog(null, "Thêm đơn hàng thành công!", "About", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnIn.setIcon(new ImageIcon("C:\\icon\\add_order.png"));
			btnIn.setFont(new Font("Tahoma", Font.PLAIN, 18));

			JButton btnThem_1_2_1 = new JButton("Refresh");
			btnThem_1_2_1.setIcon(new ImageIcon("C:\\icon\\refresh.jpg"));
			btnThem_1_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						tableDSChiTietDH.setModel(ctdhm.getDB_ChiTiet1DH(textMaDH2.getText()));
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			});
			btnThem_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem_1_2_1.setBounds(801, 365, 131, 26);
			panel_4.add(btnThem_1_2_1);
			//			table.setCellSelectionEnabled(true);
			//			table.setModel(ctdhm.getDB_DonHang());
			//			table.setCellSelectionEnabled(true);

			DefaultComboBoxModel model = new DefaultComboBoxModel();
			JComboBox cbo_cus = new JComboBox (model);

			JPanel panel_2_1 = new JPanel();
			panel_2_1.setLayout(null);
			tabbedPane.addTab("Quản lý khách hàng", new ImageIcon("C:\\icon\\customer.png"), panel_2_1, null);

			JLabel lblHngSnXut_1 = new JLabel("Tên Khách Hàng");
			lblHngSnXut_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHngSnXut_1.setBounds(10, 62, 157, 23);
			panel_2_1.add(lblHngSnXut_1);

			textTenKH1 = new JTextField();
			textTenKH1.setColumns(10);
			textTenKH1.setBounds(175, 59, 338, 26);
			panel_2_1.add(textTenKH1);

			textDiaChi1 = new JTextField();
			textDiaChi1.setColumns(10);
			textDiaChi1.setBounds(175, 98, 681, 26);
			panel_2_1.add(textDiaChi1);

			JLabel lblMT_1_1 = new JLabel("Địa chỉ");
			lblMT_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMT_1_1.setBounds(10, 101, 157, 23);
			panel_2_1.add(lblMT_1_1);

			JLabel lblGiBn_1_1 = new JLabel("Email");
			lblGiBn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGiBn_1_1.setBounds(10, 140, 157, 23);
			panel_2_1.add(lblGiBn_1_1);

			textEmail1 = new JTextField();
			textEmail1.setColumns(10);
			textEmail1.setBounds(175, 137, 338, 26);
			panel_2_1.add(textEmail1);

			JLabel lblPhone_1 = new JLabel("Điện thoại");
			lblPhone_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhone_1.setBounds(10, 176, 157, 23);
			panel_2_1.add(lblPhone_1);

			textSdt1 = new JTextField();
			textSdt1.setColumns(10);
			textSdt1.setBounds(175, 173, 338, 26);
			panel_2_1.add(textSdt1);

			JScrollPane scrollPaneDSKH = new JScrollPane();
			scrollPaneDSKH.setBounds(0, 215, 977, 334);
			panel_2_1.add(scrollPaneDSKH);

			final JTable tableDSKH= new JTable();
			/*			table.getTableHeader().setFont(new Font("Segoe UI", 1, 16));
							table.getColumnModel().getColumn(0).setPreferredWidth(10);

							table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			 */			
			scrollPaneDSKH.setViewportView(tableDSKH);
			tableDSKH.setModel(khm.getDB_KhachHang());
			//							table.setCellSelectionEnabled(true);

			JPanel panel_1_1_1 = new JPanel();
			panel_1_1_1.setLayout(null);
			panel_1_1_1.setBounds(10, 578, 947, 57);
			panel_2_1.add(panel_1_1_1);

			JButton btnThoat_2 = new JButton("Thoát");
			btnThoat_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
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
			});
			btnThoat_2.setIcon(new ImageIcon("C:\\icon\\exit.jpg"));
			btnThoat_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThoat_2.setBounds(809, 16, 123, 35);
			panel_1_1_1.add(btnThoat_2);

			JButton btnSua_2 = new JButton("Sửa");
			btnSua_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String ma=JOptionPane.showInputDialog("Nhập mã khách hàng cần sửa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã khách hàng cần sửa!");
						khm.update(ma, textMaKH1.getText(), textTenKH1.getText(),
								textSdt1.getText(), textEmail1.getText(), textDiaChi1.getText());
						tableDSKH.setModel(khm.getDB_KhachHang());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (NumberFormatException nu) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin mới của đơn hàng trước khi sửa", "About", JOptionPane.INFORMATION_MESSAGE);
					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						e1.printStackTrace();
					}
				}
			});
			btnSua_2.setIcon(new ImageIcon("C:\\icon\\edit.png"));
			btnSua_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSua_2.setBounds(671, 16, 123, 35);
			panel_1_1_1.add(btnSua_2);

			JButton btnXoa_2 = new JButton("Xóa");
			btnXoa_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String ma=JOptionPane.showInputDialog("Nhập mã khách hàng cần xóa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã khách hàng cần xóa!");
						khm.delete(ma);
						tableDSKH.setModel(khm.getDB_KhachHang());
						dhm.deleteByNV(ma);
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnXoa_2.setIcon(new ImageIcon("C:\\icon\\delete.png"));
			btnXoa_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnXoa_2.setBounds(533, 16, 123, 35);
			panel_1_1_1.add(btnXoa_2);

			JButton btnThem_2 = new JButton("Thêm");
			btnThem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (textMaKH1.getText().length()==0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần thêm!");
						khm.add(textMaKH1.getText(), textTenKH1.getText(),
								textSdt1.getText(), textEmail1.getText(), textDiaChi1.getText());
						tableDSKH.setModel(khm.getDB_KhachHang());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnThem_2.setIcon(new ImageIcon("C:\\icon\\add.png"));
			btnThem_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem_2.setBounds(395, 16, 123, 35);
			panel_1_1_1.add(btnThem_2);

			JButton btnTim_2 = new JButton("Tìm (mã)");
			btnTim_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ma=JOptionPane.showInputDialog("Nhập tên khách hàng cần tìm: ");
					if(ma.length() == 0) {
						JOptionPane.showMessageDialog(null,	"Vui lòng nhập tên khách hàng cần tìm!");
					}
					try {
						JOptionPane.showMessageDialog(null,	khm.find(ma).toString());
						tableDSKH.setModel(khm.getDB_KhachHang());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnTim_2.setIcon(new ImageIcon("C:\\icon\\find.png"));
			btnTim_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnTim_2.setBounds(243, 16, 137, 35);
			panel_1_1_1.add(btnTim_2);

			JLabel lblHngSnXut_1_1 = new JLabel("Mã khách Hàng");
			lblHngSnXut_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHngSnXut_1_1.setBounds(15, 20, 157, 23);
			panel_2_1.add(lblHngSnXut_1_1);

			textMaKH1 = new JTextField();
			textMaKH1.setColumns(10);
			textMaKH1.setBounds(175, 17, 338, 26);
			panel_2_1.add(textMaKH1);

			JPanel panel_6 = new JPanel();
			tabbedPane.addTab("Thêm admin", new ImageIcon("C:\\icon\\admin.png"), panel_6, null);
			panel_6.setLayout(null);

			textUsernameAd = new JTextField();
			textUsernameAd.setBounds(271, 215, 600, 50);
			panel_6.add(textUsernameAd);
			textUsernameAd.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("TẠO TÀI KHOẢN ADMIN MỚI");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
			lblNewLabel_2.setBounds(295, 107, 341, 55);
			panel_6.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Xác nhận mật khẩu");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(61, 375, 195, 48);
			panel_6.add(lblNewLabel_3);

			JLabel lblNewLabel_3_1 = new JLabel("Mật khẩu");
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3_1.setBounds(61, 294, 195, 48);
			panel_6.add(lblNewLabel_3_1);

			JLabel lblNewLabel_3_2 = new JLabel("Tên đăng nhập");
			lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3_2.setBounds(61, 215, 195, 48);
			panel_6.add(lblNewLabel_3_2);

			passwordAd = new JPasswordField();
			passwordAd.setBounds(271, 295, 600, 50);
			panel_6.add(passwordAd);

			passwordAdConf = new JPasswordField();
			passwordAdConf.setBounds(271, 373, 600, 50);
			panel_6.add(passwordAdConf);

			JButton btnNewButton = new JButton("Tạo tài khoản");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!passwordAd.getText().equals(passwordAdConf.getText())) 
						JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp!", "About", JOptionPane.INFORMATION_MESSAGE);
					else {
						try {
							dnm.addAdmin(textUsernameAd.getText(), passwordAd.getText());
							JOptionPane.showMessageDialog(null, "Thêm admin thành công!", "About", JOptionPane.INFORMATION_MESSAGE);
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton.setBounds(374, 458, 195, 42);
			panel_6.add(btnNewButton);

			addBoxMaNV ();
			addBoxMaKH ();
			addBoxMaLaptop();

		}		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// lay danh sach laptop them vao combobox ten laptop
	JComboBox addBoxLaptop() throws ClassNotFoundException, SQLException {
		JComboBox cbx = null;
		Connection conn = ConnectDatabase.getConnection();
		try {
			Statement st = conn.createStatement();
			String query = "Select * from laptop;";
			ResultSet rs = st.executeQuery(query);
			cbx = new JComboBox();
			while (rs.next()) {
				cbx.addItem(rs.getString(2));
			}
		}catch (Exception x) {
			System.out.println(x.getMessage());
		}
		return cbx;
	}
	// lay ma NV them vao combox maNV
	void addBoxMaNV () throws ClassNotFoundException, SQLException {
		Connection conn = ConnectDatabase.getConnection();
		try {
			Statement st = conn.createStatement();
			String query = "Select * from nhanvien;";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				comboBoxMaNV.addItem(rs.getString(1));
				comboBoxMaNV2.addItem(rs.getString(1));
			}
		}catch (Exception x) {
			System.out.println(x.getMessage());
		}
	}
	// load thong tin vao o ten NV
	public void loadThongTinNV() throws ClassNotFoundException, SQLException {
		NhanVien DonHang = NhanVienModel.find(comboBoxMaNV.getSelectedItem().toString());
		textTenNV.setText(DonHang.getTenNV());
	}
	public void loadThongTinNV2() throws ClassNotFoundException, SQLException {
		NhanVien DonHang = NhanVienModel.find(comboBoxMaNV2.getSelectedItem().toString());
		textTenNV2.setText(DonHang.getTenNV());
	}
	void addBoxMaKH () throws ClassNotFoundException, SQLException {
		Connection conn = ConnectDatabase.getConnection();
		try {
			Statement st = conn.createStatement();
			String query = "Select * from khachhang;";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				comboBoxMaKH.addItem(rs.getString("maKH"));
				comboBoxMaKH2.addItem(rs.getString("maKH"));
			}
		}catch (Exception x) {
			System.out.println(x.getMessage());
		}
	}
	public void loadThongTinKH() throws ClassNotFoundException, SQLException {
		KhachHang DonHang = KhachHangModel.find(comboBoxMaKH.getSelectedItem().toString());
		textTenKH.setText(DonHang.getTenKH());
	}
	public void loadThongTinKH2() throws ClassNotFoundException, SQLException {
		KhachHang DonHang = KhachHangModel.find(comboBoxMaKH2.getSelectedItem().toString());
		textTenKH2.setText(DonHang.getTenKH());
	}
	void addBoxMaLaptop () throws ClassNotFoundException, SQLException {
		Connection conn = ConnectDatabase.getConnection();
		try {
			Statement st = conn.createStatement();
			String query = "Select * from laptop;";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				comboBoxMaLaptop.addItem(rs.getString("maSo"));
			}
		}catch (Exception x) {
			System.out.println(x.getMessage());
		}
	}
	public void loadThongTinLaptop() throws ClassNotFoundException, SQLException {
		Laptop DonHang = LaptopModel.find(comboBoxMaLaptop.getSelectedItem().toString());
		textTenLaptop.setText(DonHang.getTen());
	}
	public void setCTDH() throws ClassNotFoundException, SQLException {
		DonHang a = DonHangModel.find(textMaDH2.getText());
		textNgayTao2.setText(a.getNgayTao().toString());
		comboBoxMaNV2.setSelectedItem(a.getmaNV());
		comboBoxMaKH2.setSelectedItem(a.getMaKH());
		loadThongTinNV2();
		loadThongTinKH2();
		textGhiChu2.setText(a.getGhiChu());
		textThanhToan2.setText(a.getThanhToan());
	}
	private static PieDataset createDataset() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeSoLuongLaptop> lsSoLuong= ChiTietDonHangModel.getDataForTK();
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (ThongKeSoLuongLaptop temp : lsSoLuong)
			dataset.setValue(LaptopModel.find(temp.getMaLaptop()).getTen(), temp.getSoLuong());
		return dataset;
	}
	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart(
				"Thống kê số lượng các loại laptop đã bán được trong 1 tháng qua", dataset, true, true, true);
		return chart;
	}
	private static CategoryDataset createDatasetTongTien() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongTienNV> lsSoLuong= DonHangModel.getDataForTKTongTien();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (ThongKeTongTienNV temp : lsSoLuong)
			dataset.addValue( temp.gettongTien(),"Tên nhân viên", NhanVienModel.find(temp.getmaNV()).getTenNV());
		return dataset;
	}
	private static JFreeChart createChartTongTien() throws ClassNotFoundException, SQLException {
		JFreeChart chart = ChartFactory.createBarChart(
				"Thống kê tổng doanh thu bán được của mỗi nhân viên.", "Nhân viên", "Tổng doanh thu bán được",
				createDatasetTongTien(), PlotOrientation.VERTICAL, false, false, false);
		return chart;
	}
	private static CategoryDataset createDatasetSoMay() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeSoMay> lsSoLuong= DonHangModel.getDataForTKSoMay();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (ThongKeSoMay temp : lsSoLuong)
			dataset.addValue( temp.getSoLuong(),"Tên nhân viên", NhanVienModel.find(temp.getmaNV()).getTenNV());
		return dataset;
	}
	private static JFreeChart createChartSoMay() throws ClassNotFoundException, SQLException {
		JFreeChart chart = ChartFactory.createBarChart(
				"Thống kê tổng số laptop bán được của mỗi nhân viên.", "Nhân viên", "Tổng số máy bán được",
				createDatasetSoMay(), PlotOrientation.VERTICAL, false, false, false);
		return chart;
	}
	private static CategoryDataset createDatasetTongThu() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongThu> lsSoLuong= DonHangModel.getDataForTKTongThu6Thang();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (ThongKeTongThu temp : lsSoLuong)
			dataset.addValue( temp.getTongThu(),"Tháng", temp.getTen());
		return dataset;
	}
	private static JFreeChart createChartTongThu() throws ClassNotFoundException, SQLException {
		JFreeChart chart = ChartFactory.createBarChart(
				"Thống kê tổng thu 6 tháng gần nhất.", "Tháng", "Tổng thu",
				createDatasetTongThu(), PlotOrientation.VERTICAL, false, false, false);
		return chart;
	}
	private static CategoryDataset createDatasetTongMay() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongThu> lsSoLuong= DonHangModel.getDataForTKTongMay6Thang();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (ThongKeTongThu temp : lsSoLuong)
			dataset.addValue( temp.getTongThu(),"Tháng", temp.getTen());
		return dataset;
	}
	private static JFreeChart createChartTongMay() throws ClassNotFoundException, SQLException {
		JFreeChart chart = ChartFactory.createBarChart(
				"Thống kê tổng số máy 6 tháng gần nhất.", "Tháng", "Tổng số máy",
				createDatasetTongMay(), PlotOrientation.VERTICAL, false, false, false);
		return chart;
	}
	private static CategoryDataset createDatasetTheoTuan() throws ClassNotFoundException, SQLException {
		ArrayList<ThongKeTongThu> lsSoLuong= DonHangModel.getDataForTKTongThuTheoTuan();
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (ThongKeTongThu temp : lsSoLuong)
			dataset.addValue( temp.getTongThu(),"Tên nhân viên", temp.getTen());
		return dataset;
	}
	private static JFreeChart createChartTheoTuan() throws ClassNotFoundException, SQLException {
		JFreeChart chart = ChartFactory.createBarChart(
				"Thống kê số lượng laptop theo ngày trong tuần trong 1 tháng qua.", "Thứ", "Tổng số máy",
				createDatasetTheoTuan(), PlotOrientation.VERTICAL, false, false, false);
		return chart;
	}
}
