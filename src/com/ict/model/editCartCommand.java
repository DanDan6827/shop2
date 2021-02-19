package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;

public class editCartCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
	String amount = request.getParameter("amount");
		String id = request.getParameter("id");
		String p_num = request.getParameter("p_num");
		
		//수량이 변경되면 총 가격도 변경 된다.
		CVO cvo = new CVO();
		cvo.setId(id);
		cvo.setP_num(p_num);
		cvo.setAmount(amount);
		
		//카트안에 존재하는 제품의 수량을 업데이트 하자
		int result = DAO.getCartAmountUpdate(cvo);
		
		return "mycontroller?cmd=viewCart";
	}

}
