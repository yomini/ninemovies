package com.ninemovies.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller Interface : execute client's request and return uri
public interface Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception;
	
}
