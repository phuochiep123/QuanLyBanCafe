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
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private Ban ban;
	private ArrayList<ChiTietHoaDon> dsCTHD;

	public HoaDon(String maHoaDon,NhanVien nhanVien, LocalDateTime ngayTao, boolean trangThaiThanhToan, String ghiChu, Ban ban, PhuongThucThanhToan phuongThucThanhToan, KhachHang khachHang) {
		this.maHoaDon = maHoaDon;
		this.ngayTao = ngayTao;
		this.trangThaiThanhToan = trangThaiThanhToan;
		this.ghiChu = ghiChu;
		this.ban = ban;
		this.nhanVien= nhanVien;
		this.khachHang = khachHang;
		this.dsCTHD = new ArrayList<ChiTietHoaDon>();
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	//Setter và getter
	public String getMaHoaDon() {
		return maHoaDon;
	}

	public PhuongThucThanhToan getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public Ban getBan() {
		return ban;
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
	public boolean addChiTietHoaDon(ChiTietHoaDon cthd) {
        return dsCTHD.add(cthd);
    }
	//Xoá CTHD
    public boolean removeChiTietHoaDon(ChiTietHoaDon cthd) {
        return dsCTHD.remove(cthd); 
    }
	public double tinhTongThue() {
		return dsCTHD.stream()
				.mapToDouble(cthd -> cthd.tinhVAT())
				.sum();
	}
	public int getSoLuongSanPham() {
		return dsCTHD.size();
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
