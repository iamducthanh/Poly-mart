-- DROP DATABASE  POLYMART_v1

CREATE DATABASE POLYMART_v1
GO

USE POLYMART_v1
GO

IF OBJECT_ID('LOAISANPHAM') IS NOT NULL
DROP TABLE LOAISANPHAM
GO
CREATE TABLE LOAISANPHAM (
	ID INT IDENTITY (1,1),
	TEN NVARCHAR(100) NOT NULL,

	CONSTRAINT PK_LOAISANPHAM PRIMARY KEY (ID)
)

IF OBJECT_ID('SANPHAM') IS NOT NULL
DROP TABLE SANPHAM
GO
CREATE TABLE SANPHAM (
	ID INT IDENTITY (1,1),
	IDLOAISANPHAM INT,
	TEN NVARCHAR(100) NOT NULL,

	CONSTRAINT PK_SANPHAM PRIMARY KEY (ID),
	CONSTRAINT FK_SANPHAM_LOAISANPHAM FOREIGN KEY (IDLOAISANPHAM) REFERENCES LOAISANPHAM (ID)
)

IF OBJECT_ID('CHITIETSANPHAM') IS NOT NULL
DROP TABLE CHITIETSANPHAM
GO
CREATE TABLE CHITIETSANPHAM (
	ID INT IDENTITY (10001,1),
	IDSANPHAM INT,
	MAUSAC NVARCHAR(20) NOT NULL,
	SIZE VARCHAR(10) NOT NULL,
	SOLUONG INT CHECK (SOLUONG > -1),
	GIABAN MONEY DEFAULT 0,
	GIAVON MONEY DEFAULT 0,
	GIAGIAM MONEY DEFAULT 0,
	NGAYCAPNHAT DATETIME DEFAULT GETDATE(),
	TRANGTHAI BIT DEFAULT 0,

	CONSTRAINT PK_CHITIETSANPHAM PRIMARY KEY (ID),
	CONSTRAINT FK_CHITIETSANPHAM FOREIGN KEY (IDSANPHAM) REFERENCES SANPHAM (ID)
)

IF OBJECT_ID('ANHSANPHAM') IS NOT NULL
DROP TABLE ANHSANPHAM
GO
CREATE TABLE ANHSANPHAM (
	IDCHITIETSANPHAM INT,
	TENANH VARCHAR(100) NOT NULL,

	CONSTRAINT PK_ANHSANPHAM PRIMARY KEY (IDCHITIETSANPHAM, TENANH),
	CONSTRAINT FK_ANHSANPHAM_CHITIETSANPHAM FOREIGN KEY (IDCHITIETSANPHAM) REFERENCES CHITIETSANPHAM (ID)
)

IF OBJECT_ID('NHANVIEN') IS NOT NULL
DROP TABLE NHANVIEN
GO
CREATE TABLE NHANVIEN (
	ID INT IDENTITY (10001,1),
	HOTEN NVARCHAR(50) NOT NULL,
	NGAYSINH DATETIME NOT NULL,
	GIOITINH BIT NOT NULL,
	DIACHI NVARCHAR(200) NOT NULL,
	SODIENTHOAI VARCHAR(20) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	CHUCVU NVARCHAR(50) NOT NULL,
	MUCLUONG MONEY NOT NULL,
	ANHDAIDIEN VARCHAR(100) NOT NULL,
	MATKHAU NVARCHAR(50) NOT NULL,

	CONSTRAINT PK_NHANVIEN PRIMARY KEY (ID),
)

IF OBJECT_ID('CHAMCONG') IS NOT NULL
DROP TABLE CHAMCONG
GO
CREATE TABLE CHAMCONG (
	IDNHANVIEN INT,
	NGAYCHAMCONG DATETIME DEFAULT GETDATE(),

	CONSTRAINT PK_CHAMCONG PRIMARY KEY (IDNHANVIEN, NGAYCHAMCONG),
	CONSTRAINT FK_CHAMCONG_NHANVIEN FOREIGN KEY (IDNHANVIEN) REFERENCES NHANVIEN (ID)
)

IF OBJECT_ID('CHITIEU') IS NOT NULL
DROP TABLE CHITIEU
GO
CREATE TABLE CHITIEU (
	MUCDICHCHITIEU NVARCHAR(100) NOT NULL,
	IDNHANVIEN INT,
	SOTIEN MONEY NOT NULL,
	NGAYCHITIEU DATETIME DEFAULT GETDATE(),
	GHICHU NTEXT,

	CONSTRAINT PK_CHITIEU PRIMARY KEY (MUCDICHCHITIEU, IDNHANVIEN, SOTIEN, NGAYCHITIEU),
	CONSTRAINT FK_CHITIEU_NHANVIEN FOREIGN KEY (IDNHANVIEN) REFERENCES NHANVIEN (ID)
)

IF OBJECT_ID('KHACHHANG') IS NOT NULL
DROP TABLE KHACHHANG
GO
CREATE TABLE KHACHHANG (
	ID INT IDENTITY (1,1),
	HOTEN NVARCHAR(50) NOT NULL,
	SODIENTHOAI VARCHAR(20) NOT NULL,
	DIACHI NVARCHAR(200),
	TICHDIEM INT DEFAULT 0,

	CONSTRAINT PK_KHACHHANG PRIMARY KEY (ID)
)

IF OBJECT_ID('NGUONHANG') IS NOT NULL
DROP TABLE NGUONHANG
GO
CREATE TABLE NGUONHANG (
	ID INT IDENTITY (1,1),
	TEN NVARCHAR(100) NOT NULL,
	SODIENTHOAI VARCHAR(20) NOT NULL,
	DIACHI NVARCHAR(200) NOT NULL,

	CONSTRAINT PK_NGUONHANG PRIMARY KEY (ID)
)

