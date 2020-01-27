package com.ninemovies.board.service;

import com.ninemovies.board.dao.BoardDAO;
import com.ninemovies.main.Service;

//frontcontroller -> 세부컨트로럴러 -> service -> dao
//서비스에서 dao를 실행해야 dao가 처리됨...
public class BoardListService implements Service{
	
	//예전에는 필요할때마다 호출해서 썼는데 이제는 여기에 한번만 지역변수로 선언하고 생성자 를 이용하여 (final붙여서 값 고정) 쓰도록한다.
	private final BoardDAO dao;
	
	//생성자 - dao를입력받아야 한다.(주입의존)
	//new BoardListService()으로 호출될때 괄호안에 dao 전달 강제하기 위해 사용
	public BoardListService(BoardDAO dao) {
		this.dao = dao;
	}
	
	//인터페이스 형식 강제
	@Override
	public Object service(Object[] objs) throws Exception {
		//dao에서 만든 list메소드를 실행해야 db에서 꺼내올수있다.
		return dao.list();
	}

	
}
