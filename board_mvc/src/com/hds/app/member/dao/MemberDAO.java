package com.hds.app.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hds.app.member.vo.MemberVO;
import com.hds.app.mybatis.config.MyBatisConfig;

public class MemberDAO {
	SqlSessionFactory sessionFactory = MyBatisConfig.getSqlsession_f();
	SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = sessionFactory.openSession(true);
	}
	
	//아이디 검사
	public boolean checkId(String memberId) {
		//Member.checkId에 memberId를 전달하고 받은값이 1과 같다면 true를 반환
		return (Integer)(sqlSession.selectOne("Member.checkId", memberId)) == 1;//중복일때 true
	}
	
	//회원가입
	public void join(MemberVO member) {
		sqlSession.insert("Member.join", member);
	}
	
	//로그인
	public boolean login(String memberId, String memberPw) {
		HashMap<String, String> userMap = new HashMap<>();
		userMap.put("memberId", memberId);
		userMap.put("memberPw", memberPw);
		return (Integer)(sqlSession.selectOne("Member.login", userMap)) == 1;
	}
	
	//아이디 찾기
	public String findId(String memberEmail, String memberPw) {
		HashMap<String, String> memberMap = new HashMap<>();
		memberMap.put("memberEmail", memberEmail);
		memberMap.put("memberPw", memberPw);
		return sqlSession.selectOne("Member.findId", memberMap);
	}
}
