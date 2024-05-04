package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.HoaDon;

public class HoaDonDAO implements InterfaceDAO<HoaDon> {
	
	public static HoaDonDAO getInstance() {
		return new HoaDonDAO();
	}

	@Override
	public int insert(HoaDon t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "INSERT INTO HoaDon (MaHoaDon, MaKhachHang, NgayLap, TongTien) VALUES (?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaHoaDon());
			pst.setString(2, t.getMaKhachHang());
			pst.setDate(3, t.getNgayTao());
			pst.setDouble(4, t.getTongTien());
			// Thực thi câu lệnh
			kq = pst.executeUpdate();
			// Đóng kết nối
			connectDB.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(HoaDon t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "UPDATE HoaDon SET MaKhachHang=?, NgayLap=?, TongTien=? WHERE MaHoaDon=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());
			pst.setDate(2, t.getNgayTao());
			pst.setDouble(3, t.getTongTien());
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
	public ArrayList<HoaDon> selectAll() {
		ArrayList<HoaDon> kq = new ArrayList<HoaDon>();
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "SELECT * FROM HoaDon";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				HoaDon hd = new HoaDon(sql, null, false, sql, null, null, null);
				hd.setMaHoaDon(rs.getString("MaHoaDon"));
				hd.setMaKhachHang(rs.getString("MaKhachHang"));
				hd.setNgayTao(rs.getDate("NgayLap"));
				hd.setTongTien(rs.getDouble("TongTien"));
				kq.add(hd);
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
	public HoaDon selectById(String id) {
		HoaDon hd = null;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "SELECT * FROM HoaDon WHERE MaHoaDon=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				hd = new HoaDon(sql, null, false, sql, null, null, null);
				hd.setMaHoaDon(rs.getString("MaHoaDon"));
				hd.setMaKhachHang(rs.getString("MaKhachHang"));
				hd.setNgayTao(rs.getDate("NgayLap"));
				hd.setTongTien(rs.getDouble("TongTien"));
			}
			// Thực thi câu lệnh
			pst.executeQuery();
			// Đóng kết nối
			connectDB.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		return null;
	}
	

}
