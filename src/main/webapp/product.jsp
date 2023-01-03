<%@page import="java.text.NumberFormat"%>
<%@ page import="dao.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	 <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</head>
<body>

<%
SanPhamDAOImpl sanPhamDAO=new SanPhamDAOImpl();

NumberFormat nf=NumberFormat.getInstance();
nf.setMinimumIntegerDigits(0);

GioHang cart = (GioHang) session.getAttribute("cart");
if(cart==null){
	cart=new GioHang();
	session.setAttribute("cart", cart);
}
%>
<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">San Pham</h2>
						<%for(SanPham sp: sanPhamDAO.getListProductByCategory(request.getParameter("ma_danh_muc"))){ %>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="<%=sp.getHinh_anh()%>" alt="" />
											<h2><%=nf.format(sp.getDon_gia())%> VND</h2>
											<p><%=sp.getTen_san_pham()%></p>
											<a href="GioHangServlet?command=add&ma_san_pham=<%=sp.getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Them vao gio hang</a>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
											<h2><%=nf.format(sp.getDon_gia())%>VND</h2>
											<p><%=sp.getTen_san_pham()%></p>
												<a href="GioHangServlet?command=insert&ma_san_pham=<%=sp.getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Them vao gio hang</a>
											</div>
										</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href="detail.jsp?ma_san_pham=<%=sp.getMa_san_pham()%>"><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
			<%} %>
</body>
</html>