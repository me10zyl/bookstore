<%@page import="net.vicp.zyl_me.model.GoodsBeanHandler"%>
<%@page import="net.vicp.zyl_me.model.GoodsBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	ArrayList<GoodsBean> spearr = new GoodsBeanHandler().getSpecialGoodsBean();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/content.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/special.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div id="content">
		<div id="content-left">
			<div id="special">
				<div class="gray">
					<img src="images/bullet1.gif"> 特别推荐
				</div>
				<%
					for (int i = 0; i < spearr.size(); i++) {
				%>
				<div class="item">
					<div class="item-left">
						<a href=<%="ShowDetailServlet?id="+spearr.get(i).getGoodsid()%> ><img src=<%="images/banner/"+spearr.get(i).getPhoto() %>></a>
					</div>
					<div class="item-right">
						<div class="box_top"></div>
						<div class="box_center">
							<div class="orange">简介:</div>
							<p class="details">
								<span class="special_icon"><img
									src="images/special_icon.gif" alt="" title=""> </span>
								<%=spearr.get(i).getBreifintroduction()%>
							</p>
							<div class="orange2">
								<a href=<%="ShowDetailServlet?id="+spearr.get(i).getGoodsid()%> class="orange2">--更多信息--</a>
							</div>
						</div>
						<div class="box_bottom"></div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<jsp:include page="content-right.jsp"></jsp:include>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
