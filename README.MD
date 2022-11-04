# QuanLyCuaHangLaptop
CHƯƠNG 1: TÓM TẮT CƠ SỞ LÝ THUYẾT
1.1.	Cơ sở lý thuyết thiết kế giao diện
 	Đồ án chủ yếu sử dụng thư viện Java Swing để thiết kế giao diện.
 	Giới thiệu về Java Swing thì Java Swing là một phần của Java Foundation Classes (JFC) được sử dụng để tạo các ứng dụng window-based. Nó được xây dựng trên API AWT (Abstract Windowing Toolkit) và được viết hoàn toàn bằng Java.
 	Gói javax.swing cung cấp các lớp cho java swing API như JButton, JTextField, JTextArea, JRadioButton, JCheckbox, JMenu, JColorChooser, …
 	Các lớp java Swing trong đồ án sử dụng có thể kể đến như JButton, JTextField, JTextArea, JradioButton, JfreeChart,…
1.2.	Cơ sở lý thuyết thiết chức năng
 	Sử dụng các kĩ thuật lập trình cơ bản với ngôn ngữ java.
 	Sử dụng phương pháp lập trình hướng đối tượng (OOP) trong ngôn ngữ lập trình java để thiết kế các lớp và các đối tượng có trong đồ án. là một kỹ thuật lập trình cho phép lập trình viên tạo ra các đối tượng trong code trừu tượng hóa các đối tượng.
 	Sử dụng những đặc tính cơ bản của lập trình hướng đối tượng trong java để áp dụng vô đồ án:
	Tính đóng gói là tính chất không cho phép người dùng hay đối tượng khác thay đổi dữ liệu thành viên của đối tượng nội tại. Chỉ có các hàm thành viên của đối tượng đó mới có quyền thay đổi trạng thái nội tại của nó
	Tính kế thừa có thể được định nghĩa là quá trình mà một lớp (class) có được các thuộc tính của một lớp khác. Các thuộc tính đó có thể là một phương thức (method) hoặc một trường (field) nào đó. Lớp được kế thừa sẽ được gọi chung là lớp cha, còn lớp kế thừa sẽ được gọi chung là lớp con. Tính kế thừa cho phép xây dựng một lớp mới dựa trên các định nghĩa của lớp đã có.
 	Giới thiệu về JDBC, JDBC là viết tắt của Java Database Connectivity, là một Java API chuẩn để kết nối giữa ngôn ngữ lập trình Java và các cơ sở dữ liệu đa dạng. Sử dụng JDBC, bạn có thể thực hiện nhiều tác vụ đa dạng khi làm việc với cơ sở dữ liệu như tạo, xóa cơ sở dữ liệu; tạo và thực thi các lệnh SQL hoặc MySQL; tạo, xóa các bản ghi.
 	Các thành phần của JDBC được sử dụng trong đồ án:
	DriverManager: Lớp này quản lý các Database Driver. Ánh xạ các yêu cầu kết nối từ ứng dụng Java với Data driver thích hợp bởi sử dụng giao thức kết nối phụ.
	Driver: Interface này xử lý các kết nối với Database Server. Hiếm khi, bạn tương tác trực tiếp với các đối tượng Driver này. Thay vào đó, bạn sử dụng các đối tượng DriverManager để quản lý các đối tượng kiểu này.
	Connection: Đối tượng Connection biểu diễn ngữ cảnh giao tiếp. Interface này chứa nhiều phương thức đa dạng để tạo kết nối với một Database.
	PreparedStatement – Sử dụng để thực hiện các câu truy vấn SQL động hoặc có tham số, nó thừa kế từ Statement nhưng nó cho phép truyền các tham số vào câu SQL trong thời gian run time.
	ResultSet: Các đối tượng này giữ dữ liệu được thu nhận từ một Database sau khi bạn thực thi một truy vấn SQL. Nó nóng vai trò như một Iterator để cho phép bạn lọc qua dữ liệu của nó.
 
CHƯƠNG 2: GIỚI THIỆU HỆ THỐNG
2.1.	Mô tả sơ bộ ứng dụng
 	Admin (chủ quản):
	Quản lí thông tin của nhân viên gồm xem, thêm, xóa, sửa
	Quản lí các đơn hàng được bán
	Quản lí danh sách khách hàng mua bán
 	Nhân viên:
	Quản lí kho hàng: hàng nhập, xuất kho
	Quản lý đơn hàng: tạo đơn, xóa đơn
2.2.	Các Form giao diện và chức năng
 	Form đăng nhập:
	Có chức năng xác nhận người đăng nhập admin hay nhân viên.
 	Form dành cho người quản lý (admin): mỗi phần sẽ có một form hỗ trợ công việc
	Quản lý nhân viên
	Quản lý đơn hàng
	Quản lý khách hàng
	Thống kê hiệu suất
	Tạo tài khoản admin
 	Form làm việc cho các nhân viên: mỗi phần sẽ có 1 form hỗ trợ công việc:
	Quản lý kho hàng
	Quản lý đơn hàng
	Quản lý khách hàng
