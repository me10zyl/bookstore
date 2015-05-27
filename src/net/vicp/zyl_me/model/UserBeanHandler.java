package net.vicp.zyl_me.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserBeanHandler {
	Connection connection;
	Statement statement;
	ResultSet resultset;
	public boolean isUserNameExist(String username)
	{
		boolean isExist = false;
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from users where username='"+username+"' limit 1");
			if(resultset.next())
			{
				isExist = true;
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
		return isExist;
	}
	public boolean register(String username,String pwd) {
		boolean isSuccessed = false;
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			statement.execute("insert into users values (null,'"+username+"','"+pwd+"',null,null,null,null,null)");
			resultset = statement.executeQuery("select * from users where username='"+username+"' and password_='"+pwd+"' limit 1");
			if(resultset.next())
				isSuccessed = true;
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
	
	public boolean checkUser(String username,String pwd) {
		boolean isMember = false;
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select password_ from users where username='"+username+"' limit 1");
			if(resultset.next())
			{
				if(pwd.equals(resultset.getString(1)))
				{
					isMember = true;
				}
				
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
		return isMember;
	}
	public ArrayList<UserBean> getNewUsers()
	{
		ArrayList<UserBean> arr = new ArrayList<UserBean>();
		try{
			connection = new DBConnection().getConnection();
		statement = connection.createStatement();
		resultset = statement.executeQuery("select * from users order by userid desc limit 12");
		while(resultset.next())
		{
			arr.add(new UserBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getInt(4), resultset.getString(5), resultset.getString(6), resultset.getString(7), resultset.getString(8)));
		}
		}catch (SQLException e) {
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
	public UserBean getUserByUserName(String username)
	{
		UserBean userBean = null;
		try {
			connection = new DBConnection().getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from users where username='"+username+"' limit 1");
			if(resultset.next())
			{
				userBean = new UserBean(resultset.getLong(1), resultset.getString(2), resultset.getString(3), resultset.getInt(4), resultset.getString(5), resultset.getString(6), resultset.getString(7), resultset.getString(8));
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
		return userBean;
	}
}
