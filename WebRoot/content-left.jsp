<%@page import="net.vicp.zyl_me.model.GoodsBeanHandler"%>
<%@page import="net.vicp.zyl_me.model.GoodsBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	/* 	ArrayList<GoodsBean> ranarr = (ArrayList<GoodsBean>)request.getAttribute("ranarr");
	 if(ranarr == null || ranarr.size() != 2)
	 request.getRequestDispatcher("GetIndexGoodsServlet").forward(request, response); */
	GoodsBeanHandler goodsBeanHandler = new GoodsBeanHandler();
	ArrayList<GoodsBean> ranarr = goodsBeanHandler.getRandomGoodsBeans(2);
	GoodsBean goodsBean1 = ranarr.get(0);
	GoodsBean goodsBean2 = ranarr.get(1);
	ArrayList<GoodsBean> newarr = goodsBeanHandler.getNewGoodsBean();
%>
<div id="content-left">
	<div class="gray">
		<img src="images/bullet1.gif">好书一瞥
		<div class=""></div>
	</div>
	<%
		if (goodsBean1 != null && goodsBean2 != null) {
	%>
	<div class="item">
		<div class="item-left">
			<a href=<%="ShowDetailServlet?id=" + goodsBean1.getGoodsid()%>> <img
				src=<%="images/banner/" + goodsBean1.getPhoto()%>>
			</a>
		</div>
		<div class="item-right">
			<div class="box_top"></div>
			<div class="box_center">
				<div class="orange">简介:</div>
				<p class="details">
					<%=goodsBean1.getBreifintroduction()%>
				</p>
				<div class="orange2">
					<a href=<%="ShowDetailServlet?id=" + goodsBean1.getGoodsid()%>
						class="orange2">--更多信息--</a>
				</div>
			</div>
			<div class="box_bottom"></div>
		</div>
	</div>
	<div class="item">
		<div class="item-left">
			<a href=<%="ShowDetailServlet?id=" + goodsBean2.getGoodsid()%>> <img
				src=<%="images/banner/" + goodsBean2.getPhoto()%>>
			</a>
		</div>
		<div class="item-right">
			<div class="box_top"></div>
			<div class="box_center">
				<div class="orange">简介:</div>
				<p class="details">
					<%=goodsBean2.getBreifintroduction()%>
				</p>
				<div class="orange2">
					<a href=<%="ShowDetailServlet?id=" + goodsBean2.getGoodsid()%>
						class="orange2">--更多信息--</a>
				</div>
			</div>
			<div class="box_bottom"></div>
		</div>
	</div>
	<%
		}
	%>
	<div id="content-left-bottom">
		<div class="gray">
			<img src="images/bullet2.gif">新书推荐
		</div>
		<%
			for (int i = 0; i < newarr.size(); i++) {
		%>
		<div class="newbook">
			<div class="title"><%=newarr.get(i).getGoodsname()%></div>
			<div class="newbook-box">
				<a href=<%="ShowDetailServlet?id=" + newarr.get(i).getGoodsid()%>> <span class="new"> <img
						src="images/new_icon.gif">
				</span> <img src=<%="images/banner/" + newarr.get(i).getPhoto()%>>
				</a>
			</div>
		</div>
		<%
			}
		%>
	</div>
</div>