package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.MVO;

public class login_okCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MVO mvo = new MVO();
		mvo.setId(id);
		mvo.setPw(pw);
		
		MVO m_vo=DAO.getlogin(mvo);
		if(m_vo==null) {
			return "mycontroller?cmd=login";
		}else {
			request.getSession().setAttribute("m_vo", m_vo);
			request.getSession().setAttribute("login", "ok");
			//관리자인지 일반회원인지 검사
			if (m_vo.getId().equals("admin")&&m_vo.getPw().equals("admin")) {
				request.getSession().setAttribute("admin", "ok");
				return "view/admin.jsp";
			}
			return "mycontroller?cmd=list";
		}
	}

}
