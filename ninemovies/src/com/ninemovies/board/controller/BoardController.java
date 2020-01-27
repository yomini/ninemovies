package com.ninemovies.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ninemovies.main.Controller;
import com.ninemovies.main.Execute;
import com.ninemovies.main.Service;

public class BoardController implements Controller {

	//실행에 필요한 객체 선언 (listservice가 인터페이스를 상속받아서 타입을 인터페이스 service타입으로 )
	private Service listService;
	//객체 사용위한 초기화 생성자 (순서 주의)
	public BoardController(Service listService) {
		this.listService = listService;
	} 
	

//	case문 다 실행 후 uri중간부분만 jsp리턴...(뷰리졸버에서 앞뒤합차서조립)
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		String jsp = "";
		
		switch (uri) {
		case "/board/list.do":
			request.setAttribute("list", Execute.service(listService, 1) );
			jsp="board/list";
			break;

		default:
			break;
		}//end switch
		
		System.out.println("BoardController.execute().jsp"+jsp);
		return jsp;
		
	}//execute() end

}//BoardController class end
