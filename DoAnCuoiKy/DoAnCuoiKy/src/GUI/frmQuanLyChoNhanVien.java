package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import DAO.ConnectDatabase;
import Model.ChiTietDonHang;
import Model.ChiTietDonHangModel;
import Model.DonHang;
import Model.DonHangModel;
import Model.KhachHang;
import Model.KhachHangModel;
import Model.Laptop;
import Model.LaptopModel;
import Model.NhanVien;
import Model.NhanVienModel;

import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class frmQuanLyChoNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textMa;
	private JTextField textTen;
	private JTextField textGiaBan;
	private JTextField textHangSX;
	private JTextField textCpu;
	private JTextField textRam;
	private JTextField textKichThuocMH;
	private JTextField textSoLuong;
	private JTextField textSoLuong2;
	private JTextField textMaDH;
	private JTextField textGhiChu;
	private JTextField textNgayTao;
	private JTextField textThanhToan;
	private JTextField textTenNV;
	private JComboBox comboBoxMaNV;
	private JComboBox comboBoxMaKH ;
	private JComboBox comboBoxMaLaptop;
	private JComboBox comboBoxMaNV2;
	private JComboBox comboBoxMaKH2;
	private JTextField textTenKH;
	private JTextField textTenKH1;
	private JTextField textMaDH2;
	private JTextField textTenLaptop;
	private JTextField textNgayTao2;
	private JTextField textGhiChu2;
	private JTextField textThanhToan2;
	private JTextField textTenNV2;
	private JTextField textTenKH2;
	private JTextField textDiaChi1;
	private JTextField textEmail1;
	private JTextField textSdt1;
	private JTextField textMaKH1;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public frmQuanLyChoNhanVien() {
		ChiTietDonHangModel ctdhm = new ChiTietDonHangModel();
		DonHangModel dhm = new DonHangModel();
		KhachHangModel khm = new KhachHangModel();
		NhanVienModel nvm = new NhanVienModel();

		LaptopModel lpm = new LaptopModel();

		ArrayList <Laptop> lsLaptop = new ArrayList<Laptop>();
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
			tabbedPane.addTab("Quản lý kho hàng", new ImageIcon("C:\\icon\\warehouse.jpg"), panel, null);
			panel.setLayout(null);

			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBounds(15, 0, 950, 347);
			panel.add(panel_2);

			textMa = new JTextField();
			textMa.setColumns(10);
			textMa.setBounds(220, 16, 338, 26);
			panel_2.add(textMa);

			JLabel lblNewLabel = new JLabel("Mã Laptop:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(15, 19, 185, 23);
			panel_2.add(lblNewLabel);

			JLabel lblHngSnXut = new JLabel("Tên");
			lblHngSnXut.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHngSnXut.setBounds(15, 61, 185, 23);
			panel_2.add(lblHngSnXut);

			textTen = new JTextField();
			textTen.setColumns(10);
			textTen.setBounds(220, 58, 338, 26);
			panel_2.add(textTen);

			JLabel lblMT = new JLabel("Giá bán");
			lblMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMT.setBounds(15, 100, 185, 23);
			panel_2.add(lblMT);

			textGiaBan = new JTextField();
			textGiaBan.setColumns(10);
			textGiaBan.setBounds(220, 97, 338, 26);
			panel_2.add(textGiaBan);

			JLabel lblGiBn = new JLabel("Hãng sản xuất");
			lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblGiBn.setBounds(15, 139, 185, 23);
			panel_2.add(lblGiBn);

			textHangSX = new JTextField();
			textHangSX.setColumns(10);
			textHangSX.setBounds(220, 136, 338, 26);
			panel_2.add(textHangSX);

			textCpu = new JTextField();
			textCpu.setColumns(10);
			textCpu.setBounds(220, 178, 521, 26);
			panel_2.add(textCpu);

			JLabel lblCpu = new JLabel("CPU");
			lblCpu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCpu.setBounds(15, 181, 185, 23);
			panel_2.add(lblCpu);

			JLabel lblRam = new JLabel("Ram");
			lblRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRam.setBounds(15, 223, 185, 23);
			panel_2.add(lblRam);

			textRam = new JTextField();
			textRam.setColumns(10);
			textRam.setBounds(220, 220, 338, 26);
			panel_2.add(textRam);

			JLabel lblKchThcMn = new JLabel("Kích thước màn hình");
			lblKchThcMn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblKchThcMn.setBounds(15, 262, 185, 23);
			panel_2.add(lblKchThcMn);

			textKichThuocMH = new JTextField();
			textKichThuocMH.setColumns(10);
			textKichThuocMH.setBounds(220, 259, 338, 26);
			panel_2.add(textKichThuocMH);

			JLabel lblSLng = new JLabel("Số lượng");
			lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSLng.setBounds(15, 301, 185, 23);
			panel_2.add(lblSLng);

			textSoLuong2 = new JTextField();
			textSoLuong2.setColumns(10);
			textSoLuong2.setBounds(220, 298, 338, 26);
			panel_2.add(textSoLuong2);

			JScrollPane scrollPaneDSLaptop = new JScrollPane();
			scrollPaneDSLaptop.setBounds(0, 360, 977, 231);
			panel.add(scrollPaneDSLaptop);

			final JTable table = new JTable();
			/*			table.getTableHeader().setFont(new Font("Segoe UI", 1, 16));
			table.getColumnModel().getColumn(0).setPreferredWidth(10);

			table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			 */			
			scrollPaneDSLaptop.setViewportView(table);
			table.setModel(lpm.getDB_Laptop());
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
						String ma=JOptionPane.showInputDialog("Nhập mã sản phẩm cần sửa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số sản phẩm cần sửa!");
						LaptopModel.update(ma, textMa.getText(), textTen.getText(), Double.parseDouble(textGiaBan.getText()), textHangSX.getText(),
								textCpu.getText(), Integer.parseInt(textRam.getText()), textKichThuocMH.getText() , Integer.parseInt(textSoLuong2.getText()));
						table.setModel(lpm.getDB_Laptop());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (NumberFormatException nu) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin mới của sản phẩm trước khi sửa", "About", JOptionPane.INFORMATION_MESSAGE);
					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
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
						String ma=JOptionPane.showInputDialog("Nhập mã sản phẩm cần xóa: ");
						if(ma.length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số sản phẩm cần xóa!");
						LaptopModel.delete(ma);
						table.setModel(lpm.getDB_Laptop());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException | SQLException e1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
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
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số sản phẩm cần thêm!");
						LaptopModel.add(textMa.getText(), textTen.getText(), Double.parseDouble(textGiaBan.getText()), textHangSX.getText(),
								textCpu.getText(), Integer.parseInt(textRam.getText()), textKichThuocMH.getText() , Integer.parseInt(textSoLuong2.getText()));
						table.setModel(lpm.getDB_Laptop());
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
					String ma=JOptionPane.showInputDialog("Nhập mã sản phẩm cần tìm: ");
					if(ma.length() == 0) {
						JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã số sản phẩm cần tìm!");
					}
					try {
						JOptionPane.showMessageDialog(null,	lpm.find(ma).toString());
						table.setModel(lpm.getDB_Laptop());
					} catch(NullPointerException n) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã như trên!", "About", JOptionPane.INFORMATION_MESSAGE);
						n.printStackTrace();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnTim.setBounds(243, 16, 137, 35);
			panel_1_1.add(btnTim);

			JButton btnTmkhc = new JButton("Tìm (khác)");
			btnTmkhc.setIcon(new ImageIcon("C:\\icon\\another.png"));
			btnTmkhc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								frmTimLaptop frame = new frmTimLaptop();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			btnTmkhc.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnTmkhc.setBounds(15, 16, 149, 35);
			panel_1_1.add(btnTmkhc);

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
			btnThem_1_2.setBounds(840, 233, 122, 26);
			panel_3.add(btnThem_1_2);
			table.setModel(lpm.getDB_Laptop());
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
			lblGiBn_1_2.setBounds(15, 332, 92, 23);
			panel_4.add(lblGiBn_1_2);

			textSoLuong = new JTextField();
			textSoLuong.setColumns(10);
			textSoLuong.setBounds(172, 332, 243, 26);
			panel_4.add(textSoLuong);

			JLabel lblPhone_2 = new JLabel("Tên laptop");
			lblPhone_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPhone_2.setBounds(15, 291, 157, 23);
			panel_4.add(lblPhone_2);

			JScrollPane scrollPaneDSChiTietDH = new JScrollPane();
			scrollPaneDSChiTietDH.setBounds(0, 410, 977, 168);
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
			comboBoxMaLaptop.setBounds(172, 294, 243, 26);
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
						if (textSoLuong.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng cần xóa vào ô số lượng!", "About", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							dhm.deletePriceItem(textMaDH2.getText(), ma);
							ctdhm.delete(textMaDH2.getText(), ma);
							tableDSChiTietDH.setModel(ctdhm.getDB_ChiTiet1DH(textMaDH2.getText()));
							tableDSDonHang.setModel(dhm.getDB_DonHang());
							LaptopModel.update(ma, Integer.parseInt(textSoLuong.getText()));
							table.setModel(lpm.getDB_Laptop());	
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
			btnXoa_1_1.setBounds(635, 16, 158, 35);
			panel_1_2_1.add(btnXoa_1_1);

			JButton btnThem_1_1 = new JButton("Thêm laptop");
			btnThem_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (textMaDH2.getText().length()==0 || textSoLuong.getText().length() == 0)
							JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần thêm!");
						else {
							if (lpm.find(comboBoxMaLaptop.getSelectedItem().toString()).getSoLuong() < Integer.parseInt(textSoLuong.getText())) {
								JOptionPane.showMessageDialog(null, "Không đủ số lượng của loại laptop trên!", "About", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								ctdhm.add(textMaDH2.getText(), 
										comboBoxMaLaptop.getSelectedItem().toString(), Integer.parseInt(textSoLuong.getText()));
								dhm.addPriceItem(textMaDH2.getText(), comboBoxMaLaptop.getSelectedItem().toString(), Integer.parseInt(textSoLuong.getText()));
								tableDSChiTietDH.setModel(ctdhm.getDB_ChiTiet1DH(textMaDH2.getText()));
								tableDSDonHang.setModel(dhm.getDB_DonHang());
								LaptopModel.update(comboBoxMaLaptop.getSelectedItem().toString(), -Integer.parseInt(textSoLuong.getText()));
								table.setModel(lpm.getDB_Laptop());
							}
						}
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnThem_1_1.setIcon(new ImageIcon("C:\\icon\\add.png"));
			btnThem_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem_1_1.setBounds(454, 16, 166, 35);
			panel_1_2_1.add(btnThem_1_1);

			textTenLaptop = new JTextField();
			textTenLaptop.setForeground(Color.BLACK);
			textTenLaptop.setEnabled(false);
			textTenLaptop.setColumns(10);
			textTenLaptop.setBackground(SystemColor.info);
			textTenLaptop.setBounds(430, 291, 494, 26);
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
			lblNewLabel_1_1_1_1.setBounds(15, 374, 205, 20);
			panel_4.add(lblNewLabel_1_1_1_1);

			JPanel panel_5 = new JPanel();
			panel_5.setBorder( new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_5.setBounds(0, 0, 987, 275);
			panel_4.add(panel_5);
			panel_5.setLayout(null);

			JButton btnIn = new JButton("Thêm đơn hàng");
			btnIn.setBounds(181, 229, 235, 30);
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

			JButton btnTimChiTiet = new JButton("Xem đơn hàng");
			btnTimChiTiet.setBounds(542, 229, 235, 30);
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

			JButton btnThem_1_2_1 = new JButton("Refresh");
			btnThem_1_2_1.setIcon(new ImageIcon("C:\\icon\\refresh.jpg"));
			btnThem_1_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						tableDSChiTietDH.setModel(ctdhm.getDB_ChiTiet1DH(textMaDH2.getText()));
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnThem_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnThem_1_2_1.setBounds(833, 368, 122, 26);
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
		Statement st = conn.createStatement();
		String query = "Select * from khachhang;";
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			comboBoxMaKH.addItem(rs.getString("maKH"));
			comboBoxMaKH2.addItem(rs.getString("maKH"));
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
		try {
			DonHang a = DonHangModel.find(textMaDH2.getText());
			textNgayTao2.setText(a.getNgayTao().toString());
			comboBoxMaNV2.setSelectedItem(a.getmaNV());
			comboBoxMaKH2.setSelectedItem(a.getMaKH());
			loadThongTinNV2();
			loadThongTinKH2();
			textGhiChu2.setText(a.getGhiChu());
			textThanhToan2.setText(a.getThanhToan());
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null,	"Vui lòng nhập mã đơn hàng cần thêm!");
		}
	}
}