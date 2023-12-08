package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Placeholder {
	

	private Font font = new Font("Tahoma", Font.PLAIN, 18);
	
	public Placeholder() {
	}

	public void addPlaceholerStyle(JTextField jTextField) {
		jTextField.setFont(font);
		jTextField.setForeground(Color.gray);
	}

	public void addPlaceholerStyle(JPasswordField jPasswordField) {
		jPasswordField.setFont(font);
		jPasswordField.setForeground(Color.gray);
	}
	
	public void removePlaceholerStyle(JTextField jTextField) {
		jTextField.setFont(font);
		jTextField.setForeground(Color.black);
	}
	
	public void removePlaceholerStyle(JPasswordField jPasswordField) {
		jPasswordField.setFont(font);
		jPasswordField.setForeground(Color.black);
	}

	private void txtUserFocusGained(java.awt.event.FocusEvent evt, JTextField jTextField) {
		if (jTextField.getText().equals("Tên tài khoản")) {
			jTextField.setText(null);
			jTextField.requestFocus();
			removePlaceholerStyle(jTextField);
		}
	}

	private void txtPasswordFocusGained(java.awt.event.FocusEvent evt, JPasswordField jPasswordField) {
		if (jPasswordField.getText().equals("Mật khẩu")) {
			jPasswordField.setText(null);
			jPasswordField.requestFocus();
			jPasswordField.setEchoChar('*');
			removePlaceholerStyle(jPasswordField);
		}
	}
	
	private void txtUserFocusLost(java.awt.event.FocusEvent evt, JTextField jTextField) {
		if (jTextField.getText().length()==0) {
			addPlaceholerStyle(jTextField);
			jTextField.setText("Tên tài khoản");
		}
	}
	
	private void txtPasswordFocusLost(java.awt.event.FocusEvent evt, JPasswordField jPasswordField) {
		if (jPasswordField.getText().length()==0) {
			addPlaceholerStyle(jPasswordField);
			jPasswordField.setText("Mật khẩu");
		}
	}
}
