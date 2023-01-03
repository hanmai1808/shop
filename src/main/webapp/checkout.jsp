<%@page import="java.util.Map"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.TreeMap"%>
<%@page import="model.GioHang"%>
<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="org.apache.catalina.ssi.ResponseIncludeWrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/bootstrapindex.html.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</head>
<body>
<%
if(session.getAttribute("username")==null){
	response.sendRedirect("account.jsp");
}else{
	GioHang cart = (GioHang) session.getAttribute("cart");
	if(cart==null){
		cart=new GioHang();
		session.setAttribute("cart", cart);
	}
	TreeMap<SanPham, Integer> list = cart.getList();
%>
	<jsp:include page="header.jsp"></jsp:include>
	<section id="cart_items">
		<div class="container">
		<div class="review-payment">
				<h2>Review & Payment</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<%
					for(Map.Entry<SanPham,Integer> ds:list.entrySet()){
					%>
						<tr>
							<td class="cart_product">
								<a href=""><img src=<%=ds.getKey().getHinh_anh() %> alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%=ds.getKey().getTen_san_pham() %></a></h4>
								<p><%=ds.getKey().getMa_san_pham() %></p>
							</td>
							<td class="cart_price">
								<p><%=ds.getKey().getDon_gia() %></p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="GioHangServlet?command=add&ma_san_pham=<%=ds.getKey().getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>"> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="<%=ds.getValue() %>" autocomplete="off" size="2">
									<a class="cart_quantity_down" href="GioHangServlet?command=sub&ma_san_pham=<%=ds.getKey().getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>"> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price"><%=ds.getValue()* ds.getKey().getDon_gia() %></p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="GioHangServlet?command=remove&ma_san_pham=<%=ds.getKey().getMa_san_pham() %>&cartID=<%=System.currentTimeMillis() %>"><i class="fa fa-times"></i></a>
							</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			<div class="payment-options">
					<span>
						<label><input type="checkbox"> Direct Bank Transfer</label>
					</span>
					<span>
						<label><input type="checkbox"> Check Payment</label>
					</span>
					<span>
						<label><input type="checkbox"> Paypal</label>
					</span>
				</div>
			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
							<p>Thong tin thanh toan</p>
							<form action="ThanhToanServlet" method="post">
								<p>dia chi giao hang</p>
								<textarea name="message"  placeholder="Notes about your order, Special Notes for Delivery" rows="5"></textarea>
								<input type="text">
								<select>
										<option>Thanh Toan</option>
										<option value="Thanh Toan Khi Giao Hang" >Thanh Toan Khi Giao Hang</option>
										<option value ="Chuyen Khoan Ngan Hang">Chuyen Khoan Ngan Hang</option>

								</select>
								<input type="hidden" value="<%=session.getAttribute("username") %>"/>
								<input type="submit" value="xac_nhan_thanh_toan" class="btn btn-primary">
							</form>
						</div>
					</div>
				
		</div>
	</section> <!--/#cart_items-->

	
	<jsp:include page="footer.jsp"></jsp:include>
	<%} %>
	</body>
	
</html>