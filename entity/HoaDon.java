package Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HoaDon {
	private ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
	private String maHD;
	private String tenHoaDon;
	private String phuongThucThanhToan;
	private LocalDateTime ngayLap;
	private boolean trangThaiThanhToan; //true = đã thanh toán ; false = chờ thanh toán
	public boolean isTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getTenHoaDon() {
		return tenHoaDon;
	}
	public void setTenHoaDon(String tenHoaDon) {
		this.tenHoaDon = tenHoaDon;
	}

	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	public double tinhTongTien() {
		double s = 0;
		for (ChiTietHoaDon chiTietHoaDon : list) {
			s+= chiTietHoaDon.tinhTongThu();
		}
		return s;
	}
	
	public boolean themChiTietHD(ChiTietHoaDon chiTietHD) {
		return list.contains(chiTietHD) ? false : true;
	}
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HoaDon(ArrayList<ChiTietHoaDon> list, String maHD, String tenHoaDon, String phuongThucThanhToan,
			LocalDateTime ngayLap, boolean trangThaiThanhToan) {
		super();
		this.list = list;
		this.maHD = maHD;
		this.tenHoaDon = tenHoaDon;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.ngayLap = ngayLap;
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
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
		HoaDon other = (HoaDon) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String dsSP = "";
		for (ChiTietHoaDon chiTietHoaDon : list) {
			dsSP+= chiTietHoaDon.toString();
		}
		return "\\t\\t\\tTHE GARDEN COFFEE\\r\\n\\r\\n"
				+ "\\t\\t590 CMT8, P.11, Q.3, TPHCM\\r\\n"
				+ "\\t\\t\\tSĐT: 01212692802\\r\\n\\r\\n"
				+ "\\t\\t\\tHÓA ĐƠN BÁN HÀNG\\r\\n\\r\\n"
				+ "Mã hóa đơn: " + maHD + "\\r\\n"
				+ "Tên hoá đơn: " + tenHoaDon + "\\r\\n"
				+ "Ngày lập: " + ngayLap + "\\r\\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------------"
				+ "|                                                  DANH SÁCH SẢN PHẨM                                                                  |"
				+ "----------------------------------------------------------------------------------------------------------------------------------------"
				+ "| Mã sản phẩm  |   Tên sản phẩm   | Kích thước |       Giá       |    Khuyến mãi    |    Chiết khấu     |   Số lượng    |     Tổng     |"
				+ dsSP + "\\n"
				+ "-----------------------------------------------------------------------------------------"
				+ "Phương thức thanh toán: " + phuongThucThanhToan + "\\r\\n"
				+ "Trạng thái thanh toán: " + trangThaiThanhToan + "\\r\\n"
				+ "Tổng tiền: " + tinhTongTien() + "\\r\\n"
				+ "CẢM ƠN QUÝ KHÁCH!!!" + "\\r\\n"
				+ "WiFi: xincamonquykhach"
				;
				
	}
	
	
}
