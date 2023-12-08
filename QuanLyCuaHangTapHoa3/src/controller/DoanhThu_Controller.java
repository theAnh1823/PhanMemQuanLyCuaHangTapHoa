package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.TrangChu_Controller;
import dao.HangHoaDAO;
import model.HangHoa;
import model.SanPhamDaBan;
import view.TrangChu_View;

public class DoanhThu_Controller implements MouseListener{
	private TrangChu_Controller tCC;
	private TrangChu_View tCV;
	private ArrayList<SanPhamDaBan> list;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public DoanhThu_Controller(TrangChu_View tCV) {
		super();
		this.tCV = tCV;
	}
	public void setData(String sql, DefaultTableModel dTM) throws ParseException{
		list = HangHoaDAO.getInstance().selectByDay(sql);
		dTM.getDataVector().removeAllElements();
		for (SanPhamDaBan sanPhamDaBan : list) {
			dTM.addRow(new Object[] { sanPhamDaBan.getMaSanPham(), sanPhamDaBan.getTenSanPham(),
					sanPhamDaBan.getNhaSanXuat(), sanPhamDaBan.getSoLuong(), sanPhamDaBan.getGiaBan(),
					sdf.format(sanPhamDaBan.getNgayBanHang())});
		}
		if(dTM.getRowCount() == 0) {
			String dt[] = {"", "", "", "", "", ""};
			dTM.addRow(dt);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == tCV.btn_DoanhThuNgay) {
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(tCV.txt_DoanhThuNgay.getText());
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				String sql = "SELECT * FROM HangDaBan WHERE ngayBanHang = '" + sdf1.format(date) + "'";
				setData(sql, tCV.model_DoanhThuNgay);
				int dong = tCV.model_DoanhThuNgay.getRowCount();
				int tongTien = 0;
				for(int i = 0; i < dong; i++) {
					Double gia = Double.valueOf(tCV.model_DoanhThuNgay.getValueAt(i, 4).toString());
					int soLuong = Integer.valueOf(tCV.model_DoanhThuNgay.getValueAt(i, 3).toString());
					tongTien += gia * soLuong;
				}
				tCV.text_Ngay.setText(tCV.txt_DoanhThuNgay.getText() + ":");
				tCV.lbl_TienDoanhThuNgay.setText(Integer.toString(tongTien));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Nhập sai định dạng dữ liệu.\nVui lòng kiểm tra lại!", "LỖI",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getSource() == tCV.btn_DoanhThuThang) {
			try {
				Date date = new SimpleDateFormat("MM/yyyy").parse(tCV.txt_DoanhThuThang.getText());
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
				String sql = "SELECT * FROM HangDaBan WHERE ngayBanHang like '" + sdf1.format(date) + "-%'";
				setData(sql, tCV.model_DoanhThuThang);
				int dong = tCV.model_DoanhThuThang.getRowCount();
				int tongTien = 0;
				for(int i = 0; i < dong; i++) {
					Double gia = Double.valueOf(tCV.model_DoanhThuThang.getValueAt(i, 4).toString());
					int soLuong = Integer.valueOf(tCV.model_DoanhThuThang.getValueAt(i, 3).toString());
					tongTien += gia * soLuong;
				}
				tCV.text_Thang.setText(tCV.txt_DoanhThuThang.getText() + ":");
				tCV.lbl_TienDoanhThuThang.setText(Integer.toString(tongTien));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Nhập sai định dạng dữ liệu.\nVui lòng kiểm tra lại!", "LỖI",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getSource() == tCV.btn_DoanhThuNam) {
			try {
				Date date = new SimpleDateFormat("yyyy").parse(tCV.txt_DoanhThuNam.getText());
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
				String sql = "SELECT * FROM HangDaBan WHERE ngayBanHang like '" + sdf1.format(date) + "-%-%'";
				setData(sql, tCV.model_DoanhThuNam);
				int dong = tCV.model_DoanhThuNam.getRowCount();
				int tongTien = 0;
				for(int i = 0; i < dong; i++) {
					Double gia = Double.valueOf(tCV.model_DoanhThuNam.getValueAt(i, 4).toString());
					int soLuong = Integer.valueOf(tCV.model_DoanhThuNam.getValueAt(i, 3).toString());
					tongTien += gia * soLuong;
				}
				tCV.text_Nam.setText(tCV.txt_DoanhThuNam.getText() + ":");
				tCV.lbl_TienDoanhThuNam.setText(Integer.toString(tongTien));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Nhập sai định dạng dữ liệu.\nVui lòng kiểm tra lại!", "LỖI",
						JOptionPane.ERROR_MESSAGE);
			}

			System.out.println(tCV.txt_DoanhThuNam.getText());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
