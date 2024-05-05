package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.LoaiSanPham;

public class LoaiSanPhamDAO implements InterfaceDAO<LoaiSanPham> {
	public static LoaiSanPhamDAO getInstance() {
		return new LoaiSanPhamDAO();
	}
    @Override
    public int insert(LoaiSanPham loaiSanPham) {
        int rowsInserted = 0;
        PreparedStatement preparedStatement = null;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "INSERT INTO LoaiSanPham (MaLoai, TenLoai, MoTa) VALUES (?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, loaiSanPham.getMaLoai());
            preparedStatement.setString(2, loaiSanPham.getTenloai());
            preparedStatement.setString(3, loaiSanPham.getMoTa());
            rowsInserted += preparedStatement.executeUpdate();
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsInserted;
    }

    @Override
    public int update(LoaiSanPham loaiSanPham) {
        int rowsUpdated = 0;
        PreparedStatement preparedStatement = null;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "UPDATE LoaiSanPham SET TenLoai=?, MoTa=? WHERE MaLoai=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, loaiSanPham.getTenloai());
            preparedStatement.setString(2, loaiSanPham.getMoTa());
            preparedStatement.setString(3, loaiSanPham.getMaLoai());
            rowsUpdated += preparedStatement.executeUpdate();
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rowsUpdated;
    }

    @Override
    public ArrayList<LoaiSanPham> selectAll() {
        ArrayList<LoaiSanPham> danhSachLoaiSanPham = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "SELECT * FROM LoaiSanPham";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maLoai = resultSet.getString("MaLoai");
                String tenLoai = resultSet.getString("TenLoai");
                String moTa = resultSet.getString("MoTa");
                LoaiSanPham loaiSanPham = new LoaiSanPham(maLoai, tenLoai, moTa);
                danhSachLoaiSanPham.add(loaiSanPham);
            }
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return danhSachLoaiSanPham;
    }

    @Override
    public LoaiSanPham selectById(String id) {
        LoaiSanPham loaiSanPham = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "SELECT * FROM LoaiSanPham WHERE MaLoai=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String maLoai = resultSet.getString("MaLoai");
                String tenLoai = resultSet.getString("TenLoai");
                String moTa = resultSet.getString("MoTa");
                loaiSanPham = new LoaiSanPham(maLoai, tenLoai, moTa);
            }
            connectDB.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return loaiSanPham;
    }
}
