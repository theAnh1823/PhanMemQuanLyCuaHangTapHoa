package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.DangNhap_Controller;
import controller.Mouse_Controller;
import dao.DBConnectionFactory;
import resource.Color_Res;

public class DangNhap_View extends JFrame {

	private Placeholder placeholder = new Placeholder();
	private Font font = new Font("Arial", Font.PLAIN, 18);
	private Color_Res color = new Color_Res();

	private javax.swing.JPanel Left;
	private javax.swing.JPanel Right;
	private javax.swing.JButton btn_DangNhap;
	private javax.swing.JButton btn_QuenMatKhau;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField passwordField_MatKhau;
	private javax.swing.JTextField textField_TenTaiKhoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap_View frame = new DangNhap_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap_View() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				requestFocusInWindow();
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Đăng nhập");
		this.setPreferredSize(new java.awt.Dimension(800, 500));

		MouseListener mouseListener = new Mouse_Controller(this, null, null);
		ActionListener actionListener = new DangNhap_Controller(this, null);

		jPanel1 = new javax.swing.JPanel();
		Right = new javax.swing.JPanel();
		Left = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setAlignmentX(Component.RIGHT_ALIGNMENT);

		textField_TenTaiKhoan = new javax.swing.JTextField();
		textField_TenTaiKhoan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_TenTaiKhoan.getText().equals("Tên tài khoản")) {
					textField_TenTaiKhoan.setText("");
					placeholder.removePlaceholerStyle(textField_TenTaiKhoan);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_TenTaiKhoan.getText().length() == 0) {
					textField_TenTaiKhoan.setText("Tên tài khoản");
					placeholder.addPlaceholerStyle(textField_TenTaiKhoan);
				}
			}
		});
		textField_TenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_TenTaiKhoan.setText("Tên tài khoản");
		textField_TenTaiKhoan.setBorder(BorderFactory.createCompoundBorder(textField_TenTaiKhoan.getBorder(),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));

		passwordField_MatKhau = new javax.swing.JPasswordField();
		passwordField_MatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField_MatKhau.setForeground(Color.GRAY);
		passwordField_MatKhau.setText("Mật khẩu");
		passwordField_MatKhau.setEchoChar((char) 0);
		passwordField_MatKhau.setBorder(BorderFactory.createCompoundBorder(passwordField_MatKhau.getBorder(),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		passwordField_MatKhau.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField_MatKhau.getPassword().length < 1) {
					placeholder.addPlaceholerStyle(passwordField_MatKhau);
					passwordField_MatKhau.setText("Mật khẩu");
					passwordField_MatKhau.setEchoChar((char) 0);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf((passwordField_MatKhau.getPassword())).equals("Mật khẩu")) {
					passwordField_MatKhau.setText("");
					passwordField_MatKhau.requestFocus();
					passwordField_MatKhau.setEchoChar('•');
					placeholder.removePlaceholerStyle(passwordField_MatKhau);
				}
			}
		});

		btn_DangNhap = new javax.swing.JButton();
		btn_DangNhap.addActionListener(actionListener);
		btn_DangNhap.addMouseListener(mouseListener);
		btn_DangNhap.setBorderPainted(false);
		btn_DangNhap.setHideActionText(true);
		btn_DangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DangNhap.setBackground(color.color_Login_XanhDuongDam);
		btn_DangNhap.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btn_DangNhap.setForeground(color.color_Login_XanhDuongNhat);
		btn_DangNhap.setText("Đăng nhập");
		btn_DangNhap.setFocusPainted(false);

		btn_QuenMatKhau = new javax.swing.JButton();
		btn_QuenMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_QuenMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btn_QuenMatKhau.setForeground(new java.awt.Color(255, 51, 51));
		btn_QuenMatKhau.setText("Quên mật khẩu?");
		btn_QuenMatKhau.addActionListener(actionListener);
		btn_QuenMatKhau.setFocusPainted(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
		jPanel1.setLayout(null);

		Right.setBackground(new Color(5, 50, 98));
		Right.setPreferredSize(new java.awt.Dimension(400, 500));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DangNhap_View.class.getResource("/resource/logo_shop.png")));

		javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
		RightLayout.setHorizontalGroup(RightLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(RightLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 380, Short.MAX_VALUE)
						.addContainerGap()));
		RightLayout.setVerticalGroup(RightLayout.createParallelGroup(Alignment.LEADING).addGroup(RightLayout
				.createSequentialGroup().addGap(32).addComponent(lblNewLabel).addContainerGap(68, Short.MAX_VALUE)));
		Right.setLayout(RightLayout);

		jPanel1.add(Right);
		Right.setBounds(0, 0, 400, 500);

		Left.setBackground(new java.awt.Color(255, 255, 255));
		Left.setMinimumSize(new java.awt.Dimension(400, 500));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
		jLabel1.setForeground(new Color(5, 50, 98));
		jLabel1.setText("ĐĂNG NHẬP");

		textField_TenTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_TenTaiKhoan.setForeground(Color.GRAY);

		javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
		LeftLayout.setHorizontalGroup(LeftLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				LeftLayout.createSequentialGroup().addGroup(LeftLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING,
								LeftLayout.createSequentialGroup().addGap(87).addComponent(jLabel1))
						.addGroup(Alignment.LEADING,
								LeftLayout.createSequentialGroup().addGap(30)
										.addGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(passwordField_MatKhau, Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
												.addComponent(btn_QuenMatKhau)
												.addComponent(textField_TenTaiKhoan, 343, 343, Short.MAX_VALUE))))
						.addGap(27))
				.addGroup(LeftLayout.createSequentialGroup().addGap(73)
						.addComponent(btn_DangNhap, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(77, Short.MAX_VALUE)));
		LeftLayout.setVerticalGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(LeftLayout.createSequentialGroup().addGap(52).addComponent(jLabel1).addGap(50)
						.addComponent(textField_TenTaiKhoan, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(37)
						.addComponent(passwordField_MatKhau, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(42)
						.addComponent(btn_DangNhap, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(60).addComponent(btn_QuenMatKhau).addContainerGap(59, Short.MAX_VALUE)));
		Left.setLayout(LeftLayout);

		jPanel1.add(Left);
		Left.setBounds(400, 0, 400, 500);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 129, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 149, Short.MAX_VALUE)));

		getAccessibleContext().setAccessibleName("LOGIN");

		pack();
		this.setVisible(true);
	}

	public void chuyenMauNenXanhNhat(String textInButton) {
		btn_DangNhap.setForeground(color.color_Login_XanhDuongDam);
		btn_DangNhap.setBackground(color.color_Login_XanhDuongNhat);
	}

	public void chuyenMauNenXanhDam(String textInButton) {
		btn_DangNhap.setForeground(color.color_Login_XanhDuongNhat);
		btn_DangNhap.setBackground(color.color_Login_XanhDuongDam);
	}

	public void chuyenSangManHinhQuenMatKhau() {
		// TODO Auto-generated method stub
		QuenMatKhau_View forgotPasswordFrame = new QuenMatKhau_View();
		forgotPasswordFrame.pack();
		forgotPasswordFrame.setLocationRelativeTo(null);
		forgotPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forgotPasswordFrame.setVisible(true);
		this.dispose();
	}

	public void dangNhapThanhCong() {
		// TODO Auto-generated method stub
		String tenTaiKhoan = textField_TenTaiKhoan.getText();
		String matKhau = passwordField_MatKhau.getText();
		try {
			Connection connection = DBConnectionFactory.getConnection();
			PreparedStatement st = connection.prepareStatement(
					"select userName, password from LoginCuaHangTapHoa where userName=? and password=?");
			st.setString(1, tenTaiKhoan);
			st.setString(2, matKhau);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
                TrangChu_View manHinhChinh_View = new TrangChu_View();
                manHinhChinh_View.pack();
                manHinhChinh_View.setLocationRelativeTo(null);
                manHinhChinh_View.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                manHinhChinh_View.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(new JFrame(),
						"Tài khoản hoặc mật khẩu không đúng.\nVui lòng kiểm tra lại.", "Đăng nhập thất bại!",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
