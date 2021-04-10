﻿-- INSERT

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
(10001, N'Thun tay dài'),
(10002, N'Sơ mi tay ngắn'),
(10002, N'Sơ mi tay dài'),
(10003, N'Short'),
(10004, N'Quần jean'),
(10004, N'Quần jogger'),
(10005, N'Chân váy')

INSERT INTO CHITIETSANPHAM (IDSANPHAM, MAUSAC, SIZE, SOLUONG, GIABAN, TRANGTHAI)
VALUES (1, N'Đen', 'XL', 0, 215000, 1),
(10001, N'Đen', 'L', 0, 215000, 0),
(10001, N'Đen', 'M', 0, 215000, 1),
(10001, N'Đen', 'S', 0, 215000, 1),
(10001, N'Xám', 'XL', 0, 215000, 1),
(10001, N'Xám', 'L', 0, 215000, 1),
(10001, N'Xám', 'M', 0, 215000, 1),
(10001, N'Xám', 'S', 0, 215000, 1),
(10001, N'Vàng', 'XL', 0, 215000, 1),
(10001, N'Vàng', 'L', 0, 215000, 1),
(10001, N'Vàng', 'M', 0, 215000, 1),
(10001, N'Vàng', 'S', 0, 215000, 1),
(10001, N'Trắng', 'XL', 0, 215000, 1),
(10001, N'Trắng', 'L', 0, 215000, 1),
(10001, N'Trắng', 'M', 0, 215000, 1),
(10001, N'Trắng', 'S', 0, 215000, 1),
(10001, N'Đen', 'XL', 0, 215000, 1),
(10001, N'Đen', 'L', 0, 215000, 1),
(10001, N'Đen', 'M', 0, 215000, 1),
(10001, N'Đen', 'S', 0, 215000, 1),
(10001, N'Xám', 'XL', 0, 215000, 1),
(10001, N'Xám', 'L', 0, 215000, 1),
(10001, N'Xám', 'M', 0, 215000, 1),
(10001, N'Xám', 'S', 0, 215000, 1),
(10001, N'Vàng', 'XL', 0, 215000, 1),
(10001, N'Vàng', 'L', 0, 215000, 1),
(10001, N'Vàng', 'M', 0, 215000, 1),
(10001, N'Vàng', 'S', 0, 215000, 1),
(10001, N'Đỏ', 'XL', 0, 215000, 1),
(10001, N'Đỏ', 'L', 0, 215000, 1),
(10001, N'Đỏ', 'M', 0, 215000, 1),
(10001, N'Đỏ', 'S', 0, 215000, 1),
(10001, N'Trắng', 'XL', 0, 215000, 1),
(10001, N'Trắng', 'L', 0, 215000, 1),
(10001, N'Trắng', 'M', 0, 215000, 1),
(10001, N'Trắng', 'S', 0, 215000, 1),
(10001, N'Đen', 'XL', 0, 185000, 1),
(10001, N'Đen', 'L', 0, 185000, 1),
(10001, N'Đen', 'M', 0, 185000, 1),
(10001, N'Đen', 'S', 0, 185000, 1),
(10001, N'Hồng', 'XL', 0, 185000, 1),
(10001, N'Hồng', 'L', 0, 185000, 1),
(10001, N'Hồng', 'M', 0, 185000, 1),
(10001, N'Hồng', 'S', 0, 185000, 1),
(10001, N'Kem', 'XL', 0, 185000, 1),
(10001, N'Kem', 'L', 0, 185000, 1),
(10001, N'Kem', 'M', 0, 185000, 1),
(10001, N'Kem', 'S', 0, 185000, 1),
(10001, N'Trắng', 'XL', 0, 185000, 1),
(10001, N'Trắng', 'L', 0, 185000, 1),
(10001, N'Trắng', 'M', 0, 185000, 1),
(10001, N'Trắng', 'S', 0, 185000, 1),
(10001, N'Đen', 'XL', 0, 245000, 1),
(10001, N'Đen', 'L', 0, 245000, 1),
(10001, N'Đen', 'M', 0, 245000, 1),
(10001, N'Đen', 'S', 0, 245000, 1),
(10001, N'Trắng', 'XL', 0, 245000, 1),
(10001, N'Trắng', 'L', 0, 245000, 1),
(10001, N'Trắng', 'M', 0, 245000, 1),
(10001, N'Trắng', 'S', 0, 245000, 1),
(10002, N'Đen', 'XL', 0, 245000, 1),
(10002, N'Đen', 'L', 0, 245000, 1),
(10002, N'Đen', 'M', 0, 245000, 1),
(10002, N'Đen', 'S', 0, 245000, 1),
(10002, N'Xanh dương', 'XL', 0, 245000, 1),
(10002, N'Xanh dương', 'L', 0, 245000, 1),
(10002, N'Xanh dương', 'M', 0, 245000, 1),
(10002,  N'Xanh dương',  'S',  0,  245000,  1), 
(10002,  N'Kem',  'XL',  0,  245000,  1), 
(10002,  N'Kem',  'L',  0,  245000,  1), 
(10002,  N'Kem',  'M',  0,  245000,  1), 
(10002,  N'Kem',  'S',  0,  245000,  1), 
(10002,  N'Vàng',  'XL',  0,  245000,  1), 
(10002,  N'Vàng',  'L',  0,  245000,  1), 
(10002,  N'Vàng',  'M',  0,  245000,  1), 
(10002,  N'Vàng',  'S',  0,  245000,  1), 
(10002,  N'Đỏ',  'XL',  0,  245000,  1), 
(10002,  N'Đỏ',  'L',  0,  245000,  1), 
(10002,  N'Đỏ',  'M',  0,  245000,  1), 
(10002,  N'Đỏ',  'S',  0,  245000,  1), 
(10002,  N'Trắng',  'XL',  0,  245000,  1), 
(10002,  N'Trắng',  'L',  0,  245000,  1), 
(10002,  N'Trắng',  'M',  0,  245000,  1), 
(10002,  N'Trắng',  'S',  0,  245000,  1), 
(10002,  N'Đen',  'XL',  0,  215000,  1), 
(10002,  N'Đen',  'L',  0,  215000,  1), 
(10002,  N'Đen',  'M',  0,  215000,  1), 
(10002,  N'Đen',  'S',  0,  215000,  1), 
(10002,  N'Kem',  'XL',  0,  215000,  1), 
(10002,  N'Kem',  'L',  0,  215000,  1), 
(10002,  N'Kem',  'M',  0,  215000,  1), 
(10002,  N'Kem',  'S',  0,  215000,  1), 
(10002,  N'Đỏ',  'XL',  0,  215000,  1), 
(10002,  N'Đỏ',  'L',  0,  215000,  1), 
(10002,  N'Đỏ',  'N',  0,  215000,  1), 
(10002,  N'Đỏ',  'S',  0,  215000,  1), 
(10002,  N'Trắng',  'XL',  0,  215000,  1), 
(10002,  N'Trắng',  'L',  0,  215000,  1), 
(10002,  N'Trắng',  'M',  0,  215000,  1), 
(10002,  N'Trắng',  'S',  0,  215000,  1), 
(10002,  N'Đen',  'XL',  0,  195000,  1), 
(10002,  N'Đen',  'L',  0,  195000,  1), 
(10002,  N'Đen',  'M',  0,  195000,  1), 
(10002,  N'Đen',  'S',  0,  195000,  1), 
(10002,  N'Xanh dương',  'XL',  0,  195000,  1), 
(10002,  N'Xanh dương',  'L',  0,  195000,  1), 
(10002,  N'Xanh dương',  'M',  0,  195000,  1), 
(10002,  N'Xanh dương',  'S',  0,  195000,  1), 
(10002,  N'Hồng',  'XL',  0,  195000,  1), 
(10002,  N'Hồng',  'L',  0,  195000,  1), 
(10002,  N'Hồng',  'M',  0,  195000,  1), 
(10002,  N'Hồng',  'S',  0,  195000,  1), 
(10002,  N'Đỏ',  'XL',  0,  195000,  1), 
(10002,  N'Đỏ',  'L',  0,  195000,  1), 
(10002,  N'Đỏ',  'M',  0,  195000,  1), 
(10002,  N'Đỏ',  'S',  0,  195000,  1), 
(10002,  N'Trắng',  'XL',  0,  195000,  1), 
(10002,  N'Trắng',  'L',  0,  195000,  1), 
(10002,  N'Trắng',  'M',  0,  195000,  1), 
(10002,  N'Trắng',  'S',  0,  195000,  1), 
(10003,  N'Xanh dương',  'XL',  0,  215000,  1), 
(10003,  N'Xanh dương',  'L',  0,  215000,  1), 
(10003,  N'Xanh dương',  'M',  0,  215000,  1), 
(10003,  N'Xanh dương',  'S',  0,  215000,  1), 
(10004,  N'Kem',  'L',  0,  245000,  1), 
(10004,  N'Kem',  'M',  0,  245000,  1), 
(10004,  N'Xanh lá',  'L',  0,  245000,  1), 
(10004,  N'Xanh lá',  'M',  0,  245000,  1), 
(10004,  N'Tím',  'L',  0,  245000,  1), 
(10004,  N'Tím',  'M',  0,  245000,  1), 
(10004,  N'Hồng',  'L',  0,  245000,  1), 
(10004,  N'Hồng',  'M',  0,  245000,  1), 
(10004,  N'Vàng',  'L',  0,  245000,  1), 
(10004,  N'Vàng',  'M',  0,  245000,  1), 
(10004,  N'Trắng',  'XL',  0,  225000,  1), 
(10004,  N'Trắng',  'L',  0,  225000,  1),
(10004,  N'Trắng',  'M',  0,  225000,  1), 
(10004,  N'Trắng',  'S',  0,  225000,  1), 
(10004,  N'Hồng',  'L',  0,  235000,  1), 
(10004,  N'Hồng',  'M',  0,  235000,  1), 
(10005,  N'Kem',  'S',  0,  215000,  1), 
(10005,  N'Kem',  'M',  0,  215000,  1), 
(10005,  N'Kem',  'L',  0,  215000,  1), 
(10005,  N'Đen',  'S',  0,  215000,  1), 
(10005,  N'Đen',  'M',  0,  215000,  1), 
(10005,  N'Đen',  'L',  0,  215000,  1), 
(10005,  N'Da bò',  'S',  0,  215000,  1), 
(10005,  N'Da bò',  'M',  0,  215000,  1), 
(10005,  N'Da bò',  'L',  0,  215000,  1), 
(10005,  N'Đen',  'S',  0,  285000,  1), 
(10005,  N'Đen',  'M',  0,  285000,  1), 
(10005,  N'Đen',  'L',  0,  285000,  1), 
(10005,  N'Xanh',  'S',  0,  285000,  1), 
(10005,  N'Xanh',  'M',  0,  285000,  1), 
(10005,  N'Xanh',  'L',  0,  285000,  1), 
(10005,  N'Trắng',  'S',  0,  285000,  1), 
(10005,  N'Trắng',  'M',  0,  285000,  1), 
(10005,  N'Trắng',  'L',  0,  285000,  1), 
(10005,  N'Trắng',  'S',  0,  315000,  1), 
(10005,  N'Trắng',  'M',  0,  315000,  1), 
(10005,  N'Trắng',  'L',  0,  315000,  1), 
(10005,  N'Đen',  'S',  0,  315000,  1), 
(10005,  N'Đen',  'M',  0,  315000,  1), 
(10005,  N'Đen',  'L',  0,  315000,  1), 
(10005,  N'Xanh',  'S',  0,  315000,  1), 
(10005,  N'Xanh',  'M',  0,  315000,  1), 
(10005,  N'Xanh',  'L',  0,  315000,  1), 
(10006,  N'Xanh',  'S',  0,  395000,  1), 
(10006,  N'Xanh',  'M',  0,  395000,  1), 
(10006,  N'Xanh',  'L',  0,  395000,  1), 
(10006,  N'Đen',  '26',  0,  440000,  1), 
(10006,  N'Đen',  '27',  0,  440000,  1), 
(10006,  N'Đen',  '28',  0,  440000,  1), 
(10006,  N'Đen',  '29',  0,  440000,  1), 
(10006,  N'Xanh',  '26',  0,  340000,  1), 
(10006,  N'Xanh',  '27',  0,  340000,  1), 
(10006,  N'Xanh',  '28',  0,  340000,  1), 
(10006,  N'Xanh',  '29',  0,  340000,  1), 
(10007,  N'Đen',  'S',  0,  395000,  1), 
(10007,  N'Đen',  'M',  0,  395000,  1), 
(10007,  N'Đen',  'L',  0,  395000,  1), 
(10007,  N'Kem',  'S',  0,  385000,  1), 
(10007,  N'Kem',  'M',  0,  385000,  1), 
(10007,  N'Kem',  'L',  0,  385000,  1), 
(10007,  N'Đen',  'S',  0,  385000,  1), 
(10007,  N'Đen',  'M',  0,  385000,  1), 
(10007,  N'Đen',  'L',  0,  385000,  1), 
(10007,  N'Xanh',  'S',  0,  385000,  1), 
(10007,  N'Xanh',  'M',  0,  385000,  1), 
(10007,  N'Xanh',  'L',  0,  385000,  1), 
(10008,  N'Da bò',  'S',  0,  225000,  1), 
(10008,  N'Da bò',  'M',  0,  225000,  1), 
(10008,  N'Da bò',  'L',  0,  225000,  1), 
(10008,  N'Hồng',  'S',  0,  225000,  1), 
(10008,  N'Hồng',  'M',  0,  225000,  1), 
(10008,  N'Hồng',  'L',  0,  225000,  1), 
(10008,  N'Trắng',  'S',  0,  315000,  1), 
(10008,  N'Trắng',  'M',  0,  315000,  1), 
(10008,  N'Trắng',  'L',  0,  315000,  1), 
(10008,  N'Xanh',  'S',  0,  315000,  1), 
(10008,  N'Xanh',  'M',  0,  315000,  1), 
(10008,  N'Xanh',  'L',  0,  315000,  1)

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

INSERT INTO KHACHHANG (HOTEN, SODIENTHOAI, DIACHI, TICHDIEM)
VALUES (N'Đỗ Văn Duy', '0345678912', N'', 0),
(N'Nguyễn Quang Ngọc', '0345678912', NULL, 0),
(N'Bùi Việt Đức', '0345678912', N'Hoàn Kiếm', 100),
(N'Nguyễn Đức Thành', '0345678912', NULL, 10)

INSERT INTO NGUONHANG (TEN, SODIENTHOAI, DIACHI)
VALUES (N'Nhà may kinh đô', '18008198', N'Nam Từ Liêm'),
(N'Nhà may amy', '18008199', N'Hai Bà Trưng')

INSERT INTO HOADONTRAHANG(IDNHANVIEN, GHICHU)
VALUES (10001, N'THÍCH THÌ TRẢ')