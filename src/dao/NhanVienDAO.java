package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVienDAO  implements InterfaceDAO<NhanVien>{
	
	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	// Thêm một đối tượng Nhân viên vào cơ sở dữ liệu
    public int insert(NhanVien nhanVien) {
        int kq = 0;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "INSERT INTO NhanVien (MaNhanVien, MaTaiKhoan, HoTen, GioiTinh, Sdt, NgaySinh, ChucVu, NgayThem, DiaChi, KhuVuc, Email, TrangThai, HinhAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nhanVien.getMaNhanVien());
            pst.setString(2, nhanVien.getTaiKhoan().getMaTaiKhoan());
            pst.setString(3, nhanVien.getHoTen());
            pst.setString(4, nhanVien.getGioiTinh());
            pst.setString(5, nhanVien.getSdt());
            pst.setObject(6, nhanVien.getNgaySinh());
            pst.setBoolean(7, nhanVien.isChucVu());
            pst.setObject(8, nhanVien.getNgayThem());
            pst.setString(9, nhanVien.getDiaChi());
            pst.setString(10, nhanVien.getKhuVuc());
            pst.setString(11, nhanVien.getEmail());
            pst.setString(12, nhanVien.getTrangThai());
            pst.setString(13, nhanVien.getHinhAnh());

            kq = pst.executeUpdate();
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

	@Override
	// Cập nhật thông tin của một đối tượng Nhân viên trong cơ sở dữ liệu
    public int update(NhanVien nhanVien) {
        int kq = 0;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "UPDATE NhanVien SET MaTaiKhoan = ?, HoTen = ?, GioiTinh = ?, Sdt = ?, NgaySinh = ?, ChucVu = ?, NgayThem = ?, DiaChi = ?, KhuVuc = ?, Email = ?, TrangThai = ?, HinhAnh = ? WHERE MaNhanVien = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nhanVien.getTaiKhoan().getMaTaiKhoan());
            pst.setString(2, nhanVien.getHoTen());
            pst.setString(3, nhanVien.getGioiTinh());
            pst.setString(4, nhanVien.getSdt());
            pst.setObject(5, nhanVien.getNgaySinh());
            pst.setBoolean(6, nhanVien.isChucVu());
            pst.setObject(7, nhanVien.getNgayThem());
            pst.setString(8, nhanVien.getDiaChi());
            pst.setString(9, nhanVien.getKhuVuc());
            pst.setString(10, nhanVien.getEmail());
            pst.setString(11, nhanVien.getTrangThai());
            pst.setString(12, nhanVien.getHinhAnh());
            pst.setString(13, nhanVien.getMaNhanVien());

            kq = pst.executeUpdate();
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

	@Override
	public ArrayList<NhanVien>selectAll() {
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "SELECT * FROM NhanVien";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maNhanVien = rs.getString("MaNhanVien");
                String maTaiKhoan = rs.getString("MaTaiKhoan");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                LocalDate ngaySinh = rs.getObject("NgaySinh", LocalDate.class);
                boolean chucVu = rs.getBoolean("ChucVu");
                LocalDate ngayThem = rs.getObject("NgayThem", LocalDate.class);
                String diaChi = rs.getString("DiaChi");
                String khuVuc = rs.getString("KhuVuc");
                String email = rs.getString("Email");
                String trangThai = rs.getString("TrangThai");
                String hinhAnh = rs.getString("HinhAnh");

                // Lấy thông tin tài khoản từ cơ sở dữ liệu
                TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
                TaiKhoan taiKhoan = taiKhoanDAO.selectById(maTaiKhoan);

                // Tạo đối tượng Nhân viên và thêm vào danh sách
                NhanVien nhanVien = new NhanVien(maNhanVien, taiKhoan, hoTen, gioiTinh, sdt, ngaySinh, chucVu, ngayThem, diaChi, khuVuc, email, trangThai, hinhAnh);
                danhSachNhanVien.add(nhanVien);
            }
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNhanVien;
    }

	@Override
	public NhanVien selectById(String id) {
        NhanVien nhanVien = null;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String maNhanVien = rs.getString("MaNhanVien");
                String maTaiKhoan = rs.getString("MaTaiKhoan");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                String sdt = rs.getString("Sdt");
                LocalDate ngaySinh = rs.getObject("NgaySinh", LocalDate.class);
                boolean chucVu = rs.getBoolean("ChucVu");
                LocalDate ngayThem = rs.getObject("NgayThem", LocalDate.class);
                String diaChi = rs.getString("DiaChi");
                String khuVuc = rs.getString("KhuVuc");
                String email = rs.getString("Email");
                String trangThai = rs.getString("TrangThai");
                String hinhAnh = rs.getString("HinhAnh");

                // Lấy thông tin tài khoản từ cơ sở dữ liệu
                TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
                TaiKhoan taiKhoan = taiKhoanDAO.selectById(maTaiKhoan);

                // Tạo đối tượng Nhân viên
                nhanVien = new NhanVien(maNhanVien, taiKhoan, hoTen, gioiTinh, sdt, ngaySinh, chucVu, ngayThem, diaChi, khuVuc, email, trangThai, hinhAnh);
            }
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVien;
    }
	//xóa nv
	public int delete(String maNhanVien) {
	    int kq = 0;
	    try {
	        Connection conn = connectDB.getConnectDB();
	        String sql = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, maNhanVien);

	        kq = pst.executeUpdate();

	        // Gọi phương thức xóa tài khoản tương ứng
	        if (kq > 0) {
	            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
	            NhanVien nhanVien = selectById(maNhanVien); // Lấy thông tin nhân viên để xóa tài khoản
	            if (nhanVien != null) {
	                kq = taiKhoanDAO.delete(nhanVien.getTaiKhoan().getMaTaiKhoan());
	            }
	        }

	        connectDB.closeConnection(conn);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return kq;
	}


}
