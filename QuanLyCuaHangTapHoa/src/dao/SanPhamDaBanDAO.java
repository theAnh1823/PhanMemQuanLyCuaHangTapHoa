package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.HangHoa;
import model.SanPhamDaBan;

public class SanPhamDaBanDAO implements DAOInterface<SanPhamDaBan>{
	
	public static SanPhamDaBanDAO getInstance() {
		return new SanPhamDaBanDAO();
	}
	
	@Override
	public int insert(SanPhamDaBan t) {
		int ketQua = 0;
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "INSERT INTO SanPhamDaBan VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMaSanPham());
			ps.setString(2, t.getTenSanPham());
			ps.setString(3, t.getNhaSanXuat());
			ps.setInt(4, t.getSoLuong());
			ps.setDouble(5, t.getGiaBan());
			ps.setDate(6, new Date(t.getNgaySanXuat().getTime()));
			ps.setDate(7, new Date(t.getHanSuDung().getTime()));
			ps.setDate(8, new Date(t.getNgayBanHang().getTime()));
	        
			ketQua = ps.executeUpdate();

			DBConnectionFactory.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(SanPhamDaBan t) {
		int ketQua = 0;
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "UPDATE SanPhamDaBan SET soLuong = soLuong + ?, ngayBanHang = ? WHERE maSanPham = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, t.getSoLuong());
	        ps.setDate(2, new Date(t.getNgayBanHang().getTime()));
			ps.setString(3, t.getMaSanPham());

			ketQua = ps.executeUpdate();
			DBConnectionFactory.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int delete(SanPhamDaBan t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SanPhamDaBan> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPhamDaBan selectById(SanPhamDaBan t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SanPhamDaBan> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectById(String id) {
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "SELECT * FROM SanPhamDaBan WHERE maSanPham = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	@Override
	public boolean isProductExist(SanPhamDaBan t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HangHoa selectIfExist(HangHoa t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HangHoa> selectBySQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SanPhamDaBan> selectByDay(String day) {
		// TODO Auto-generated method stub
		return null;
	}




}
