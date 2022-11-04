CREATE DATABASE  IF NOT EXISTS `quanlycuahang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlycuahang`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlycuahang
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonhang` (
  `stt` int NOT NULL AUTO_INCREMENT,
  `madonhang` varchar(25) DEFAULT NULL,
  `malaptop` varchar(45) DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  PRIMARY KEY (`stt`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonhang`
--

LOCK TABLES `chitietdonhang` WRITE;
/*!40000 ALTER TABLE `chitietdonhang` DISABLE KEYS */;
INSERT INTO `chitietdonhang` VALUES (2,'DH2021082001','LP01',3),(3,'DH2021082001','LP02',2),(4,'DH2021092501','LP02',4),(5,'DH2021120901','LP01',3),(35,'DH2021120801','LP01',1),(36,'DH2021120701','LP02',1),(37,'DH2021120601','LP01',1),(38,'DH2021120601','LP02',2),(39,'DH2021120501','LP01',3),(40,'DH2021120401','LP01',1),(41,'DH2021120401','LP02',1),(42,'DH2021120301','LP02',2),(43,'DH2021120201','LP01',1),(44,'DH2021120201','LP02',3),(45,'DH2021111901','LP03',2),(46,'DH2021112001','LP04',1),(47,'DH2021101002','LP05',2),(48,'DH2021101001','LP04',2),(49,'DH2021100201','LP03',1),(50,'DH2020100902','LP05',1),(51,'DH2021092601','LP04',3),(52,'DH2021081001','LP05',2),(53,'DH2021080801','LP03',5),(54,'DH2021080801','LP01',5),(55,'DH2021071101','LP04',5),(57,'DH2020100901','LP02',2),(59,'DH2021111101','LP02',4),(60,'DH2021111101','LP01',4),(61,'DH2021111001','LP02',2),(62,'DH2021110901','LP02',2),(63,'DH2021081401','LP03',1),(64,'DH2021081401','LP04',4);
/*!40000 ALTER TABLE `chitietdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dangnhap_nhanvien`
--

DROP TABLE IF EXISTS `dangnhap_nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dangnhap_nhanvien` (
  `username` varchar(45) NOT NULL,
  `manv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dangnhap_nhanvien`
--

LOCK TABLES `dangnhap_nhanvien` WRITE;
/*!40000 ALTER TABLE `dangnhap_nhanvien` DISABLE KEYS */;
INSERT INTO `dangnhap_nhanvien` VALUES ('',''),('0','0'),('batam7','CH03'),('chiduong02','CH04');
/*!40000 ALTER TABLE `dangnhap_nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `maDH` varchar(25) NOT NULL,
  `ngayTao` date DEFAULT NULL,
  `maNV` varchar(45) DEFAULT NULL,
  `maKH` varchar(45) DEFAULT NULL,
  `thanhToan` varchar(45) DEFAULT NULL,
  `ghiChu` varchar(45) DEFAULT NULL,
  `thanhTien` double DEFAULT '0',
  PRIMARY KEY (`maDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES ('DH2020100901','2020-10-09','CH01','2','Tiền mặt','Giao hàng tận nơi',55960),('DH2020100902','2020-10-09','CH01','3','Chuyển khoản',' ',18990),('DH2021071101','2021-07-11','CH03','2','','',134950),('DH2021080801','2021-08-08','CH03','1','','',124900),('DH2021081001','2021-08-10','CH04','1','','',37980),('DH2021081401','2021-08-14','CH04','6','','',121950),('DH2021082001','2021-08-20','CH03','5','Tiền mặt','',66950),('DH2021092501','2021-09-25','CH02','3','Mastercard','Giao về địa chỉ của khách hàng',33980),('DH2021092601','2021-09-26','CH03','6','','',80970),('DH2021100201','2021-10-02','CH01','4',' ',' ',13990),('DH2021101001','2021-10-10','CH01','5',' ',' ',53980),('DH2021101002','2021-10-10','CH01','6','Mastercard','',37980),('DH2021110901','2021-11-09','CH02','1','','',33980),('DH2021111001','2021-11-10','CH03','3','','',33980),('DH2021111101','2021-11-11','CH02','4','Tiền mặt','Giao về địa chỉ của khách hàng',111920),('DH2021111901','2021-11-19','CH03','3','','',27980),('DH2021112001','2021-11-20','CH01','8','Mastercard',' ',26990),('DH2021120201','2021-12-02','CH01','3','','',61960),('DH2021120301','2021-12-03','CH02','2','','',33980),('DH2021120401','2021-12-04','CH03','4','','',27980),('DH2021120501','2021-12-05','CH03','2','','',32970),('DH2021120601','2021-12-06','CH01','7','','',44970),('DH2021120701','2021-12-07','CH02','5','','',16990),('DH2021120801','2021-12-08','CH04','3','','',10990),('DH2021120901','2021-12-09','CH04','4','Tiền mặt','Gói hộp làm quà tặng',32970);
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `maKH` varchar(25) NOT NULL,
  `tenKH` varchar(45) DEFAULT 'Unkown',
  `sdt` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `diaChi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('1','Đoàn Minh Quân','09356132','',''),('2','Nguyễn Hải',' ',' ','Hồ Chí Minh'),('3','Nguyễn Minh','03030303',' ','1A33, Phạm Văn Đồng, Hồ Chí Minh'),('4','Nguyễn Ngọc Như','05060506',' ','Khánh Hòa'),('5','Nguyễn Tường Long','07321032',' ','Hồ Chí Minh'),('6','Nguyễn Tường Minh','07321032',' ','Hồ Chí Minh'),('7','Trần Định','011101111',' ','Đà Nẵng'),('8','Trần Khang','06060606','trankhang ','Hà Nội'),('9','Dư Thị Yến','06531265','','99, Xa lộ Hà Nội, Hồ Chí Minh');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laptop` (
  `maSo` varchar(25) NOT NULL,
  `ten` varchar(45) DEFAULT NULL,
  `giaBan` double DEFAULT NULL,
  `hangSX` varchar(45) DEFAULT NULL,
  `cpu` varchar(45) DEFAULT NULL,
  `ram` int DEFAULT NULL,
  `kichThuocManHinh` varchar(45) DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  PRIMARY KEY (`maSo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laptop`
--

LOCK TABLES `laptop` WRITE;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
INSERT INTO `laptop` VALUES ('LP01','HP Pavilon',10990,'HP','Core i3',4,'14',0),('LP02','Inspiron N4300',16990,'Dell','Core i5',4,'15.6',10),('LP03','Acer Asprise 5',13990,'Acer','Ryzen 5',8,'13',21),('LP04','Asus ROG G512',26990,'Asus','Core i7',16,'17',10),('LP05','Lenovo Thinkpad X1 Carbon',18990,'Lenovo','Core i5',8,'14',11);
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `chucvu` varchar(25) DEFAULT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('nhanvien','',''),('nhanvien','0','0'),('admin','admin','0admin'),('admin','admin1','1admin'),('admin','admin2','2admin'),('nhanvien','batam7','batam#'),('nhanvien','chiduong02','02chiduong'),('nhanvien','nhanvien','0nhanvien'),('admin','user000','000user');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNhanVien` varchar(25) NOT NULL,
  `tenNhanVien` varchar(45) DEFAULT NULL,
  `sdt` varchar(45) DEFAULT NULL,
  `diaChi` varchar(45) DEFAULT NULL,
  `luongCung` double DEFAULT NULL,
  `luongThuong` double DEFAULT NULL,
  PRIMARY KEY (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('CH01','Đoàn Võ Nhựt Hào','09090909','An Giang',5000,0.01),('CH02','Nguyễn Linh Sắc','01234567','Hồ Chí Minh',6000,0.005),('CH03','Nguyễn Bá Tâm','09876543','Hồ Chí Minh',8000,0.02),('CH04','Trương Chí Dương','06532169','Đồng Nai',6000,0.05);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-13 19:38:03
