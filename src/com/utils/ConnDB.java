package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * <p>
 * Class:ConnDB
 * </p>
 * <p>
 * Description:操作数据库
 * </p>
 * <p>
 * Copyright: USTC
 * </p>
 * 
 * @author Oukailiang
 * @version 1.0.0
 */
public class ConnDB {

	private static Connection conn = null;

	/**
	 * 
	 * @Description：获得数据库连接
	 * @return
	 */
	public static Connection getConn() {
		String url = "jdbc:mysql:///simpleController";
		String user = "root";
		String password = "Admin@123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Description：释放操作数据库资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeConn(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn = ConnDB.getConn();
		ConnDB.closeConn(conn, null, null);
		System.out.println("连接OK");
	}
}
