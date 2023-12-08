package model;

import java.util.Date;
import java.util.Objects;

public class HangHoa {
	private String maSanPham;
	private String tenSanPham;
	private String nhaSanXuat;
	private int soLuong;
	private double giaBan;
	private Date ngaySanXuat;
	private Date hanSuDung;

	public HangHoa() {
		// TODO Auto-generated constructor stub
	}

	public HangHoa(String maSanPham, String tenSanPham, String nhaSanXuat, int soLuong, double giaBan,Date ngaySanXuat, Date hanSuDung) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.nhaSanXuat = nhaSanXuat;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
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

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public Date getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	@Override
    public String toString() {
        return "test{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", nhaSanXuat=" + nhaSanXuat + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", ngaySanXuat=" + ngaySanXuat + ", hanSuDung=" + hanSuDung + '}';
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HangHoa other = (HangHoa) obj;
        if (Double.doubleToLongBits(this.giaBan) != Double.doubleToLongBits(other.giaBan)) {
            return false;
        }
        if (!Objects.equals(this.tenSanPham, other.tenSanPham)) {
            return false;
        }
        if (!Objects.equals(this.nhaSanXuat, other.nhaSanXuat)) {
            return false;
        }
        if (!Objects.equals(this.ngaySanXuat, other.ngaySanXuat)) {
            return false;
        }
        return Objects.equals(this.hanSuDung, other.hanSuDung);
    }
	
	public void themSoLuong(int soLuongThem) {
		this.soLuong += soLuongThem;
	}
	
}