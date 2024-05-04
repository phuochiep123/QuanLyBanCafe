--14/04/2024--
USE master

CREATE DATABASE CoffeeShop
GO

USE CoffeeShop
GO
--Tạo bảng
CREATE TABLE Ban 
	(MaBan int  NOT NULL, 
	SoGhe int NOT NULL, 
	TinhTrang bit NOT NULL, 
	PRIMARY KEY (MaBan)
)
GO

CREATE TABLE CaLam 
	(MaCa varchar(10) NOT NULL, 
	TenCa nvarchar(30) NULL, 
	ThoiGianBatDau time(7) NOT NULL, 
	ThoiGianketThuc time(7) NOT NULL, 
	LuongTheoGio float(10) NOT NULL,
	PRIMARY KEY (MaCa)
)
GO

CREATE TABLE ChiTietHoaDon 
	(SoLuong int NOT NULL, 
	SanPham varchar(10) NOT NULL, 
	HoaDon varchar(10) NOT NULL,
	PRIMARY KEY (SanPham, HoaDon)
)
GO

CREATE TABLE HoaDon (
	MaHoaDon varchar(10) NOT NULL, 
	NhanVien varchar(10) NOT NULL, 
	Ban int NOT NULL, 
	KhachHang varchar(10) NOT NULL,
	NgayTao DATETIME NULL, 
	PhuongThucThanhToan varchar(15),
	TrangThaiThanhToan bit NOT NULL, 
	GhiChu varchar(1150) NULL, 
	PRIMARY KEY (MaHoaDon)
)
GO

CREATE TABLE KhachHang (
	MaKhachHang varchar(10) NOT NULL, 
	HoTen nvarchar(30) NOT NULL, 
	GioiTinh bit NOT NULL, 
	DienThoai varchar(11) NOT NULL, 
	NgayThem datetime NOT NULL, 
	PRIMARY KEY (MaKhachHang)
)
GO
CREATE TABLE KhuyenMai 
	(MaKhuyenMai varchar(10) NOT NULL, 
	TenKhuyenMai nvarchar(150) NOT NULL, 
	MoTa nvarchar(150) NULL, 
	NgayBatDau datetime NOT NULL, 
	NgayKetThuc datetime NOT NULL, 
	PhanTramGiamGia float(10) NOT NULL, 
	TrangThai bit NOT NULL, 
	PRIMARY KEY (MaKhuyenMai)
)
GO

CREATE TABLE LoaiSanPham (
	MaLoai varchar(10) NOT NULL, 
	TenLoai nvarchar(30) NOT NULL, 
	MoTa nvarchar(150) NULL, 
	PRIMARY KEY (MaLoai)
)
GO

CREATE TABLE TaiKhoan 
	(MaTaiKhoan varchar(10) NOT NULL,  
	TenTaiKhoan varchar(20) NOT NULL, 
	MatKhau varchar(160) NULL, 
	LoaiTaiKhoan bit NOT NULL, 
	PRIMARY KEY (MaTaiKhoan)
)
GO

CREATE TABLE NhanVien 
	(MaNhanVien varchar(10) NOT NULL, 
	MaTaiKhoan varchar(10) NOT NULL,  
	HoTen nvarchar(30) NULL, 
	GioiTinh bit NOT NULL, 
	Sdt varchar(11) NOT NULL, 
	NgaySinh datetime NULL, 
	ChucVu varchar(20) NOT NULL, 
	NgayThem datetime NULL, 
	DiaChi varchar(100) NULL, 
	KhuVuc varchar(100) NULL, 
	Email varchar(50) NULL,
	TrangThai bit NOT NULL,
	HinhAnh varchar(50) NULL, 
	PRIMARY KEY (MaNhanVien)
)
GO

CREATE TABLE NV_Ca
(
    MaCa varchar(10) NOT NULL,
    MaNhanVien varchar(10) NOT NULL,
    NgayLam date NOT NULL,
    TongDoanhThu float(10) NOT NULL,
    PRIMARY KEY (MaCa, MaNhanVien,NgayLam)
)
GO


CREATE TABLE SanPham 
	(MaSanPham varchar(10) NOT NULL, 
	KhuyenMai varchar(10) NULL, 
	LoaiSanPham varchar(10) NOT NULL, 
	TenSanPham nvarchar(150) NULL, 
	KichThuoc char(1) NULL, 
	Gia float(10) NOT NULL, 
	TrangThai bit NOT NULL, 
	HinhAnh varchar(150) NULL, 
	MoTa nvarchar(150) NULL, 
	PRIMARY KEY (MaSanPham)
)
GO



--Thêm ràng buộc khóa
ALTER TABLE HoaDon 
	ADD CONSTRAINT FK_HD_KH FOREIGN KEY (KhachHang) REFERENCES KhachHang (MaKhachHang)
GO

ALTER TABLE HoaDon 
	ADD CONSTRAINT FK_HD_Ban FOREIGN KEY (Ban) REFERENCES Ban(MaBan)
GO

ALTER TABLE ChiTietHoaDon 
	ADD CONSTRAINT FK_ChiTietHoaDon FOREIGN KEY (HoaDon) REFERENCES HoaDon (MaHoaDon)
GO

ALTER TABLE ChiTietHoaDon 
	ADD CONSTRAINT FK_ChiTietHoaDon_SanPham FOREIGN KEY (SanPham) REFERENCES SanPham (MaSanPham)
GO

ALTER TABLE SanPham 
	ADD CONSTRAINT FK_SanPham_Loai FOREIGN KEY (LoaiSanPham) REFERENCES LoaiSanPham (MaLoai)
GO

ALTER TABLE HoaDon 
	ADD CONSTRAINT FK_HoaDon_NV FOREIGN KEY (NhanVien) REFERENCES NhanVien (MaNhanVien)
GO

ALTER TABLE SanPham 
	ADD CONSTRAINT FK_SanPham_KhuyenMai FOREIGN KEY (KhuyenMai) REFERENCES KhuyenMai (MaKhuyenMai)
GO

ALTER TABLE NV_Ca
	ADD CONSTRAINT FK_NV_Ca_CaLam FOREIGN KEY (MaCa) REFERENCES CaLam(MaCa)
go
ALTER TABLE NV_Ca
	ADD CONSTRAINT FK_NV_Ca_NhanVien FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
go
ALTER TABLE NhanVien
	ADD CONSTRAINT FK_TaiKhoan_NV FOREIGN KEY (MaTaiKhoan) REFERENCES TaiKhoan (MaTaiKhoan)
GO
--chèn dữ liệu bảng bàn
INSERT INTO Ban (MaBan, SoGhe, TinhTrang) VALUES
    (1, 4, 1), (2, 4, 1), (3, 4, 1), (4, 4, 0),
    (5, 4, 1), (6, 4, 1), (7, 4, 0), (8, 4, 0), (9, 6, 0), (10, 6, 0),
    (11, 6, 1), (12, 6, 1),
    (13, 8, 0), (14, 8, 0),(15, 8, 1), (16, 8, 0);