2.3.	Công cụ và ngôn ngữ xây dựng đề tài
 	Ngôn ngữ: Java chạy trên ứng dụng Eclipse.
 	Hệ quản trị cơ sở dữ liệu: MySQL.
 
CHƯƠNG 3: THIẾT KẾ HỆ THỐNG
3.1.	Sơ đồ chức năng
![image](https://user-images.githubusercontent.com/93209137/200001234-f65b0dc6-2a92-41fd-94b4-5f2bdbca78c8.png)

Các chức năng chính của chương trình:
	Quản lý nhân viên: dùng để admin quản lý danh sách và thông tin nhân viên.
	Quản lý đơn hàng: dùng để nhân viên tạo đơn bán hàng và admin quản lý các đơn hàng, tình hình kinh doanh của cửa hàng.
	Quản lý khách hàng: dùng để lưu trữ thông tin khách hàng.
	Quản lý kho hàng: dùng để quản lý thông tin và số lượng hàng trong kho và nhập xuất kho.
	Thống kê thông tin: thống kê các số liệu trợ giúp cho việc quản lý của hàng và định hướng phát triển của cửa hàng.
 
3.2.	Sơ đồ lớp
 ![image](https://user-images.githubusercontent.com/93209137/200001271-14060183-2fc7-4023-aaf6-ff93d7417909.png)

Các thành phần chính:
 	Kết nối data:
	ConnectDatabase: Thực hiện việc kết nối với database
 	Các giao diện để giao tiếp với người dùng:
	frmBangLuong: hiển thị bảng lương nhân viên.
	frmDangNhap: form dùng để đăng nhập vào chương trình
	frmQuanLyChoAdmin: dành cho admin thực hiện các tác vụ
	frmQuanLyChoNhanVien: dành cho nhân viên thực hiện các tác vụ
	frmTimLaptop: cho phép tìm các loại laptop theo yêu cầu
 	Các model:
	Laptop: lớp mô tả thông tin laptop
	Donhang: lớp mô tả thông tin đơn hàng
	NhanVien: lớp mô tả thông tin nhân viên
	KhachHang: lớp mô tả thông tin khách hàng
	LaptopModel: tải dữ liệu về laptop từ database
	DonhangModel: tải dữ liệu về đơn hàng từ database
	NhanVienModel: tải dữ liệu về nhân viên từ database
	KhachHangModel: tải dữ liệu về khách hàng từ database
3.3.	Sơ đồ thiết kế dữ liệu
 ![image](https://user-images.githubusercontent.com/93209137/200001338-ab8237bb-16d1-4b2a-82d7-def440a1d8de.png)

Mô tả sơ đồ thiết kế cơ sở dữ liệu:
	Bảng login: lưu thông tin đăng nhập và được liên kết với bảng nhân viên thông qua bảng dangnhap_nhanvien
	Bảng dangnhap_nhanvien: liên kết 2 bảng login và nhanvien
	Bảng nhanvien: lưu thông tin của nhân viên
	Bảng donhang: lưu thông tin các đơn hàng (người mua, nhân viên bán, …)
	Bảng khachhang: lưu thông tin các khách hàng 
	Bảng laptop: lưu thông tin các laptop (cấu hình máy, số lượng trong kho, …)
	Bảng chitietdonhang: lưu thông tin chi tiết về các sản phẩm được bán của từng đơn hàng
 
CHƯƠNG 4: GIAO DIỆN CỦA CHƯƠNG TRÌNH
4.1.	Đăng nhập
 ![image](https://user-images.githubusercontent.com/93209137/200001411-8df7a6ce-1471-44bd-a1bb-229e368220a3.png)


4.2.	Form làm việc của người quản lý cửa hàng (admin)
Bảng chọn:
 ![image](https://user-images.githubusercontent.com/93209137/200001308-3f35b88e-7fda-4f90-aeb6-d8ae19767c85.png)

Quản lý nhân viên:
 ![image](https://user-images.githubusercontent.com/93209137/200001357-36fb2065-3276-4a8e-abc9-0ea6cb918b14.png)

Quản lý đơn hàng:
 ![image](https://user-images.githubusercontent.com/93209137/200001396-761f5314-8e6e-4489-ad66-0ef2fb5210a0.png)

Quản lý khách hàng:
 ![image](https://user-images.githubusercontent.com/93209137/200001378-9bcaf257-416c-4c55-9add-45bfa06a9cd2.png)

Thống kê:
![image](https://user-images.githubusercontent.com/93209137/200001438-a796c2e4-166c-467f-8ac9-adcde56f646b.png)
![image](https://user-images.githubusercontent.com/93209137/200001449-6fae436c-a724-4eae-990f-0f51787132a2.png)
![image](https://user-images.githubusercontent.com/93209137/200001458-a770385b-e839-4316-81aa-9206ead231ec.png)
![image](https://user-images.githubusercontent.com/93209137/200001470-0ba0ef72-867e-4439-b7b2-b212296f97fd.png)

  
 
Tạo tài khoản quản lý (admin) mới:
 ![image](https://user-images.githubusercontent.com/93209137/200001507-4ce7ad5e-5c84-4443-a2f0-ac21ad9fa8b1.png)

4.3.	Form làm việc dành cho nhân viên
Bảng chọn:
 ![image](https://user-images.githubusercontent.com/93209137/200001531-a8d3606a-786c-4e04-9ea2-a1f726578f94.png)

Quản lý kho hàng: 
 ![image](https://user-images.githubusercontent.com/93209137/200001554-2a30c9d3-df0b-43d6-bd64-1bc1cc864e9b.png)

Quản lý đơn hàng:
![image](https://user-images.githubusercontent.com/93209137/200001575-41c50206-39e8-4362-8ec0-d2b4f0125f73.png)
Quản lý khách hàng:
 ![image](https://user-images.githubusercontent.com/93209137/200001613-30d85020-1509-445b-bc29-c24c4ab254ee.png)

 
CHƯƠNG 5: KẾT QUẢ
5.1.	Nội dung chính của chương trình:
 	Đăng nhập: đăng nhập bằng tài khoản admin hoặc nhân viên (phân quyền tự động).
 	Quản lý nhân viên: xem danh sách nhân viên, có thể thêm, xóa, cập nhật, hoặc tìm kiếm nhân viên.
 	Quản lý Đơn hàng: xem danh sách các đơn hàng, có thể thêm, xóa, cập nhật, hoặc tìm kiếm đơn hàng.
 	Quản lý khách hàng: xem danh sách các khách hàng, có thể thêm, xóa, cập nhật, hoặc tìm kiếm khách hàng.
 	Quản lý kho hàng: xem danh sách các laptop trong kho, có thể thêm, xóa, cập nhật thông tin và số lượng, hoặc tìm kiếm laptop trong kho hàng. Không cho phép tạo đơn hàng khi hàng trong kho không đủ.
 	Thống kê hiệu suất:
	Thống kê theo nhân viên (số tiền lương nhận được trong tháng, số hàng bán được trong háng)
	Thống kê theo hàng bán được: tỉ lệ các loại hàng khác nhau bán được
	Thống kê theo doanh số cửa hàng:  số tiền bán được trong các tháng gần nhất, số tiền bán được theo các ngày trong tuần ở tháng gần nhất, …
5.2.	Ưu điểm:
 	Sử dụng được ngôn ngữ lập trình java để hoàn thành chương trình với các ứng dụng cơ bản đáp ứng việc quản lý cửa hàng bán laptop.
 	Sử dụng thư viện swing để thiết kế giao diện bằng ngôn ngữ lập trình java.
 	Áp dụng được tư tưởng hướng đối tượng trong chương trình.
 	Sử dụng được java JDBC kết nối và thao tác với cơ sở dữ liệu trên MySQL.
5.3.	Khuyết điểm:
 	Giao diện còn khá đơn giản và chưa được đẹp.
 	Mặt hàng bán trong thiết kế của chương trình còn ít (chỉ có laptop).
 	Các chức năng của chương trình hầu hết còn đơn giản và chưa có sự sáng tạo, đột phá. 
CHƯƠNG 6: ĐỊNH HƯỚNG PHÁT TRIỂN CỦA ĐỀ TÀI
6.1.	Hình thức và chức năng
Cho phép thêm các hình ảnh để tạo sự trực quan sinh động về thông tin các mặt hàng.
Tạo thêm nhiều loại thống kê đa dạng hữu ích hơn như: thống kê và phân tích thêm về các mặt hàng thường mua của các lứa, giới tính tuổi dựa trên thông tin khách hàng và các mặt hàng mà họ mua.
Tạo thêm tiện ích cho người dùng là khách hàng để họ có thể sử dụng xem và đặt hàng trực tuyến (đặt trước rồi đến lấy hoặc đặt giao tận nơi).
6.2.	Quy mô
Cho phép chủ cửa hàng tự cài đặt và lưu thông tin, hình ảnh các mặt hàng tùy theo ý của họ. Từ đó mở rộng ra không chỉ cho cửa hàng laptop mà còn có thể dùng cho các cửa hàng khác như bán thú bông hay các cửa hàng bán đồ ăn, uống...
Tạo thêm các hình thức liên kết và gửi các thông tin thông qua mạng internet để chương trình có thể dùng để quản lý 1 chuỗi cửa hàng thay vì 1 cửa hàng duy nhất.
 
TÀI LIỆU THAM KHẢO
David Gilbert. (2021, Tháng hai 21). Welcome To JFreeChart! Được truy lục từ https://www.jfree.org/jfreechart/
Team Việt Dev. (2019, Tháng ba 1). Tích hợp biểu đồ JFreeChart trong Java Swing. Được truy lục từ https://teamvietdev.com/tich-hop-bieu-do-jfreechart-trong-java-swing/

