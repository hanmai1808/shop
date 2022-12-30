package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.net.ssl.SSLException;


import connect.DBConnect;
import model.DanhMuc;

public class DanhMucDAOImpl implements DanhMucDAO {
	// implement all abstract method

	@Override
	public ArrayList<DanhMuc> getListDanhMucCha() {
		Connection connection=DBConnect.getConnection();
		String sql="SELECT * FROM danh_muc WHERE danh_muc_cha is null;";
		ArrayList<DanhMuc> arr= new ArrayList<>();
		
		try {
			PreparedStatement ps= connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				DanhMuc dm=new DanhMuc();
				dm.setMa_danh_muc(rs.getString("ma_danh_muc"));
				dm.setTen_danh_muc(rs.getString("ten_danh_muc"));
				dm.setDanh_muc_cha(rs.getString("danh_muc_cha"));
				arr.add(dm);
				
			}
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return arr;
	}

	@Override
	public ArrayList<DanhMuc> getListDanhMucCon(String ma_danh_muc) {
		Connection connection=DBConnect.getConnection();
		String sql="select * from danh_muc where danh_muc_cha ='10001';";
		ArrayList<DanhMuc> arr= new ArrayList<>();
		
		try {
			PreparedStatement ps= connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				DanhMuc dm=new DanhMuc();
				dm.setMa_danh_muc(rs.getString("ma_danh_muc"));
				dm.setTen_danh_muc(rs.getString("ten_danh_muc"));
				dm.setDanh_muc_cha(rs.getString("danh_muc_cha"));
				arr.add(dm);
				
			}
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return arr;
	}

}
