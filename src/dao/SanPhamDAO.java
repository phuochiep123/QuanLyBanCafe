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
            // Lấy loại sản phẩm
            LoaiSanPham loaiSanPham = sanPham.getLoaiSanPham();

            // Tạo câu lệnh SQL dựa trên loại sản phẩm
            String sql = "INSERT INTO SanPham (MaSanPham, KhuyenMai, LoaiSanPham, TenSanPham, KichThuoc, Gia, TrangThai, HinhAnh, MoTa) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Tạo mã sản phẩm dựa trên loại sản phẩm
            String maSanPham = sanPham.getMaSanPham();
            Connection conn = connectDB.getConnectDB();
            if (loaiSanPham.getMaLoai().equals("Loai01") || loaiSanPham.getMaLoai().equals("Loai03")) {
            	
                for (KichThuoc kichThuoc : KichThuoc.values()) {
                	
                   if(kichThuoc!=kichThuoc.D) {
                	   String maSanPhamWithSize = maSanPham + kichThuoc.toString();
                       
                       preparedStatement = conn.prepareStatement(sql);
                       preparedStatement.setString(1, maSanPhamWithSize);
                       preparedStatement.setString(2, sanPham.getKhuyenMai().getMaKhuyenMai().toString());
                       preparedStatement.setString(3, loaiSanPham.getMaLoai().toString());
                       preparedStatement.setString(4, sanPham.getTenSanPham());
                       preparedStatement.setString(5, kichThuoc.toString());
                       preparedStatement.setDouble(6, sanPham.getGiaByKichThuoc(kichThuoc));
                       preparedStatement.setBoolean(7, sanPham.isTrangThai());
                       preparedStatement.setString(8, sanPham.getHinhAnh());
                       preparedStatement.setString(9, sanPham.getMoTa());
                       rowsInserted += preparedStatement.executeUpdate();
                   }
                }
            } else if (loaiSanPham.equals("Loai2")) {
                // Không có kích thước cho sản phẩm Loai2
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, maSanPham);
                preparedStatement.setString(2, sanPham.getKhuyenMai().toString());
                preparedStatement.setString(3, loaiSanPham.getMaLoai().toString());
                preparedStatement.setString(4, sanPham.getTenSanPham());
