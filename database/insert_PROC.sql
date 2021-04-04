﻿
USE POLYMART_v1
GO

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

-- CẬP NHẬT LẠI SỐ LƯỢNG TỒN KHO SAU KHI XÓA HÓA ĐƠN NHẬP HÀNG
-- xóa hóa đơn nhập hàng
IF OBJECT_ID('PROC_DELETE_HOADONNHAPHANG') IS NOT NULL
DROP PROC PROC_DELETE_HOADONNHAPHANG
GO
CREATE PROC PROC_DELETE_HOADONNHAPHANG
	@IDHOADONNHAPHANG INT
AS
	BEGIN TRY
		BEGIN TRAN
			IF (@IDHOADONNHAPHANG NOT IN (SELECT ID FROM HOADONNHAPHANG))
				PRINT N'MÃ HÓA ĐƠN KHÔNG TỒN TẠI'
			ELSE
				UPDATE CHITIETSANPHAM 
				SET SOLUONG = SOLUONG - (SELECT SOLUONG FROM CHITIETHOADONNHAPHANG 
					WHERE IDCHITIETSANPHAM = CHITIETSANPHAM.ID AND IDHOADONNHAPHANG = @IDHOADONNHAPHANG)
				WHERE ID IN (SELECT IDCHITIETSANPHAM FROM CHITIETHOADONNHAPHANG 
					WHERE IDHOADONNHAPHANG = @IDHOADONNHAPHANG)
				DELETE FROM CHITIETHOADONNHAPHANG
				WHERE IDHOADONNHAPHANG = @IDHOADONNHAPHANG
				DELETE FROM HOADONNHAPHANG WHERE ID = @IDHOADONNHAPHANG
		COMMIT TRAN
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
	END CATCH