go
--Chèn dữ liệu bảng ca làm
INSERT INTO CaLam (MaCa, TenCa, ThoiGianBatDau, ThoiGianketThuc,LuongTheoGio) VALUES
	('CA01', N'Ca Sáng', '06:30:00', '11:30:00', 23000.0),
    ('CA02', N'Ca Chiều', '11:30:00', '16:30:00', 23000.0),
	('CA03', N'Ca Tối', '16:30:00', '21:30:00', 25000.0);
 
go
--chèn dữ liệu vào bảng loại sản phẩm
INSERT INTO LoaiSanPham (MaLoai, TenLoai, MoTa) VALUES
    ('Loai01', N'Cà phê', N'Cà phê nóng, sữa và đá, các loại espresso, cappuccino, latte, và nhiều hương vị khác'),
    ('Loai02', N'Bánh ngọt', N'Bánh ngọt làm từ các nguyên liệu như bột mỳ, đường, trứng, bơ, và có thể có các loại nhân khác nhau'),
    ('Loai03', N'Thức uống khác', N'Thức uống khác bao gồm các loại nước ép, sinh tố, nước ngọt và nước ép trái cây tự nhiên');
go
--chèn bảng khách hàng
INSERT INTO KhachHang (MaKhachHang, HoTen, GioiTinh, DienThoai, NgayThem)
VALUES
    ('KH001', N'Nguyễn Thị Hằng', 0, '0987654321', '2024-04-27'),
    ('KH002', N'Trần Văn Hùng', 1, '0123456789', '2024-04-27'),
    ('KH003', N'Lê Thị Minh Châu', 0, '0978123456', '2024-04-27'),
    ('KH004', N'Phạm Hoàng Nam', 1, '0932123456', '2024-04-27'),
    ('KH005', N'Vũ Thị Linh', 0, '0918234567', '2024-04-27'),
    ('KH006', N'Nguyễn Văn An', 1, '0987654321', '2024-04-27'),
    ('KH007', N'Hoàng Thị Mai', 0, '0909123456', '2024-04-27'),
    ('KH008', N'Trần Văn Long', 1, '0987123456', '2024-04-27'),
    ('KH009', N'Nguyễn Thị Hằng', 0, '0938123456', '2024-04-27'),
    ('KH010', N'Phạm Thị Hoa', 0, '0976123456', '2024-04-27'),
	('KH011', N'Lê Văn Đức', 1, '0987123456', '2024-04-28'),
    ('KH012', N'Nguyễn Thị Thanh', 0, '0978123456', '2024-04-28'),
    ('KH013', N'Trần Thị Hồng', 0, '0918234567', '2024-04-28'),
    ('KH014', N'Phạm Văn Tùng', 1, '0987123456', '2024-04-28'),
    ('KH015', N'Hoàng Văn Nam', 1, '0932123456', '2024-04-28'),
    ('KH016', N'Lê Thị Thu', 0, '0909123456', '2024-04-28'),
    ('KH017', N'Nguyễn Văn Lâm', 1, '0938123456', '2024-04-28'),
    ('KH018', N'Trần Thị Hương', 0, '0976123456', '2024-04-28'),
	('KH019', N'Phạm Văn Tuấn', 1, '0987123456', '2024-04-29'),
    ('KH020', N'Lê Thị Thảo', 0, '0978123456', '2024-04-29'),
    ('KH021', N'Trần Văn Hải', 1, '0918234567', '2024-04-29'),
    ('KH022', N'Nguyễn Thị Bích', 0, '0987123456', '2024-04-29'),
    ('KH023', N'Phạm Văn Hiếu', 1, '0932123456', '2024-04-29'),
    ('KH024', N'Hoàng Thị Ngọc', 0, '0909123456', '2024-04-29'),
    ('KH025', N'Trần Văn Tiến', 1, '0938123456', '2024-04-29'),
    ('KH026', N'Lê Thị Thu Hà', 0, '0976123456', '2024-04-29'),
    ('KH027', N'Nguyễn Văn Thắng', 1, '0978123456', '2024-04-29'),
	('KH028', N'Nguyễn Thị Hương', 0, '0987123456', '2024-04-30'),
    ('KH029', N'Trần Văn Tuấn', 1, '0978123456', '2024-04-30'),
    ('KH030', N'Phạm Thị Lan', 0, '0918234567', '2024-04-30'),
    ('KH031', N'Lê Văn Dũng', 1, '0987123456', '2024-04-30'),
    ('KH032', N'Nguyễn Thị Hà', 0, '0932123456', '2024-04-30'),
    ('KH033', N'Trần Văn Nam', 1, '0909123456', '2024-04-30'),
    ('KH034', N'Phạm Thị Hằng', 0, '0938123456', '2024-04-30'),
    ('KH035', N'Hoàng Văn Hùng', 1, '0976123456', '2024-04-30'),
	('KH036', N'Nguyễn Thị Lan Anh', 0, '0987123456', '2024-05-01'),
    ('KH037', N'Trần Văn Quân', 1, '0978123456', '2024-05-01'),
    ('KH038', N'Phạm Thị Hà', 0, '0918234567', '2024-05-01'),
    ('KH039', N'Lê Văn Minh', 1, '0987123456', '2024-05-01'),
    ('KH040', N'Nguyễn Thị Thu Hà', 0, '0932123456', '2024-05-01'),
    ('KH041', N'Trần Văn Long', 1, '0909123456', '2024-05-01'),
    ('KH042', N'Phạm Thị Hương', 0, '0938123456', '2024-05-01'),
    ('KH043', N'Lê Văn Đức', 1, '0976123456', '2024-05-01'),
    ('KH044', N'Nguyễn Thị Mai', 0, '0987123456', '2024-05-02'),
    ('KH045', N'Trần Văn Tuấn', 1, '0978123456', '2024-05-02'),
    ('KH046', N'Phạm Thị Lan', 0, '0918234567', '2024-05-02'),
    ('KH047', N'Lê Văn Dũng', 1, '0987123456', '2024-05-02'),
    ('KH048', N'Nguyễn Thị Hà', 0, '0932123456', '2024-05-02'),
    ('KH049', N'Trần Văn Nam', 1, '0909123456', '2024-05-02'),
    ('KH050', N'Phạm Thị Hằng', 0, '0938123456', '2024-05-02'),
    ('KH051', N'Lê Văn Hùng', 1, '0976123456', '2024-05-02'),
    ('KH052', N'Nguyễn Thị Thanh', 0, '0987123456', '2024-05-03'),
    ('KH053', N'Trần Thị Hồng', 0, '0978123456', '2024-05-03'),
    ('KH054', N'Phạm Văn Tùng', 1, '0918234567', '2024-05-03'),
    ('KH055', N'Lê Thị Thu', 0, '0987123456', '2024-05-03');
--chèn bảng khuyến mãi

INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, MoTa, NgayBatDau, NgayKetThuc, PhanTramGiamGia, TrangThai)
VALUES
    ('KM001', N'Giảm giá 20% cho tất cả sản phẩm nhân ngày Giải Phóng hoàn toàn miền Nam và Quốc tế lao động', N'Áp dụng cho tất cả các sản phẩm trong cửa hàng','2024-04-30 00:00:00', '2024-05-01 23:59:59', 20.0, 1),
    ('KM002', N'Giảm giá 15% cho bánh ngọt', N'Chương trình khuyến mãi đặc biệt cho bánh ngọt', '2024-05-1 00:00:00', '2024-05-31 23:59:59', 15.0, 1);
