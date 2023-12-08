package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import view.DangNhap_View;
import view.QuenMatKhau_View;
import view.TrangChu_View;

public class Mouse_Controller implements MouseListener {
	private boolean buttonPressed = false;

	private DangNhap_View loginView;
	private QuenMatKhau_View forgotPasswordView;
	private TrangChu_View manHinhChinh_View;

	public Mouse_Controller(DangNhap_View loginView, QuenMatKhau_View forgotPasswordView,
			TrangChu_View manHinhChinh_View) {
		super();
		this.loginView = loginView;
		this.forgotPasswordView = forgotPasswordView;
		this.manHinhChinh_View = manHinhChinh_View;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		String cm = ((JButton) e.getSource()).getText();
		if (cm.equals("DOANH THU")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("DOANH THU");
			this.manHinhChinh_View.chuyenMauNenXanhDam("THỐNG KÊ");
			this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ BÁN HÀNG");
			this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ KHO");
			buttonPressed = true;
		} else if (cm.equals("QUẢN LÝ KHO")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("DOANH THU");
			this.manHinhChinh_View.chuyenMauNenXanhDam("THỐNG KÊ");
			this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ BÁN HÀNG");
			this.manHinhChinh_View.chuyenMauNenXanhNhat("QUẢN LÝ KHO");
			buttonPressed = true;
		} else if (cm.equals("QUẢN LÝ BÁN HÀNG")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("DOANH THU");
			this.manHinhChinh_View.chuyenMauNenXanhDam("THỐNG KÊ");
			this.manHinhChinh_View.chuyenMauNenXanhNhat("QUẢN LÝ BÁN HÀNG");
			this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ KHO");
			buttonPressed = true;
		} else if (cm.equals("THỐNG KÊ")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("DOANH THU");
			this.manHinhChinh_View.chuyenMauNenXanhNhat("THỐNG KÊ");
			this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ BÁN HÀNG");
			this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ KHO");
			buttonPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String cm = ((JButton) e.getSource()).getText();
		if (cm.equals("Đăng nhập")) {
			this.loginView.chuyenMauNenXanhNhat("Đăng nhập");
		} else if (cm.equals("OK")) {
			this.forgotPasswordView.chuyenMauNenXanhNhat("OK");
		} else if (cm.equals("DOANH THU")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("DOANH THU");
			buttonPressed = false;
		} else if (cm.equals("THỐNG KÊ")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("THỐNG KÊ");
			buttonPressed = false;
		} else if (cm.equals("QUẢN LÝ BÁN HÀNG")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("QUẢN LÝ BÁN HÀNG");
			buttonPressed = false;
		} else if (cm.equals("QUẢN LÝ KHO")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("QUẢN LÝ KHO");
			buttonPressed = false;
		}
		if (cm.equals("Tìm kiếm")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Tìm kiếm");
		} else if (cm.equals("Thêm")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Thêm");
		} else if (cm.equals("Làm mới")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Làm mới");
		} else if (cm.equals("Xóa")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Xóa");
		} else if (cm.equals("Cập nhật")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Cập nhật");
		} else if (cm.equals("Hủy bỏ")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Hủy bỏ");
		} else if (cm.equals("Thanh toán")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Thanh toán");
		} else if (cm.equals("Xác nhận")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Xác nhận");
		} else if (cm.equals("Trở lại")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Trở lại");
		} else if (cm.equals("Chỉnh sửa")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Chỉnh sửa");
		} else if (cm.equals("Lọc")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Lọc");
		} else if (cm.equals("Thống kê")) {
			this.manHinhChinh_View.chuyenMauNenXanhNhat("Thống kê");
		} else if (cm.equals("Xuất file Excel")) {
			this.manHinhChinh_View.chuyenMauNenXanhLucNhat();
		} else if (cm.equals("Đăng xuất")) {
			this.manHinhChinh_View.chuyenMauNenDoTham("Đăng xuất");
		} else if (cm.equals("Xóa hàng")) {
			this.manHinhChinh_View.chuyenMauNenDoTham("Xóa hàng");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		String cm = ((JButton) e.getSource()).getText();
		if (!buttonPressed) {
			if (cm.equals("DOANH THU")) {
				this.manHinhChinh_View.chuyenMauNenXanhDam("DOANH THU");
			} else if (cm.equals("THỐNG KÊ")) {
				this.manHinhChinh_View.chuyenMauNenXanhDam("THỐNG KÊ");
			} else if (cm.equals("QUẢN LÝ BÁN HÀNG")) {
				this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ BÁN HÀNG");
			} else if (cm.equals("QUẢN LÝ KHO")) {
				this.manHinhChinh_View.chuyenMauNenXanhDam("QUẢN LÝ KHO");
			}
		}

		if (cm.equals("Đăng nhập")) {
			this.loginView.chuyenMauNenXanhDam("Đăng nhập");
		} else if (cm.equals("OK")) {
			this.forgotPasswordView.chuyenMauNenXanhDam("OK");
		} else if (cm.equals("Tìm kiếm")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Tìm kiếm");
		} else if (cm.equals("Làm mới")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Làm mới");
		} else if (cm.equals("Thêm")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Thêm");
		} else if (cm.equals("Xóa")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Xóa");
		} else if (cm.equals("Cập nhật")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Cập nhật");
		} else if (cm.equals("Hủy bỏ")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Hủy bỏ");
		} else if (cm.equals("Thanh toán")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Thanh toán");
		} else if (cm.equals("Xác nhận")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Xác nhận");
		} else if (cm.equals("Trở lại")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Trở lại");
		} else if (cm.equals("Chỉnh sửa")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Chỉnh sửa");
		} else if (cm.equals("Lọc")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Lọc");
		} else if (cm.equals("Thống kê")) {
			this.manHinhChinh_View.chuyenMauNenXanhDam("Thống kê");
		} else if (cm.equals("Xuất file Excel")) {
			this.manHinhChinh_View.chuyenMauNenXanhLucDam();
		} else if (cm.equals("Đăng xuất")) {
			this.manHinhChinh_View.chuyenMauNenDo("Đăng xuất");
		} else if (cm.equals("Xóa hàng")) {
			this.manHinhChinh_View.chuyenMauNenDo("Xóa hàng");
		}
	}

}
