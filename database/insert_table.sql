-- DROP DATABASE POLYMART_v1

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
                          NGAYCHAMCONG TIMESTAMP,

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
                         NGAYCHITIEU TIMESTAMP,
                         GHICHU NTEXT,

                         CONSTRAINT PK_CHITIEU PRIMARY KEY (MUCDICHCHITIEU, IDNHANVIEN, SOTIEN, NGAYCHITIEU),
                         CONSTRAINT FK_CHITIEU_NHANVIEN FOREIGN KEY (IDNHANVIEN) REFERENCES NHANVIEN (ID)
)

    IF OBJECT_ID('KHACHHANG') IS NOT NULL
DROP TABLE KHACHHANG
    GO
CREATE TABLE KHACHHANG (
                           ID INT IDENTITY (1,1),
                           HOTEN NVARCHAR(50),
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
                                NGAYNHAP TIMESTAMP,
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
                                 NGAYTHANHTOAN TIMESTAMP,
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
                               NGAYTRAHANG TIMESTAMP,
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

-- INSERT

    INSERT INTO LOAISANPHAM (TEN)
VALUES (N'Áo thun'),
(N'Áo sơ mi'),
(N'Quần short'),
(N'Quần dài'),
(N'Chân váy')

INSERT INTO SANPHAM (IDLOAISANPHAM, TEN)
VALUES (1, N'Thun tay ngắn'),
(1, N'Thun tay dài'),
(2, N'Sơ mi tay ngắn'),
(2, N'Sơ mi tay dài'),
(3, N'Short'),
(4, N'Quần jean'),
(4, N'Quần jogger'),
(5, N'Chân váy')

INSERT INTO CHITIETSANPHAM (IDSANPHAM, MAUSAC, SIZE, SOLUONG, GIABAN, TRANGTHAI)
VALUES (1, N'Đen', 'XL', 100, 215000, 1),
(1, N'Đen', 'L', 100, 215000, 1),
(1, N'Đen', 'M', 100, 215000, 1),
(1, N'Đen', 'S', 100, 215000, 1),
(1, N'Xám', 'XL', 100, 215000, 1),
(1, N'Xám', 'L', 100, 215000, 1),
(1, N'Xám', 'M', 100, 215000, 1),
(1, N'Xám', 'S', 100, 215000, 1),
(1, N'Vàng', 'XL', 100, 215000, 1),
(1, N'Vàng', 'L', 100, 215000, 1),
(1, N'Vàng', 'M', 100, 215000, 1),
(1, N'Vàng', 'S', 100, 215000, 1),
(1, N'Trắng', 'XL', 100, 215000, 1),
(1, N'Trắng', 'L', 100, 215000, 1),
(1, N'Trắng', 'M', 100, 215000, 1),
(1, N'Trắng', 'S', 100, 215000, 1),
(1, N'Đen', 'XL', 100, 215000, 1),
(1, N'Đen', 'L', 100, 215000, 1),
(1, N'Đen', 'M', 100, 215000, 1),
(1, N'Đen', 'S', 100, 215000, 1),
(1, N'Xám', 'XL', 100, 215000, 1),
(1, N'Xám', 'L', 100, 215000, 1),
(1, N'Xám', 'M', 100, 215000, 1),
(1, N'Xám', 'S', 100, 215000, 1),
(1, N'Vàng', 'XL', 100, 215000, 1),
(1, N'Vàng', 'L', 100, 215000, 1),
(1, N'Vàng', 'M', 100, 215000, 1),
(1, N'Vàng', 'S', 100, 215000, 1),
(1, N'Đỏ', 'XL', 100, 215000, 1),
(1, N'Đỏ', 'L', 100, 215000, 1),
(1, N'Đỏ', 'M', 100, 215000, 1),
(1, N'Đỏ', 'S', 100, 215000, 1),
(1, N'Trắng', 'XL', 100, 215000, 1),
(1, N'Trắng', 'L', 100, 215000, 1),
(1, N'Trắng', 'M', 100, 215000, 1),
(1, N'Trắng', 'S', 100, 215000, 1),
(1, N'Đen', 'XL', 100, 185000, 1),
(1, N'Đen', 'L', 100, 185000, 1),
(1, N'Đen', 'M', 100, 185000, 1),
(1, N'Đen', 'S', 100, 185000, 1),
(1, N'Hồng', 'XL', 100, 185000, 1),
(1, N'Hồng', 'L', 100, 185000, 1),
(1, N'Hồng', 'M', 100, 185000, 1),
(1, N'Hồng', 'S', 100, 185000, 1),
(1, N'Kem', 'XL', 100, 185000, 1),
(1, N'Kem', 'L', 100, 185000, 1),
(1, N'Kem', 'M', 100, 185000, 1),
(1, N'Kem', 'S', 100, 185000, 1),
(1, N'Trắng', 'XL', 100, 185000, 1),
(1, N'Trắng', 'L', 100, 185000, 1),
(1, N'Trắng', 'M', 100, 185000, 1),
(1, N'Trắng', 'S', 100, 185000, 1),
(1, N'Đen', 'XL', 100, 245000, 1),
(1, N'Đen', 'L', 100, 245000, 1),
(1, N'Đen', 'M', 100, 245000, 1),
(1, N'Đen', 'S', 100, 245000, 1),
(1, N'Trắng', 'XL', 100, 245000, 1),
(1, N'Trắng', 'L', 100, 245000, 1),
(1, N'Trắng', 'M', 100, 245000, 1),
(1, N'Trắng', 'S', 100, 245000, 1),
(2, N'Đen', 'XL', 100, 245000, 1),
(2, N'Đen', 'L', 100, 245000, 1),
(2, N'Đen', 'M', 100, 245000, 1),
(2, N'Đen', 'S', 100, 245000, 1),
(2, N'Xanh dương', 'XL', 100, 245000, 1),
(2, N'Xanh dương', 'L', 100, 245000, 1),
(2, N'Xanh dương', 'M', 100, 245000, 1),
( 2,  N'Xanh dương',  'S',  100,  245000,  1),

( 2,  N'Kem',  'XL',  100,  245000,  1),

( 2,  N'Kem',  'L',  100,  245000,  1),

( 2,  N'Kem',  'M',  100,  245000,  1),

( 2,  N'Kem',  'S',  100,  245000,  1),

( 2,  N'Vàng',  'XL',  100,  245000,  1),

( 2,  N'Vàng',  'L',  100,  245000,  1),

( 2,  N'Vàng',  'M',  100,  245000,  1),

( 2,  N'Vàng',  'S',  100,  245000,  1),

( 2,  N'Đỏ',  'XL',  100,  245000,  1),

( 2,  N'Đỏ',  'L',  100,  245000,  1),

( 2,  N'Đỏ',  'M',  100,  245000,  1),

( 2,  N'Đỏ',  'S',  100,  245000,  1),

( 2,  N'Trắng',  'XL',  100,  245000,  1),

( 2,  N'Trắng',  'L',  100,  245000,  1),

( 2,  N'Trắng',  'M',  100,  245000,  1),

( 2,  N'Trắng',  'S',  100,  245000,  1),

( 2,  N'Đen',  'XL',  100,  215000,  1),

( 2,  N'Đen',  'L',  100,  215000,  1),

( 2,  N'Đen',  'M',  100,  215000,  1),

( 2,  N'Đen',  'S',  100,  215000,  1),

( 2,  N'Kem',  'XL',  100,  215000,  1),

( 2,  N'Kem',  'L',  100,  215000,  1),

( 2,  N'Kem',  'M',  100,  215000,  1),

( 2,  N'Kem',  'S',  100,  215000,  1),

( 2,  N'Đỏ',  'XL',  100,  215000,  1),

( 2,  N'Đỏ',  'L',  100,  215000,  1),

( 2,  N'Đỏ',  'N',  100,  215000,  1),

( 2,  N'Đỏ',  'S',  100,  215000,  1),

( 2,  N'Trắng',  'XL',  100,  215000,  1),

( 2,  N'Trắng',  'L',  100,  215000,  1),

( 2,  N'Trắng',  'M',  100,  215000,  1),

( 2,  N'Trắng',  'S',  100,  215000,  1),

( 2,  N'Đen',  'XL',  100,  195000,  1),

( 2,  N'Đen',  'L',  100,  195000,  1),

( 2,  N'Đen',  'M',  100,  195000,  1),

( 2,  N'Đen',  'S',  100,  195000,  1),

( 2,  N'Xanh dương',  'XL',  100,  195000,  1),

( 2,  N'Xanh dương',  'L',  100,  195000,  1),

( 2,  N'Xanh dương',  'M',  100,  195000,  1),

( 2,  N'Xanh dương',  'S',  100,  195000,  1),

( 2,  N'Hồng',  'XL',  100,  195000,  1),

( 2,  N'Hồng',  'L',  100,  195000,  1),

( 2,  N'Hồng',  'M',  100,  195000,  1),

( 2,  N'Hồng',  'S',  100,  195000,  1),

( 2,  N'Đỏ',  'XL',  100,  195000,  1),

( 2,  N'Đỏ',  'L',  100,  195000,  1),

( 2,  N'Đỏ',  'M',  100,  195000,  1),

( 2,  N'Đỏ',  'S',  100,  195000,  1),

( 2,  N'Trắng',  'XL',  100,  195000,  1),

( 2,  N'Trắng',  'L',  100,  195000,  1),

( 2,  N'Trắng',  'M',  100,  195000,  1),

( 2,  N'Trắng',  'S',  100,  195000,  1),

( 3,  N'Xanh dương',  'XL',  100,  215000,  1),

( 3,  N'Xanh dương',  'L',  100,  215000,  1),

( 3,  N'Xanh dương',  'M',  100,  215000,  1),

( 3,  N'Xanh dương',  'S',  100,  215000,  1),

( 4,  N'Kem',  'L',  100,  245000,  1),

( 4,  N'Kem',  'M',  100,  245000,  1),

( 4,  N'Xanh lá',  'L',  100,  245000,  1),

( 4,  N'Xanh lá',  'M',  100,  245000,  1),

( 4,  N'Tím',  'L',  100,  245000,  1),

( 4,  N'Tím',  'M',  100,  245000,  1),

( 4,  N'Hồng',  'L',  100,  245000,  1),

( 4,  N'Hồng',  'M',  100,  245000,  1),

( 4,  N'Vàng',  'L',  100,  245000,  1),

( 4,  N'Vàng',  'M',  100,  245000,  1),

( 4,  N'Trắng',  'XL',  100,  225000,  1),

( 4,  N'Trắng',  'L',  100,  225000,  1),

( 4,  N'Trắng',  'M',  100,  225000,  1),

( 4,  N'Trắng',  'S',  100,  225000,  1),

( 4,  N'Hồng',  'L',  100,  235000,  1),

( 4,  N'Hồng',  'M',  100,  235000,  1),

( 5,  N'Kem',  'S',  100,  215000,  1),

( 5,  N'Kem',  'M',  100,  215000,  1),

( 5,  N'Kem',  'L',  100,  215000,  1),

( 5,  N'Đen',  'S',  100,  215000,  1),

( 5,  N'Đen',  'M',  100,  215000,  1),

( 5,  N'Đen',  'L',  100,  215000,  1),

( 5,  N'Da bò',  'S',  100,  215000,  1),

( 5,  N'Da bò',  'M',  100,  215000,  1),

( 5,  N'Da bò',  'L',  100,  215000,  1),

( 5,  N'Đen',  'S',  100,  285000,  1),

( 5,  N'Đen',  'M',  100,  285000,  1),

( 5,  N'Đen',  'L',  100,  285000,  1),

( 5,  N'Xanh',  'S',  100,  285000,  1),

( 5,  N'Xanh',  'M',  100,  285000,  1),

( 5,  N'Xanh',  'L',  100,  285000,  1),

( 5,  N'Trắng',  'S',  100,  285000,  1),

( 5,  N'Trắng',  'M',  100,  285000,  1),

( 5,  N'Trắng',  'L',  100,  285000,  1),

( 5,  N'Trắng',  'S',  100,  315000,  1),

( 5,  N'Trắng',  'M',  100,  315000,  1),

( 5,  N'Trắng',  'L',  100,  315000,  1),

( 5,  N'Đen',  'S',  100,  315000,  1),

( 5,  N'Đen',  'M',  100,  315000,  1),

( 5,  N'Đen',  'L',  100,  315000,  1),

( 5,  N'Xanh',  'S',  100,  315000,  1),

( 5,  N'Xanh',  'M',  100,  315000,  1),

( 5,  N'Xanh',  'L',  100,  315000,  1),

( 6,  N'Xanh',  'S',  100,  395000,  1),

( 6,  N'Xanh',  'M',  100,  395000,  1),

( 6,  N'Xanh',  'L',  100,  395000,  1),

( 6,  N'Đen',  '26',  100,  440000,  1),

( 6,  N'Đen',  '27',  100,  440000,  1),

( 6,  N'Đen',  '28',  100,  440000,  1),

( 6,  N'Đen',  '29',  100,  440000,  1),

( 6,  N'Xanh',  '26',  100,  340000,  1),

( 6,  N'Xanh',  '27',  100,  340000,  1),

( 6,  N'Xanh',  '28',  100,  340000,  1),

( 6,  N'Xanh',  '29',  100,  340000,  1),

( 7,  N'Đen',  'S',  100,  395000,  1),

( 7,  N'Đen',  'M',  100,  395000,  1),

( 7,  N'Đen',  'L',  100,  395000,  1),

( 7,  N'Kem',  'S',  100,  385000,  1),

( 7,  N'Kem',  'M',  100,  385000,  1),

( 7,  N'Kem',  'L',  100,  385000,  1),

( 7,  N'Đen',  'S',  100,  385000,  1),

( 7,  N'Đen',  'M',  100,  385000,  1),

( 7,  N'Đen',  'L',  100,  385000,  1),

( 7,  N'Xanh',  'S',  100,  385000,  1),

( 7,  N'Xanh',  'M',  100,  385000,  1),

( 7,  N'Xanh',  'L',  100,  385000,  1),

( 8,  N'Da bò',  'S',  100,  225000,  1),

( 8,  N'Da bò',  'M',  100,  225000,  1),

( 8,  N'Da bò',  'L',  100,  225000,  1),

( 8,  N'Hồng',  'S',  100,  225000,  1),

( 8,  N'Hồng',  'M',  100,  225000,  1),

( 8,  N'Hồng',  'L',  100,  225000,  1),

( 8,  N'Trắng',  'S',  100,  315000,  1),

( 8,  N'Trắng',  'M',  100,  315000,  1),

( 8,  N'Trắng',  'L',  100,  315000,  1),

( 8,  N'Xanh',  'S',  100,  315000,  1),

( 8,  N'Xanh',  'M',  100,  315000,  1),

( 8,  N'Xanh',  'L',  100,  315000,  1)

INSERT INTO ANHSANPHAM (IDCHITIETSANPHAM, TENANH)
VALUES (10001, 'MAT-SAU.JPG'),
(10001, 'MAT-TRUOC.JPG'),
(10002, 'MAT-SAU.JPG'),
(10002, 'MAT-TRUOC.JPG')

INSERT INTO NHANVIEN (HOTEN, NGAYSINH, GIOITINH, DIACHI, SODIENTHOAI, EMAIL, CHUCVU, MUCLUONG, ANHDAIDIEN, MATKHAU)
VALUES (N'Nguyễn Quang Ngọc', '01-01-2001', 1, N'Hà Nội', '0345678901', 'ngoc@gmail.com', N'NHÂN VIÊN BÁN HÀNG', 5000000, 'ngocnq.jpg', '12345678'),
(N'Đỗ Văn Duy', '01-01-2001', 1, N'Hà Nam', '0345678901', 'duy@gmail.com', N'NHÂN VIÊN THU NGÂN', 5500000, 'duydv.jpg', '12345678'),
(N'Bùi Việt Đức', '01-01-2001', 1, N'Quảng Ninh', '0345678901', 'duc@gmail.com', N'QUẢN LÝ', 5500000, 'ducbv.jpg', '12345678'),
(N'Hoàng Hồng Quang', '01-01-2001', 1, N'Quảng Trị', '0345678901', 'quang@gmail.com', N'NHÂN VIÊN BÁN HÀNG', 5500000, 'quanghq.jpg', '12345678'),
(N'Nguyễn Đức Thành', '01-01-2001', 1, N'Thanh Hóa', '0345678901', 'thanh@gmail.com', N'NHÂN VIÊN BÁN HÀNG', 5500000, 'thanhnd.jpg', '12345678'),
(N'Hoàng Quốc Huy', '01-01-2001', 1, N'Nghệ An', '0345678901', 'huy@gmail.com', N'NHÂN VIÊN BÁN HÀNG', 5500000, 'huynq.jpg', '12345678')

INSERT INTO CHAMCONG (IDNHANVIEN)
VALUES (10001),
(10002),
(10003),
(10004),
(10005),
(10006)

INSERT INTO CHITIEU (MUCDICHCHITIEU, IDNHANVIEN, SOTIEN, GHICHU)
VALUES (N'Tiển điện', 10002, 300000, N'tiền điện tháng 2'),
(N'Tiền nước', 10002, 150000, N'tiền nước tháng 2'),
(N'Tiền internet', 10002, 230000, N'tiền internet fpt tháng 2')

INSERT INTO KHACHHANG (HOTEN, SODIENTHOAI, DIACHI, TICHDIEM)
VALUES (NULL, '0345678912', '', 0),
('Nguyễn Quang Ngọc', '0345678912', NULL, 0),
('', '0345678912', 'Hoàn Kiếm', 100),
(NULL, '0345678912', NULL, 10)

INSERT INTO NGUONHANG (TEN, SODIENTHOAI, DIACHI)
VALUES (N'Nhà may kinh đô', '18008198', N'Nam Từ Liêm'),
(N'Nhà may amy', '18008199', N'Hai Bà Trưng')

INSERT INTO HOADONNHAPHANG (IDNHANVIEN, IDNGUONHANG, GHICHU)
VALUES (10001, 1, N'NGUỒN HÀNG NGÀY 28')

INSERT INTO CHITIETHOADONNHAPHANG (IDHOADONNHAPHANG, IDCHITIETSANPHAM, GIANHAP, SOLUONG)
VALUES (1, 10001, 250000, 100),
(1, 10002, 245000, 50)

INSERT INTO HOADONTHANHTOAN (IDKHACHHANG, IDNHANVIEN, DIEMDADOI, GHICHU)
VALUES (1, 10002, 0, N'HÓA ĐƠN THANH TOÁN NGÀY 28')

INSERT INTO CHITIETHOADONTHANHTOAN (IDCHITIETSANPHAM, IDHOADONTHANHTOAN, SOLUONG, GIAMGIATHEM)
VALUES (10001, 1, 10, 0),
(10002, 1, 2, 0)

INSERT INTO HOADONTRAHANG (IDNHANVIEN, GHICHU)
VALUES (10002, N'KHÁCH TRẢ HÀNG')

INSERT INTO CHITIETHOADONTRAHANG (IDHOADONTRAHANG, IDCHITIETHOADONTHANHTOAN, SOLUONG)
VALUES (1, 1, 1),
(1, 2, 1)

-- lấy số id tiếp theo của bảng
IF OBJECT_ID('PROC_GETID') IS NOT NULL
DROP PROC PROC_GETID
GO
CREATE PROC PROC_GETID
	@TABLE_NAME VARCHAR(30)
AS
	IF(@TABLE_NAME IS NULL)
		PRINT N'DỮ LIỆU NHẬP VÀO KHÔNG HỢP LỆ'
	ELSE
		DECLARE @LASSTID INT
		SET @LASSTID = IDENT_CURRENT(@TABLE_NAME)
SELECT @LASSTID

/*

INSERT INTO CHITIETSANPHAM (IDSANPHAM, MAUSAC, SIZE, SOLUONG, GIABAN, TRANGTHAI)
VALUES (1, /*N'ÁO THUN W2ATN2021034'*/, N'Đen', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Đen', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Đen', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Đen', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Xám', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Xám', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Xám', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Xám', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Vàng', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Vàng', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Vàng', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Vàng', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Trắng', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Trắng', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Trắng', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021034', N'Trắng', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đen', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đen', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đen', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đen', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Xám', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Xám', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Xám', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Xám', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Vàng', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Vàng', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Vàng', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Vàng', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đỏ', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đỏ', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đỏ', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Đỏ', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Trắng', 'XL', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Trắng', 'L', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Trắng', 'M', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021033', N'Trắng', 'S', 100, 215000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Đen', 'XL', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Đen', 'L', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Đen', 'M', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Đen', 'S', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Hồng', 'XL', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Hồng', 'L', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Hồng', 'M', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Hồng', 'S', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Kem', 'XL', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Kem', 'L', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Kem', 'M', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Kem', 'S', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Trắng', 'XL', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Trắng', 'L', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Trắng', 'M', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021030', N'Trắng', 'S', 100, 185000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Đen', 'XL', 100, 245000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Đen', 'L', 100, 245000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Đen', 'M', 100, 245000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Đen', 'S', 100, 245000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Trắng', 'XL', 100, 245000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Trắng', 'L', 100, 245000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Trắng', 'M', 100, 245000, 1),
(1, N'ÁO THUN W2ATN2021024', N'Trắng', 'S', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đen', 'XL', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đen', 'L', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đen', 'M', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đen', 'S', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Xanh dương', 'XL', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Xanh dương', 'L', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Xanh dương', 'M', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Xanh dương', 'S', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Kem', 'XL', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Kem', 'L', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Kem', 'M', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Kem', 'S', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Vàng', 'XL', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Vàng', 'L', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Vàng', 'M', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Vàng', 'S', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đỏ', 'XL', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đỏ', 'L', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đỏ', 'M', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Đỏ', 'S', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Trắng', 'XL', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Trắng', 'L', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Trắng', 'M', 100, 245000, 1),
(2, N'ÁO THUN W2ATD120005', N'Trắng', 'S', 100, 245000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đen', 'XL', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đen', 'L', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đen', 'M', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đen', 'S', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Kem', 'XL', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Kem', 'L', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Kem', 'M', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Kem', 'S', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đỏ', 'XL', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đỏ', 'L', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đỏ', 'N', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Đỏ', 'S', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Trắng', 'XL', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Trắng', 'L', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Trắng', 'M', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110019', N'Trắng', 'S', 100, 215000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đen', 'XL', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đen', 'L', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đen', 'M', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đen', 'S', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Xanh dương', 'XL', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Xanh dương', 'L', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Xanh dương', 'M', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Xanh dương', 'S', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Hồng', 'XL', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Hồng', 'L', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Hồng', 'M', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Hồng', 'S', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đỏ', 'XL', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đỏ', 'L', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đỏ', 'M', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Đỏ', 'S', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Trắng', 'XL', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Trắng', 'L', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Trắng', 'M', 100, 195000, 1),
(2, N'ÁO THUN W2ATD110010', N'Trắng', 'S', 100, 195000, 1),
(3, N'SƠ MI NỮ SMG079005BU', N'Xanh dương', 'XL', 100, 215000, 1),
(3, N'SƠ MI NỮ SMG079005BU', N'Xanh dương', 'L', 100, 215000, 1),
(3, N'SƠ MI NỮ SMG079005BU', N'Xanh dương', 'M', 100, 215000, 1),
(3, N'SƠ MI NỮ SMG079005BU', N'Xanh dương', 'S', 100, 215000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Kem', 'L', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Kem', 'M', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Xanh lá', 'L', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Xanh lá', 'M', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Tím', 'L', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Tím', 'M', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Hồng', 'L', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Hồng', 'M', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Vàng', 'L', 100, 245000, 1),
(4, N'ÁO SOMI W1SMD2011001', N'Vàng', 'M', 100, 245000, 1),
(4, N'ÁO SOMI W2SMD090007', N'Trắng', 'XL', 100, 225000, 1),
(4, N'ÁO SOMI W2SMD090007', N'Trắng', 'L', 100, 225000, 1),
(4, N'ÁO SOMI W2SMD090007', N'Trắng', 'M', 100, 225000, 1),
(4, N'ÁO SOMI W2SMD090007', N'Trắng', 'S', 100, 225000, 1),
(4, N'ÁO SOMI W2SMD090003', N'Hồng', 'L', 100, 235000, 1),
(4, N'ÁO SOMI W2SMD090003', N'Hồng', 'M', 100, 235000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Kem', 'S', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Kem', 'M', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Kem', 'L', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Đen', 'S', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Đen', 'M', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Đen', 'L', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Da bò', 'S', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Da bò', 'M', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN1011003', N'Da bò', 'L', 100, 215000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Đen', 'S', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Đen', 'M', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Đen', 'L', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Xanh', 'S', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Xanh', 'M', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Xanh', 'L', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Trắng', 'S', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Trắng', 'M', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120003', N'Trắng', 'L', 100, 285000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Trắng', 'S', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Trắng', 'M', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Trắng', 'L', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Đen', 'S', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Đen', 'M', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Đen', 'L', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Xanh', 'S', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Xanh', 'M', 100, 315000, 1),
(5, N'QUẦN SHORT W2SJN120001', N'Xanh', 'L', 100, 315000, 1),
(6, N'QUẦN JEAN W2QJN4011021', N'Xanh', 'S', 100, 395000, 1),
(6, N'QUẦN JEAN W2QJN4011021', N'Xanh', 'M', 100, 395000, 1),
(6, N'QUẦN JEAN W2QJN4011021', N'Xanh', 'L', 100, 395000, 1),
(6, N'QUẦN JEAN W2QJN1011017', N'Đen', '26', 100, 440000, 1),
(6, N'QUẦN JEAN W2QJN1011017', N'Đen', '27', 100, 440000, 1),
(6, N'QUẦN JEAN W2QJN1011017', N'Đen', '28', 100, 440000, 1),
(6, N'QUẦN JEAN W2QJN1011017', N'Đen', '29', 100, 440000, 1),
(6, N'QUẦN JEAN W2QJN3011012', N'Xanh', '26', 100, 340000, 1),
(6, N'QUẦN JEAN W2QJN3011012', N'Xanh', '27', 100, 340000, 1),
(6, N'QUẦN JEAN W2QJN3011012', N'Xanh', '28', 100, 340000, 1),
(6, N'QUẦN JEAN W2QJN3011012', N'Xanh', '29', 100, 340000, 1),
(7, N'QUẦN JOGGER W2QJJ1011001', N'Đen', 'S', 100, 395000, 1),
(7, N'QUẦN JOGGER W2QJJ1011001', N'Đen', 'M', 100, 395000, 1),
(7, N'QUẦN JOGGER W2QJJ1011001', N'Đen', 'L', 100, 395000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Kem', 'S', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Kem', 'M', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Kem', 'L', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Đen', 'S', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Đen', 'M', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Đen', 'L', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Xanh', 'S', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Xanh', 'M', 100, 385000, 1),
(7, N'QUẦN JOGGER W2QJG100002', N'Xanh', 'L', 100, 385000, 1),
(8, N'CHÂN VÁY W2CHV2011004', N'Da bò', 'S', 100, 225000, 1),
(8, N'CHÂN VÁY W2CHV2011004', N'Da bò', 'M', 100, 225000, 1),
(8, N'CHÂN VÁY W2CHV2011004', N'Da bò', 'L', 100, 225000, 1),
(8, N'CHÂN VÁY W2CHV2011004', N'Hồng', 'S', 100, 225000, 1),
(8, N'CHÂN VÁY W2CHV2011004', N'Hồng', 'M', 100, 225000, 1),
(8, N'CHÂN VÁY W2CHV2011004', N'Hồng', 'L', 100, 225000, 1),
(8, N'CHÂN VÁY W2CHV120002', N'Trắng', 'S', 100, 315000, 1),
(8, N'CHÂN VÁY W2CHV120002', N'Trắng', 'M', 100, 315000, 1),
(8, N'CHÂN VÁY W2CHV120002', N'Trắng', 'L', 100, 315000, 1),
(8, N'CHÂN VÁY W2CHV120002', N'Xanh', 'S', 100, 315000, 1),
(8, N'CHÂN VÁY W2CHV120002', N'Xanh', 'M', 100, 315000, 1),
(8, N'CHÂN VÁY W2CHV120002', N'Xanh', 'L', 100, 315000, 1)

*/