//                preparedStatement.setString(5, kichThuoc.toString());
//                preparedStatement.setDouble(6, sanPham.getGiaByKichThuoc(kichThuoc));
                preparedStatement.setBoolean(7, sanPham.isTrangThai());
                preparedStatement.setString(8, sanPham.getHinhAnh());
                preparedStatement.setString(9, sanPham.getMoTa());
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
    public int update(SanPham sanPham) {
        int kq = 0;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "UPDATE SanPham SET TenSanPham=?, TrangThai=?, MaLoai=?, HinhAnh=?, MoTa=?, MaKhuyenMai=? WHERE MaSanPham=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sanPham.getTenSanPham());
            pst.setBoolean(2, sanPham.isTrangThai());
            pst.setString(3, sanPham.getLoaiSanPham().getMaLoai());
            pst.setString(4, sanPham.getHinhAnh());
            pst.setString(5, sanPham.getMoTa());
            pst.setString(6, sanPham.getKhuyenMai().getMaKhuyenMai());
            pst.setString(7, sanPham.getMaSanPham());
            kq = pst.executeUpdate();
            connectDB.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
//
//    @Override
//    public ArrayList<SanPham> selectAll() {
//        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
//        try {
//            Connection conn = connectDB.getConnectDB();
//            String sql = "SELECT * FROM SanPham";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                String maSanPham = rs.getString("MaSanPham");
//                String tenSanPham = rs.getString("TenSanPham");
//                boolean trangThai = rs.getBoolean("TrangThai");
//                String maLoai = rs.getString("MaLoai");
//                String hinhAnh = rs.getString("HinhAnh");
//                String moTa = rs.getString("MoTa");
//                String maKhuyenMai = rs.getString("MaKhuyenMai");
//                // Lấy thông tin loại sản phẩm từ cơ sở dữ liệu
//                LoaiSanPham loaiSanPham = getLoaiSanPhamById(maLoai);
//                // Lấy thông tin khuyến mãi từ cơ sở dữ liệu
//                KhuyenMai khuyenMai = getKhuyenMaiById(maKhuyenMai);
//                SanPham sanPham = new SanPham(maSanPham, tenSanPham, trangThai, loaiSanPham, hinhAnh, moTa, khuyenMai);
//                danhSachSanPham.add(sanPham);
//            }
//            connectDB.closeConnection(conn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return danhSachSanPham;
//    }
//
//    @Override
//    public SanPham selectById(String maSanPham) {
//        SanPham sanPham = null;
//        try {
//            Connection conn = connectDB.getConnectDB();
//            String sql = "SELECT * FROM SanPham WHERE MaSanPham=?";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, maSanPham);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                String tenSanPham = rs.getString("TenSanPham");
//                boolean trangThai = rs.getBoolean("TrangThai");
//                String maLoai = rs.getString("MaLoai");
//                String hinhAnh = rs.getString("HinhAnh");
//                String moTa = rs.getString("MoTa");
//                String maKhuyenMai = rs.getString("MaKhuyenMai");
//                // Lấy thông tin loại sản phẩm từ cơ sở dữ liệu
//                LoaiSanPham loaiSanPham = getLoaiSanPhamById(maLoai);
//                // Lấy thông tin khuyến mãi từ cơ sở dữ liệu
//                KhuyenMai khuyenMai = getKhuyenMaiById(maKhuyenMai);
//                sanPham = new SanPham(maSanPham, tenSanPham, trangThai, loaiSanPham, hinhAnh, moTa, khuyenMai);
//            }
//            connectDB.closeConnection(conn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sanPham;
//    }

    // Phương thức này sẽ truy vấn cơ sở dữ liệu để lấy thông tin loại sản phẩm bằng mã loại
//    private LoaiSanPham getLoaiSanPhamById(String maLoai) {
//        LoaiSanPham loaiSanPham = null;
//        try {
//            Connection conn = connectDB.getConnectDB();
//            String sql = "SELECT * FROM LoaiSanPham WHERE MaLoai=?";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, maLoai);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                String tenLoai = rs.getString("TenLoai");
//                loaiSanPham = new LoaiSanPham(maLoai, tenLoai);
//            }
//            connectDB.closeConnection(conn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return loaiSanPham;
//    }
    public static void main(String[] args) {
    	try (Connection connection = connectDB.getConnectDB()) {
    		KhuyenMai khuyenMai = new KhuyenMai("KM001", "KhuyenMai1", "MoTa1", LocalDateTime.now(), LocalDateTime.now().plusDays(7), 10.0, true);;
            // Tạo một đối tượng SanPham mới
    		LoaiSanPham loaiSanPham = new LoaiSanPham("Loai01","Loai 1", null);
    		SanPham sanPham = new SanPham("SP1000S", "TenSanPham1", true, loaiSanPham, "HinhAnh1", "MoTa1", khuyenMai);
            sanPham.themKichThuocGia(KichThuoc.S, 100.0);
            sanPham.themKichThuocGia(KichThuoc.M, 150.0);
            sanPham.themKichThuocGia(KichThuoc.L, 200.0);

            // Tạo một đối tượng SanPhamDAO
            SanPhamDAO sanPhamDAO = new SanPhamDAO();

            // Thêm sản phẩm vào cơ sở dữ liệu
            int rowsInserted = sanPhamDAO.insert(sanPham);

            // Kiểm tra xem sản phẩm đã được thêm thành công hay không
            if (rowsInserted > 0) {
                System.out.println("Sản phẩm đã được thêm thành công vào cơ sở dữ liệu.");
            } else {
                System.out.println("Thêm sản phẩm vào cơ sở dữ liệu không thành công.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
	}

    // Phương thức này sẽ truy vấn cơ sở dữ liệu để lấy thông tin khuyến mãi bằng mã khuyến mãi
    private KhuyenMai getKhuyenMaiById(String maKhuyenMai) {
        KhuyenMai khuyenMai = null;
        try {
            Connection conn = connectDB.getConnectDB();
            String sql = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maKhuyenMai);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // Lấy thông tin khuyến mãi từ cơ sở dữ liệu
                // Code lấy thông tin khuyến mãi
            }
            connectDB.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khuyenMai;
    }
	@Override
	public ArrayList<SanPham> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SanPham selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
