package Entity;

import java.time.LocalDateTime;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private String moTa;
	private LocalDateTime ngayBatDau;
	private LocalDateTime ngayKetThuc;
	private double phanTramGiamGia;
	private String trangThai;
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public LocalDateTime getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(LocalDateTime ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public LocalDateTime getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public double getPhanTramGiamGia() {
		return phanTramGiamGia;
	}
	public void setPhanTramGiamGia(double phanTramGiamGia) {
		this.phanTramGiamGia = phanTramGiamGia;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	public void apDungKhuyenMai() {
		
	}
	
	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String moTa, LocalDateTime ngayBatDau,
			LocalDateTime ngayKetThuc, double phanTramGiamGia, String trangThai) {
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.moTa = moTa;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.phanTramGiamGia = phanTramGiamGia;
		this.trangThai = trangThai;
	}
	public KhuyenMai(String maKhuyenMai) {
		super();
		this.maKhuyenMai = maKhuyenMai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhuyenMai == null) ? 0 : maKhuyenMai.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		if (maKhuyenMai == null) {
			if (other.maKhuyenMai != null)
				return false;
		} else if (!maKhuyenMai.equals(other.maKhuyenMai))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KhuyenMai [maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", moTa=" + moTa
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", phanTramGiamGia=" + phanTramGiamGia
				+ ", trangThai=" + trangThai + "]";
	}
	
}
