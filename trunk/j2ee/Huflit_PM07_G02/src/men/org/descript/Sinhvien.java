package men.org.descript;
/**
 * Lớp này đặt tả 1 sinh viên
 * @author VoVanHai
 *
 */
public class Sinhvien {
	private String mssv;
	private String hoten;
	private int namsinh;
	
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(int namsinh) throws Exception{
		if(namsinh<1800||namsinh>3000)
			throw new Exception("Năm sinh không hợp lệ");
		this.namsinh = namsinh;
	}
	public Sinhvien() throws Exception  {
		this("no-id","no-name",1900);
	}
	public Sinhvien(String mssv, String hoten, int namsinh) throws Exception {
		this.mssv = mssv;
		this.hoten = hoten;
		setNamsinh(namsinh);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mssv == null) ? 0 : mssv.hashCode());
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
		Sinhvien other = (Sinhvien) obj;
		if (mssv == null) {
			if (other.mssv != null)
				return false;
		} else if (!mssv.equalsIgnoreCase(other.mssv))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return hoten;
	}
	
}
