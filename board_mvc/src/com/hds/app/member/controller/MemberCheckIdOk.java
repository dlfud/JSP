package com.hds.app.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;
import com.hds.app.member.dao.MemberDAO;

public class MemberCheckIdOk implements Action{//아이디 조회하는 로직을 여기서 짬

	//어디로 갈지, 어떤 타입으로 갈건지 리턴해야 하므로 클래스를 씀
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//한글이 깨지지 않게...
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String memberId = req.getParameter("memberId");//req를 통해 입력한 아이디를 받아옴
		MemberDAO dao = new MemberDAO();
		JSONObject obj = new JSONObject();
		PrintWriter out = resp.getWriter();
		
		if(dao.checkId(memberId)) {//아이디 중복이 있을 때
			obj.put("status", "not-ok");
		}else {//아이디 중복이 없을 때
			obj.put("status", "ok");
		}
		out.println(obj.toJSONString());
		out.close();
		return null;//페이지 이동이 필요 없으므로 null리턴함
	}
	
}
