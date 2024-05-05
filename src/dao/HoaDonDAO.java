package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.Ban;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDonDAO implements InterfaceDAO<HoaDon>{
    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }

    @Override
    public int insert(HoaDon hoaDon) {
        int rowsInserted = 0;
        
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "INSERT INTO HoaDon (MaHoaDon, NhanVien, Ban, KhachHang, NgayTao, PhuongThucThanhToan, TrangThaiThanhToan, GhiChu) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hoaDon.getMaHoaDon());
            preparedStatement.setString(2, hoaDon.getNhanVien().getMaNhanVien());
            preparedStatement.setString(3, hoaDon.getBan().getMaBan());
            preparedStatement.setString(4, hoaDon.getKhachHang().getMaKhachHang());
            preparedStatement.setObject(5, hoaDon.getNgayTao());
         // Sử dụng toán tử ba ngôi để xác định giá trị chuỗi PhuongThucThanhToan
            String phuongThuc = hoaDon.isTrangThaiThanhToan() ? "Trực tiếp" : "Chuyển khoản";
            // Set giá trị chuỗi vào preparedStatement
            preparedStatement.setString(6, phuongThuc);
            preparedStatement.setBoolean(7, hoaDon.isTrangThaiThanhToan());
            preparedStatement.setString(8, hoaDon.getGhiChu());
            rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    @Override
    public int update(HoaDon hoaDon) {
        int rowsUpdated = 0;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "UPDATE HoaDon SET NhanVien=?, Ban=?, KhachHang=?, NgayTao=?, PhuongThucThanhToan=?, TrangThaiThanhToan=?, GhiChu=? WHERE MaHoaDon=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hoaDon.getNhanVien().getMaNhanVien());
            preparedStatement.setString(2, hoaDon.getBan().getMaBan());
            preparedStatement.setString(3, hoaDon.getKhachHang().getMaKhachHang());
            preparedStatement.setObject(4, hoaDon.getNgayTao());
            // Sử dụng toán tử ba ngôi để xác định giá trị chuỗi PhuongThucThanhToan
            String phuongThuc = hoaDon.isTrangThaiThanhToan() ? "Trực tiếp" : "Chuyển khoản";
            // Set giá trị chuỗi vào preparedStatement
            preparedStatement.setString(6, phuongThuc);
            preparedStatement.setBoolean(6, hoaDon.isTrangThaiThanhToan());
            preparedStatement.setString(7, hoaDon.getGhiChu());
            preparedStatement.setString(8, hoaDon.getMaHoaDon());
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    @Override
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maHoaDon = resultSet.getString("MaHoaDon");
                String maNhanVien = resultSet.getString("NhanVien");
                // Lấy thông tin đối tượng Nhân viên từ cơ sở dữ liệu
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                NhanVien nhanVien = nhanVienDAO.selectById(maNhanVien);

                int maBan = resultSet.getInt("Ban");
                // Lấy thông tin đối tượng Bàn từ cơ sở dữ liệu
                BanDAO banDAO = new BanDAO();
                String strMaBan = String.valueOf(maBan); 
                Ban ban = banDAO.selectById(strMaBan);

                String maKhachHang = resultSet.getString("KhachHang");
                // Lấy thông tin đối tượng Khách hàng từ cơ sở dữ liệu
                KhachHangDAO khachHangDAO = new KhachHangDAO();
                KhachHang khachHang = khachHangDAO.selectById(maKhachHang);

                // Hoàn thiện các thông tin còn lại của đối tượng HoaDon từ ResultSet
                LocalDateTime ngayTao = resultSet.getTimestamp("NgayTao").toLocalDateTime();
                boolean trangThaiThanhToan = resultSet.getBoolean("TrangThaiThanhToan");
                String ghiChu = resultSet.getString("GhiChu");
                // Các thông tin còn lại của đối tượng HoaDon, chẳng hạn phương thức thanh toán và danh sách chi tiết hóa đơn, bạn cần lấy từ cơ sở dữ liệu hoặc gán giá trị mặc định

                // Khởi tạo đối tượng HoaDon và thêm vào danh sách
                HoaDon hoaDon = new HoaDon(maHoaDon, nhanVien, ngayTao, trangThaiThanhToan, ghiChu, ban, null, khachHang); // Đối số thứ hai và thứ ba của constructor chưa được hoàn thiện
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }


    @Override
    public HoaDon selectById(String id) {
        HoaDon hoaDon = null;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String maHoaDon = resultSet.getString("MaHoaDon");
                String maNhanVien = resultSet.getString("NhanVien");
                // Lấy thông tin đối tượng Nhân viên từ cơ sở dữ liệu
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                NhanVien nhanVien = nhanVienDAO.selectById(maNhanVien);

                String maBan = resultSet.getString("Ban");
                // Lấy thông tin đối tượng Bàn từ cơ sở dữ liệu
                BanDAO banDAO = new BanDAO();
                Ban ban = banDAO.selectById(maBan); 

                String maKhachHang = resultSet.getString("KhachHang");
                // Lấy thông tin đối tượng Khách hàng từ cơ sở dữ liệu
                KhachHangDAO khachHangDAO = new KhachHangDAO();
                KhachHang khachHang = khachHangDAO.selectById(maKhachHang);

                // Hoàn thiện các thông tin còn lại của đối tượng HoaDon từ ResultSet
                LocalDateTime ngayTao = resultSet.getTimestamp("NgayTao").toLocalDateTime();
                boolean trangThaiThanhToan = resultSet.getBoolean("TrangThaiThanhToan");
                String ghiChu = resultSet.getString("GhiChu");
                // Các thông tin còn lại của đối tượng HoaDon, chẳng hạn phương thức thanh toán và danh sách chi tiết hóa đơn, bạn cần lấy từ cơ sở dữ liệu hoặc gán giá trị mặc định

                // Khởi tạo đối tượng HoaDon
                hoaDon = new HoaDon(maHoaDon, nhanVien, ngayTao, trangThaiThanhToan, ghiChu, ban, null, khachHang); // Đối số thứ hai và thứ ba của constructor chưa được hoàn thiện
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDon;
    }


}
