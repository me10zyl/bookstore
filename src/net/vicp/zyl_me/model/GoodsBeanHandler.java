package net.vicp.zyl_me.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class GoodsBeanHandler {
	Connection connection;
	Statement statement;
	ResultSet resultset;
	public int getGoodsBeanCount() {
		int count = 0;
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select count(*) from goods");
			if (resultset.next())
				count = resultset.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public ArrayList<GoodsBean> getGoodsBeanByPage(int page, int pageSize) {
		ArrayList<GoodsBean> arr = new ArrayList<GoodsBean>();
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select top " + pageSize + " * from goods where goodsid not in (select top " + pageSize * (page - 1) + " goodsid from goods)");
			while (resultset.next())
				arr.add(new GoodsBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getFloat(5), resultset.getString(6), resultset.getString(7)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
	}
	public ArrayList<GoodsBean> getAllGoodsBean() {
		ArrayList<GoodsBean> arr = new ArrayList<GoodsBean>();
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from goods");
			while (resultset.next())
				arr.add(new GoodsBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getFloat(5), resultset.getString(6), resultset.getString(7)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
	}
	public ArrayList<GoodsBean> getRandomGoodsBeans(int size) {
		ArrayList<GoodsBean> arr = new ArrayList<GoodsBean>();
		Random ran = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int rowCount = getGoodsBeanCount();
		boolean isUsed[] = new boolean[rowCount];
		for(int i = 0;i < size;i++)
		{
			int num = 0;
			do
			{
				num = ran.nextInt(rowCount);
			}while(isUsed[num] == true);
			isUsed[num] = true;
			nums.add(num + 1);
		}
		
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			String sql = "select * from goods where goodsid in (";
			for(int i = 0;i < nums.size() - 1;i++)
			{
				sql += nums.get(i) + ",";
			}
			sql += nums.get(nums.size() - 1) + ")";
			resultset = statement.executeQuery(sql);
			while (resultset.next())
				arr.add(new GoodsBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getFloat(5), resultset.getString(6), resultset.getString(7)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
	}
	public ArrayList<GoodsBean> getNewGoodsBean() {
		ArrayList<GoodsBean> arr = new ArrayList<GoodsBean>();
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from goods where goodsid in (select goodsid from newgoods)");
			while (resultset.next())
				arr.add(new GoodsBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getFloat(5), resultset.getString(6), resultset.getString(7)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
	}
	public ArrayList<GoodsBean> getSpecialGoodsBean() {
		ArrayList<GoodsBean> arr = new ArrayList<GoodsBean>();
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from goods where goodsid in (select goodsid from specialgoods)");
			while (resultset.next())
				arr.add(new GoodsBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getFloat(5), resultset.getString(6), resultset.getString(7)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
	}
	public ArrayList<GoodsBean> getPromotionGoodsBean() {
		ArrayList<GoodsBean> arr = new ArrayList<GoodsBean>();
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from goods where goodsid in (select goodsid from promotiongoods)");
			while (resultset.next())
				arr.add(new GoodsBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getFloat(5), resultset.getString(6), resultset.getString(7)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
	}
	public GoodsBean getGoodsBean(int id) {
		GoodsBean goodsBean = null;
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from goods where goodsid=" + id);
			if (resultset.next())
				goodsBean = new GoodsBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getFloat(5), resultset.getString(6), resultset.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultset != null) {
					resultset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goodsBean;
	}
}
