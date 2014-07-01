package net.vicp.zyl_me.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CartHandler {
	Connection connection;
	Statement statement;
	ResultSet resultset;
	HashMap<String, String> hashMap = new HashMap<String, String>();

	public void addNewGoods(String id, String qty) {
		if(!hashMap.containsKey(id))
			hashMap.put(id, qty);
	}

	public void clear() {
		hashMap.clear();
	}

	public void updateGoodsById(String id, String qty) {
		hashMap.put(id, qty);
	}
	
	public void AddGoods1QuantityById(String id) {
		hashMap.put(id, ""+(Integer.parseInt(hashMap.get(id))+1));
	}
	public void SubGoods1QuantityById(String id) {
		hashMap.put(id, ""+(Integer.parseInt(hashMap.get(id))-1));
		if("0".equals(hashMap.get(id)))
		{
			hashMap.remove(id);
		}
	}
	public int getGoodsCount()
	{
		return hashMap.size();
	}
	public int getTotalGoodsPrice()
	{
		int sum = 0;
		ArrayList<GoodsBean> goods = getGoods();
		Iterator<String> it = hashMap.keySet().iterator();
		for(int i = 0;i <goods.size();i++)
		{
			sum += Integer.parseInt(getGoodsCountById(goods.get(i).getGoodsid()+"")) * goods.get(i).getGoodsprice();//ÎÞÓï£¬HashMap.get(goods.get(i).getGoodsid()) = null, HashMap.get(goods.get(i).getGoodsid() + "") = 1
		}
		return sum;
	}
	public void removeGoodsById(String id)
	{
		hashMap.remove(id);
	}
	public String getGoodsCountById(String id)
	{
		return hashMap.get(id);
	}
	public ArrayList<GoodsBean> getGoods() {
		ArrayList<GoodsBean> arr = new ArrayList<GoodsBean>();
		if(hashMap.isEmpty())
		{
			return arr; 
		}
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			String sql = "select * from goods where goodsid in (";
			Iterator iterator = hashMap.keySet().iterator();
			while(iterator.hasNext())
			{
				sql += iterator.next();
				if(iterator.hasNext())
					 sql += ",";
				else
					sql += ")";
			}
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
}
