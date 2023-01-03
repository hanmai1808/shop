package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.HoaDon;

public class HoaDonDAOImpl implements HoaDonDAO {

	public void themHoaDon(HoaDon hd) {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "INSERT INTO hoa_don value (?,?,?,?,?,?);";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setString(1, hd.getMa_hoa_don());
			ps.setString(2, hd.getTai_khoan().getMa_tai_khoan());
			ps.setString(3, hd.getDia_chi_giao_hang());
			ps.setString(4, hd.getPhuong_thuc_thanh_toan());
			ps.setTimestamp(5, hd.getNgay_mua_hang());
			ps.setInt(6, hd.getTinh_trang_don_hang());
			ps.executeUpdate();
			cons.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
