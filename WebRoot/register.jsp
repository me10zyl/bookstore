<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String error = request.getParameter("error");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/content.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/register.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div id="content">
	<div id="content-left">   <div class="gray">
                <img src="images/bullet1.gif">
                注册
                </div>
                <div id="reg_top">
                    <div class="item">
                    <div class="box_top"></div>
                    <div class="box_center">
                    <div class="orange">致辞:</div>
                    <p class="details">
                    欢迎加入Book Store商店，在这里你可以买到很多很多好玩又好看的书。不仅能增加你的知识，还能边看边玩。    
                    </p>
                    </div>
                    <div class="box_bottom"></div>
                    </div>
                </div>
               <div id="register">
               <% 
               if (error != null) {
								if (error.equals("usernameexist")) {
									out.println("<div style='font-size:15px;margin:3px 0 3px 1px;color:red;'>用户已存在!</div>");
								}else if(error.equals("registererror"))
								{
									out.println("<div style='font-size:15px;margin:3px 0 3px 1px;color:red;'>注册失败!</div>");
								}
								else if(error.equals("noagree"))
								{
									out.println("<div style='font-size:15px;margin:3px 0 3px 1px;color:red;'>必须同意协议!</div>");
								}
							}
					%>
                <form action="RegisterServlet" method="post">
                    <div class="reg_title">填写你的信息</div>
                    <div class="row1">
                        <label>用户名:</label>&nbsp;
                        <input name="username">
                    </div>
                    <div class="row2">
                        <label>密&nbsp;&nbsp;&nbsp;码:</label>&nbsp;
                        <input type="password" name="password">
                    </div>
                    <iframe src="protocal.html" width="360" height="200"></iframe>
                    <div class="row3">
                    	<span>
                        <input type="checkbox" name="agree" value="true">
                        <font color='#1961c4'>同意协议</font></span>
                        </input>
                    </div>
                    <div class="row4">
                        <input type="submit" value="注册">
                    </div>
                </form>
            </div>
               </div>
	<jsp:include page="content-right.jsp"></jsp:include>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
