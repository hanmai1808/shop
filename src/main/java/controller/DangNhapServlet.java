package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MaHoa.MaHoa;
import dao.TaiKhoanDAOImpl;
import model.TaiKhoan;

/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private TaiKhoanDAOImpl taiKhoanDAO = new TaiKhoanDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("command").equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ten_tai_khoan = request.getParameter("ten_tai_khoan");
		String ten_dang_nhap = request.getParameter("ten_dang_nhap");
		String mat_khau = request.getParameter("mat_khau");
		String err = "";
		if (ten_dang_nhap.equals("") || mat_khau.equals("")) {
			err = "Vui Long nhap day du thong tin";
		} else {
			if (taiKhoanDAO.kiemTraDangNhap(ten_dang_nhap, MaHoa.maHoaMD5(mat_khau)) == false)
				err = "email hoac mat khau khong chinh xac";

		}
		if (err.length() > 0)
			request.setAttribute("err", err);
		String url = "/account.jsp";
		try {
			if (err.length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("username", ten_dang_nhap);
				url = "/index.jsp";
			} else {
				url = "/account.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
