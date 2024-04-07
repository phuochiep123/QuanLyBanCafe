package Entity;

public class KhachHang {
	private String maKH;
	private String hoTen;
	private String dienThoai;
	private int diemTichLuy;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	
	public boolean thanhToan(HoaDon hoaDon) {
		return hoaDon.isTrangThaiThanhToan() ? true : false;
	}
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH, String hoTen, String dienThoai, int diemTichLuy) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.dienThoai = dienThoai;
		this.diemTichLuy = diemTichLuy;
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTen=" + hoTen + ", dienThoai=" + dienThoai + ", diemTichLuy="
				+ diemTichLuy + "]";
	}
	
}
