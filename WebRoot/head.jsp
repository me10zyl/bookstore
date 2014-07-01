<%@page import="net.vicp.zyl_me.model.UserBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	HttpSession session_ = request.getSession();
	UserBean userBean = (UserBean) session.getAttribute("userBean");
	boolean isLogin = false;
	if (userBean != null) {
		isLogin = true;
	}
	String success = request.getParameter("success");
	if(success != null)
	{
		session_.setAttribute("userBean", null);
		isLogin = false;
	}
%>
<div id="header">
	<img src="images/logo.gif">
	<%
		if (isLogin) {
	%>
	<div class="welcome"><a href="myaccount.jsp">欢迎你，<%=userBean.getUsername()%></a>
		<a href="myaccount.jsp?error=logout">注销</a>
	</div>
	<%
		} else {
	%>
	<div id="login">
		<form action="LoginServlet" method="post">
			<div>
				账号: <input name="username">
			</div>
			<div>
				密码: <input name="password" type="password">
			</div>
			<div id="denglu">
				<input type="submit" value="登陆">
			</div>
		</form>
	</div>
	<%
		}
	%>
	<div id="menu">
		<ul>
			<li><a href="index.jsp" <% if(request.getRequestURI().contains("index.jsp")){ %>class="selected"<% } %>>主页</a></li>
			<li><a href="about.jsp" <% if(request.getRequestURI().contains("about.jsp")){ %>class="selected"<% } %>>关于</a></li>
			<li><a href="books.jsp" <% if(request.getRequestURI().contains("books.jsp")){ %>class="selected"<% } %>>书籍</a></li>
			<li><a href="special.jsp" <% if(request.getRequestURI().contains("special.jsp")){ %>class="selected"<% } %>>特别推荐</a></li>
			<li><a href="myaccount.jsp" <% if(request.getRequestURI().contains("myaccount.jsp")){ %>class="selected"<% } %>>我的账号</a></li>
			<li><a href="register.jsp" <% if(request.getRequestURI().contains("register.jsp")){ %>class="selected"<% } %>>注册</a></li>
			<li><a href="contact.jsp" <% if(request.getRequestURI().contains("contact.jsp")){ %>class="selected"<% } %>>留言</a></li>
		</ul>
	</div>
</div>