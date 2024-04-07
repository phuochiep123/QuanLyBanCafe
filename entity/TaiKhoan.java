package entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class TaiKhoan {
	private String maTaiKhoan;
	private String tenTaiKhoan;
	private String matKhau;
	private boolean loaiTaiKhoan;
	private LocalDateTime ngayTao;
	public TaiKhoan(String maTaiKhoan, String tenTaiKhoan, String matKhau, boolean loaiTaiKhoan,
			LocalDateTime ngayTao) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.ngayTao = ngayTao;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public boolean isLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}
	public LocalDateTime getNgayTao() {
		return ngayTao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTaiKhoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTaiKhoan, other.maTaiKhoan);
	}
	
	
}
