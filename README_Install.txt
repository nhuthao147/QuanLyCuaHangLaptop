### Hướng dẫn cài đặt và sử dụng phần mềm Quản lý cửa hàng Laptop

Yêu cầu hệ thống:
	+ JDK phiên bản 1.8.0_301 và JRE phiên bản 1.8.0_301
	+ EclipseIDE for Java Developers (includes Incubating components) phiên bản 2020-06 (4.16.0)
	+ MySQL Workbench 8.0 CE
	+ 3 thư viện bổ trợ bao gồm: mysql-connector-java-8.0.27, jfreechart-1.5.0 và jcommon-1.0.23

Hướng dẫn cài đặt:
	- EclipseIDE for Java Developers (includes Incubating components) phiên bản 2020-06 (4.16.0)
	https://www.eclipse.org/downloads/packages/release/2020-06/r
	- Phần mềm MySQL Workbench 8.0 CE:
	https://blogchiasekienthuc.com/thu-thuat-hay/cai-dat-mysql-workbench-tren-windows-10.html
	- Môi trường JDK 1.8.0_301 và JRE 1.8.0_3018u301:
	https://viettuts.vn/java/cai-dat-moi-truong-java
	- 3 thư viện bổ trợ 
	https://drive.google.com/drive/folders/1vMTGukixQYAZx5Ln3ruJNlbG3CEI19z7?usp=sharing

## Giải nén thư mục đính kèm, mở thư mục "DoAnCuoiKy" và sao chép thư mục "icon" vào ổ đĩa C (đường dẫn là "C:\") 

## Cài đặt Database:
Bước 1: Mở phần mềm MySQL Workbench 8.0 CE
Bước 2: Đăng nhập vào Local instance MySQL 
Bước 3: Mở File "database.sql" ở thư mục "DoAnCuoiKy"
Bước 4: Thực thi toàn bộ code trong file database.sql
Bước 5: Refresh lại SCHEMAS, lúc này schema "quanlycuahang" đã xuất hiện

## Cài đặt Project
Bước 1: Mở phần mềm Eclipse
Bước 2: Import project, chọn thư mục chứa project (chính là thư mục "DoAnCuoiKy" ta đã giải nén)
Bước 3: Import 3 file thư viện ngoài jfreechart-1.5.0.jar (hỗ trợ tạo biểu đồ thống kê số liệu), jcommon-1.0.23 (thư viện hỗ trợ jfreechart-1.5.0) và
mysql-connector-java-8.0.27.jar (Hỗ trợ driver kết nối với mysql trên máy)
	+ Chuột phải vào Project, chọn Build Path > Configure Build Path
	+ Chọn tab Libraries
	+ Chọn Add External JARs
	+ Chọn đường dẫn đến nơi bạn tải 3 thư viện bên trên và add chúng vào project "DoAnCuoiKy"
Bước 4: Cấu hình lại Connection String url, user, pw với MySQL tại DAO/ConnectionDatabase
Bước 5: Cấu hình môi trường Java1.8
	+ Click chuột phải vào project, chọn Built Path > Cofigure Build Path
	+ Chọn tab Libraries
	+ Nếu Buitl path không phải là JRE Library[JavaSE-1.8] thì ta click vào built path đó > Edit> Excutions Environment > JavaSE-1.8(jre1.8.0_311)>Finish 
Bước 6: Build Project và chạy
Tài khoản quản lý: 	username: admin
					mật khẩu: 0admin
Tài khoản nhân viên: 	username: nhanvien
					mật khẩu: 0nhanvien
