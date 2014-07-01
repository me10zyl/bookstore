package net.vicp.zyl_me.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vicp.zyl_me.model.GoodsBean;
import net.vicp.zyl_me.model.GoodsBeanHandler;

public class ShowDetailServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		GoodsBeanHandler goodsBeanHandler = new GoodsBeanHandler(); 
		int _id = 0;
		if(id != null)
		{
			_id = Integer.parseInt(id);
		}
		if(_id != 0)
		{
			GoodsBean goodsBean = goodsBeanHandler.getGoodsBean(_id);
			request.setAttribute("goodsBean", goodsBean);
			request.getRequestDispatcher("details.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
