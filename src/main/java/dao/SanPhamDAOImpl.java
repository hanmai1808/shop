package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.DanhMuc;
import model.SanPham;

public class SanPhamDAOImpl implements SanPhamDAO{

	@Override
	public ArrayList<SanPham> getListProductByCategory(String ma_danh_muc) {
		Connection connection=DBConnect.getConnection();
		String sql="select * from san_pham where ma_danh_muc = '"+ma_danh_muc+"'";
		ArrayList<SanPham> arr= new ArrayList<>();
		
		try {
			PreparedStatement ps= connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				SanPham sp=new SanPham();
				sp.setMa_san_pham(rs.getString("ma_san_pham"));
				DanhMuc dm=new DanhMuc(rs.getString("ma_danh_muc"),"","");
				sp.setDanh_muc(dm);
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));
				arr.add(sp);
				
			}
			connection.close();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
		}
		
				
		return arr;
	}

	@Override
	public SanPham getChiTietSanPham(String ma_san_pham) {
		
		Connection connection=DBConnect.getConnection();
		String sql="select * from san_pham where ma_san_pham = '"+ma_san_pham+"'";
		SanPham sp=new SanPham();
		try {
			PreparedStatement ps= connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				sp.setMa_san_pham(rs.getString("ma_san_pham"));
				DanhMuc dm=new DanhMuc(rs.getString("ma_danh_muc"),"","");
				sp.setDanh_muc(dm);
				sp.setTen_san_pham(rs.getString("ten_san_pham"));
				sp.setHinh_anh(rs.getString("hinh_anh"));
				sp.setSo_luong(rs.getInt("so_luong"));
				sp.setMo_ta(rs.getString("mo_ta"));
				sp.setDon_gia(rs.getDouble("don_gia"));
				sp.setGiam_gia(rs.getInt("giam_gia"));
				
				
			}
			connection.close();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
		}
		
				
		return sp;
	}

}
