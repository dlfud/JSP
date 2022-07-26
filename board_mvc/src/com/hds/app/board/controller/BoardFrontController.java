package com.hds.app.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.ActionForward;

public class BoardFrontController extends HttpServlet{
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
		
		ActionForward forward = null;
		
		if(command.equals("/board/BoardListOk.bo")) {
			try {
				forward = new BoardListOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardWrite.bo")) {//글 작성하기
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/board/boardWrite.jsp");
		}else if(command.equals("/board/BoardWriteOk.bo")) {//글 작성 완료
			try {
				forward = new BoardWriteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardViewOk.bo")) {//게시글 보기
			 try {
				forward = new BoardViewOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/FileDownloadOk.bo")) {//첨부파일 다운로드
			try {
				forward = new FileDownloadOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardDeleteOk.bo")) {//게시글 삭제
			try {
				forward = new BoardDeleteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardModify.bo")) {//게시글 수정
			try {
				forward = new BoardModify().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardModifyOk.bo")) {
			try {
				forward = new BoardModifyOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//***********댓글***********
		else if(command.equals("/board/BoardReplyListOk.bo")) {
			try {
				forward = new BoardReplyListOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardReplyWriteOk.bo")) {
			try {
				forward = new BoardReplyWriteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardReplyModifyOk.bo")) {
			try {
				forward = new BoardReplyModifyOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/board/BoardReplyDeleteOk.bo")) {
			try {
				forward = new BoardReplyDeleteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
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
