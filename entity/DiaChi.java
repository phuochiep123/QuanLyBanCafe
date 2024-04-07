package entity;

import java.util.Objects;

public class DiaChi {
	private String maVung;
	private String soNha;
	private String duong;
	private String thanhPho;
	
	public DiaChi(String maVung, String soNha, String duong, String thanhPho) {
		this.maVung = maVung;
		this.soNha = soNha;
		this.duong = duong;
		this.thanhPho = thanhPho;
	}

	public String getMaVung() {
		return maVung;
	}

	public void setMaVung(String maVung) {
		this.maVung = maVung;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public String getDuong() {
		return duong;
	}

	public void setDuong(String duong) {
		this.duong = duong;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maVung);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaChi other = (DiaChi) obj;
		return Objects.equals(maVung, other.maVung);
	}
	
	
}
