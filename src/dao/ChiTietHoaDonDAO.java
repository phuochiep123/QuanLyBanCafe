package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class ChiTietHoaDonDAO implements InterfaceDAO<HoaDon> {

	@Override
	public int insert(HoaDon hoaDon) {
	    int rowsInserted = 0;
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        // Câu lệnh SQL chèn dữ liệu vào bảng ChiTietHoaDon
	        String sql = "INSERT INTO ChiTietHoaDon (SoLuong, SanPham, HoaDon) VALUES (?, ?, ?)";
	        Connection conn = connectDB.getConnectDB();
	        preparedStatement = conn.prepareStatement(sql);
	        
	        for (ChiTietHoaDon chiTiet : hoaDon.getDsCTHD()) {
	        	preparedStatement.setInt(1, chiTiet.getSoLuong());
		        preparedStatement.setString(2, chiTiet.getSanPham().getMaSanPham());
		        preparedStatement.setString(3, hoaDon.getMaHoaDon());
		        rowsInserted += preparedStatement.executeUpdate();
	        }
	       
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng PreparedStatement
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
	public int update(HoaDon hoaDon) {
	    int rowsUpdated = 0;
	    PreparedStatement preparedStatement = null;
	    
	    try {
	        // Câu lệnh SQL cập nhật số lượng trong bảng ChiTietHoaDon
	        String sql = "UPDATE ChiTietHoaDon SET SoLuong = ? WHERE SanPham = ? AND HoaDon = ?";
	        Connection conn = connectDB.getConnectDB();
	        preparedStatement = conn.prepareStatement(sql);
	        
	        for (ChiTietHoaDon chiTiet : hoaDon.getDsCTHD()) {
	            preparedStatement.setInt(1, chiTiet.getSoLuong());
	            preparedStatement.setString(2, chiTiet.getSanPham().getMaSanPham());
	            preparedStatement.setString(3, hoaDon.getMaHoaDon());
	            rowsUpdated += preparedStatement.executeUpdate(); // Sử dụng +=
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng PreparedStatement
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
	public ArrayList<HoaDon> selectAll() {
	    ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        // Câu lệnh SQL để lấy toàn bộ chi tiết hóa đơn từ bảng ChiTietHoaDon
	        String sql = "SELECT * FROM ChiTietHoaDon";
	        Connection conn = connectDB.getConnectDB();
	        preparedStatement = conn.prepareStatement(sql);
	        resultSet = preparedStatement.executeQuery();

	        // Duyệt qua kết quả trả về và tạo danh sách các chi tiết hóa đơn
	        while (resultSet.next()) {
	            String maHoaDon = resultSet.getString("HoaDon");
	            int soLuong = resultSet.getInt("SoLuong");
	            String maSanPham = resultSet.getString("SanPham");

	            // Tạo một chi tiết hóa đơn từ dữ liệu trong ResultSet và thêm vào danh sách
	            HoaDon hoaDon = getHoaDonById(maHoaDon); // Lấy thông tin hóa đơn từ id
	            
	            SanPham sanPham = getSanPhamById(maSanPham); // Lấy thông tin sản phẩm từ id
	            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(sanPham, soLuong);
	            hoaDon.addChiTietHoaDon(chiTietHoaDon); // Thêm chi tiết hóa đơn vào danh sách của hóa đơn
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng ResultSet và PreparedStatement
	        if (resultSet != null) {
	            try {
	                resultSet.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (preparedStatement != null) {
	            try {
	                preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return danhSachHoaDon;
	}

	@Override
	public HoaDon selectById(String id) {
	    HoaDon hoaDon = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        // Câu lệnh SQL để lấy chi tiết hóa đơn dựa trên id của hóa đơn
	        String sql = "SELECT * FROM ChiTietHoaDon WHERE HoaDon = ?";
	        Connection conn = connectDB.getConnectDB();
	        preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setString(1, id);
	        resultSet = preparedStatement.executeQuery();

	        // Tạo một đối tượng hóa đơn từ dữ liệu trong ResultSet
	        hoaDon = getHoaDonById(id); // Lấy thông tin hóa đơn từ id
	        while (resultSet.next()) {
	            int soLuong = resultSet.getInt("SoLuong");
	            String maSanPham = resultSet.getString("SanPham");

	            // Tạo một chi tiết hóa đơn từ dữ liệu trong ResultSet và thêm vào hóa đơn
	            SanPham sanPham = getSanPhamById(maSanPham); // Lấy thông tin sản phẩm từ id
	            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(sanPham, soLuong);
	            hoaDon.addChiTietHoaDon(chiTietHoaDon); // Thêm chi tiết hóa đơn vào danh sách của hóa đơn
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng ResultSet và PreparedStatement
	        if (resultSet != null) {
	            try {
	                resultSet.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (preparedStatement != null) {
	            try {
	                preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return hoaDon;
	}

	

}
