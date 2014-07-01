package net.vicp.zyl_me.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vicp.zyl_me.model.CartHandler;
import net.vicp.zyl_me.model.GoodsBean;

public class CartServlet extends HttpServlet {

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
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		CartHandler cartHandler = (CartHandler) session.getAttribute("cartHandler");
		// 保持只有一个购物车【CartHandler]
		if (cartHandler == null) {
			// 说明第一次购物
			cartHandler = new CartHandler();
			request.getSession().setAttribute("cartHandler", cartHandler);
		}
		if (id != null)// 不是查看，是添加商品或删除商品
		{
			if ("del".equals(action)) {
				cartHandler.removeGoodsById(id);
			} else if ("add".equals(action)) {
				cartHandler.AddGoods1QuantityById(id);
			} else if ("sub".equals(action)) {
				cartHandler.SubGoods1QuantityById(id);
			} else// 添加新货物
			{
				cartHandler.addNewGoods(id, "1");
			}
		}
		ArrayList<GoodsBean> cart = cartHandler.getGoods();
		ArrayList<Integer> goods = new ArrayList<Integer>();
		for(int i = 0;i < cart.size();i++)
			goods.add(Integer.parseInt(cartHandler.getGoodsCountById(cart.get(i).getGoodsid()+"")));
		request.setAttribute("cart", cart);
		request.setAttribute("goodsNums",goods);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
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
