package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.HangHoa;
import model.SanPhamDaBan;

public class HangHoaDAO implements DAOInterface<HangHoa> {

	public static HangHoaDAO getInstance() {
		return new HangHoaDAO();
	}

	@Override
	public int insert(HangHoa t) {
		int ketQua = 0;
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "INSERT INTO HangHoa VALUES (?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMaSanPham());
			ps.setString(2, t.getTenSanPham());
			ps.setString(3, t.getNhaSanXuat());
			ps.setInt(4, t.getSoLuong());
			ps.setDouble(5, t.getGiaBan());
			ps.setDate(6, new Date(t.getNgaySanXuat().getTime()));
			ps.setDate(7, new Date(t.getHanSuDung().getTime()));

			ketQua = ps.executeUpdate();

			DBConnectionFactory.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(HangHoa t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "UPDATE HangHoa SET tenSanPham = ?, nhaSanXuat = ?, soLuong = ?, giaBan = ?, ngaySanXuat = ?, hanSuDung =? WHERE maSanPham = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTenSanPham());
			ps.setString(2, t.getNhaSanXuat());
			ps.setInt(3, t.getSoLuong());
			ps.setDouble(4, t.getGiaBan());
			ps.setDate(5, new Date(t.getNgaySanXuat().getTime()));
			ps.setDate(6, new Date(t.getHanSuDung().getTime()));
			ps.setString(7, t.getMaSanPham());

			ketQua = ps.executeUpdate();
			DBConnectionFactory.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	@Override
	public int delete(HangHoa t) {
		int ketQua = 0;
		try {
			Connection con = DBConnectionFactory.getConnection();

			String sql = "DELETE from HangHoa " + " WHERE maSanPham=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPham());

			ketQua = st.executeUpdate();

			DBConnectionFactory.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public ArrayList<HangHoa> selectAll() {
		ArrayList<HangHoa> list = new ArrayList<>();
		try {
			Connection conn = DBConnectionFactory.getConnection();
			String sql = "SELECT * FROM HangHoa ORDER BY tenSanPham ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				HangHoa hangHoa = new HangHoa();
				hangHoa.setMaSanPham(rs.getString("maSanPham"));
				hangHoa.setTenSanPham(rs.getString("tenSanPham"));
				hangHoa.setNhaSanXuat(rs.getString("nhaSanXuat"));
				hangHoa.setSoLuong(rs.getInt("soLuong"));
				hangHoa.setGiaBan(rs.getDouble("giaBan"));
				hangHoa.setNgaySanXuat(rs.getDate("ngaySanXuat"));
				hangHoa.setHanSuDung(rs.getDate("hanSuDung"));
				list.add(hangHoa);
			}

			DBConnectionFactory.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean selectById(String id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "SELECT * FROM HangHoa WHERE maSanPham = ?";

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
	public ArrayList<HangHoa> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<HangHoa> list = new ArrayList<>();
		try {
			Connection conn = DBConnectionFactory.getConnection();
			String sql = "SELECT * FROM HangHoa where tenSanPham COLLATE SQL_Latin1_General_CP1_CI_AS LIKE ? ORDER BY tenSanPham ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + condition + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HangHoa hangHoa = new HangHoa();
				hangHoa.setMaSanPham(rs.getString("maSanPham"));
				hangHoa.setTenSanPham(rs.getString("tenSanPham"));
				hangHoa.setNhaSanXuat(rs.getString("nhaSanXuat"));
				hangHoa.setSoLuong(rs.getInt("soLuong"));
				hangHoa.setGiaBan(rs.getDouble("giaBan"));
				hangHoa.setNgaySanXuat(rs.getDate("ngaySanXuat"));
				hangHoa.setHanSuDung(rs.getDate("hanSuDung"));
				list.add(hangHoa);
			}

			DBConnectionFactory.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public HangHoa selectById(HangHoa t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isProductExist(HangHoa t) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "SELECT * FROM HangHoa WHERE tenSanPham = ? and nhaSanXuat = ? and giaBan = ? and ngaySanXuat = ? and hanSuDung = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTenSanPham());
			ps.setString(2, t.getNhaSanXuat());
			ps.setDouble(3, t.getGiaBan());
			ps.setDate(4, new Date(t.getNgaySanXuat().getTime()));
			ps.setDate(5, new Date(t.getHanSuDung().getTime()));

			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public HangHoa selectIfExist(HangHoa t) {
		// TODO Auto-generated method stub
		HangHoa hangHoa = new HangHoa();
		try {
			Connection conn = DBConnectionFactory.getConnection();

			String sql = "SELECT * FROM HangHoa WHERE tenSanPham = ? and nhaSanXuat = ? and giaBan = ? and ngaySanXuat = ? and hanSuDung = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTenSanPham());
			ps.setString(2, t.getNhaSanXuat());
			ps.setDouble(3, t.getGiaBan());
			ps.setDate(4, new Date(t.getNgaySanXuat().getTime()));
			ps.setDate(5, new Date(t.getHanSuDung().getTime()));

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hangHoa.setMaSanPham(rs.getString("maSanPham"));
				hangHoa.setTenSanPham(rs.getString("tenSanPham"));
				hangHoa.setNhaSanXuat(rs.getString("nhaSanXuat"));
				hangHoa.setSoLuong(rs.getInt("soLuong"));
				hangHoa.setGiaBan(rs.getDouble("giaBan"));
				hangHoa.setNgaySanXuat(rs.getDate("ngaySanXuat"));
				hangHoa.setHanSuDung(rs.getDate("hanSuDung"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hangHoa;
	}
	@Override
	public ArrayList<HangHoa> selectBySQL(String sql) {
		// TODO Auto-generated method stub
		ArrayList<HangHoa> list = new ArrayList<>();
		try {
			Connection conn = DBConnectionFactory.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				HangHoa hangHoa = new HangHoa();
				hangHoa.setMaSanPham(rs.getString("maSanPham"));
				hangHoa.setTenSanPham(rs.getString("tenSanPham"));
				hangHoa.setNhaSanXuat(rs.getString("nhaSanXuat"));
				hangHoa.setSoLuong(rs.getInt("soLuong"));
				hangHoa.setGiaBan(rs.getDouble("giaBan"));
				hangHoa.setNgaySanXuat(rs.getDate("ngaySanXuat"));
				hangHoa.setHanSuDung(rs.getDate("hanSuDung"));
				list.add(hangHoa);
			}

			DBConnectionFactory.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ArrayList<SanPhamDaBan> selectByDay(String sql) {
		// TODO Auto-generated method stub
		ArrayList<SanPhamDaBan> listBan = new ArrayList<>();
		try {
			Connection conn = DBConnectionFactory.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				SanPhamDaBan sanPhamDaBan = new SanPhamDaBan();
				sanPhamDaBan.setMaSanPham(rs.getString("maSanPham"));
				sanPhamDaBan.setTenSanPham(rs.getString("tenSanPham"));
				sanPhamDaBan.setNhaSanXuat(rs.getString("nhaSanXuat"));
				sanPhamDaBan.setSoLuong(rs.getInt("soLuong"));
				sanPhamDaBan.setGiaBan(rs.getDouble("giaBan"));
				sanPhamDaBan.setNgayBanHang(rs.getDate("ngayBanHang"));
				listBan.add(sanPhamDaBan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBan;
	}
}
