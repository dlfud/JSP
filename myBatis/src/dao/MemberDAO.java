package dao;//추가 수정 삭제 목록 기능이 있음

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import config.MyBatisConfig;
import vo.MemberVO;

public class MemberDAO {
	SqlSessionFactory sqlSession_f = MyBatisConfig.getSqlsession_f();
	SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = sqlSession_f.openSession(true);//자동으로 commit되게 true를 줌
	}
	
	//아이디 중복 검사
	public boolean checkId(String id) {//중복이 있으면 true 없으면 false, false일때 회원가입이 가능함
		//하나의 결과값이 있으므로 selectOne을 씀
		//selectOne리턴값이 제네릭, 제네릭 타입으로 parseInt()에 전달하면 문자열이 아닌 값을 전달했기 때문에 오류가 발생한다.
		//이럴 떄에는 Down Casting을 사용하여 Integer타입으로 강제 형변환 해준다.
		//parseInt()는 문자열을 Integer로 바꿔주는것
		return (Integer)(sqlSession.selectOne("Member.checkId", id)) == 1;
	}
	
	//회원가입
	public void join(MemberVO member) {//따로 변수 만들지 않고 id, pw, name, age를 포함한 memberVO를 받아옴 
		sqlSession.insert("Member.join", member);//member.xml에 있는 member안에 join에 member전달
		//실행한 건수를 전달함
	}
	
	//로그인
	public boolean login(String id, String pw) {
		HashMap<String, String> loginMap = new HashMap<>();
		loginMap.put("id", id);
		loginMap.put("pw", pw);
		return (Integer)(sqlSession.selectOne("Member.login", loginMap)) == 1;//1이면 로그인 성공
	}
	
	//정보 수정
	public boolean update(MemberVO member) {
		return sqlSession.update("Member.modify", member) == 1;//1건이 수정됬으면 수정된 것 
	}
	
	//회원탈퇴
	public boolean delete(String id) {
		return sqlSession.delete("Member.remove", id) == 1;//1건이 삭제됬으면 삭제된 것
	}
	
	//아이디 조회(이름과 비밀번호)
	public String findId(String name, String pw) {
		HashMap<String , String> findIdMap = new HashMap<>();
		findIdMap.put("name", name);
		findIdMap.put("pw", pw);
		return sqlSession.selectOne("findId", findIdMap);
	}
	
	//나이 조회(20살이 아닌 고객)
	//여러명이 나와야 하므로 List<>씀, 전체정보가 나와야 하므로 MemberVO타입 지정
	public List<MemberVO> findMember() {
		//결과가 2개 나오면 add 2번 실행
		//member.xml에서는 returnType을 member(MemberVO)로 하고, 받을 떄에는 List로 받음 
		//알아서 add가 됨
		return sqlSession.selectList("Member.findMember");
	}
}
