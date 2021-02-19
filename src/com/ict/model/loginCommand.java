package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "view/login.jsp";
	}

}
