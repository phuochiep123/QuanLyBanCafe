package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Ca {
	private String maCa;
	private String tenCa;
	private LocalDateTime thoiGianBatDau;
	private LocalDateTime thoiGianKetThuc;
	private ArrayList<NhanVien> listNhanVien;
	public Ca(String maCa, String tenCa, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc,
			ArrayList<NhanVien> listNhanVien) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.listNhanVien = listNhanVien;
	}
	public String getMaCa() {
		return maCa;
	}
	public String getTenCa() {
		return tenCa;
	}
	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}
	public LocalDateTime getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public LocalDateTime getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public ArrayList<NhanVien> getListNhanVien() {
		return listNhanVien;
	}
	public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ca other = (Ca) obj;
		return Objects.equals(maCa, other.maCa);
	}
	
	
	
}
