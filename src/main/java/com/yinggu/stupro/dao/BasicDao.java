package com.yinggu.stupro.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yinggu.stupro.utils.JDBCUtils;
/**
/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * DAO层有哪些功能
 *   1、增删改
 *   2、查询单个对象
 *   3、查询单个值
 *   4、查询多个对象
 */
public class BasicDao<T> {
	
	Class<T> clazz;
	QueryRunner qr;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BasicDao() {
		qr = new QueryRunner();

		// 获取父类的泛型
		Class c = this.getClass();// AccountDao.class
		ParameterizedType type = (ParameterizedType) c.getGenericSuperclass();// BasicDao<Account>
		clazz = (Class<T>) type.getActualTypeArguments()[0];// Account

	}

	/**
	 * 增删改
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public int update(String sql, Object... objects) throws Exception {
		Connection connection = JDBCUtils.getConnection();
		int update = qr.update(connection, sql, objects);
		connection.close();
		return update;
	}

	/**
	 * 查询单个对象
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public T querySingle(String sql, Object... objects) throws Exception {
		Connection connection = JDBCUtils.getConnection();
		T t = qr.query(connection, sql, new BeanHandler<T>(clazz), objects);
		connection.close();
		return t;

	}

	/**
	 * 查询多个对象
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public List<T> queryList(String sql, Object... objects) throws Exception {
		Connection connection = JDBCUtils.getConnection();
		List<T> list = qr.query(connection, sql, new BeanListHandler<T>(clazz), objects);
		connection.close();
		return list;

	}

	/**
	 * 查询一个值
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 * @throws Exception
	 */
	public Object scalar(String sql, Object... objects) throws Exception {
		Connection connection = JDBCUtils.getConnection();
		Object query = qr.query(connection, sql, new ScalarHandler(), objects);
		connection.close();
		return query;

	}
}
