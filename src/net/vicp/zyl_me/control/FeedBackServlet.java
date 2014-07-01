package net.vicp.zyl_me.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vicp.zyl_me.model.FeedBackBean;
import net.vicp.zyl_me.model.FeedBackHandler;

public class FeedBackServlet extends HttpServlet {

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

		response.setContentType("text/html;");
		FeedBackHandler feedBackHandler = new FeedBackHandler();
		String add = request.getParameter("add");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String msg = request.getParameter("message");
		String ip = request.getParameter("ip");
		if (add != null) {
			if (name == null || subject == null || msg == null || email == null || ip == null || !feedBackHandler.addFeedBack(new FeedBackBean(name, subject, msg, email, ip))) {
				String error = "?error=feedbackaddwrong";
				request.getRequestDispatcher("contact.jsp" + error).forward(request, response);
				return;
			} else {
				request.getRequestDispatcher("contact.jsp").forward(request, response);
				return;
			}
		}
		ArrayList<FeedBackBean> arr = feedBackHandler.getFeedBacks();
		request.setAttribute("feedbackarr", arr);     
		request.getRequestDispatcher("feedback.jsp").forward(request, response);
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

		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
