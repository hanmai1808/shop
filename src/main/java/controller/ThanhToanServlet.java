package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import model.*;

/**
 * Servlet implementation class MuaHangServlet
 */
@WebServlet("/ThanhToanServlet")
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HoaDonDAOImpl hdDAO= new HoaDonDAOImpl();
    private ChiTietHoaDonDAOImpl cthdDAO = new ChiTietHoaDonDAOImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dia_chi_giao_hang = request.getParameter("dia_chi_giao_hang");
		String phuong_thuc_thanh_toan = request.getParameter("phuong_thuc_thanh_toan");
		String tai_khoan =  request.getParameter("tai_khoan");
		HttpSession session=request.getSession();
		GioHang cart =(GioHang) session.getAttribute("cart");
		try {
			Date date=new Date();
			String mhd=""+date.getTime();
			TaiKhoan tk=new TaiKhoan();
			HoaDon hd = new HoaDon(mhd, tk, dia_chi_giao_hang, phuong_thuc_thanh_toan, new Timestamp (new Date().getTime()), 0);
			hd.setMa_hoa_don(mhd);
			hdDAO.themHoaDon(hd);
			TreeMap<SanPham, Integer> list=cart.getList();
			for(Map.Entry<SanPham, Integer> ds:list.entrySet()) {
				SanPham sp=new SanPham();
				sp.setMa_san_pham(ds.getKey().getMa_san_pham());
				cthdDAO.themChitietHD(new ChiTietHoaDon(0, hd, sp, ds.getKey().getSo_luong(), ds.getKey().getDon_gia(), ds.getKey().getGiam_gia()));
				
			}
			response.sendRedirect("/shop/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
