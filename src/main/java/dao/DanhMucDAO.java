package dao;

import java.util.ArrayList;

import model.DanhMuc;

public interface DanhMucDAO {
	//load danh sach danh muc cha
	public ArrayList<DanhMuc> getListDanhMucCha();
	// load danh sach danh muc con
	public ArrayList<DanhMuc> getListDanhMucCon(String ma_danh_muc);
	
	

}
