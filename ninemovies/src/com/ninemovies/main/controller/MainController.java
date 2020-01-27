package com.ninemovies.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ninemovies.main.Controller;

public class MainController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		return "main/main";
	}

	
}
