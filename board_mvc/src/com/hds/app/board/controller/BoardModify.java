package com.hds.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;
import com.hds.app.board.dao.BoardDAO;

public class BoardModify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//DB조회가 필요하므로 컨트롤러(BoardDAO안에 있는 getDetail)를 타고 들어가야 함
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		ActionForward forward = new ActionForward();
		BoardDAO bDao = new BoardDAO();
		
		//DB조회 후에
		req.setAttribute("board", bDao.getDetail(boardNum));
		
		//수정하는 jsp로 보냄
		forward.setRedirect(false);
		forward.setPath("/app/board/boardModify.jsp");
		return forward;
	}

}
