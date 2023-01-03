package dao;
import java.util.ArrayList;

import model.SanPham;

public interface SanPhamDAO {
	//lay danh sach san pham dua theo ma danh muc
	public ArrayList<SanPham> getListProductByCategory(String ma_danh_muc);
	//hien thi thong tin chi tiet san pham
	public SanPham getChiTietSanPham(String ma_san_pham);
	
}
