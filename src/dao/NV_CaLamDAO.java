package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.CaLam;
import entity.NhanVien;
import entity.ThongTinCa;

public class NV_CaLamDAO implements InterfaceDAO<ThongTinCa> {

    @Override
    public int insert(ThongTinCa thongTinCa) {
        int rowsInserted = 0;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "INSERT INTO ThongTinCa ( MaCa, MaNhanVien, NgayLam, TongDoanhThu) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, thongTinCa.getCalam().getMaCa());
            preparedStatement.setString(2, thongTinCa.getNhanVien().getMaNhanVien());
            preparedStatement.setObject(3, thongTinCa.getNgayLam());
            preparedStatement.setDouble(4, thongTinCa.getDoanhThuCa());
            rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

//    @Override
//    public int update(ThongTinCa thongTinCa) {
//        int rowsUpdated = 0;
//        try (Connection connection = connectDB.getConnectDB()) {
//            String sql = "UPDATE ThongTinCa SET DoanhThuCa=? WHERE MaNhanVien=? AND MaCa=? AND NgayLam=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setDouble(1, thongTinCa.getDoanhThuCa());
//            preparedStatement.setString(2, thongTinCa.getCalam().getMaCa());
//            preparedStatement.setString(3, thongTinCa.getNhanVien().getMaNhanVien());
//            preparedStatement.setObject(4, thongTinCa.getNgayLam());
//            rowsUpdated = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rowsUpdated;
//    }

    @Override
    public ArrayList<ThongTinCa> selectAll() {
        ArrayList<ThongTinCa> danhSachThongTinCa = new ArrayList<>();
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM ThongTinCa";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maNhanVien = resultSet.getString("MaNhanVien");
                String maCa = resultSet.getString("MaCa");
                LocalDateTime ngayLam = resultSet.getTimestamp("NgayLam").toLocalDateTime();
                double doanhThuCa = resultSet.getDouble("DoanhThuCa");

                // Lấy thông tin đối tượng Nhân viên từ cơ sở dữ liệu
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                NhanVien nhanVien = nhanVienDAO.selectById(maNhanVien);

                // Lấy thông tin đối tượng Ca làm từ cơ sở dữ liệu
                CaLamDAO caLamDAO = new CaLamDAO();
                CaLam caLam = caLamDAO.selectById(maCa);

                // Khởi tạo đối tượng ThongTinCa và thêm vào danh sách
                ThongTinCa thongTinCa = new ThongTinCa(nhanVien, caLam, ngayLam);
               // thongTinCa.setDoanhThuCa(doanhThuCa);
                danhSachThongTinCa.add(thongTinCa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachThongTinCa;
    }

    @Override
    public ThongTinCa selectById(String id) {
        ThongTinCa thongTinCa = null;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM ThongTinCa WHERE MaNhanVien = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String maNhanVien = resultSet.getString("MaNhanVien");
                String maCa = resultSet.getString("MaCa");
                LocalDateTime ngayLam = resultSet.getTimestamp("NgayLam").toLocalDateTime();
                double doanhThuCa = resultSet.getDouble("DoanhThuCa");

                // Lấy thông tin đối tượng Nhân viên từ cơ sở dữ liệu
                NhanVienDAO nhanVienDAO = new NhanVienDAO();
                NhanVien nhanVien = nhanVienDAO.selectById(maNhanVien);

                // Lấy thông tin đối tượng Ca làm từ cơ sở dữ liệu
                CaLamDAO caLamDAO = new CaLamDAO();
                CaLam caLam = caLamDAO.selectById(maCa);

                // Khởi tạo đối tượng ThongTinCa
                thongTinCa = new ThongTinCa(nhanVien, caLam, ngayLam);
                //thongTinCa.setDoanhThuCa(doanhThuCa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongTinCa;
    }

	@Override
	public int update(ThongTinCa t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
