package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TrangChu_View;

public class TrangChu_Controller implements ActionListener {
	private TrangChu_View manHinhChinh_View;

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

		
		if(cm.equals("Tìm kiếm bán hàng")) {
			this.manHinhChinh_View.TimKiemBanHang();
		}else if (cm.equals("Làm mới bán hàng")) {
			this.manHinhChinh_View.LamMoiBangBanHang();
		}else if (cm.equals("Xóa hàng")) {
			this.manHinhChinh_View.XoaHangDaChon();
		}else if (cm.equals("Chỉnh sửa")) {
			this.manHinhChinh_View.ChinhSuaDaChon();
		}else if (cm.equals("Xác nhận")) {
			this.manHinhChinh_View.XacNhanDaChon();
		}
		
		
		if (cm.equals("Hủy bỏ")) {
			this.manHinhChinh_View.lamMoiTrang();
		} else if (cm.equals("Xóa")) {
			this.manHinhChinh_View.xoaHang();
		} else if (cm.equals("Cập nhật")) {
			this.manHinhChinh_View.capNhat();
		} else if (cm.equals("Tìm kiếm")) {
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
