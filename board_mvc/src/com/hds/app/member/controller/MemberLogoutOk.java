package com.hds.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;

public class MemberLogoutOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		//세션 가져와서 없애주기
		HttpSession session = req.getSession();
		session.invalidate();
		
		//로그아웃을 하면 게시판으로 가도 도고 로그인페이지로 가도 되고
		forward.setRedirect(true);//로그아웃을 했으니 남아 있는것은 없애는게 나음
		forward.setPath(req.getContextPath() + "/member/MemberLogin.me");//FrontController로 가서 해당 경로에 맞는 if문 찾음
		
		return forward;
	}

}
