package Entity;

public class DiaChi {
	private String maVung;
	private int soNha;
	private String duong;
	private String thanhPho;
	public String getMaVung() {
		return maVung;
	}
	public void setMaVung(String maVung) {
		this.maVung = maVung;
	}
	public int getSoNha() {
		return soNha;
	}
	public void setSoNha(int soNha) {
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
	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiaChi(String maVung, int soNha, String duong, String thanhPho) {
		super();
		this.maVung = maVung;
		this.soNha = soNha;
		this.duong = duong;
		this.thanhPho = thanhPho;
	}
	public DiaChi(String maVung) {
		super();
		this.maVung = maVung;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maVung == null) ? 0 : maVung.hashCode());
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
		DiaChi other = (DiaChi) obj;
		if (maVung == null) {
			if (other.maVung != null)
				return false;
		} else if (!maVung.equals(other.maVung))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DiaChi [maVung=" + maVung + ", soNha=" + soNha + ", duong=" + duong + ", thanhPho=" + thanhPho + "]";
	}
		
}
