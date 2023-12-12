package model;


import java.util.Date;

public class SanPhamDaBan extends HangHoa {
	private Date ngayBanHang;

	public SanPhamDaBan() {
		// TODO Auto-generated constructor stub
	}

	public SanPhamDaBan(String maSanPham, String tenSanPham, String nhaSanXuat, int soLuong, double giaBan,Date ngaySanXuat, Date hanSuDung, Date ngayBanHang) {
		super(maSanPham, tenSanPham, nhaSanXuat, soLuong, giaBan, ngaySanXuat, hanSuDung);
		this.ngayBanHang = ngayBanHang;
	}

	public Date getNgayBanHang() {
		return ngayBanHang;
	}

	public void setNgayBanHang(Date ngayBanHang) {
		this.ngayBanHang = ngayBanHang;
	}

}
