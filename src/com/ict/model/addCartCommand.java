package com.ict.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.CVO;
import com.ict.db.DAO;
import com.ict.db.MVO;
import com.ict.db.VO;


public class addCartCommand implements Commend {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		
		//해당 제품을 구입한 id를 구하자
		//id는 로그인할때 sesstion에 저장했다.
		MVO mvo = (MVO)request.getSession().getAttribute("m_vo");
		String id = mvo.getId();

		//idx를 이용해서 제품을 가져오자
		VO vo =DAO.getContent(idx);
		//해당 아이디를 가진 사람이 해당제품을 가지고 있는지 먼저 검사 하자
		CVO cvo = DAO.getCartList(id,vo.getP_num());
		
		//카트에 제품이 있을수도 있고 없을수도있다.
		if (cvo==null) {
			//제품이없으면 카트에추가
			CVO c_vo = new CVO();
			c_vo.setP_num(vo.getP_num());
			c_vo.setP_name(vo.getP_name());
			c_vo.setP_price(String.valueOf(vo.getP_price()));
			c_vo.setP_saleprice(String.valueOf(vo.getP_saleprice()));
			c_vo.setAmount(String.valueOf(1));
			c_vo.setId(id);
			int result = DAO.getCartInsert(c_vo);
		}else {
			//제품이 카트에 있으므로 수량만1증가 업데이트
			int result = DAO.getCartUP(cvo);
		}
		
		return "mycontroller?cmd=content&idx="+idx;
	}

}






