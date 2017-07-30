package com.turreta.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class MyBean {

	private String sessionData;

	public String getSessionData() {
		return sessionData;
	}

	public void setSessionData(String sessionData) {
		this.sessionData = sessionData;
	}
	
	public void extractSessionData() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		
		Object loggedIn = session.getAttribute("loggedIn");
		if(loggedIn == null) {
			sessionData = "false";
		} else {
			sessionData = loggedIn.toString();
		}		
	}
	
}
