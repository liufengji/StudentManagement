package com.yinggu.stupro.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 */
public class JDBCUtils {

	static ComboPooledDataSource cpds;

	static {
		// 1.创建连接池对象
		cpds = new ComboPooledDataSource("c3p0config");
	}

	/**
	 * 获取连接
	 * 
	 * @return 可用的连接对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		return cpds.getConnection();

	}

	/**
	 * 释放资源
	 * 
	 * @param set
	 * @param statement
	 * @param connection
	 * @throws Exception
	 */
	public static void closeConnection(ResultSet set, Statement statement, Connection connection) throws Exception {
		if (set != null)
			set.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

}
