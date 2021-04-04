-- INSERT

USE POLYMART_v1
GO

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
VALUES (N'Đỗ Văn Duy', '0345678912', N'', 0),
(N'Nguyễn Quang Ngọc', '0345678912', NULL, 0),
(N'Bùi Việt Đức', '0345678912', N'Hoàn Kiếm', 100),
(N'Nguyễn Đức Thành', '0345678912', NULL, 10)

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