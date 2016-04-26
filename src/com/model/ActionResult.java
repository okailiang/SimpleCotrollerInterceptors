package com.model;

import java.io.Serializable;

public class ActionResult implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 4841386583740382795L;

	private String resultName;

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	private String type;
	private String value;

	public ActionResult() {
	}

	public ActionResult(String resultName, String type, String value) {
		this.resultName = resultName;
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
