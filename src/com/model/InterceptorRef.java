package com.model;

import java.io.Serializable;

/**
 * <p>
 * Class:InterceptorRef
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
public class InterceptorRef implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 2298119424402860371L;

	private String name;

	public InterceptorRef() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InterceptorRef(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
