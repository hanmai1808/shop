package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.TaiKhoan;

public class TaiKhoanDAOImpl implements TaiKhoanDAO{

	@Override
	public boolean kiemTraTaiKhoan(String ten_dang_nhap) {
		Connection cons=DBConnect.getConnection();
		String sql ="select ten_dang_nhap from tai_khoan where ten_dang_nhap='"+ten_dang_nhap+"';";
	
		try {
			PreparedStatement ps=cons.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			cons.close();
		}  catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
		}
		return false;
		
	}
	public void themTaiKhoan(TaiKhoan tk) {
		Connection cons = DBConnect.getConnection();
		String sql="INSERT INTO `shopping`.`tai_khoan` (`ma_tai_khoan`, `ten_tai_khoan`, `ten_dang_nhap`, `mat_khau`, `quyen_truy_cap`,`tinh_trang`) VALUES (?,?,?,?,?,?);";
		try {
			PreparedStatement ps =cons.prepareStatement(sql);
			ps.setString(1, tk.getMa_tai_khoan());
			ps.setString(2, tk.getTen_tai_khoan());
			ps.setString(3,tk.getTen_dang_nhap());
			ps.setString(4, tk.getMat_khau());
			ps.setInt(5, tk.getQuyen_truy_cap());
			ps.setInt(6, tk.getTinh_trang());
			ps.executeUpdate();
			cons.close();
			
		}  catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		
	}
	@Override
	public boolean kiemTraDangNhap(String ten_dang_nhap, String mat_khau) {
		Connection cons=DBConnect.getConnection();
		String sql="select * from tai_khoan where ten_dang_nhap='"+ten_dang_nhap+"' and mat_khau = '"+mat_khau+"';";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()){
				return true;
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	

}
