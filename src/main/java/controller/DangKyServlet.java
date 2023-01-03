package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaiKhoanDAOImpl;
import model.TaiKhoan;
import MaHoa.MaHoa;

/**
 * Servlet implementation class DangKyServlet
 */
@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public DangKyServlet() {
		super(); 
   }
		
   private TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();
   
        // TODO Auto-generated constructor stub

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ten_tai_khoan = request.getParameter("ten_tai_khoan");
		String ten_dang_nhap = request.getParameter("ten_dang_nhap");
		String mat_khau = request.getParameter("mat_khau");
		
		String ten_tai_khoan_err="",ten_dang_nhap_err="",mat_khau_err="";
		if(ten_tai_khoan.equals("")) {
			ten_tai_khoan_err="Vui long nhap ho ten cua ban";
		}
		if(ten_tai_khoan_err.length()>0) {
			request.setAttribute("ten_tai_khoan_err", ten_tai_khoan_err);
			
		}
		if(ten_dang_nhap.equals("")) {
			ten_dang_nhap_err="Vui long nhap email cua ban";
		} else {
			if(taiKhoanDAO.kiemTraTaiKhoan(ten_dang_nhap)==true) {
				ten_dang_nhap_err="Dang ki roi dang nhap thoi";
			}
		}
		if(ten_dang_nhap_err.length()>0) {
			request.setAttribute("ten_dang_nhap_err", ten_dang_nhap_err);
			
		}
		if(mat_khau.equals("")) {
			mat_khau_err +="Vui long nhap pass word cua ban";
		}
		if(mat_khau_err.length()>0) {
			request.setAttribute("mat_khau_err", mat_khau_err);
		}
		request.setAttribute("ten_tai_khoan", ten_tai_khoan);
		request.setAttribute("ten_dang_nhap", ten_dang_nhap);
		request.setAttribute("mat_khau", mat_khau);
		
		String url="/account.jsp";
		
		try {
			if(mat_khau_err.length()==0 && ten_dang_nhap_err.length()==0&& ten_tai_khoan_err.length()==0) {
				Date id= new Date();
				TaiKhoan tk= new TaiKhoan(""+id.getTime(),ten_tai_khoan, ten_dang_nhap, MaHoa.maHoaMD5(mat_khau),2,1);
				taiKhoanDAO.themTaiKhoan(tk);
				url="/index.jsp";
			} else {
				url="/account.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
