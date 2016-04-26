package com.servlet.action;

import com.model.UserBean;
import com.service.LoginServiceImpl;
import com.utils.CheckInputUtil;

public class LoginAction {
	/**
	 * 
	 * @Description：校验用户登录信息
	 * @param userBean
	 * @return
	 */
	public String login(UserBean userBean) {
		String userName = userBean.getUserName();
		String password = userBean.getPassword();
		LoginServiceImpl loginService = new LoginServiceImpl();
		try {
			// 校验前台输入的用户和密码是否合法
			if (CheckInputUtil.checkInput(userName, password)) {
				userBean.setUserName(userName);
				userBean.setPassword(password);
				userBean = loginService.checkUserLogin(userBean);
				// 用户验证合法
				if (userBean != null) {
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
}
