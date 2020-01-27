package com.ninemovies.bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.ninemovies.board.controller.BoardController;
import com.ninemovies.board.dao.BoardDAO;
import com.ninemovies.board.service.BoardListService;
import com.ninemovies.main.Controller;
import com.ninemovies.main.Service;

/**
 * Servlet implementation class Beans
 */
//@WebServlet의 속성 값을 통해 해당 Servlet과 매핑될 URL 패턴을 지정한다.
//이 Annotation을 통해 web.xml 파일에 별로의 설정을 하지 않더라도 해당 Servlet을 실행할 수 있다.
//loadOnStartup = 1 : 서버가 시작되면 /Beans를 가장 먼저 실행해라.

//스프링에서 Bean 속성으로 init-method와 destroy-method를 사용해 초기화 및 소멸 시 특정 동작을 수행할 수 있다. 
@WebServlet(urlPatterns = "/init", loadOnStartup = 1)
public class Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//각각의 객체를 저장할 map객체 선언하고 생성
	private static Map<String, Object> daos = new HashMap<>();
	private static Map<String, Service> services = new HashMap<>();
	private static Map<String, Controller> controllers = new HashMap<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Beans() {
        super(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //서블릿 초기화.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Beans.inti() = static{} 블록");
		System.out.println("객체 초기화 중 .....");
		
		//**************Board***************
		daos.put("boardDAO", new BoardDAO());
		services.put("boardListService", new BoardListService((BoardDAO) daos.get("boardDAO")));
		controllers.put("boardController", new BoardController(services.get("boardListService")));
	
		//**************Member***************
//		daos.put("memberDAO", new MemberDAO())
	
	
	
	}//end init


	public static Controller getController(String name) {
		// TODO Auto-generated method stub
		return controllers.get(name);
	}	
}//end Beans{}