go
-- chèn tài khoản
INSERT INTO TaiKhoan (MaTaiKhoan, TenTaiKhoan, MatKhau, LoaiTaiKhoan)
VALUES 
	('TK001', 'TranCongTinh', 'pass', 0),
	('TK002', 'admin', 'admin', 1),
	('TK003', 'PhucDaiCute', 'PhucDaiCuTe', 0),
	('TK004', 'NguyenVanThach', 'password', 0);
go

--chèn bảng nhân viên
INSERT INTO NhanVien (MaNhanVien,MaTaiKhoan, HoTen, GioiTinh, Sdt, NgaySinh, ChucVu, NgayThem, DiaChi, KhuVuc, Email, TrangThai, HinhAnh)
VALUES ('NV001','TK001' , N'Trần Công Tính',1, '0326829327', '2004-04-20', N'Nhân viên bán hàng','2024-04-26', N'TP.Hồ Chí Minh', N'Quận 12', 'trancongtinh20042004@gmail.com', 1, NULL),
	   ('NV002', 'TK002', N'Phan Phước Hiệp', 1, '0376782409', '2004-11-14', N'Quản lý','2024-04-26', N'TP.Hồ Chí Minh', N'Huyện Hóc Môn', 'phanphuochiep2004@gmail.com', 1, NULL),
	   ('NV003', 'TK003', N'Lữ Hồng Phúc Đại', 1, '0366192248', '2004-01-15', N'Nhân viên bán hàng','2024-04-26', N'TP.Hồ Chí Minh', N'Quận Thủ Đức', 'luhongphucdaiht@gmail.com', 1, NULL),
	   ('NV004', 'TK004', N'Nguyễn Văn Thạch', 1, '0326111333', '2003-06-23', N'Nhân viên bán hàng','2024-04-26', N'TP.Hồ Chí Minh', N'Quận Gò Vấp', 'nvthach2003@gmail.com', 1, NULL);
-- chèn vào bảng 
INSERT INTO NV_Ca (MaCa, MaNhanVien, NgayLam, TongDoanhThu)
VALUES 
	('CA01', 'NV001', '2024-04-27', 1500000),
	('CA02', 'NV003', '2024-04-27', 900000),
	('CA03', 'NV004', '2024-04-27', 1200000),
	('CA01', 'NV004', '2024-04-28', 1250000),
	('CA02', 'NV002', '2024-04-28', 875000),
	('CA03', 'NV001', '2024-04-28', 1150000),
	('CA01', 'NV001', '2024-04-29', 1500000),
	('CA02', 'NV003', '2024-04-29', 900000),
	('CA03', 'NV004', '2024-04-29', 1200000),
	('CA01', 'NV001', '2024-04-30', 1500000),
	('CA02', 'NV003', '2024-04-30', 900000),
	('CA03', 'NV004', '2024-04-30', 1200000),
	('CA01', 'NV004', '2024-05-01', 1250000),
	('CA02', 'NV002', '2024-05-01', 875000),
	('CA03', 'NV001', '2024-05-01', 1150000);
	go

