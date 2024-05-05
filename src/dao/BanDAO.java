package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.Ban;

public class BanDAO implements InterfaceDAO<Ban> {

    public static BanDAO getInstance() {
        return new BanDAO();
    }

    @Override
    public int insert(Ban ban) {
        int rowsInserted = 0;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "INSERT INTO Ban (MaBan, SoGhe, TinhTrang) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ban.getMaBan());
            preparedStatement.setInt(2, ban.getSoGhe());
            preparedStatement.setBoolean(3, ban.isTinhTrang());
            rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    @Override
    public int update(Ban ban) {
        int rowsUpdated = 0;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "UPDATE Ban SET SoGhe = ?, TinhTrang = ? WHERE MaBan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ban.getSoGhe());
            preparedStatement.setBoolean(2, ban.isTinhTrang());
            preparedStatement.setString(3, ban.getMaBan());
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    @Override
    public ArrayList<Ban> selectAll() {
        ArrayList<Ban> danhSachBan = new ArrayList<>();
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM Ban";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maBan = resultSet.getString("MaBan");
                int soGhe = resultSet.getInt("SoGhe");
                boolean tinhTrang = resultSet.getBoolean("TinhTrang");

                Ban ban = new Ban(maBan, soGhe, tinhTrang);
                danhSachBan.add(ban);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachBan;
    }

    @Override
    public Ban selectById(String id) {
        Ban ban = null;
        try (Connection connection = connectDB.getConnectDB()) {
            String sql = "SELECT * FROM Ban WHERE MaBan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String maBan = resultSet.getString("MaBan");
                int soGhe = resultSet.getInt("SoGhe");
                boolean tinhTrang = resultSet.getBoolean("TinhTrang");

                ban = new Ban(maBan, soGhe, tinhTrang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ban;
    }
}
