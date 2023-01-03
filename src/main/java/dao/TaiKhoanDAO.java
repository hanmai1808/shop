package dao;

import model.TaiKhoan;

public interface TaiKhoanDAO {
	public boolean kiemTraTaiKhoan(String ten_dang_nhap);
	public void themTaiKhoan (TaiKhoan tk);
	public boolean kiemTraDangNhap (String ten_dang_nhap, String mat_khau);

}
