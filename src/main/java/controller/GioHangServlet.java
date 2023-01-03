package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SanPhamDAOImpl;
import model.GioHang;
import model.SanPham;

/**
 * Servlet implementation class GioHang
 */
@WebServlet("/GioHangServlet")
public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private SanPhamDAOImpl sanPhamDAO= new SanPhamDAOImpl();
	
    public GioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//https://www.w3schools.blog/httpsession-in-servlet
		HttpSession session = request.getSession();
		GioHang cart = (GioHang) session.getAttribute("cart");
		String msp=request.getParameter("ma_san_pham");
		String command= request.getParameter("command");
		ArrayList<Long> listBuy=null;
		String url="/cart.jsp";
		
		try {
		listBuy=(ArrayList<Long>) session.getAttribute("cartID");
		long idBuy=0;
		if(request.getParameter("cartID") != null) {
			idBuy=Long.parseLong(request.getParameter("cartID"));
		}
			SanPham sp= sanPhamDAO.getChiTietSanPham(msp);
			switch(command) {
				case "insert":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cartID", listBuy);
					}
					if(listBuy.indexOf(idBuy)==-1) {
						cart.addToCart(sp, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "add":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cartID", listBuy);
					}
					if(listBuy.indexOf(idBuy)==-1) {
						cart.addToCart(sp, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "sub":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cartID", listBuy);
					}
					if(listBuy.indexOf(idBuy)==-1) {
						cart.subToCart(sp, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "remove":
					cart.removeToCart(sp);
					url="/cart.jsp";
					break;
				default:
					break;
					
				
			}
			RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
		
		} catch (Exception e){
			
		
		}
	}

}
