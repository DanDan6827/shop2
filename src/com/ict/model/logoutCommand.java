package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logoutCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//(로그아웃)세션 초기화(세션에 로그인정보가 저장되어있으므로)
		request.getSession().invalidate();
		

		return "mycontroller?cmd=list";
	}

}
