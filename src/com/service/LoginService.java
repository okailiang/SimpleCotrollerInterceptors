package com.service;

import com.model.UserBean;

/**
 * 
 * <p>
 * Class:LoginServiceImpl
 * </p>
 * <p>
 * Description: 用户登录校验service层接口
 * </p>
 * <p>
 * Copyright: USTC
 * </p>
 * 
 * @author Oukailiang
 * @version 1.0.0
 */
public interface LoginService {
	/**
	 * 
	 * @Description：校验用户身份是否合法
	 * @param userBean
	 * @return
	 */
	public UserBean checkUserLogin(UserBean userBean);

	/**
	 * 
	 * @Description：注册用户信息
	 * @param userBean
	 * @return
	 */
	public boolean registUser(UserBean userBean);

}
