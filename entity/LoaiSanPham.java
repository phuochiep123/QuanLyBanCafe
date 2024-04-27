package entity;

import java.util.ArrayList;
import java.util.Objects;

public class LoaiSanPham {
	private String maLoai;
	private String tenloai;
	private String moTa;
	
	private ArrayList<SanPham> dsSanPham;
	
	public LoaiSanPham(String maLoai, String tenloai, String moTa, ArrayList<SanPham> dsSanPham) {
		this.maLoai = maLoai;
		this.tenloai = tenloai;
		this.moTa = moTa;
		this.dsSanPham = dsSanPham;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiSanPham other = (LoaiSanPham) obj;
		return Objects.equals(maLoai, other.maLoai);
	}

	@Override
	public String toString() {
		return "LoaiSanPham [maLoai=" + maLoai + ", tenloai=" + tenloai + ", moTa=" + moTa + "]";
	}
	
	
}
