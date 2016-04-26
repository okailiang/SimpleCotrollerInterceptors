package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.model.UserBean;
import com.utils.ConnDB;

/**
 * 
 * <p>
 * Class:LoginDaoImpl
 * </p>
 * <p>
 * Description:用户登录校验dao层接口实现
 * </p>
 * <p>
 * Copyright: USTC
 * </p>
 * 
 * @author Oukailiang
 * @version 1.0.0
 */
public class LoginDaoImpl {

	/**
	 * 
	 * @Description：校验用户身份是否合法
	 * @param userBean
	 * @return
	 */
	public UserBean checkUser(UserBean userBean) {
		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			connection = ConnDB.getConn();
			sql = "select id,userName,password from users where userName= ? and password= ?";
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, userBean.getUserName());
			ptmt.setString(2, userBean.getPassword());
			rs = ptmt.executeQuery();
			if (rs == null) {
				return null;
			}
			// 取得查询结果集的用户信息
			while (rs.next()) {
				userBean.setId(rs.getString("id"));
				userBean.setUserName(rs.getString("userName"));
				userBean.setPassword(rs.getString("password"));
				return userBean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnDB.closeConn(connection, ptmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @Description：注册用户信息
	 * @param userBean
	 * @return
	 */
	public boolean registUser(UserBean userBean) {
		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "";
		boolean flag = false;
		try {
			connection = ConnDB.getConn();
			sql = "insert into users(id,userName,password) values(?,?,?)";
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, UUID.randomUUID().toString());
			ptmt.setString(2, userBean.getUserName());
			ptmt.setString(3, userBean.getPassword());
			int num = ptmt.executeUpdate();

			if (num != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnDB.closeConn(connection, ptmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
