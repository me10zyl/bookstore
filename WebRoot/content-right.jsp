<%@page import="net.vicp.zyl_me.model.UserBeanHandler"%>
<%@page import="net.vicp.zyl_me.model.CartHandler"%>
<%@page import="net.vicp.zyl_me.model.GoodsBeanHandler"%>
<%@page import="net.vicp.zyl_me.model.GoodsBean"%>
<%@page import="net.vicp.zyl_me.model.UserBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	ArrayList<GoodsBean> proarr = new GoodsBeanHandler().getPromotionGoodsBean();
	CartHandler cartHandler = (CartHandler) session.getAttribute("cartHandler");
	ArrayList<UserBean> newuserarr = new UserBeanHandler().getNewUsers();
	// 保持只有一个购物车[CartHandler]
	if (cartHandler == null) {
		cartHandler = new CartHandler();
		request.getSession().setAttribute("cartHandler", cartHandler);
	}
	int price_sum = cartHandler.getTotalGoodsPrice();
	int count = cartHandler.getGoodsCount();
%>
<div id="content-right">
	<div id="cart">
		<img src="images/cart.gif">我的购物车
	</div>
	<div id="total">
		<%=count%>
		x 物品 <span class="red">| 总共: <%=price_sum%>￥
		</span>
	</div>
	<div id="view">
		<a href="CartServlet" class="red">查看购物车</a>
	</div>
	<div class="middle">
		<img src="images/border.gif">
	</div>
	<div class="middle" id="banner">
		<script type="text/javascript" src="zyl.js"></script>
	</div>
	<div class="middle">
		<img src="images/border.gif">
	</div>
	<br />
	<div id="bottom" class="gray">
		<div id="left">
			<img src="images/bullet4.gif">促销:
			<%
				for (int i = 0; i < proarr.size(); i++) {
			%>
			<div class="promotebook">
				<div class="title"><%=proarr.get(i).getGoodsname()%></div>
				<div class="promotebook-box">
					<a href=<%="ShowDetailServlet?id=" + proarr.get(i).getGoodsid()%>>
						<span class="promote"> <img src="images/promo_icon.gif">
					</span> <img src=<%="images/banner/" + proarr.get(i).getPhoto()%>>
					</a>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div id="right">
		<img src="images/bullet3.gif">种类:
		<table>
			<tr>
				<td><a href="##">C++</a></td>
			</tr>
			<tr>
				<td><a href="##">JAVA</a></td>
			</tr>
			<tr>
				<td><a href="##">JAVASCRIPT</a></td>
			</tr>
			<tr>
				<td><a href="##">ASP .NET</a></td>
			</tr>
			<tr>
				<td><a href="##">AJAX</a></td>
			</tr>
		</table>
		<div>
			<img src="images/bullet6.gif">新用户:
			<table class="flag">
				<%
						for (UserBean userBean : newuserarr) {
				%>
				<tr>
					<td><%=userBean.getUsername()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</div>