--chèn sản phẩm
INSERT INTO SanPham (MaSanPham, KhuyenMai, LoaiSanPham, TenSanPham, KichThuoc, Gia, TrangThai, HinhAnh, MoTa)
VALUES 
	('SP001S',NULL, 'Loai01', N'Cafe-Affogato', 'S', '30000', 1, '/images/cafe/cafe-affogato.png', N'Affogato đậm đặc với hương vị mạnh mẽ.'),
	('SP001M',NULL, 'Loai01', N'Cafe-Affogato', 'M', '35000', 1, '/images/cafe/cafe-affogato.png', N'Affogato đậm đặc với hương vị mạnh mẽ.'),
	('SP001L',NULL, 'Loai01', N'Cafe-Affogato', 'L', '40000', 1, '/images/cafe/cafe-affogato.png', N'Affogato đậm đặc với hương vị mạnh mẽ.'),
	('SP002S', NULL, 'Loai01', N'Cafe-Americano', 'S', '25000', 1, '/images/cafe/cafe-americano.png', N'Cà phê Americano đậm đặc với hương vị đặc trưng.'),
	('SP002M', NULL, 'Loai01', N'Cafe-Americano', 'M', '30000', 1, '/images/cafe/cafe-americano.png', N'Cà phê Americano đậm đặc với hương vị đặc trưng.'),
	('SP002L', NULL, 'Loai01', N'Cafe-Americano', 'L', '35000', 1, '/images/cafe/cafe-americano.png', N'Cà phê Americano đậm đặc với hương vị đặc trưng.'),
	
	('SP003S', NULL, 'Loai01', N'Bạc xỉu', 'S', '20000', 1, '/images/cafe/cafe-bacxiu.png', N'Cà phê bạc xỉu nhẹ nhàng, dễ uống.'),
	('SP003M', NULL, 'Loai01', N'Bạc xỉu', 'M', '25000', 1, '/images/cafe/cafe-bacxiu.png', N'Cà phê bạc xỉu nhẹ nhàng, dễ uống.'),
	('SP003L', NULL, 'Loai01', N'Bạc xỉu', 'L', '30000', 1, '/images/cafe/cafe-bacxiu.png', N'Cà phê bạc xỉu nhẹ nhàng, dễ uống.'),
	
	('SP004S', NULL, 'Loai01', N'Cafe-Cappuccino', 'S', '28000', 1, '/images/cafe/cafe-cappuccino.png', N'Cappuccino với lớp bọt sữa mịn màng.'),
	('SP004M', NULL, 'Loai01', N'Cafe-Cappuccino', 'M', '33000', 1, '/images/cafe/cafe-cappuccino.png', N'Cappuccino với lớp bọt sữa mịn màng.'),
	('SP004L', NULL, 'Loai01', N'Cafe-Cappuccino', 'L', '38000', 1, '/images/cafe/cafe-cappuccino.png', N'Cappuccino với lớp bọt sữa mịn màng.'),
	
	('SP005S', NULL, 'Loai01', N'Cafe Đen đá', 'S', '20000', 1, '/images/cafe/cafe-denda.png', N'Cà phê đen đá thơm ngon, hấp dẫn.'),
	('SP005M', NULL, 'Loai01', N'Cafe Đen đá', 'M', '25000', 1, '/images/cafe/cafe-denda.png', N'Cà phê đen đá thơm ngon, hấp dẫn.'),
	('SP005L', NULL, 'Loai01', N'Cafe Đen đá', 'L', '30000', 1, '/images/cafe/cafe-denda.png', N'Cà phê đen đá thơm ngon, hấp dẫn.'),
	
	('SP006S', NULL, 'Loai01', N'Cafe-Espresso', 'S', '22000', 1, '/images/cafe/cafe-espresso.png', N'Cà phê Espresso sắc nét, đậm đà.'),
	('SP006M', NULL, 'Loai01', N'Cafe-Espresso', 'M', '27000', 1, '/images/cafe/cafe-espresso.png', N'Cà phê Espresso sắc nét, đậm đà.'),
	('SP006L', NULL, 'Loai01', N'Cafe-Espresso', 'L', '32000', 1, '/images/cafe/cafe-espresso.png', N'Cà phê Espresso sắc nét, đậm đà.'),
	
	('SP007S', NULL, 'Loai01', N'Cafe-FlatWhite', 'S', '30000', 1, '/images/cafe/cafe-flatwhite.png', N'Cà phê Flat White mềm mịn, ngọt ngào.'),
	('SP007M', NULL, 'Loai01', N'Cafe-FlatWhite', 'M', '35000', 1, '/images/cafe/cafe-flatwhite.png', N'Cà phê Flat White mềm mịn, ngọt ngào.'),
	('SP007L', NULL, 'Loai01', N'Cafe-FlatWhite', 'L', '40000', 1, '/images/cafe/cafe-flatwhite.png', N'Cà phê Flat White mềm mịn, ngọt ngào.'),
	
	('SP008S', NULL, 'Loai01', N'Cafe-Frappuccino', 'S', '35000', 1, '/images/cafe/cafe-frappuccino.png', N'Cà phê Frappuccino đá xay mát lạnh.'),
	('SP008M', NULL, 'Loai01', N'Cafe-Frappuccino', 'M', '40000', 1, '/images/cafe/cafe-frappuccino.png', N'Cà phê Frappuccino đá xay mát lạnh.'),
	('SP008L', NULL, 'Loai01', N'Cafe-Frappuccino', 'L', '45000', 1, '/images/cafe/cafe-frappuccino.png', N'Cà phê Frappuccino đá xay mát lạnh.'),
	
	('SP009S', NULL, 'Loai01', N'Cafe-IrishCoffee', 'S', '38000', 1, '/images/cafe/cafe-irishcoffee.png', N'Cà phê Irish Coffee đậm đà với rượu whiskey.'),
	('SP009M', NULL, 'Loai01', N'Cafe-IrishCoffee', 'M', '43000', 1, '/images/cafe/cafe-irishcoffee.png', N'Cà phê Irish Coffee đậm đà với rượu whiskey.'),
	('SP009L', NULL, 'Loai01', N'Cafe-IrishCoffee', 'L', '48000', 1, '/images/cafe/cafe-irishcoffee.png', N'Cà phê Irish Coffee đậm đà với rượu whiskey.'),
	
	('SP010S', NULL, 'Loai01', N'Cafe-Macchiato', 'S', '26000', 1, '/images/cafe/cafe-macchiato.png', N'Cà phê Macchiato đơn giản và ngon.'),
	('SP010M', NULL, 'Loai01', N'Cafe-Macchiato', 'M', '31000', 1, '/images/cafe/cafe-macchiato.png', N'Cà phê Macchiato đơn giản và ngon.'),
	('SP010L', NULL, 'Loai01', N'Cafe-Macchiato', 'L', '36000', 1, '/images/cafe/cafe-macchiato.png', N'Cà phê Macchiato đơn giản và ngon.'),
	
	('SP011S', NULL, 'Loai01', N'Cafe-Mocha', 'S', '32000', 1, '/images/cafe/cafe-mocha.png', N'Cà phê Mocha ngọt ngào với sô cô la.'),
	('SP011M', NULL, 'Loai01', N'Cafe-Mocha', 'M', '37000', 1, '/images/cafe/cafe-mocha.png', N'Cà phê Mocha ngọt ngào với sô cô la.'),
	('SP011L', NULL, 'Loai01', N'Cafe-Mocha', 'L', '42000', 1, '/images/cafe/cafe-mocha.png', N'Cà phê Mocha ngọt ngào với sô cô la.'),
	
	('SP012S', NULL, 'Loai01', N'Cafe-Phin', 'S', '18000', 1, '/images/cafe/cafe-phin.png', N'Cà phê Phin đậm đà, thơm ngon.'),
	('SP012M', NULL, 'Loai01', N'Cafe-Phin', 'M', '23000', 1, '/images/cafe/cafe-phin.png', N'Cà phê Phin đậm đà, thơm ngon.'),
	('SP012L', NULL, 'Loai01', N'Cafe-Phin', 'L', '28000', 1, '/images/cafe/cafe-phin.png', N'Cà phê Phin đậm đà, thơm ngon.'),

	('SP013S', NULL, 'Loai01', N'Cafe Cốt Dừa', 'S', '28000', 1, '/images/cafe/cafe-cotdua.png', N'Cà phê Cốt Dừa thơm ngon, ngọt dịu.'),
    ('SP013M', NULL, 'Loai01', N'Cafe Cốt Dừa', 'M', '33000', 1, '/images/cafe/cafe-cotdua.png', N'Cà phê Cốt Dừa thơm ngon, ngọt dịu.'),
    ('SP013L', NULL, 'Loai01', N'Cafe-Cốt Dừa', 'L', '38000', 1, '/images/cafe/cafe-cotdua.png', N'Cà phê Cốt Dừa thơm ngon, ngọt dịu.'),
    
    ('SP014S', NULL, 'Loai01', N'Cafe Trứng nướng', 'S', '30000', 1, '/images/cafe/cafe-trungnuong.png', N'Cà phê Trứng Nướng độc đáo, hấp dẫn.'),
    ('SP014M', NULL, 'Loai01', N'Cafe Trứng nướng', 'M', '35000', 1, '/images/cafe/cafe-trungnuong.png', N'Cà phê Trứng Nướng độc đáo, hấp dẫn.'),
    ('SP014L', NULL, 'Loai01', N'Cafe Trứng nướng', 'L', '40000', 1, '/images/cafe/cafe-trungnuong.png', N'Cà phê Trứng Nướng độc đáo, hấp dẫn.'),
    
    ('SP015S', NULL, 'Loai01', N'Cafe-Latte', 'S', '32000', 1, '/images/cafe/cafe-latte.png', N'Cà phê Latte thơm ngon với sữa và bọt sữa.'),
    ('SP015M', NULL, 'Loai01', N'Cafe-Latte', 'M', '37000', 1, '/images/cafe/cafe-latte.png', N'Cà phê Latte thơm ngon với sữa và bọt sữa.'),
    ('SP015L', NULL, 'Loai01', N'Cafe-Latte', 'L', '42000', 1, '/images/cafe/cafe-latte.png', N'Cà phê Latte thơm ngon với sữa và bọt sữa.'),
    
    ('SP016S', NULL, 'Loai01', N'Cafe Hoa quả', 'S', '35000', 1, '/images/cafe/cafe-hoaqua.png', N'Cà phê Hoa Quả tươi mới, mát lạnh.'),
    ('SP016M', NULL, 'Loai01', N'Cafe Hoa quả', 'M', '40000', 1, '/images/cafe/cafe-hoaqua.png', N'Cà phê Hoa Quả tươi mới, mát lạnh.'),
    ('SP016L', NULL, 'Loai01', N'Cafe Hoa quả', 'L', '45000', 1, '/images/cafe/cafe-hoaqua.png', N'Cà phê Hoa Quả tươi mới, mát lạnh.'),

	('SP017S', NULL, 'Loai01', N'Cafe Sữa Đá', 'S', '18000', 1, '/images/cafe/cafe-suada.png', N'Cà phê sữa đá đậm đà, thơm ngon.'),
	('SP017M', NULL, 'Loai01', N'Cafe Sữa Đá', 'M', '23000', 1, '/images/cafe/cafe-suada.png', N'Cà phê sữa đá đậm đà, thơm ngon.'),
	('SP017L', NULL, 'Loai01', N'Cafe Sữa Đá', 'L', '28000', 1, '/images/cafe/cafe-suada.png', N'Cà phê sữa đá đậm đà, thơm ngon.');

