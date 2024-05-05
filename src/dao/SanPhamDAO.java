package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import connectDB.connectDB;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.KichThuoc;
import entity.LoaiSanPham;
import entity.SanPham;

public class SanPhamDAO implements InterfaceDAO<SanPham>{
	public static SanPhamDAO getInstance() {
		return new SanPhamDAO();
	}
    @Override
 // Phương thức để chèn sản phẩm vào cơ sở dữ liệu và trả về số dòng đã thêm

    public int insert(SanPham sanPham) {
        int rowsInserted = 0;
        PreparedStatement preparedStatement = null;
        
        try {
            String sql = "INSERT INTO SanPham (MaSanPham, KhuyenMai, LoaiSanPham, TenSanPham, KichThuoc, Gia, TrangThai, HinhAnh, MoTa) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conn = connectDB.getConnectDB();
            
            // Lấy loại sản phẩm và mã khuyến mãi từ đối tượng SanPham
            LoaiSanPham loaiSanPham = sanPham.getLoaiSanPham();
            String maLoaiSanPham = loaiSanPham.getMaLoai();
            String maKhuyenMai = sanPham.getKhuyenMai().getMaKhuyenMai();
            
            // Tạo câu lệnh SQL dựa trên loại sản phẩm
            if (maLoaiSanPham.equals("Loai01") || maLoaiSanPham.equals("Loai03")) {
                // Xử lý cho sản phẩm có kích thước (Loai01, Loai03)
                for (KichThuoc kichThuoc : KichThuoc.values()) {
                    if (kichThuoc != KichThuoc.D) {
                        String maSanPhamWithSize = sanPham.getMaSanPham() + kichThuoc.toString();
                        preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, maSanPhamWithSize);
                        preparedStatement.setString(2, maKhuyenMai);
                        preparedStatement.setString(3, maLoaiSanPham);
                        preparedStatement.setString(4, sanPham.getTenSanPham());
                        preparedStatement.setString(5, kichThuoc.toString());
                        preparedStatement.setDouble(6, sanPham.getGiaByKichThuoc(kichThuoc));
                        preparedStatement.setBoolean(7, sanPham.isTrangThai());
                        preparedStatement.setString(8, sanPham.getHinhAnh());
                        preparedStatement.setString(9, sanPham.getMoTa());
                        rowsInserted += preparedStatement.executeUpdate();
                    }
                }
            } else if (maLoaiSanPham.equals("Loai02")) {
                // Xử lý cho sản phẩm không có kích thước (Loai02)
            	for (KichThuoc kichThuoc : KichThuoc.values()) {
                    if (kichThuoc == KichThuoc.D) {
                        String maSanPhamWithSize = sanPham.getMaSanPham() + kichThuoc.toString();
                        preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, maSanPhamWithSize);
                        preparedStatement.setString(2, maKhuyenMai);
                        preparedStatement.setString(3, maLoaiSanPham);
                        preparedStatement.setString(4, sanPham.getTenSanPham());
                        preparedStatement.setNull(5, java.sql.Types.VARCHAR);
                        preparedStatement.setDouble(6, sanPham.getGiaByKichThuoc(kichThuoc));
                        preparedStatement.setBoolean(7, sanPham.isTrangThai());
                        preparedStatement.setString(8, sanPham.getHinhAnh());
                        preparedStatement.setString(9, sanPham.getMoTa());
                        rowsInserted += preparedStatement.executeUpdate();
                    }
                }
                
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

//    public static void main(String[] args) {
//    	try (Connection connection = connectDB.getConnectDB()) {
//    		KhuyenMai khuyenMai = new KhuyenMai("KM001", "KhuyenMai1", "MoTa1", LocalDateTime.now(), LocalDateTime.now().plusDays(7), 10.0, true);;
//            // Tạo một đối tượng SanPham mới
//    		LoaiSanPham loaiSanPham = new LoaiSanPham("Loai01","Loai 1", null);
//    		SanPham sanPham = new SanPham("SP1000S", "TenSanPham1", true, loaiSanPham, "HinhAnh1", "MoTa1", khuyenMai);
//            sanPham.themKichThuocGia(KichThuoc.S, 100.0);
//            sanPham.themKichThuocGia(KichThuoc.M, 150.0);
//            sanPham.themKichThuocGia(KichThuoc.L, 200.0);
//
//            // Tạo một đối tượng SanPhamDAO
//            SanPhamDAO sanPhamDAO = new SanPhamDAO();
//
//            // Thêm sản phẩm vào cơ sở dữ liệu
//            int rowsInserted = sanPhamDAO.insert(sanPham);
//
//            // Kiểm tra xem sản phẩm đã được thêm thành công hay không
//            if (rowsInserted > 0) {
//                System.out.println("Sản phẩm đã được thêm thành công vào cơ sở dữ liệu.");
//            } else {
//                System.out.println("Thêm sản phẩm vào cơ sở dữ liệu không thành công.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    
//	}
    @Override
    public int update(SanPham sanPham) {
        int rowsUpdated = 0;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "UPDATE SanPham SET TenSanPham = ?, TrangThai = ?, HinhAnh = ?, MoTa = ? WHERE MaSanPham = ?";
            Connection conn = connectDB.getConnectDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, sanPham.getTenSanPham());
            preparedStatement.setBoolean(2, sanPham.isTrangThai());
            preparedStatement.setString(3, sanPham.getHinhAnh());
            preparedStatement.setString(4, sanPham.getMoTa());
            preparedStatement.setString(5, sanPham.getMaSanPham());
            rowsUpdated = preparedStatement.executeUpdate();
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
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM SanPham";
            Connection conn = connectDB.getConnectDB();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maSanPham = resultSet.getString("MaSanPham");
                String tenSanPham = resultSet.getString("TenSanPham");
                boolean trangThai = resultSet.getBoolean("TrangThai");
                String hinhAnh = resultSet.getString("HinhAnh");
                String moTa = resultSet.getString("MoTa");
                
                
                String maLoai = resultSet.getString("LoaiSanPham");
             // Lấy thông tin đối tượng LoaiSanPham từ cơ sở dữ liệu
                LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
                LoaiSanPham loaiSanPham = loaiSanPhamDAO.selectById(maLoai);
                
                String maKhuyenMai = resultSet.getString("KhuyenMai");
                // Lấy thông tin đối tượng LoaiSanPham từ cơ sở dữ liệu
                   KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
                   KhuyenMai khuyenMai= khuyenMaiDAO.selectById(maKhuyenMai);
                
                // Tạo đối tượng SanPham từ dữ liệu trong ResultSet và thêm vào danh sách
                SanPham sanPham = new SanPham(maSanPham, tenSanPham, trangThai,loaiSanPham, hinhAnh, moTa,khuyenMai);
                
                
                danhSachSanPham.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return danhSachSanPham;
    }

