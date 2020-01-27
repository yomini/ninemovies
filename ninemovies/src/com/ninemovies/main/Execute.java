package com.ninemovies.main;

public class Execute {
	public static Object service(Service service, Object ...objs)throws Exception{
		return service.service(objs);
	}
}
