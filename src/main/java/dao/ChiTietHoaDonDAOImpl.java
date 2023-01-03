package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.ChiTietHoaDon;

public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {

	@Override
	public void themChitietHD(ChiTietHoaDon cthd) {
		// TODO Auto-generated method stub
		Connection cons = DBConnect.getConnection();
		String sql = "INSERT INTO chi_tiet_hoa_don value (?,?,?,?,?,?);";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ps.setInt(1, cthd.getMa_chi_tiet_hoa_don());
			ps.setString(2, cthd.getHoa_don().getMa_hoa_don());
			ps.setString(3, cthd.getSan_pham().getMa_san_pham());
			ps.setInt(4, cthd.getSo_luong());
			ps.setDouble(5, cthd.getDon_gia());
			ps.setInt(6, cthd.getGiam_gia());
			ps.executeUpdate();
			cons.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(SanPhamDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
