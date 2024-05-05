package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.connectDB;
import entity.TaiKhoan;

public class TaiKhoanDAO implements InterfaceDAO<TaiKhoan>{
	
	public static TaiKhoanDAO getInstance() {
		return new TaiKhoanDAO();
	}
	@Override
	public int insert(TaiKhoan t) {
		int kq = 0;
		try {
			Connection conn = connectDB.getConnectDB();
			String sql = "INSERT INTO TaiKhoan (MaTaiKhoan, TenTaiKhoan, MatKhau, LoaiTaiKhoan) VALUES (?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t.getMaTaiKhoan());
			pst.setString(2, t.getTenTaiKhoan());
			pst.setString(3, t.getMatKhau());
			pst.setString(4, t.isLoaiTaiKhoan()?"1":"0");
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
	public int update(TaiKhoan t) {
		int kq = 0;
		try {
			Connection con = connectDB.getConnectDB();
			String sql = "UPDATE TaiKhoan SET TenTaiKhoan=?, MatKhau=?, LoaiTaiKhoan=? WHERE MaTaiKhoan=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTenTaiKhoan());
			pst.setString(1, t.getMatKhau());
			pst.setString(1, t.isLoaiTaiKhoan()?"1":"0");
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
	public ArrayList<TaiKhoan> selectAll() {
		ArrayList<TaiKhoan> kq = new ArrayList<TaiKhoan>();
		try {
			Connection con = connectDB.getConnectDB();
			String sql = "SELECT * FROM TaiKhoan";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTK = rs.getString("MaTaiKhoan");
				String tenTaiKhoan = rs.getString("TenTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				Boolean loaiTK = rs.getString("LoaiTaiKhoan")=="1"?true:false;
				TaiKhoan tk = new TaiKhoan(maTK, tenTaiKhoan, matKhau, false);
				kq.add(tk);
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public TaiKhoan selectById(String id) {
		TaiKhoan tk = null;
		try {
			Connection con = connectDB.getConnectDB();
			String sql = "SELECT * FROM TaiKhoan WHERE MaTaiKhoan=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTK = rs.getString("MaTaiKhoan");
				String tenTaiKhoan = rs.getString("TenTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				Boolean loaiTK = rs.getString("LoaiTaiKhoan")=="1"?true:false;
				tk = new TaiKhoan(maTK, tenTaiKhoan, matKhau, false);
			}
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}
	//Câp nhật mật khẩu
	public int updatePassword(String maTK, String passNew){
		int kq = 0;
		try {
			Connection con = connectDB.getConnectDB();
			String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaTaiKhoan=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, passNew);
			pst.setString(2, maTK);
			
			kq = pst.executeUpdate();
			connectDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	//xóa theo id
	public int delete(String id) {
	    int kq = 0;
	    try {
	        Connection conn = connectDB.getConnectDB();
	        String sql = "DELETE FROM TaiKhoan WHERE MaTaiKhoan = ?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, id);
	        kq = pst.executeUpdate();
	        connectDB.closeConnection(conn);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return kq;
	}
}
