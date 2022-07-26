package com.hds.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//execute()는 모든 컨트롤러에서 쓰이므로 추상메소드로 선언해서 씀

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
