package com.hds.app.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;
import com.hds.app.board.dao.BoardDAO;
import com.hds.app.files.dao.FilesDAO;
import com.hds.app.files.vo.FilesVO;

public class BoardDeleteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String saveFolder = "C:\\JSP\\workspace\\board_mvc\\WebContent\\app\\upload";
		FilesDAO fDao = new FilesDAO();
		BoardDAO bDao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		for(FilesVO file : fDao.getFiles(boardNum)) {//첨부파일이 여러개일수 있으므로 반복을 돌림
			File f = new File(saveFolder, file.getFileName());
			if(f.exists()) {
				f.delete();
			}
		}
		
		fDao.deleteFiles(boardNum);//첨부파일 지우고
		bDao.deleteBoard(boardNum);//게시글 지우고
		
		forward.setRedirect(false);
		forward.setPath("/board/BoardListOk.bo");//목록으로 돌아감, 페이징처리와 DB조회를 해야지만 목록을 보여줄수 있음, 그래서 컨트롤러를 들렸다가 와야 함
		
		return forward;
	}

}
