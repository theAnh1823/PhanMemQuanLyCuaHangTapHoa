package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DangNhap_View;
import view.QuenMatKhau_View;

public class DangNhap_Controller implements ActionListener {

	private DangNhap_View loginView;
	private QuenMatKhau_View forgotPasswordView;

	public DangNhap_Controller(DangNhap_View loginView, QuenMatKhau_View forgotPasswordView) {
		super();
		this.loginView = loginView;
		this.forgotPasswordView = forgotPasswordView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Quên mật khẩu?")) {
			this.loginView.chuyenSangManHinhQuenMatKhau();
		} else if (cm.equals("Hủy")) {
			this.forgotPasswordView.chuyenVeManHinhDangNhap();
		} else if (cm.equals("Đăng nhập")) {
			this.loginView.dangNhapThanhCong();
		} else if (cm.equals("OK")) {
			this.forgotPasswordView.thongBaoKhoiPhucMatKhau();
		}
	}

}
