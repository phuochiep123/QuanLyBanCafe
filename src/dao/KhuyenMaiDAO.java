package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.KhuyenMai;
import entity.LoaiSanPham;
import entity.TaiKhoan;

public class KhuyenMaiDAO implements InterfaceDAO<KhuyenMai> {
	public static KhuyenMaiDAO getInstance() {
		return new KhuyenMaiDAO();
	}
	@Override
	public int insert(KhuyenMai t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, MoTa, NgayBatDau, NgayKetThuc, PhanTramGiamGia, TrangThai) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			pst.setString(1, t.getMaKhuyenMai());
			pst.setString(2, t.getTenKhuyenMai());
			pst.setString(3, t.getMoTa());
			pst.setString(4, t.getNgayBatDau().format(fm));
			pst.setString(5, t.getNgayKetThuc().format(fm));
			pst.setDouble(6, t.getPhanTramGiamGia());
			pst.setString(7, t.isTrangThai()? "1":"0");
			//Thực thi câu lệnh
			kq = pst.executeUpdate();
			//Đóng kết nối
			connectDB.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(KhuyenMai t) {
		int kq = 0;
		try {
			Connection con = connectDB.getConnectDB();
			String sql = "UPDATE KhuyenMai SET MaKhuyenMai = ?, TenKhuyenMai = ?, MoTa = ?, NgayBatDau = ?, NgayKetThuc = ?, PhanTranGiamGia = ?, TrangThai = ? WHERE MaKhuyenMai=?";
			PreparedStatement pst = con.prepareStatement(sql);
			DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			pst.setString(1, t.getMaKhuyenMai());
			pst.setString(1, t.getTenKhuyenMai());
			pst.setString(1, t.getMoTa());
			pst.setString(1, t.getNgayBatDau().format(fm));
			pst.setString(1, t.getNgayKetThuc().format(fm));
			pst.setDouble(1, t.getPhanTramGiamGia());
			pst.setString(1, t.isTrangThai()?"1":"0");
			//Thực thi
			kq = pst.executeUpdate();
			//Đóng kết nối
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<KhuyenMai> selectAll() {
		ArrayList<KhuyenMai> kq = new ArrayList<KhuyenMai>();
		try {
			Connection con = connectDB.getConnectDB();
			String sql = "SELECT * FROM KhuyenMai";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			while (rs.next()) {
				String maKM = rs.getString("MaKhuyenMai");
				String tenKM = rs.getString("TenKhuyenMai");
				String moTa = rs.getString("MoTa");
				LocalDateTime ngayBD = LocalDateTime.parse(rs.getString("NgayBatDau"), fm);
	            LocalDateTime ngayKT = LocalDateTime.parse(rs.getString("NgayKetThuc"), fm);
				Double phanTram = rs.getDouble("PhanTramGiamGia");
				Boolean trangThai = rs.getString("TrangThai")=="1"?true:false;
				KhuyenMai tk = new KhuyenMai(maKM, tenKM, moTa, ngayBD, ngayKT, phanTram, false);
				kq.add(tk);
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public KhuyenMai selectById(String id) {
		KhuyenMai tk = null;
		try {
			Connection con = connectDB.getConnectDB();
			String sql = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			while (rs.next()) {
				String maKM = rs.getString("MaKhuyenMai");
				String tenKM = rs.getString("TenKhuyenMai");
				String moTa = rs.getString("MoTa");
				LocalDateTime ngayBD = LocalDateTime.parse(rs.getString("NgayBatDau"), fm);
	            LocalDateTime ngayKT = LocalDateTime.parse(rs.getString("NgayKetThuc"), fm);
				Double phanTram = rs.getDouble("PhanTramGiamGia");
				Boolean trangThai = rs.getString("TrangThai")=="1"?true:false;
				tk = new KhuyenMai(maKM, tenKM, moTa, ngayBD, ngayKT, phanTram, false);
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}
}
