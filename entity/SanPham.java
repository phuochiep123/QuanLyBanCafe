package entity;

import java.util.ArrayList;
import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private char kichThuoc;
	private double gia;
	private boolean trangThai;
	private String hinhAnh;
	private String moTa;
	
	private ArrayList<KhuyenMai> khuyenMai;

	public SanPham(String maSanPham, String tenSanPham, char kichThuoc, double gia, boolean trangThai, String hinhAnh,
			String moTa, ArrayList<KhuyenMai> khuyenMai) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.kichThuoc = kichThuoc;
		this.gia = gia;
		this.trangThai = trangThai;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
		this.khuyenMai = khuyenMai;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public char getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(char kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public ArrayList<KhuyenMai> getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(ArrayList<KhuyenMai> khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", kichThuoc=" + kichThuoc + ", gia="
				+ gia + ", trangThai=" + trangThai + ", hinhAnh=" + hinhAnh + ", moTa=" + moTa + ", khuyenMai="
				+ khuyenMai + "]";
	}
	
	
}
