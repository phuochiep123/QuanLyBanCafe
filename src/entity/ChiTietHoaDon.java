package entity;

public class ChiTietHoaDon {
	private SanPham sanPham;
	private int soLuong;
	
	public ChiTietHoaDon(SanPham sanPham, int soLuong) {
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + "]";
	}
	//Tính VAT
	public double tinhVAT() {
		return 0;
	}
	//get giá bán
	public double giaBan() {
		//Trừ khuyến mãi nêú có
		return 0;
	}
}
