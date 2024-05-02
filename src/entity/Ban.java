package entity;

import java.util.Objects;

public class Ban {
	private int maBan;
	private int soGhe;
	private boolean tinhTrang; // true: đang trống, false: đang bận
	
	public Ban(int maBan, int soGhe, boolean tinhTrang) {
		this.maBan = maBan;
		this.soGhe = soGhe;
		this.tinhTrang = tinhTrang;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

	public int getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maBan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ban other = (Ban) obj;
		return maBan == other.maBan;
	}

	@Override
	public String toString() {
		return "Ban [maBan=" + maBan + ", soGhe=" + soGhe + ", tinhTrang=" + tinhTrang + "]";
	}
	
	
}
