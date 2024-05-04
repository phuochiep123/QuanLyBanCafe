package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.connectDB;

public class LoaiSanPham  implements InterfaceDAO<LoaiSanPham>{
	
	public LoaiSanPham(String maLoaiSanPham, String tenLoaiSanPham) {
		// TODO Auto-generated constructor stub
	}

	public static LoaiSanPham getInstance() {
		return new LoaiSanPham(null, null);
	}

	@Override
	public int insert(LoaiSanPham t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "INSERT INTO LoaiSanPham (MaLoaiSanPham, TenLoaiSanPham) VALUES (?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaLoaiSanPham());
			pst.setString(2, t.getMaLoaiSanPham());
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

	private String getMaLoaiSanPham() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(LoaiSanPham t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "UPDATE LoaiSanPham SET TenLoaiSanPham=? WHERE MaLoaiSanPham=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaLoaiSanPham());
			pst.setString(2, t.getMaLoaiSanPham());
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
	public ArrayList<LoaiSanPham> selectAll() {
		ArrayList<LoaiSanPham> kq = new ArrayList<LoaiSanPham>();
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "SELECT * FROM LoaiSanPham";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maLoaiSanPham = rs.getString("MaLoaiSanPham");
				String tenLoaiSanPham = rs.getString("TenLoaiSanPham");
				LoaiSanPham lsp = new LoaiSanPham(maLoaiSanPham, tenLoaiSanPham);
				kq.add(lsp);
				
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
	public LoaiSanPham selectById(String id) {
		LoaiSanPham lsp = null;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "SELECT * FROM LoaiSanPham WHERE MaLoaiSanPham=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maLoaiSanPham = rs.getString("MaLoaiSanPham");
				String tenLoaiSanPham = rs.getString("TenLoaiSanPham");
				lsp = new LoaiSanPham(maLoaiSanPham, tenLoaiSanPham);
			}
			// Thực thi câu lệnh
			pst.executeQuery();
			// Đóng kết nối
			connectDB.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		return lsp;
	}
	

}
