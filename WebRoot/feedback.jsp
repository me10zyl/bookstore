<%@page import="net.vicp.zyl_me.model.FeedBackBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	ArrayList<FeedBackBean> arr = (ArrayList<FeedBackBean>) request.getAttribute("feedbackarr");
	if (arr == null) {
		response.sendRedirect("FeedBackServlet");
		return;
	}
%>
<html>
<head>
<link rel="stylesheet" href="css/feedback.css">
</head>
<body>
	<div id="feedback">
		<%
			for (int i = 0; i < arr.size(); i++) {
		%>
		<div class="item">
			<div class="box_top"></div>
			<div class="box_center">
				<div class="orange">
					<%=arr.get(i).getName()%>
					|
					<%=arr.get(i).getEmail()%>
					|
					<%=arr.get(i).getIp()%></div>
				<p class="details"><font color=blue><%=arr.get(i).getSubject()%></font><br><%=arr.get(i).getMsg()%></p>
			</div>
			<div class="box_bottom"></div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>