package model;

public class DanhMuc {
	private String ma_danh_muc;
	private String ten_danh_muc;
	private String danh_muc_cha;
	public DanhMuc(String ma_danh_muc, String ten_danh_muc, String danh_muc_cha) {
		super();
		this.ma_danh_muc = ma_danh_muc;
		this.ten_danh_muc = ten_danh_muc;
		this.danh_muc_cha = danh_muc_cha;
	}
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMa_danh_muc() {
		return ma_danh_muc;
	}
	public void setMa_danh_muc(String ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}
	public String getTen_danh_muc() {
		return ten_danh_muc;
	}
	public void setTen_danh_muc(String ten_danh_muc) {
		this.ten_danh_muc = ten_danh_muc;
	}
	public String getDanh_muc_cha() {
		return danh_muc_cha;
	}
	public void setDanh_muc_cha(String danh_muc_cha) {
		this.danh_muc_cha = danh_muc_cha;
	}
	
	

}
