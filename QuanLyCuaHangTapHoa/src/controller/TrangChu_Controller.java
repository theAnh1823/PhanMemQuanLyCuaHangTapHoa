package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TrangChu_View;

public class TrangChu_Controller implements ActionListener {
	private TrangChu_View manHinhChinh_View;

	/**
	 * @wbp.parser.entryPoint
	 */
	public TrangChu_Controller(TrangChu_View manHinhChinh_View) {
		super();
		this.manHinhChinh_View = manHinhChinh_View;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("QUẢN LÝ KHO")) {
			this.manHinhChinh_View.chuyenSangManHinhQuanLyKho();
		} else if (cm.equals("QUẢN LÝ BÁN HÀNG")) {
			this.manHinhChinh_View.chuyenSangManHinhQuanLyBanHang();
		} else if (cm.equals("THỐNG KÊ")) {
			this.manHinhChinh_View.chuyenSangManHinhThongKe();
		} else if (cm.equals("DOANH THU")) {
			this.manHinhChinh_View.chuyenSangManHinhDoanhThu();
		} else if (cm.equals("Đăng xuất")) {
			this.manHinhChinh_View.chuyenVeManHinhDangNhap();
		} else if (cm.equals("Thanh toán")) {
			this.manHinhChinh_View.chuyenSangManHinhXacNhan();
		} else if (cm.equals("Trở lại")) {
			this.manHinhChinh_View.chuyenSangManHinhQuanLyBanHang();
		}
		
		if (cm.equals("Lọc")) {
			this.manHinhChinh_View.locData();
		} else if (cm.equals("Xóa hàng hết hsd")) {
			this.manHinhChinh_View.xoaLocData();
		}
		if (cm.equals("Doanh thu theo ngày")) {
			this.manHinhChinh_View.doanhThuNgay();
		}else if (cm.equals("Doanh thu theo tháng")) {
			this.manHinhChinh_View.doanhThuThang();
		}else if (cm.equals("Doanh thu theo năm")) {
			this.manHinhChinh_View.doanhThuNam();
		}
		if (cm.equals("Hủy bỏ")) {
			this.manHinhChinh_View.lamMoiTrang();
		} else if (cm.equals("Xóa")) {
			this.manHinhChinh_View.xoaHang();
		} else if (cm.equals("Cập nhật")) {
			this.manHinhChinh_View.capNhat();
		} else if (cm.equals("Hello")) {
			this.manHinhChinh_View.timKiem();
		} else if (cm.equals("Làm mới")) {
			this.manHinhChinh_View.lamMoiTrang();
		}else if (cm.equals("Thêm")){
			this.manHinhChinh_View.themHang();
		}else if(cm.equals("Xuất file Excel")) {
			this.manHinhChinh_View.xuatFileExcel();
		}
	}

}
