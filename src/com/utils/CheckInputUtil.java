package com.utils;

public class CheckInputUtil {

	public static boolean checkInput(String userName, String password) {
		if ((userName == null || userName.trim().length() <= 0)
				|| (password == null || password.trim().length() <= 0)) {
			return false;
		}
		return true;
	}
}
