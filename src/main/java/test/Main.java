package test;

import javax.servlet.http.HttpSession;

import dao.*;
import model.GioHang;



public class Main {
	public static void main(String[] args) {
		DanhMucDAOImpl dm=new DanhMucDAOImpl();
		SanPhamDAOImpl sp=new SanPhamDAOImpl();
		TaiKhoanDAOImpl tk=new TaiKhoanDAOImpl();
		

		String a="";
		if(a=="")
			System.out.println(1);
		System.out.println(tk.kiemTraTaiKhoan("admin@gmail.com"));
	
}
}
