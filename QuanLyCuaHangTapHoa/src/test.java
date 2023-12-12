import javax.swing.UIManager;

import view.DangNhap_View;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			DangNhap_View loginFrame = new DangNhap_View();
			loginFrame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
