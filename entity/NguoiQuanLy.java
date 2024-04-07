package entity;

import java.util.Objects;

public class NguoiQuanLy {
	private String maNQL;
	private String hoTen;
	private String sdt;
	private DiaChi diaChi;
	public NguoiQuanLy() {
	}
	public NguoiQuanLy(String maNQL) {
		this.maNQL = maNQL;
	}
	public NguoiQuanLy(String maNQL, String hoTen, String sdt) {
		this.maNQL = maNQL;
		this.hoTen = hoTen;
		this.sdt = sdt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNQL);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NguoiQuanLy other = (NguoiQuanLy) obj;
		return Objects.equals(maNQL, other.maNQL);
	}
	
	
}
