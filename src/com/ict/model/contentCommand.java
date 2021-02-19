package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class contentCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		VO vo = new VO();
		//사용자가 수정, 삭제 할 필요없으므로 세션에 따로담아두지 않는다.
		
		vo = DAO.getContent(idx);
		request.setAttribute("vo", vo);
		
		return "view/product_content.jsp";
	}

}
