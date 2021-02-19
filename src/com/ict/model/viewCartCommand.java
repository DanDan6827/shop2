package com.ict.model;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;



public class viewCartCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//id불러오기
		MVO mvo = (MVO)request.getSession().getAttribute("m_vo");
		String id = mvo.getId();
		
		//해당 아이디가 전체카트정보를 가져온다
		List<CVO> clist = DAO.getAllCart(id);
		
		request.setAttribute("clist", clist);
		return "view/viewcart.jsp";
	}

}