GO
--insert bánh 
INSERT INTO SanPham (MaSanPham, KhuyenMai, LoaiSanPham, TenSanPham, KichThuoc, Gia, TrangThai, HinhAnh, MoTa)
VALUES 
    ('SP018', NULL, 'Loai02', N'Apple Pie', NULL, '45000', 1, '/images/cake/apple-pie.png', N'Bánh táo ngọt thanh, hòa quyện cùng vị nhẹ nhàng của những lát táo tươi.'),
    ('SP019', NULL, 'Loai02', N'Banana Cake', NULL, '38000', 1, '/images/cake/banana-cake.png', N'Bánh chuối thơm ngon, mềm mịn, kết hợp với vị ngọt tự nhiên của chuối.'),
    ('SP020', NULL, 'Loai02', N'Bánh Phô Mai', NULL, '25000', 1, '/images/cake/banh-pho-mai.png', N'Bánh phô mai truyền thống với lớp vỏ mỏng và nhân bánh thơm ngon.'),
    ('SP021', NULL, 'Loai02', N'Blueberry Muffin', NULL, '28000', 1, '/images/cake/blueberry-muffin.png', N'Muffin việt quất thơm mát, vị chua dễ chịu kết hợp với vị ngọt của việt quất.'),
    ('SP022', NULL, 'Loai02', N'Bông Lan Trứng Muối', NULL, '32000', 1, '/images/cake/bong-lan-trung-muoi.png', N'Bánh bông lan trứng muối thơm mềm, vị trứng muối đặc trưng.'),
    ('SP023', NULL, 'Loai02', N'Brownie', NULL, '35000', 1, '/images/cake/brownie.png', N'Bánh brownie sô cô la thơm ngon, đậm đà, giòn rụm ở ngoài và mềm mịn ở trong.'),
    ('SP024', NULL, 'Loai02', N'Carrot Cake', NULL, '40000', 1, '/images/cake/carrot-cake.png', N'Bánh cà rốt thơm ngon, mềm mịn, phủ lớp kem phô mai ngọt thanh.'),
    ('SP025', NULL, 'Loai02', N'Cheese Cake', NULL, '42000', 1, '/images/cake/cheese-cake.png', N'Bánh cheese cake mềm mịn, thơm ngon, vị phô mai đặc trưng.'),
    ('SP026', NULL, 'Loai02', N'Chocolate Chip', NULL, '30000', 1, '/images/cake/chocolate-chip.png', N'Bánh sô cô la chip ngọt ngào, thơm ngon, cực kỳ hấp dẫn.'),
    ('SP027', NULL, 'Loai02', N'Cinnamon Roll', NULL, '35000', 1, '/images/cake/cinnamon-roll.png', N'Bánh cuốn vị quế thơm ngon, giòn rụm, hấp dẫn.'),
    ('SP028', NULL, 'Loai02', N'Cookies', NULL, '25000', 1, '/images/cake/cookies.png', N'Bánh quy bơ ngọt ngào, giòn tan, thích hợp cho mọi dịp.'),
    ('SP029', NULL, 'Loai02', N'Danish Custard', NULL, '38000', 1, '/images/cake/danish-custard.png', N'Bánh danish custard thơm ngon, mềm mịn, vị custard béo ngậy.'),
    ('SP030', NULL, 'Loai02', N'Donut Sô-cô-la', NULL, '20000', 1, '/images/cake/donut-socola.png', N'Donut sô cô la thơm ngon, giòn rụm, vị sô cô la đặc trưng.'),
    ('SP031', NULL, 'Loai02', N'Fruit Tart', NULL, '42000', 1, '/images/cake/fruit-tart.png', N'Bánh tart trái cây tươi mát, bắt mắt, ngon miệng.'),
    ('SP032', NULL, 'Loai02', N'Lemon Tart', NULL, '38000', 1, '/images/cake/lemon-tart.png', N'Bánh tart chanh thơm mát, chua dễ chịu, hòa quyện với vị ngọt.'),
    ('SP033', NULL, 'Loai02', N'Macaroons', NULL, '35000', 1, '/images/cake/macaroons.png', N'Bánh macaroons thơm ngon, mềm mịn, hấp dẫn.'),
    ('SP034', NULL, 'Loai02', N'Muffin Vani', NULL, '30000', 1, '/images/cake/muffin-vani.png', N'Muffin vani thơm ngon, giòn rụm, đầy đặn vị vani.'),
    ('SP035', NULL, 'Loai02', N'Panacotta', NULL, '35000', 1, '/images/cake/panacotta.png', N'Bánh panacotta mềm mịn, thơm ngon, phủ lớp sốt trái cây tươi.'),
    ('SP036', NULL, 'Loai02', N'Red Velvet', NULL, '45000', 1, '/images/cake/red-velvet.png', N'Bánh red velvet mềm mịn, đậm đà vị cacao, kết hợp với kem cheese cream.'),
    ('SP037', NULL, 'Loai02', N'Sô-cô-la', NULL, '25000', 1, '/images/cake/socola.png', N'Bánh sô cô la thơm ngon, đậm đà, hấp dẫn.'),
    ('SP038', NULL, 'Loai02', N'Tiramisu', NULL, '42000', 1, '/images/cake/tiramisu.png', N'Bánh tiramisu thơm ngon, đậm đà vị cà phê và sô cô la, bên trên phủ lớp bột cacao.'),
    ('SP039', NULL, 'Loai02', N'Bánh Gato Đậu Đỏ', NULL, '32000', 1, '/images/cake/gato-dau-do.png', N'Bánh gato đậu đỏ thơm ngon, mềm mịn, ngọt dịu từ đậu đỏ.'),
    ('SP040', NULL, 'Loai02', N'Bánh Kem Dừa', NULL, '28000', 1, '/images/cake/kem-dua.png', N'Bánh kem dừa thơm ngon, mềm mịn, vị dừa tự nhiên.'),
    ('SP041', NULL, 'Loai02', N'Bánh Su Kem Phô Mai', NULL, '35000', 1, '/images/cake/su-kem-pho-mai.png', N'Bánh su kem phô mai thơm ngon, mềm mịn, vị phô mai đặc trưng.'),
    ('SP042', NULL, 'Loai02', N'Bánh Tart Nho', NULL, '38000', 1, '/images/cake/tart-nho.png', N'Bánh tart nho thơm ngon, mềm mịn, vị chua dễ chịu của nho.'),
    ('SP043', NULL, 'Loai02', N'Bánh Tart Xoài', NULL, '42000', 1, '/images/cake/tart-xoai.png', N'Bánh tart xoài thơm ngon, mềm mịn, vị chua dễ chịu của xoài.'),
    ('SP044', NULL, 'Loai02', N'Bánh Tart Đào', NULL, '38000', 1, '/images/cake/tart-dao.png', N'Bánh tart đào thơm ngon, mềm mịn, vị ngọt dịu của đào.');

