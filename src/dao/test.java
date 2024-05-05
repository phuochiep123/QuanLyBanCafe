package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import connectDB.connectDB;
import entity.Ban;
import entity.CaLam;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.KichThuoc;
import entity.LoaiSanPham;
import entity.NhanVien;
import entity.PhuongThucThanhToan;
import entity.SanPham;
import entity.TaiKhoan;

public class test {
  public static void main(String[] args) {
	try (Connection connection = connectDB.getConnectDB()) {
		KhuyenMai khuyenMai = new KhuyenMai("KM000", "KhuyenMai 0", "MoTa1", LocalDateTime.now(), LocalDateTime.now().plusDays(7), 10.0, true);;
        
//		// Tạo một đối tượng KhuyenMaiDAO
//        KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        int rowsInsertedKM = khuyenMaiDAO.insert(khuyenMai);
//
//        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//        if (rowsInsertedKM > 0) {
//            System.out.println("KM đã được thêm thành công vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Thêm KM vào cơ sở dữ liệu không thành công.");
//        }
//		
		Ban ban = new Ban("100", 4, true);
//		// Tạo một đối tượng BanDAO
//        BanDAO BanDAO = new BanDAO();
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        int rowsInsertedBan = BanDAO.insert(ban);
//
//        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//        if (rowsInsertedBan > 0) {
//            System.out.println("Ban đã được thêm thành công vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Thêm Ban vào cơ sở dữ liệu không thành công.");
//        }
		KhachHang khachHang = new KhachHang("KH000","TranCongTinh",true,"0326829327",LocalDateTime.now());
		// Tạo một đối tượng KhachHangDAO
//        KhachHangDAO KhachHangDAO = new KhachHangDAO();
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        int rowsInsertedKhachHang = KhachHangDAO.insert(khachHang);
//
//        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//        if (rowsInsertedKhachHang > 0) {
//            System.out.println("KhachHang đã được thêm thành công vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Thêm KhachHang vào cơ sở dữ liệu không thành công.");
//        }
		
		// Tạo một đối tượng SanPham mới
		
		CaLam caLam = new CaLam("Ca00", "ca 0", LocalTime.now(), LocalTime.now(), 20000);
//		
//		// Tạo một đối tượng CaLamDAO
//        CaLamDAO CaLamDAO = new CaLamDAO();
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        int rowsInsertedCaLam = CaLamDAO.insert(caLam);
//
//        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//        if (rowsInsertedCaLam > 0) {
//            System.out.println("CaLam đã được thêm thành công vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Thêm CaLam vào cơ sở dữ liệu không thành công.");
//        }
//		
		TaiKhoan taiKhoan = new TaiKhoan("TK000","tinh04", "admin", true );
		
//		// Tạo một đối tượng TaiKhoanDAO
//        TaiKhoanDAO TaiKhoanDAO = new TaiKhoanDAO();
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        int rowsInsertedTaiKhoan = TaiKhoanDAO.insert(taiKhoan);
//
//        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//        if (rowsInsertedTaiKhoan > 0) {
//            System.out.println("TaiKhoan đã được thêm thành công vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Thêm TaiKhoan vào cơ sở dữ liệu không thành công.");
//        }
		
		NhanVien nhanVien = new NhanVien("NV000", taiKhoan,"NGuyen van a" , true, "000099234", LocalDate.now(), true, LocalDate.now(), "dia chi", "khu vuc", "email", true, "anh");
//		// Tạo một đối tượng NhanVienDAO
//        NhanVienDAO NhanVienDAO = new NhanVienDAO();
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        int rowsInsertedNhanVien = NhanVienDAO.insert(nhanVien);
//
//        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//        if (rowsInsertedNhanVien > 0) {
//            System.out.println("NhanVien đã được thêm thành công vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Thêm NhanVien vào cơ sở dữ liệu không thành công.");
//        }
		// Tạo một đối tượng Hóa đơn
		HoaDon hoaDon = new HoaDon(
		    "HD000",            // Mã hóa đơn
		    nhanVien,           // Đối tượng Nhân viên
		    LocalDateTime.now(),            // Ngày tạo
		    true, // Trạng thái thanh toán (đã thanh toán hoặc chưa thanh toán)
		    "ghiChu",             // Ghi chú
		    ban,                // Đối tượng Bàn
		    PhuongThucThanhToan.BANK_TRANSFER,// Phương thức thanh toán
		    khachHang           // Đối tượng Khách hàng
		);
		// Tạo một đối tượng HoaDonDAO
        HoaDonDAO HoaDonDAO = new HoaDonDAO();

        // Thêm sản phẩm vào cơ sở dữ liệu
        int rowsInsertedHoaDon = HoaDonDAO.insert(hoaDon);

        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
        if (rowsInsertedHoaDon > 0) {
            System.out.println("HoaDon đã được thêm thành công vào cơ sở dữ liệu.");
        } else {
            System.out.println("Thêm HoaDon vào cơ sở dữ liệu không thành công.");
        }
		

		
		LoaiSanPham loaiSanPham = new LoaiSanPham("Loai01","Loai 1", null);
		SanPham sanPham = new SanPham("SP1000", "TenSanPham1", true, loaiSanPham, "HinhAnh1", "MoTa1", khuyenMai);
        sanPham.themKichThuocGia(KichThuoc.S, 100.0);
        sanPham.themKichThuocGia(KichThuoc.M, 150.0);
        sanPham.themKichThuocGia(KichThuoc.L, 200.0);

//        // Tạo một đối tượng SanPhamDAO
//        SanPhamDAO sanPhamDAO = new SanPhamDAO();
//
//        // Thêm sản phẩm vào cơ sở dữ liệu
//        int rowsInserted = sanPhamDAO.insert(sanPham);
//
//        // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//        if (rowsInserted > 0) {
//            System.out.println("Sản phẩm đã được thêm thành công vào cơ sở dữ liệu.");
//        } else {
//            System.out.println("Thêm sản phẩm vào cơ sở dữ liệu không thành công.");
//        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}
