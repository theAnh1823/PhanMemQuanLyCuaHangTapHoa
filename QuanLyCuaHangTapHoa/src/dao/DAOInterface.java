package dao;

import java.util.ArrayList;

import model.HangHoa;
import model.SanPhamDaBan;

public interface DAOInterface<T> {

	public int insert(T t);

	public int update(T t);

	public int delete(T t);

	public ArrayList<T> selectAll();

	public T selectById(T t);

	public ArrayList<T> selectByCondition(String condition);

	boolean selectById(String id);
	
	boolean isProductExist(T t);

	HangHoa selectIfExist(HangHoa t);

	ArrayList<SanPhamDaBan> selectByDay(String sql);

	ArrayList<HangHoa> selectBySQL(String sql);
}