go
--chèn sp khác
INSERT INTO SanPham (MaSanPham, KhuyenMai, LoaiSanPham, TenSanPham, KichThuoc, Gia, TrangThai, HinhAnh, MoTa)
VALUES 
    ('SP045S', NULL, 'Loai03', N'Nước Ép Cà Chua', 'S', '25000', 1, '/images/khac/nuoc-ep-ca-chua.png', N'Nước ép cà chua tươi mát, giàu vitamin và chất dinh dưỡng.'),
    ('SP045M', NULL, 'Loai03', N'Nước Ép Cà Chua', 'M', '30000', 1, '/images/khac/nuoc-ep-ca-chua.png', N'Nước ép cà chua tươi mát, giàu vitamin và chất dinh dưỡng.'),
    ('SP045L', NULL, 'Loai03', N'Nước Ép Cà Chua', 'L', '35000', 1, '/images/khac/nuoc-ep-ca-chua.png', N'Nước ép cà chua tươi mát, giàu vitamin và chất dinh dưỡng.'),
    
    ('SP046S', NULL, 'Loai03', N'Nước Ép Cam', 'S', '28000', 1, '/images/khac/nuoc-ep-cam.png', N'Nước ép cam tươi nguyên chất, giàu vitamin C, giúp tăng cường sức khỏe.'),
    ('SP046M', NULL, 'Loai03', N'Nước Ép Cam', 'M', '33000', 1, '/images/khac/nuoc-ep-cam.png', N'Nước ép cam tươi nguyên chất, giàu vitamin C, giúp tăng cường sức khỏe.'),
    ('SP046L', NULL, 'Loai03', N'Nước Ép Cam', 'L', '38000', 1, '/images/khac/nuoc-ep-cam.png', N'Nước ép cam tươi nguyên chất, giàu vitamin C, giúp tăng cường sức khỏe.'),
    
    ('SP047S', NULL, 'Loai03', N'Nước Ép Cà Rốt', 'S', '26000', 1, '/images/khac/nuoc-ep-ca-rot.png', N'Nước ép cà rốt tươi mát, giàu vitamin A, giúp tăng cường thị lực.'),
    ('SP047M', NULL, 'Loai03', N'Nước Ép Cà Rốt', 'M', '31000', 1, '/images/khac/nuoc-ep-ca-rot.png', N'Nước ép cà rốt tươi mát, giàu vitamin A, giúp tăng cường thị lực.'),
    ('SP047L', NULL, 'Loai03', N'Nước Ép Cà Rốt', 'L', '36000', 1, '/images/khac/nuoc-ep-ca-rot.png', N'Nước ép cà rốt tươi mát, giàu vitamin A, giúp tăng cường thị lực.'),
    
    ('SP048S', NULL, 'Loai03', N'Nước ép dứa', 'S', '30000', 1, '/images/khac/nuoc-ep-dua.png', N'Nước ép dứa tươi mát, giàu khoáng chất và electrolytes, giúp cung cấp năng lượng.'),
    ('SP048M', NULL, 'Loai03', N'Nước ép dứa', 'M', '35000', 1, '/images/khac/nuoc-ep-dua.png', N'Nước ép dứa tươi mát, giàu khoáng chất và electrolytes, giúp cung cấp năng lượng.'),
    ('SP048L', NULL, 'Loai03', N'Nước ép dứa', 'L', '40000', 1, '/images/khac/nuoc-ep-dua.png', N'Nước ép dứa tươi mát, giàu khoáng chất và electrolytes, giúp cung cấp năng lượng.'),
    
    ('SP049S', NULL, 'Loai03', N'Nước Ép dưa hấu', 'S', '32000', 1, '/images/khac/nuoc-ep-dua-hau.png', N'Nước ép dưa hấu tươi mát, giàu vitamin và chất chống oxy hóa, giúp cải thiện làn da.'),
    ('SP049M', NULL, 'Loai03', N'Nước Ép dưa hấu', 'M', '37000', 1, '/images/khac/nuoc-ep-dua-hau.png', N'Nước ép dưa hấu tươi mát, giàu vitamin và chất chống oxy hóa, giúp cải thiện làn da.'),
    ('SP049L', NULL, 'Loai03', N'Nước Ép dưa hấu', 'L', '42000', 1, '/images/khac/nuoc-ep-dua-hau.png', N'Nước ép dưa hấu tươi mát, giàu vitamin và chất chống oxy hóa, giúp cải thiện làn da.'),
    
    ('SP050S', NULL, 'Loai03', N'Nước Ép dưa lưới', 'S', '32000', 1, '/images/khac/nuoc-ep-dua-luoi.png', N'Nước ép dưa lưới tươi mát, giàu vitamin và khoáng chất, giúp tăng cường hệ miễn dịch.'),
    ('SP050M', NULL, 'Loai03', N'Nước Ép dưa lưới', 'M', '37000', 1, '/images/khac/nuoc-ep-dua-luoi.png', N'Nước ép dưa lưới tươi mát, giàu vitamin và khoáng chất, giúp tăng cường hệ miễn dịch.'),
    ('SP050L', NULL, 'Loai03', N'Nước Ép dưa lưới', 'L', '42000', 1, '/images/khac/nuoc-ep-dua-luoi.png', N'Nước ép dưa lưới tươi mát, giàu vitamin và khoáng chất, giúp tăng cường hệ miễn dịch.'),
    
    ('SP051S', NULL, 'Loai03', N'Nước Ép Nho', 'S', '27000', 1, '/images/khac/nuoc-ep-nho.png', N'Nước ép nho tươi mát, giàu chất chống oxy hóa và polyphenol, giúp bảo vệ tim mạch.'),
    ('SP051M', NULL, 'Loai03', N'Nước Ép Nho', 'M', '32000', 1, '/images/khac/nuoc-ep-nho.png', N'Nước ép nho tươi mát, giàu chất chống oxy hóa và polyphenol, giúp bảo vệ tim mạch.'),
    ('SP051L', NULL, 'Loai03', N'Nước Ép Nho', 'L', '37000', 1, '/images/khac/nuoc-ep-nho.png', N'Nước ép nho tươi mát, giàu chất chống oxy hóa và polyphenol, giúp bảo vệ tim mạch.'),
    
    ('SP052S', NULL, 'Loai03', N'Nước Ép Táo', 'S', '26000', 1, '/images/khac/nuoc-ep-tao.png', N'Nước ép táo tươi mát, giàu vitamin và chất xơ, giúp cải thiện hệ tiêu hóa.'),
    ('SP052M', NULL, 'Loai03', N'Nước Ép Táo', 'M', '31000', 1, '/images/khac/nuoc-ep-tao.png', N'Nước ép táo tươi mát, giàu vitamin và chất xơ, giúp cải thiện hệ tiêu hóa.'),
    ('SP052L', NULL, 'Loai03', N'Nước Ép Táo', 'L', '36000', 1, '/images/khac/nuoc-ep-tao.png', N'Nước ép táo tươi mát, giàu vitamin và chất xơ, giúp cải thiện hệ tiêu hóa.'),
    
    ('SP053S', NULL, 'Loai03', N'Nước Ép Vải Thiều', 'S', '28000', 1, '/images/khac/nuoc-ep-vai-thieu.png', N'Nước ép vải thiều tươi mát, giàu vitamin và khoáng chất, giúp tăng cường sức khỏe xương.'),
    ('SP053M', NULL, 'Loai03', N'Nước Ép Vải Thiều', 'M', '33000', 1, '/images/khac/nuoc-ep-vai-thieu.png', N'Nước ép vải thiều tươi mát, giàu vitamin và khoáng chất, giúp tăng cường sức khỏe xương.'),
    ('SP053L', NULL, 'Loai03', N'Nước Ép Vải Thiều', 'L', '38000', 1, '/images/khac/nuoc-ep-vai-thieu.png', N'Nước ép vải thiều tươi mát, giàu vitamin và khoáng chất, giúp tăng cường sức khỏe xương.'),
    
    ('SP054S', NULL, 'Loai03', N'Soda Chanh', 'S', '20000', 1, '/images/khac/soda-chanh.png', N'Soda chanh mát lạnh, ngọt dịu, là một lựa chọn tuyệt vời để giải khát trong ngày nóng.'),
    ('SP054M', NULL, 'Loai03', N'Soda Chanh', 'M', '25000', 1, '/images/khac/soda-chanh.png', N'Soda chanh mát lạnh, ngọt dịu, là một lựa chọn tuyệt vời để giải khát trong ngày nóng.'),
    ('SP054L', NULL, 'Loai03', N'Soda Chanh', 'L', '30000', 1, '/images/khac/soda-chanh.png', N'Soda chanh mát lạnh, ngọt dịu, là một lựa chọn tuyệt vời để giải khát trong ngày nóng.'),

	 ('SP055S', NULL, 'Loai03', N'Soda Chanh Đường', 'S', '22000', 1, '/images/khac/soda-chanh-duong.png', N'Soda chanh vị ngọt dịu, thơm mát, là sự kết hợp hoàn hảo giữa vị chua của chanh và ngọt của đường.'),
    ('SP055M', NULL, 'Loai03', N'Soda Chanh Đường', 'M', '27000', 1, '/images/khac/soda-chanh-duong.png', N'Soda chanh vị ngọt dịu, thơm mát, là sự kết hợp hoàn hảo giữa vị chua của chanh và ngọt của đường.'),
    ('SP055L', NULL, 'Loai03', N'Soda Chanh Đường', 'L', '32000', 1, '/images/khac/soda-chanh-duong.png', N'Soda chanh vị ngọt dịu, thơm mát, là sự kết hợp hoàn hảo giữa vị chua của chanh và ngọt của đường.'),
    
    ('SP056S', NULL, 'Loai03', N'Soda Chanh Sả', 'S', '22000', 1, '/images/khac/soda-chanh-sa.png', N'Soda chanh vị chua dễ chịu, thêm chút vị ngọt của đường và hương thơm đặc trưng của sả.'),
    ('SP056M', NULL, 'Loai03', N'Soda Chanh Sả', 'M', '27000', 1, '/images/khac/soda-chanh-sa.png', N'Soda chanh vị chua dễ chịu, thêm chút vị ngọt của đường và hương thơm đặc trưng của sả.'),
    ('SP056L', NULL, 'Loai03', N'Soda Chanh Sả', 'L', '32000', 1, '/images/khac/soda-chanh-sa.png', N'Soda chanh vị chua dễ chịu, thêm chút vị ngọt của đường và hương thơm đặc trưng của sả.'),
    
    ('SP057S', NULL, 'Loai03', N'Soda Thơm Tắc', 'S', '23000', 1, '/images/khac/soda-thom-tac.png', N'Soda thơm tắc ngọt dịu, thơm phức, là lựa chọn thú vị cho một ngày nóng bức.'),
    ('SP057M', NULL, 'Loai03', N'Soda Thơm Tắc', 'M', '28000', 1, '/images/khac/soda-thom-tac.png', N'Soda thơm tắc ngọt dịu, thơm phức, là lựa chọn thú vị cho một ngày nóng bức.'),
    ('SP057L', NULL, 'Loai03', N'Soda Thơm Tắc', 'L', '33000', 1, '/images/khac/soda-thom-tac.png', N'Soda thơm tắc ngọt dịu, thơm phức, là lựa chọn thú vị cho một ngày nóng bức.'),
    
    ('SP058S', NULL, 'Loai03', N'Soda Vải Hạt Chia', 'S', '24000', 1, '/images/khac/soda-vai-hat-chia.png', N'Soda vải vị dễ chịu, thêm hạt chia giúp cung cấp chất xơ và đạm, tốt cho hệ tiêu hóa.'),
    ('SP058M', NULL, 'Loai03', N'Soda Vải Hạt Chia', 'M', '29000', 1, '/images/khac/soda-vai-hat-chia.png', N'Soda vải vị dễ chịu, thêm hạt chia giúp cung cấp chất xơ và đạm, tốt cho hệ tiêu hóa.'),
    ('SP058L', NULL, 'Loai03', N'Soda Vải Hạt Chia', 'L', '34000', 1, '/images/khac/soda-vai-hat-chia.png', N'Soda vải vị dễ chịu, thêm hạt chia giúp cung cấp chất xơ và đạm, tốt cho hệ tiêu hóa.'),
    
    ('SP059S', NULL, 'Loai03', N'Soda Vải Ổi', 'S', '24000', 1, '/images/khac/soda-vai-oi.png', N'Soda vải vị chua dễ chịu, thêm hương thơm của ổi, là lựa chọn lý tưởng cho một ngày hè nóng bức.'),
    ('SP059M', NULL, 'Loai03', N'Soda Vải Ổi', 'M', '29000', 1, '/images/khac/soda-vai-oi.png', N'Soda vải vị chua dễ chịu, thêm hương thơm của ổi, là lựa chọn lý tưởng cho một ngày hè nóng bức.'),
    ('SP059L', NULL, 'Loai03', N'Soda Vải Ổi', 'L', '34000', 1, '/images/khac/soda-vai-oi.png', N'Soda vải vị chua dễ chịu, thêm hương thơm của ổi, là lựa chọn lý tưởng cho một ngày hè nóng bức.'),
    
    ('SP060S', NULL, 'Loai03', N'Soda Việt Quất', 'S', '25000', 1, '/images/khac/soda-viet-quat.png', N'Soda việt quất vị chua ngọt, giàu vitamin và chất chống oxy hóa, tốt cho sức khỏe tim mạch.'),
    ('SP060M', NULL, 'Loai03', N'Soda Việt Quất', 'M', '30000', 1, '/images/khac/soda-viet-quat.png', N'Soda việt quất vị chua ngọt, giàu vitamin và chất chống oxy hóa, tốt cho sức khỏe tim mạch.'),
    ('SP060L', NULL, 'Loai03', N'Soda Việt Quất', 'L', '35000', 1, '/images/khac/soda-viet-quat.png', N'Soda việt quất vị chua ngọt, giàu vitamin và chất chống oxy hóa, tốt cho sức khỏe tim mạch.'),
    
    ('SP061S', NULL, 'Loai03', N'Trà Gừng', 'S', '25000', 1, '/images/khac/tra-gung.png', N'Trà gừng nóng hoặc lạnh, hương vị cay nồng của gừng kết hợp với vị ngọt dịu, giúp cải thiện tuần hoàn máu và hệ tiêu hóa.'),
    ('SP061M', NULL, 'Loai03', N'Trà Gừng', 'M', '30000', 1, '/images/khac/tra-gung.png', N'Trà gừng nóng hoặc lạnh, hương vị cay nồng của gừng kết hợp với vị ngọt dịu, giúp cải thiện tuần hoàn máu và hệ tiêu hóa.'),
    ('SP061L', NULL, 'Loai03', N'Trà Gừng', 'L', '35000', 1, '/images/khac/tra-gung.png', N'Trà gừng nóng hoặc lạnh, hương vị cay nồng của gừng kết hợp với vị ngọt dịu, giúp cải thiện tuần hoàn máu và hệ tiêu hóa.'),
    
    ('SP062S', NULL, 'Loai03', N'Trà Sữa Chân Trâu', 'S', '28000', 1, '/images/khac/tra-sua-chan-trau.png', N'Trà sữa chân trâu thơm ngon, mềm mịn, kết hợp cùng sữa đặc và trân châu, tạo nên một đồ uống đầy hấp dẫn.'),
    ('SP062M', NULL, 'Loai03', N'Trà Sữa Chân Trâu', 'M', '33000', 1, '/images/khac/tra-sua-chan-trau.png', N'Trà sữa chân trâu thơm ngon, mềm mịn, kết hợp cùng sữa đặc và trân châu, tạo nên một đồ uống đầy hấp dẫn.'),
    ('SP062L', NULL, 'Loai03', N'Trà Sữa Chân Trâu', 'L', '38000', 1, '/images/khac/tra-sua-chan-trau.png', N'Trà sữa chân trâu thơm ngon, mềm mịn, kết hợp cùng sữa đặc và trân châu, tạo nên một đồ uống đầy hấp dẫn.'),
    
    ('SP063S', NULL, 'Loai03', N'Trà Sữa Trân Châu Đen', 'S', '28000', 1, '/images/khac/tra-sua-tran-chau-den.png', N'Trà sữa thơm ngon, mềm mịn, kết hợp cùng trân châu đen, tạo nên hương vị độc đáo và hấp dẫn.'),
    ('SP063M', NULL, 'Loai03', N'Trà Sữa Trân Châu Đen', 'M', '33000', 1, '/images/khac/tra-sua-tran-chau-den.png', N'Trà sữa thơm ngon, mềm mịn, kết hợp cùng trân châu đen, tạo nên hương vị độc đáo và hấp dẫn.'),
    ('SP063L', NULL, 'Loai03', N'Trà Sữa Trân Châu Đen', 'L', '38000', 1, '/images/khac/tra-sua-tran-chau-den.png', N'Trà sữa thơm ngon, mềm mịn, kết hợp cùng trân châu đen, tạo nên hương vị độc đáo và hấp dẫn.'),
    
    ('SP064S', NULL, 'Loai03', N'Trà Thảo Mộc', 'S', '26000', 1, '/images/khac/tra-thao-moc.png', N'Trà thảo mộc tự nhiên, không chất bảo quản, giúp thư giãn tinh thần và cải thiện sức khỏe tổng thể.'),
    ('SP064M', NULL, 'Loai03', N'Trà Thảo Mộc', 'M', '31000', 1, '/images/khac/tra-thao-moc.png', N'Trà thảo mộc tự nhiên, không chất bảo quản, giúp thư giãn tinh thần và cải thiện sức khỏe tổng thể.'),
    ('SP064L', NULL, 'Loai03', N'Trà Thảo Mộc', 'L', '36000', 1, '/images/khac/tra-thao-moc.png', N'Trà thảo mộc tự nhiên, không chất bảo quản, giúp thư giãn tinh thần và cải thiện sức khỏe tổng thể.'),
    
    ('SP065S', NULL, 'Loai03', N'Trà Chanh', 'S', '25000', 1, '/images/khac/tra-chanh.png', N'Trà chanh thơm mát, vị chua dễ chịu, là một lựa chọn tuyệt vời cho mùa hè nóng bức.'),
    ('SP065M', NULL, 'Loai03', N'Trà Chanh', 'M', '30000', 1, '/images/khac/tra-chanh.png', N'Trà chanh thơm mát, vị chua dễ chịu, là một lựa chọn tuyệt vời cho mùa hè nóng bức.'),
    ('SP065L', NULL, 'Loai03', N'Trà Chanh', 'L', '35000', 1, '/images/khac/tra-chanh.png', N'Trà chanh thơm mát, vị chua dễ chịu, là một lựa chọn tuyệt vời cho mùa hè nóng bức.');

	go
