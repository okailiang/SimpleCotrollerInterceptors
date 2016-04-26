package com.model;

import java.io.Serializable;
import java.util.Set;

public class Action implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 8415018868460151324L;

	private String name;

	private Set<ActionResult> results;

	private Set<InterceptorRef> interceptorRefs;
	private ActionClass cla;

	public ActionClass getCla() {
		return cla;
	}

	public void setCla(ActionClass cla) {
		this.cla = cla;
	}

	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Action(String name, Set<ActionResult> results,
			Set<InterceptorRef> interceptorRefs, ActionClass cla) {
		super();
		this.name = name;
		this.results = results;
		this.interceptorRefs = interceptorRefs;
		this.cla = cla;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ActionResult> getResults() {
		return results;
	}

	public void setResults(Set<ActionResult> results) {
		this.results = results;
	}

	public Set<InterceptorRef> getInterceptorRefs() {
		return interceptorRefs;
	}

	public void setInterceptorRefs(Set<InterceptorRef> interceptorRefs) {
		this.interceptorRefs = interceptorRefs;
	}

}
