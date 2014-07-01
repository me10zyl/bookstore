package net.vicp.zyl_me.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FeedBackHandler {
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;

	public ArrayList<FeedBackBean> getFeedBacks() {
		ArrayList<FeedBackBean> arr = new ArrayList<FeedBackBean>();
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from feedback order by feedid desc");
			while (resultset.next())
				arr.add(new FeedBackBean(resultset.getLong(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6)));
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
	public boolean addFeedBack(FeedBackBean fbb)
	{
		boolean isSuccessed = false;
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select count(*) from feedback");
			int count = 0;
			if(resultset.next())
				count = resultset.getInt(1);
			statement.execute("insert into feedback values ('"+fbb.getName()+"','"+fbb.getSubject()+"','"+fbb.getMsg()+"','"+fbb.getEmail()+"','"+fbb.getIp()+"')");
			resultset = statement.executeQuery("select count(*) from feedback");
			if(resultset.next())
			{
				if(resultset.getInt(1) == count + 1)
					isSuccessed = true;
			}
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
		return isSuccessed;
	}
}