--chèn hóa đơn
INSERT INTO HoaDon (MaHoaDon, NhanVien, Ban, KhachHang, NgayTao, PhuongThucThanhToan, TrangThaiThanhToan, GhiChu) 
VALUES
	('HD0427001','NV001',1,'KH001','2024-04-27 07:01:33','CASH',1,N''),
	('HD0427002','NV001',2,'KH002','2024-04-27 07:31:02','BANK_TRANSFER',1,N''),
	('HD0427003','NV001',3,'KH003','2024-04-27 08:41:10','CASH',1,N''),
	('HD0427004','NV001',3,'KH004','2024-04-27 10:20:51','CASH',1,N''),
	('HD0427005','NV003',3,'KH005','2024-04-27 14:41:04','CASH',1,N''),
	('HD0427006','NV003',3,'KH006','2024-04-27 15:01:42','BANK_TRANSFER',1,N''),
	('HD0427007','NV003',3,'KH007','2024-04-27 15:33:04','CASH',1,N''),
	('HD0427008','NV003',3,'KH003','2024-04-27 16:22:43','BANK_TRANSFER',1,N''),
	('HD0427009','NV004',3,'KH008','2024-04-27 16:41:22','CASH',1,N''),
	('HD0427010','NV004',3,'KH009','2024-04-27 17:41:55','CASH',1,N''),
	('HD0427011','NV003',3,'KH010','2024-04-27 21:01:59','BANK_TRANSFER',1,N'');
go

--chen bang chi tiet hoa don
INSERT INTO ChiTietHoaDon (SoLuong, SanPham, HoaDon) 
VALUES 
    (2, 'SP001S', 'HD0427001'),
    (1, 'SP002S', 'HD0427001'),
    (3, 'SP003M', 'HD0427002'),
    (1, 'SP004M', 'HD0427002'),
    (2, 'SP005L', 'HD0427003');
go


