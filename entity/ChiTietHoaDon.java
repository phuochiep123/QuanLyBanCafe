package Entity;

public class ChiTietHoaDon {
	private SanPham sanPham;
	private int soLuong;
	private double gia;
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
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	
	public double tinhTongThu() {
		return getSoLuong() * gia;
	}
	
	public ChiTietHoaDon(SanPham sanPham, int soLuong, double gia) {
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	@Override
	public String toString() {
		
		//| Mã sản phẩm  |   Tên sản phẩm   | Kích thước |       Giá       |    Khuyến mãi    |    Chiết khấu     |   Số lượng    |     Tổng     |
		return sanPham.toString() + gia + soLuong + tinhTongThu();
	}
	
}
