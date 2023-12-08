package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.DangNhap_Controller;
import controller.Mouse_Controller;
import resource.Color_Res;

public class QuenMatKhau_View extends JFrame {

	private JPanel contentPane;
	private JTextField textField_TaiKhoanKhoiPhuc;
	private JButton btn_KhoiPhuc;
	private Color_Res color = new Color_Res();
	private Placeholder placeholder = new Placeholder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMatKhau_View frame = new QuenMatKhau_View();
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
	public QuenMatKhau_View() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				requestFocusInWindow();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		setTitle("Khôi phục mật khẩu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 394);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		MouseListener mouseListener = new Mouse_Controller(null, this, null);
		ActionListener actionListener = new DangNhap_Controller(null, this);
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Vui lòng nhập email hoặc số di động để tìm kiếm tài khoản của bạn.");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		
		textField_TaiKhoanKhoiPhuc = new JTextField();
		textField_TaiKhoanKhoiPhuc.setFont(new Font("Helvetica", Font.PLAIN, 18));
		textField_TaiKhoanKhoiPhuc.setBorder(BorderFactory.createCompoundBorder(textField_TaiKhoanKhoiPhuc.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textField_TaiKhoanKhoiPhuc.setText("Email hoặc số di động");
		textField_TaiKhoanKhoiPhuc.setColumns(10);
		textField_TaiKhoanKhoiPhuc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_TaiKhoanKhoiPhuc.getText().equals("Email hoặc số di động")) {
					textField_TaiKhoanKhoiPhuc.setText("");
					placeholder.removePlaceholerStyle(textField_TaiKhoanKhoiPhuc);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_TaiKhoanKhoiPhuc.getText().length() == 0) {
					textField_TaiKhoanKhoiPhuc.setText("Email hoặc số di động");
					placeholder.addPlaceholerStyle(textField_TaiKhoanKhoiPhuc);
				}
			}
		});
		
		JButton btn_Huy = new JButton("Hủy");
		btn_Huy.setFocusPainted(false);
		btn_Huy.setForeground(Color.RED);
		btn_Huy.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btn_Huy.addActionListener(actionListener);
		
		btn_KhoiPhuc = new JButton("OK");
		btn_KhoiPhuc.setBorder(null);
		btn_KhoiPhuc.setBorderPainted(false);
		btn_KhoiPhuc.setHideActionText(true);
		btn_KhoiPhuc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_KhoiPhuc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn_KhoiPhuc.setForeground(color.color_Login_XanhDuongNhat);
		btn_KhoiPhuc.setBackground(color.color_Login_XanhDuongDam);
		btn_KhoiPhuc.addMouseListener(mouseListener);
		btn_KhoiPhuc.addActionListener(actionListener);
		btn_KhoiPhuc.setFocusPainted(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(77))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(205)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Huy, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btn_KhoiPhuc, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_TaiKhoanKhoiPhuc, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(221, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewLabel)
					.addGap(29)
					.addComponent(textField_TaiKhoanKhoiPhuc, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Huy, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_KhoiPhuc, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void chuyenMauNenXanhNhat(String textInButton) {
		btn_KhoiPhuc.setForeground(color.color_Login_XanhDuongDam);
		btn_KhoiPhuc.setBackground(color.color_Login_XanhDuongNhat);
	}

	public void chuyenMauNenXanhDam(String textInButton) {
		btn_KhoiPhuc.setForeground(color.color_Login_XanhDuongNhat);
		btn_KhoiPhuc.setBackground(color.color_Login_XanhDuongDam);
	}

	public void chuyenVeManHinhDangNhap() {
		// TODO Auto-generated method stub
		DangNhap_View loginView = new DangNhap_View();
		loginView.pack();
		loginView.setLocationRelativeTo(null);
		loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginView.setVisible(true);
		this.dispose();
	}

	public void thongBaoKhoiPhucMatKhau() {
		// TODO Auto-generated method stub
		final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		final String NUMBER_PHONE_PATTERN = "^0[0-9]{9}$";
		if(textField_TaiKhoanKhoiPhuc.getText().matches(NUMBER_PHONE_PATTERN) || textField_TaiKhoanKhoiPhuc.getText().matches(EMAIL_PATTERN)) {
			JOptionPane.showMessageDialog(new JFrame(),
                    "Vui lòng kiểm tra email hoặc tin nhắn để khôi phục mật khẩu.",
                    "Thông báo!",
                    JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(),
                    "Vui lòng nhập email hoặc số điện thoại để khôi phục mật khẩu.",
                    "Lỗi!",
                    JOptionPane.ERROR_MESSAGE);
		}
        	
	}
	
}