IF OBJECT_ID('HOADONNHAPHANG') IS NOT NULL
DROP TABLE HOADONNHAPHANG
GO
CREATE TABLE HOADONNHAPHANG (
	ID INT IDENTITY (1,1),
	IDNHANVIEN INT,
	IDNGUONHANG INT,
	NGAYNHAP DATETIME DEFAULT GETDATE(),
	GHICHU NTEXT,

	CONSTRAINT PK_HOADONNHAPHANG PRIMARY KEY (ID),
	CONSTRAINT FK_HOADONNHAPHANG_NHANVIEN FOREIGN KEY (IDNHANVIEN) REFERENCES NHANVIEN (ID),
	CONSTRAINT FK_HOADONNHAPHANG_NGUONHANG FOREIGN KEY (IDNGUONHANG) REFERENCES NGUONHANG (ID)
)

IF OBJECT_ID('CHITIETHOADONNHAPHANG') IS NOT NULL
DROP TABLE CHITIETHOADONNHAPHANG
GO
CREATE TABLE CHITIETHOADONNHAPHANG (
	IDHOADONNHAPHANG INT,
	IDCHITIETSANPHAM INT,
	GIANHAP MONEY NOT NULL,
	SOLUONG INT NOT NULL,

	CONSTRAINT PK_CHITIETHOADONNHAPHANG PRIMARY KEY (IDHOADONNHAPHANG, IDCHITIETSANPHAM, GIANHAP, SOLUONG),
	CONSTRAINT FK_CHITIETHOADONNHAPHANG_HOADONNHAPHANG FOREIGN KEY (IDHOADONNHAPHANG) REFERENCES HOADONNHAPHANG (ID),
	CONSTRAINT FK_CHITIETHOADONNHAPHANG_CHITIETSANPHAM FOREIGN KEY (IDCHITIETSANPHAM) REFERENCES CHITIETSANPHAM (ID)
)

IF OBJECT_ID('HOADONTHANHTOAN') IS NOT NULL
DROP TABLE HOADONTHANHTOAN
GO
CREATE TABLE HOADONTHANHTOAN (
	ID INT IDENTITY (1,1),
	IDKHACHHANG INT,
	IDNHANVIEN INT,
	DIEMDADOI INT DEFAULT 0,
	NGAYTHANHTOAN DATETIME DEFAULT GETDATE(),
	GHICHU NTEXT,

	CONSTRAINT PK_HOADONTHANHTOAN PRIMARY KEY (ID),
	CONSTRAINT FK_HOADONTHANHTOAN_KHACHHANG FOREIGN KEY (IDKHACHHANG) REFERENCES KHACHHANG (ID),
	CONSTRAINT FK_HOADONTHANHTOAN_NHANVIEN FOREIGN KEY (IDNHANVIEN) REFERENCES NHANVIEN (ID)
)

IF OBJECT_ID('CHITIETHOADONTHANHTOAN') IS NOT NULL
DROP TABLE CHITIETHOADONTHANHTOAN
GO
CREATE TABLE CHITIETHOADONTHANHTOAN (
	ID INT IDENTITY (1,1),
	IDCHITIETSANPHAM INT,
	IDHOADONTHANHTOAN INT,
	SOLUONG INT NOT NULL,
	GIAMGIATHEM MONEY DEFAULT 0,

	CONSTRAINT PK_CHITIETHOADONTHANHTOAN PRIMARY KEY (ID),
	CONSTRAINT FK_CHITIETHOADONTHANHTOAN_CHITIETSANPHAM FOREIGN KEY (IDCHITIETSANPHAM) REFERENCES CHITIETSANPHAM (ID),
	CONSTRAINT FK_CHITIETHOADONTHANHTOAN_HOADONTHANHTOAN FOREIGN KEY (IDHOADONTHANHTOAN) REFERENCES HOADONTHANHTOAN (ID)
)

IF OBJECT_ID('HOADONTRAHANG') IS NOT NULL
DROP TABLE HOADONTRAHANG
GO
CREATE TABLE HOADONTRAHANG (
	ID INT IDENTITY (1,1),
	IDNHANVIEN INT,
	NGAYTRAHANG DATETIME DEFAULT GETDATE(),
	GHICHU NTEXT,

	CONSTRAINT PK_HOADONTRAHANG PRIMARY KEY (ID),
	CONSTRAINT FK_HOADONTRAHANG_NHANVIEN FOREIGN KEY (IDNHANVIEN) REFERENCES NHANVIEN (ID)
)

IF OBJECT_ID('CHITIETHOADONTRAHANG') IS NOT NULL
DROP TABLE CHITIETHOADONTRAHANG
GO
CREATE TABLE CHITIETHOADONTRAHANG (
	IDHOADONTRAHANG INT,
	IDCHITIETHOADONTHANHTOAN INT,
	SOLUONG INT NOT NULL,

	CONSTRAINT PK_CHITIETHOADONTRAHANG PRIMARY KEY (IDHOADONTRAHANG, IDCHITIETHOADONTHANHTOAN),
	CONSTRAINT FK_CHITIETHOADONTRAHANG_HOADONTRAHANG FOREIGN KEY (IDHOADONTRAHANG) REFERENCES HOADONTRAHANG (ID),
	CONSTRAINT FK_CHITIETHOADONTRAHANG_CHITIETHOADONTHANHTOAN FOREIGN KEY (IDCHITIETHOADONTHANHTOAN) REFERENCES CHITIETHOADONTHANHTOAN (ID)
)
