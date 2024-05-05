package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.connectDB;
import entity.KhachHang;

public class KhachHangDAO implements InterfaceDAO<KhachHang> {

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHang khachHang) {
        int rowsAffected = 0;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "INSERT INTO KhachHang (MaKhachHang, HoTen, GioiTinh, DienThoai, NgayThem) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khachHang.getMaKhachHang());
            preparedStatement.setString(2, khachHang.getHoTen());
            preparedStatement.setBoolean(3, khachHang.isGioiTinh());
            preparedStatement.setString(4, khachHang.getDienThoai());
            // Chuyển LocalDateTime thành java.sql.Timestamp để lưu vào cơ sở dữ liệu
            preparedStatement.setTimestamp(5, Timestamp.valueOf(khachHang.getNgayThem()));

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public int update(KhachHang khachHang) {
        int rowsAffected = 0;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "UPDATE KhachHang SET HoTen = ?, GioiTinh = ?, DienThoai = ?, NgayThem = ? WHERE MaKhachHang = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khachHang.getHoTen());
            preparedStatement.setBoolean(2, khachHang.isGioiTinh());
            preparedStatement.setString(3, khachHang.getDienThoai());
            // Chuyển LocalDateTime thành java.sql.Timestamp để lưu vào cơ sở dữ liệu
            preparedStatement.setTimestamp(5, Timestamp.valueOf(khachHang.getNgayThem()));
            preparedStatement.setString(5, khachHang.getMaKhachHang());

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }


    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> danhSachKhachHang = new ArrayList<>();
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maKhachHang = resultSet.getString("MaKhachHang");
                String hoTen = resultSet.getString("HoTen");
                boolean gioiTinh = resultSet.getBoolean("GioiTinh");
                String dienThoai = resultSet.getString("DienThoai");
                // Lấy ngày từ cơ sở dữ liệu và chuyển đổi thành LocalDateTime (cần phải xử lý phù hợp với cơ sở dữ liệu của bạn)
                LocalDateTime ngayThem = resultSet.getTimestamp("NgayThem").toLocalDateTime();

                KhachHang khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, dienThoai, ngayThem);
                danhSachKhachHang.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    @Override
    public KhachHang selectById(String maKhachHang) {
        KhachHang khachHang = null;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maKhachHang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hoTen = resultSet.getString("HoTen");
                boolean gioiTinh = resultSet.getBoolean("GioiTinh");
                String dienThoai = resultSet.getString("DienThoai");
                // Lấy ngày từ cơ sở dữ liệu và chuyển đổi thành LocalDateTime (cần phải xử lý phù hợp với cơ sở dữ liệu của bạn)
                LocalDateTime ngayThem = resultSet.getTimestamp("NgayThem").toLocalDateTime();

                khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, dienThoai, ngayThem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }
}
