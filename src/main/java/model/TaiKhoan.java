package model;

import java.util.Date;

public class TaiKhoan {
	private String ma_tai_khoan;
	private String ten_tai_khoan;
	private String ten_dang_nhap;
	private String mat_khau;
	private int quyen_truy_cap;
	private int tinh_trang;
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String ma_tai_khoan, String ten_tai_khoan, String ten_dang_nhap, String mat_khau,
			int quyen_truy_cap, int tinh_trang) {
		super();
		this.ma_tai_khoan = ma_tai_khoan;
		this.ten_tai_khoan = ten_tai_khoan;
		this.ten_dang_nhap = ten_dang_nhap;
		this.mat_khau = mat_khau;
		this.quyen_truy_cap = quyen_truy_cap;
		this.tinh_trang = tinh_trang;
	}
	public String getMa_tai_khoan() {
		return ma_tai_khoan;
	}
	public void setMa_tai_khoan(String ma_tai_khoan) {
		this.ma_tai_khoan = ma_tai_khoan;
	}
	public String getTen_tai_khoan() {
		return ten_tai_khoan;
	}
	public void setTen_tai_khoan(String ten_tai_khoan) {
		this.ten_tai_khoan = ten_tai_khoan;
	}
	public String getTen_dang_nhap() {
		return ten_dang_nhap;
	}
	public void setTen_dang_nhap(String ten_dang_nhap) {
		this.ten_dang_nhap = ten_dang_nhap;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	public int getQuyen_truy_cap() {
		return quyen_truy_cap;
	}
	public void setQuyen_truy_cap(int quyen_truy_cap) {
		this.quyen_truy_cap = quyen_truy_cap;
	}
	public int getTinh_trang() {
		return tinh_trang;
	}
	public void setTinh_trang(int tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
	
	}
	
	

