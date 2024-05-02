package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class CaLam {
	private String maCa;
	private String tenCa;
	private LocalDateTime thoiGianBatDau;
	private LocalDateTime thoiGianketThuc;
	private double luongTheoGio;

	public CaLam(String maCa, String tenCa, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianketThuc,
			double luongTheoGio) {
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianketThuc = thoiGianketThuc;
		this.luongTheoGio = luongTheoGio;
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
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

	public LocalDateTime getThoiGianketThuc() {
		return thoiGianketThuc;
	}

	public void setThoiGianketThuc(LocalDateTime thoiGianketThuc) {
		this.thoiGianketThuc = thoiGianketThuc;
	}

	public double getLuongTheoGio() {
		return luongTheoGio;
	}

	public void setLuongTheoGio(double luongTheoGio) {
		this.luongTheoGio = luongTheoGio;
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
		CaLam other = (CaLam) obj;
		return Objects.equals(maCa, other.maCa);
	}

	@Override
	public String toString() {
		return "CaLam [maCa=" + maCa + ", tenCa=" + tenCa + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianketThuc="
				+ thoiGianketThuc + ", luongTheoGio=" + luongTheoGio + "]";
	}
	
	
}
