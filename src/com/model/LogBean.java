package com.model;

import java.io.Serializable;

/**
 * <p>
 * Class:LogBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: USTC
 * </p>
 * 
 * @author Oukailiang
 * @version 1.0.0
 */
public class LogBean implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 5693171947738589676L;
	private String actionName;
	private String startTime;
	private String endTime;
	private String result;

	public LogBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogBean(String actionName, String startTime, String endTime,
			String result) {
		super();
		this.actionName = actionName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.result = result;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}