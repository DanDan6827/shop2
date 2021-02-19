package com.ict.db;

import java.util.ArrayList;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

//DB처리를위한 클래스
public class DAO {
	//MYbatis에서는 SqlSession 크래스를 이용해서 
	//mapper의 태그들을 실행 시킨다.
	private static SqlSession ss;
	
	//싱글턴 패턴
	private synchronized static SqlSession getSession() {
		if (ss==null) {
			//DBService를 사용
			ss=DBService.getFactory().openSession(false);

			//DBService.getFactory().openSession(); - 자동커밋
			//DBService.getFactory().openSession(true);-자동커밋
			
			//DBService.getFactory().openSession(false);-수동커밋 (커밋명령어를 별도로내려야함)
			//수동커밋은 반드시 insert,update, delete 하면 커밋을 해야 DB에도 적용된다.
		
		}
		return ss;
	}

	public static List<VO> getList(String category) {
		List<VO> list = new ArrayList<VO>();
		list = getSession().selectList("list", category);
		return list;
	}

	public static MVO getlogin(MVO mvo) {
		MVO m_vo = new MVO();
		m_vo=getSession().selectOne("login", mvo);
		return m_vo;
	}

	public static VO getContent(String idx) {
		VO vo = new VO();
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}

	public static int getProductInsert(VO vo) {
		int result = 0;
		result = getSession().insert("add_P", vo);
		ss.commit();
		return result;
	}
	//아이디와 제품번호를 받아 같은제품있는지 카트리스트를 구하자
	public static CVO getCartList(String id, String p_num) {
		CVO cvo = null;
		CVO c_vo = new CVO();
		c_vo.setId(id);
		c_vo.setP_num(p_num);
		cvo= getSession().selectOne("select_cart",c_vo);
		return cvo;
	}

	public static int getCartInsert(CVO c_vo) {
		int result = 0;
		result = getSession().insert("cartInsert", c_vo);
		ss.commit();
		return result;
	}
	//담는제품이있는경우 수만증가
	public static int getCartUP(CVO cvo) {
		int result = 0 ;
		result = getSession().update("cartupdate", cvo);
		ss.commit();
		return result;
	}

	public static List<CVO> getAllCart(String id) {
		List<CVO> clist = null;
		clist = getSession().selectList("cartall",id);
		return clist;
	}

	public static int getCartAmountUpdate(CVO cvo) {
		int result = 0 ;
		result = getSession().update("amountupdate", cvo);
		ss.commit();
		return result;
	}

	public static int getCartDelete(CVO cvo) {
		int result = 0 ;
		result = getSession().delete("deletecart", cvo);
		ss.commit();
		return result;
	}






	
	
	
	
	
	
}
	
	

