package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDateTime ngayTao;
	private boolean trangThaiThanhToan;
	private String ghiChu;
	private PhuongThucThanhToan phuongThucThanhToan;
	
	private KhachHang khachHang;
	private Ban ban;
	private ArrayList<ChiTietHoaDon> dsCTHD;

	public HoaDon(String maHoaDon, LocalDateTime ngayTao, boolean trangThaiThanhToan, String ghiChu, Ban ban, PhuongThucThanhToan phuongThucThanhToan, KhachHang khachHang) {
		this.maHoaDon = maHoaDon;
		this.ngayTao = ngayTao;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.ghiChu = ghiChu;
		this.ban = ban;
		this.khachHang = khachHang;
		this.dsCTHD = new ArrayList<ChiTietHoaDon>();
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDateTime getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDateTime ngayTao) {
		this.ngayTao = ngayTao;
	}

	public boolean isTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public ArrayList<ChiTietHoaDon> getDsCTHD() {
		return dsCTHD;
	}

	public void setDsCTHD(ArrayList<ChiTietHoaDon> dsCTHD) {
		this.dsCTHD = dsCTHD;
	}
	
	//Thêm CTHD
	public void addChiTietHoaDon(ChiTietHoaDon cthd) {
        dsCTHD.add(cthd);
    }
	//Xoá CTHD
    public void removeChiTietHoaDon(ChiTietHoaDon cthd) {
        dsCTHD.remove(cthd); 
    }
	
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayTao=" + ngayTao + ", trangThaiThanhToan=" + trangThaiThanhToan
				+ ", ghiChu=" + ghiChu + ", dsCTHD=" + dsCTHD + "]";
	}
	
	
}
