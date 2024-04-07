package Entity;


import java.time.LocalDateTime;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private String sđt;
	private LocalDateTime ngaySinh;
	private double luong;
	private DiaChi diaChi;
	
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSđt() {
		return sđt;
	}
	public void setSđt(String sđt) {
		this.sđt = sđt;
	}
	public LocalDateTime getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDateTime ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}	
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	public NhanVien(String maNhanVien, String hoTen, String sđt, LocalDateTime ngaySinh, double luong, DiaChi diaChi) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.sđt = sđt;
		this.ngaySinh = ngaySinh;
		this.luong = luong;
		this.diaChi = diaChi;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", sđt=" + sđt + ", ngaySinh=" + ngaySinh
				+ ", luong=" + luong + "]";
	}
	
	
}
