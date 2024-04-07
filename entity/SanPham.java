package Entity;

import java.time.LocalDateTime;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private String kichThuoc;
	private double gia;
	private LoaiSanPham loaiSanPham;
	private KhuyenMai khuyenMai;
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
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
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		LocalDateTime df = LocalDateTime.now();
		if(khuyenMai != null &&  khuyenMai.getNgayKetThuc().isBefore(df))
			this.gia = gia - gia * khuyenMai.getPhanTramGiamGia();
		else 
			this.gia = gia;
	}
	
	
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}
	
	public SanPham(String maSanPham, String tenSanPham, String kichThuoc, double gia, LoaiSanPham loaiSanPham,
			KhuyenMai khuyenMai) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.kichThuoc = kichThuoc;
		this.gia = gia;
		this.loaiSanPham = loaiSanPham;
		this.khuyenMai = khuyenMai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSanPham == null) ? 0 : maSanPham.hashCode());
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
		SanPham other = (SanPham) obj;
		if (maSanPham == null) {
			if (other.maSanPham != null)
				return false;
		} else if (!maSanPham.equals(other.maSanPham))
			return false;
		return true;
	}
	@Override
	public String toString() {
		//| Mã sản phẩm  |   Tên sản phẩm   | Kích thước |       Giá       |    Khuyến mãi    |    Chiết khấu     |   Số lượng    |     Tổng     |
		return maSanPham + tenSanPham + kichThuoc + gia + khuyenMai.getPhanTramGiamGia();
	}
	
	
	
}
