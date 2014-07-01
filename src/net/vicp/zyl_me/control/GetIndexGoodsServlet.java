package net.vicp.zyl_me.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vicp.zyl_me.model.GoodsBean;
import net.vicp.zyl_me.model.GoodsBeanHandler;

public class GetIndexGoodsServlet extends HttpServlet {

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

		 GoodsBeanHandler goodsBeanHandler = new GoodsBeanHandler();
		 Random ran = new Random();
		 ArrayList<GoodsBean> ranarr = goodsBeanHandler.getRandomGoodsBeans(2);
		 ArrayList<GoodsBean> newarr = new ArrayList<GoodsBean>();
		 ArrayList<GoodsBean> proarr = new ArrayList<GoodsBean>();
		 request.setAttribute("ranarr", ranarr);
		 request.getRequestDispatcher("index.jsp").forward(request, response);
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
