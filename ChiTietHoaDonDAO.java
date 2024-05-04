package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.ChiTietHoaDon;

public class ChiTietHoaDonDAO implements InterfaceDAO<ChiTietHoaDon> {

	public static ChiTietHoaDonDAO getInstance() {
		return new ChiTietHoaDonDAO();
	}
	@Override
	public int insert(ChiTietHoaDon t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "INSERT INTO ChiTietHoaDon (MaHoaDon, MaSanPham, SoLuong, DonGia) VALUES (?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaHoaDon());
			pst.setString(2, t.getMaSanPham());
			pst.setInt(3, t.getSoLuong());
			pst.setDouble(4, t.getDonGia());
			//Thực thi câu lệnh
			kq = pst.executeUpdate();
			//Đóng kết nối
			connectDB.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
            }
		return kq;
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public int update(ChiTietHoaDon t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "UPDATE ChiTietHoaDon SET SoLuong=?, DonGia=? WHERE MaHoaDon=? AND MaSanPham=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, t.getSoLuong());
			pst.setDouble(2, t.getDonGia());
			pst.setString(3, t.getMaHoaDon());
			pst.setString(4, t.getMaSanPham());
			// Thực thi câu lệnh
			kq = pst.executeUpdate();
			// Đóng kết nối
			connectDB.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return kq;
	}

	@Override
	public ArrayList<ChiTietHoaDon> selectAll() {
		ArrayList<ChiTietHoaDon> kq = new ArrayList<ChiTietHoaDon>();
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "SELECT * FROM ChiTietHoaDon";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString("MaHoaDon");
				String maSanPham = rs.getString("MaSanPham");
				int soLuong = rs.getInt("SoLuong");
				double donGia = rs.getDouble("DonGia");
				ChiTietHoaDon cthd = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, donGia);
				
				kq.add(cthd);
				
				
			}
			// Thực thi câu lệnh
			pst.executeQuery();
			// Đóng kết nối
			connectDB.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return kq;
	}

	@Override
	public ChiTietHoaDon selectById(String id) {
		ChiTietHoaDon cthd = null;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHoaDon=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maHoaDon = rs.getString("MaHoaDon");
				String maSanPham = rs.getString("MaSanPham");
				int soLuong = rs.getInt("SoLuong");
				double donGia = rs.getDouble("DonGia");
				cthd = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, donGia);
			}
			// Thực thi câu lệnh
			pst.executeQuery();
			// Đóng kết nối
			connectDB.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return cthd;
	}

}
