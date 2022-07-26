package com.hds.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;
import com.hds.app.board.dao.BoardDAO;

public class BoardListOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardDAO dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		String temp = req.getParameter("page");
		//temp가 null이면 첫번쨰로 온거니까 1, 아니면 사용자가 요청한거니까 페이지를 정수로 바꿔서 page에 넣어줌
		int page = temp == null? 1 : Integer.parseInt(temp);
		int pageSize = 10;//한번에 몇개의 게시글을 보여줄지 
		
		int totalCount = dao.getTotal();
		
		//게시글
		int endRow = page * pageSize;
		int startRow = endRow - (pageSize - 1);
		
		//페이지 번호
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		int realEndPage = (int)(Math.ceil((double)totalCount / pageSize));//맨 마지막 페이지
		
		//endPage가 realEndPage보다 크면 endPage에 realEndPage를 넣음
		endPage = endPage > realEndPage ? realEndPage : endPage;
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("boardList", dao.getList(startRow, endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardList.jsp");
		
		return forward;
	}

}