    @Override
    public SanPham selectById(String id) {
        SanPham sanPham = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM SanPham WHERE MaSanPham = ?";
            Connection conn = connectDB.getConnectDB();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String maSanPham = resultSet.getString("MaSanPham");
                String tenSanPham = resultSet.getString("TenSanPham");
                boolean trangThai = resultSet.getBoolean("TrangThai");
                String hinhAnh = resultSet.getString("HinhAnh");
                String moTa = resultSet.getString("MoTa");


                String maLoai = resultSet.getString("LoaiSanPham");
             // Lấy thông tin đối tượng LoaiSanPham từ cơ sở dữ liệu
                LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
                LoaiSanPham loaiSanPham = loaiSanPhamDAO.selectById(maLoai);
                
                String maKhuyenMai = resultSet.getString("KhuyenMai");
                // Lấy thông tin đối tượng LoaiSanPham từ cơ sở dữ liệu
                   KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
                   KhuyenMai khuyenMai= khuyenMaiDAO.selectById(maKhuyenMai);
                
                // Tạo đối tượng SanPham từ dữ liệu trong ResultSet và thêm vào danh sách
                sanPham = new SanPham(maSanPham, tenSanPham, trangThai,loaiSanPham, hinhAnh, moTa,khuyenMai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return sanPham;
    }


}
