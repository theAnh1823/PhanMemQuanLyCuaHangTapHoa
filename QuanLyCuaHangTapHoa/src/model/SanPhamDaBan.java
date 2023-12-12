package model;

import java.time.LocalDateTime;
import java.util.Date;

public class SanPhamDaBan extends HangHoa {
	private LocalDateTime ngayBanHang;

	public SanPhamDaBan() {
		// TODO Auto-generated constructor stub
	}

	public SanPhamDaBan(String maSanPham, String tenSanPham, String nhaSanXuat, int soLuong, double giaBan,Date ngaySanXuat, Date hanSuDung, LocalDateTime ngayBanHang) {
		super(maSanPham, tenSanPham, nhaSanXuat, soLuong, giaBan, ngaySanXuat, hanSuDung);
		this.ngayBanHang = ngayBanHang;
	}

	public LocalDateTime getNgayBanHang() {
		return ngayBanHang;
	}

	public void setNgayBanHang(LocalDateTime ngayBanHang) {
		this.ngayBanHang = ngayBanHang;
	}

}
