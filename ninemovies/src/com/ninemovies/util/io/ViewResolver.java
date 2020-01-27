package com.ninemovies.util.io;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {

	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SURFIX = ".jsp";

	public static String getJsp(String str){
		return PREFIX + str + SURFIX;
	}
//	Dispatcher방식과 Redirect 방식
//	서블릿에서 특정 URL이나 페이지로 이동하게 하는 두 가지 방식이 있는데, 두 방식의 차이점에 대해 알아보자.
//
//	1. Redirect 방식 --> sendRedirect()
//	Redirect()[이동하기]는 새로운 페이지로 완전히 이동해서 기존 데이터를 하나도 사용할 수 없다.
//	
//	2. Dispatcher방식 -->forward()
//	forward()[전달하기]는 클라이언트가 요청하면서 전송한 데이터를 그대로 유지한다.

	public static void forward(HttpServletRequest request, HttpServletResponse response, String jsp) throws IOException, ServletException{
		
		if(jsp.indexOf("redirect")==0) {
			jsp = jsp.substring("redirect:".length());
			response.sendRedirect(jsp);
			return;
		}
		//jsp를 str에 대입해서 getJsp에 넣어서 full url을 만들고 
		//-> 그 주소로 request, response에 담긴 정보를 가지고 포워드해라..
		request.getRequestDispatcher(getJsp(jsp)).forward(request, response);
		return;
	}
	
}
