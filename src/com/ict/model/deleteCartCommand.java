package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class deleteCartCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String p_num=request.getParameter("p_num");
		CVO cvo = new CVO();
		cvo.setId(id);
		cvo.setP_num(p_num);
		
		
		int result = DAO.getCartDelete(cvo);
		
		
		return "mycontroller?cmd=viewCart";
	}

}
