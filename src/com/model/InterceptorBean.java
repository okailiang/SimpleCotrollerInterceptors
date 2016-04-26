package com.model;

import java.io.Serializable;

/**
 * <p>
 * Class:InterceptorBean
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
public class InterceptorBean implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 7174426820543464522L;

	private String name;
	private ActionClass actionClass;

	public InterceptorBean() {
		super();
	}

	public InterceptorBean(String name, ActionClass actionClass) {
		super();
		this.name = name;
		this.actionClass = actionClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActionClass getActionClass() {
		return actionClass;
	}

	public void setActionClass(ActionClass actionClass) {
		this.actionClass = actionClass;
	}

}
