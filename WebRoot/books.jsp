<%@page import="net.vicp.zyl_me.model.GoodsBean"%>
<%@page import="net.vicp.zyl_me.model.GoodsBeanHandler"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	GoodsBeanHandler goodsBeanHandler = new GoodsBeanHandler();
	String __page = (String) request.getAttribute("page");
	int _page = 1;
	final int _pageSize = 9;
	int _pageRow = goodsBeanHandler.getGoodsBeanCount();
	int _pageCount = _pageRow % _pageSize == 0 ? _pageRow / _pageSize : _pageRow / _pageSize + 1;
	if (__page != null) {
		_page = Integer.parseInt(__page);
	}
	ArrayList<GoodsBean> arr = goodsBeanHandler.getGoodsBeanByPage(_page, _pageSize);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/content.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/books.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div id="content">
		<div id="content-left">
			<div id="books">
				<div class="title">
					<a href="index.jsp">主页</a>>> 所有书籍
				</div>
				<div class="gray">
					<img src="images/bullet1.gif">全部书籍
				</div>
				<%
					for (int i = 0; i < arr.size(); i++) {
						GoodsBean goodsBean = arr.get(i);
				%>
				<div class="book">
					<div class="title"><%=goodsBean.getGoodsname()%></div>
					<div class="book-box">
						<a href=<%="ShowDetailServlet?id="+goodsBean.getGoodsid()%>> <img
							src=<%="images/banner/" + goodsBean.getPhoto()%>>
						</a>
					</div>
				</div>
				<%
					}
				%>
				<div class="pagination">
					<%
						final int _pageContraints = 6;
						if (_page == 1)
							out.println("<span class='disabled noborder'>&lt;&lt;</span>");
						else
							out.println("<a class='noborder' href='ShowGoodsServlet?page=" + (_page - 1) + "'><span>&lt;&lt;</span></a>");
						if (_pageCount <= _pageContraints)
							for (int i = 1; i <= _pageCount; i++) {
								if (_page == i)
									out.println("<span class='current'>" + i + "</span>");
								else
									out.println("<a href='ShowGoodsServlet?page=" + i + "'>" + i + "</a>");
							}
						else {
							if(_page >= 3 && _pageCount - _page > 4)
							{
								for (int i = _page - 1 ; i <= _page + 1; i++) {
									if (_page == i)
										out.println("<span class='current'>" + i + "</span>");
									else
										out.println("<a href='ShowGoodsServlet?page=" + i + "'>" + i + "</a>");
								}
							}else
							{
								for (int i = 1 ; i <= 3; i++) {
									if (_page == i)
										out.println("<span class='current'>" + i + "</span>");
									else
										out.println("<a href='ShowGoodsServlet?page=" + i + "'>" + i + "</a>");
								}
							}
							if(_pageCount - _page <= 4 && _page >= 3)
							{
								out.println("...");
							}
							if(_pageCount - _page <= 4)
							{
								for (int i = _pageCount - 4; i <= _pageCount; i++) {
									if (_page == i)
										out.println("<span class='current'>" + i + "</span>");
									else
										out.println("<a href='ShowGoodsServlet?page=" + i + "'>" + i + "</a>");
								}
							}
							else
							{
								out.println("...");
								for (int i = _pageCount - 2; i <= _pageCount; i++) {
									if (_page == i)
										out.println("<span class='current'>" + i + "</span>");
									else
										out.println("<a href='ShowGoodsServlet?page=" + i + "'>" + i + "</a>");
								}
							}
						}
						if (_page == _pageCount)
							out.println("<span class='disabled noborder'>&gt;&gt;</span>");
						else
							out.println("<a  class='noborder' href='ShowGoodsServlet?page=" + (_page + 1) + "'><span>&gt;&gt;</span></a>");
					%>

					<!-- <span class='current'>1</span> <a href="ShowGoodsServlet?page=3">3</a>…
					<a href="#?page=199">10</a> <a href="#?page=200">11</a> <a
						href="#?page=2"></a> -->
				</div>
			</div>
		</div>
		<jsp:include page="content-right.jsp"></jsp:include>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
