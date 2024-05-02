package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private boolean gioiTinh;
	private LocalDateTime ngaySinh;
	private String chucVu;
	private LocalDateTime ngayTuyenDung;
	private String diaChi;
	private String email;
	private String hinhAnh;
	
	private TaiKhoan taiKhoan;
	
	public NhanVien() {
	}

	public NhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	public NhanVien(String maNhanVien, String hoTen, boolean gioiTinh, LocalDateTime ngaySinh, String chucVu,
			LocalDateTime ngayTuyenDung, String diaChi, String email, String hinhAnh) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.ngayTuyenDung = ngayTuyenDung;
		this.diaChi = diaChi;
		this.email = email;
		this.hinhAnh = hinhAnh;
		this.taiKhoan = new TaiKhoan(maNhanVien, "1234", chucVu.equals("Quản lý")?true:false);
	}

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

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDateTime getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDateTime ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public LocalDateTime getNgayTuyenDung() {
		return ngayTuyenDung;
	}

	public void setNgayTuyenDung(LocalDateTime ngayTuyenDung) {
		this.ngayTuyenDung = ngayTuyenDung;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
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
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh="
				+ ngaySinh + ", chucVu=" + chucVu + ", ngayTuyenDung=" + ngayTuyenDung + ", diaChi=" + diaChi
				+ ", email=" + email + ", hinhAnh=" + hinhAnh + "]";
	}
	
	
}
