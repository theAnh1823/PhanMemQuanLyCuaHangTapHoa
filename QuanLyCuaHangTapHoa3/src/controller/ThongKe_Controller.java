package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.TrangChu_Controller;
import dao.DBConnectionFactory;
import dao.HangHoaDAO;
import view.TrangChu_View;
import model.HangHoa;

public class ThongKe_Controller implements MouseListener{
	private TrangChu_Controller tCC;
	private TrangChu_View tCV;
	private ArrayList<HangHoa> list;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ThongKe_Controller(TrangChu_View tCV) {
		super();
		this.tCV = tCV;
	}
	public void setTable(String sql) {
		list = HangHoaDAO.getInstance().selectBySQL(sql);
		tCV.model_HangHoaLoc.getDataVector().removeAllElements();
		for (HangHoa hangHoa : list) {
			tCV.model_HangHoaLoc.addRow(new Object[] { hangHoa.getMaSanPham(), hangHoa.getTenSanPham(),
					hangHoa.getNhaSanXuat(), hangHoa.getSoLuong(), hangHoa.getGiaBan(),
					sdf.format(hangHoa.getNgaySanXuat()), sdf.format(hangHoa.getHanSuDung())});
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String luaChon = tCV.comboBox_Loc.getSelectedItem().toString();
		if(e.getSource() == tCV.btn_Loc) {
			if(luaChon.equals("Lọc danh sách những sản phẩm đã quá hạn sử dụng")) {
				setTable("select * from HangHoa where getdate() >= hanSuDung");
				if(tCV.model_HangHoaLoc.getRowCount() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "Không có sản phẩm hết hạn!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			}else if(luaChon.equals("Lọc top 20 sản phẩm có số lượng nhỏ nhất trong kho")) {
				setTable("select top 20 * from HangHoa order by soLuong asc, tenSanPham asc");
			}else if(luaChon.equals("Lọc top 20 sản phẩm có số lượng lớn nhất trong kho")) {
				setTable("select top 20 * from HangHoa order by soLuong desc, tenSanPham asc");
			}else if(luaChon.equals("Lọc top 20 sản phẩm có ngày sản xuất gần với ngày hiện tại nhất")) {
				setTable("select top 20 * from HangHoa where ngaySanXuat <= getdate() order by ngaySanXuat desc");
			}
		}else if(e.getSource() == tCV.btn_Xoa_ThongKe) {
			if(luaChon.equals("Lọc danh sách những sản phẩm đã quá hạn sử dụng")) {
				int result = JOptionPane.showConfirmDialog(tCV,"Bạn chắc chắn muốn xóa chứ", "Cảnh báo",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	setTable("delete from HangHoa where getdate() >= hanSuDung");
			            }else if (result == JOptionPane.NO_OPTION){
			            	System.out.println("You selected: No");
			            }else {
			            	System.out.println("None selected");
			            }
			}
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