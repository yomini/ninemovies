package com.ninemovies.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ninemovies.bean.Beans;
import com.ninemovies.util.io.ViewResolver;

/**
 * Servlet implementation class FrontController
 */
//url 패턴은 web.xml에 설정
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//controllers 선언
	private Controller boardController = Beans.getController("boardController");
	private Controller memberController = Beans.getController("memberController");
	private Controller mainController = Beans.getController("mainController");
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //jsp는 파일 // uri 웹주소(식별자. 기존의 url uri개념과는 다르다.) // 
    //프론트컨트롤에서 보드컨트롤 실행해서 결과믈을 jsp에 저장해놓는다.
    //이 jsp가 viewresolver에서 조립된다.
    //ex사용자가 요청을하면 뭐든지 프론컨트롤로 먼저 간다.(콘솔에서 확인 가능)
    //사용자가 게시판리스트 클릭하면 프론컨트롤러실행되고 그안에잇는 getservletpath 실행돼서 
    //그 uri를 판별함. /board가 있으면 boardcontroller로 보낸다. 
    //boardcontroller실행후서비스실행후dao실행 끝나면 그걸 서비스로리턴하고 그게 보드컨트롤러로 리턴되고 보드컨트롤에서 처리를 끝낸다. 그 결과를 리퀘스트에 담을지 디비로 처리할지 결정함...
    //서버딴에서 처리 다끝나면 그에 해당하는 내용을 jsp파일로 포워드 (viewresolver에서 앞뒤 조립해서 jsp파일 경로를 만든다.)
    //(처리는 보드컨트롤에서 다 끝나고 프론컨에는 jsp경로만 넘어간다. 프로컨에서 viewresolver호출해서 redirect할지 forward할지 결정한다.)
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jsp ="";
		try {
		System.out.println("FrontController.service() Start~");
		String uri = request.getServletPath();
		System.out.println("uri: " +uri);
		if(uri.indexOf("/board")==0) {
			System.out.println("Board~");
			jsp = boardController.execute(request, response, uri);
		}
		else if(uri.indexOf("/member") == 0) {
			System.out.println("member~");
			jsp = memberController.execute(request, response, uri);
		}
		else if(uri.indexOf("/main") == 0) {
			System.out.println("main~");
			jsp = mainController.execute(request, response, uri);
		}
		else {
			System.out.println("404 Error: Page doesn't exist:/");
		}
		ViewResolver.forward(request, response, jsp);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new ServletException(e); //예외 되던지기. 메소드 호출한곳에서도 예외처리시킴
	}

}
}