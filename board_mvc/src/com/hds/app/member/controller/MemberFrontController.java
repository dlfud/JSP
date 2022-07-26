package com.hds.app.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.ActionForward;
//web.xml에 의해서 여기로 왔다면 회원관련해서 어떤 기능인지 분석해서 분기처리함
//사용자가 보낸 url을 다시 분석해서 회원가입인지 로그인인지를 여기서 판단함
public class MemberFrontController extends HttpServlet{
	//get, post상관없이 둘다 똑같은것이 실행될수 있도록 함
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();//naver.com앞에 항상 붙어있는 www...를 의미함
		String command = requestURI.substring(contextPath.length());//전달한 시작값 포함하여 전달
		
		ActionForward forward = null;//ActionForward를 담음수 있게 미리 객체를 만들어 둠
		
		//DB조회가 필요하다면 OK를 붙였음
		
		//사용자가 contextPath를 제외하고 이렇게 요청했다면
		if(command.equals("/member/MemberCheckIdOk.me")) {//여기 안에 코드가 너무 길어지니까 분리함
			try {
				//넘겨주는 값 타입이 ActionForward이므로 객체에 넣음
				forward = new MemberCheckIdOk().execute(req, resp);//MemberCheckIdOk 실행
			} catch (Exception e) {
				System.out.println("아이디 중복검사 오류"+e);
			}
		}else if(command.equals("/member/MemberJoinOk.me")) {
			try {
				forward = new MemberJoinOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("회원가입 오류"+e);
			}
		}else if(command.equals("/member/MemberLoginOk.me")) {
			try {
				forward = new MemberLoginOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("회원가입 오류"+e);
			}
		}else if(command.equals("/member/MemberLogin.me")) {//단순 페이지 이동이라서 ok를 안붙임
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/login.jsp");
		}else if(command.equals("/member/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/join.jsp");
		}else if(command.equals("/member/MemberLogoutOk.me")) {
			try {
				forward = new MemberLogoutOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/MemberFindIdOk.me")) {
			try {
				forward = new MemberFindIdOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/MemberFindId.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/findId.jsp");
		}
		
		//전송방식에 따라 달라짐
		if(forward != null) {//forward에 뭔가가 담겨 있다면
			if(forward.isRedirect()) {//redirect방식이라면
				resp.sendRedirect(forward.getPath());
			}else {//forward방식이라면
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
