package net.vicp.zyl_me.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vicp.zyl_me.model.UserBeanHandler;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String agree_ = request.getParameter("agree");
		boolean agree = false;
		if ("true".equals(agree_)) {
			agree = true;
		}
		UserBeanHandler userBeanHandler = new UserBeanHandler();
		if (!agree)
		{
			request.getRequestDispatcher("register.jsp?error=noagree").forward(request, response);
			return ;
		}
		if (userBeanHandler.isUserNameExist(username)) {
			request.getRequestDispatcher("register.jsp?error=usernameexist").forward(request, response);
		} else {
			if (userBeanHandler.register(username, password)) {
				request.getRequestDispatcher("myaccount.jsp?success=userregister&username="+username).forward(request, response);
			} else {
					request.getRequestDispatcher("register.jsp?error=registererror").forward(request, response);
			}
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
