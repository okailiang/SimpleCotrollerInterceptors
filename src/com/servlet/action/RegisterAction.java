package com.servlet.action;

import com.model.UserBean;
import com.service.LoginServiceImpl;
import com.utils.CheckInputUtil;

public class RegisterAction {
	/**
	 * 
	 * @Description：注册用户信息
	 * @param userBean
	 * @return
	 */
	public String register(UserBean userBean) {

		String userName = userBean.getUserName();
		String password = userBean.getPassword();
		LoginServiceImpl loginService = new LoginServiceImpl();
		try {
			// 校验前台输入的用户和密码是否合法
			if (CheckInputUtil.checkInput(userName, password)) {
				userBean.setUserName(userName);
				userBean.setPassword(password);
				// 注册用户名和密码
				if (loginService.registUser(userBean)) {
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";

	}
}
