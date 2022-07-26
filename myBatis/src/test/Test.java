package test;

import dao.MemberDAO;
import vo.MemberVO;

public class Test {
	public static void main(String[] args) {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
	
		
		//나이 조회 테스트
		dao.findMember().forEach(member ->{
			System.out.print(member.getId() + ", ");
			System.out.print(member.getPw() + ", ");
			System.out.print(member.getName() + ", ");
			System.out.println(member.getAge());
		});
		
		
		
//		//아이디 조회 테스트
//		System.out.println(dao.findId("홍길동", "1234"));
		
		
		
//		vo.setId("hds3333");
//		vo.setPw("1234");
//		vo.setName("이순신");
//		vo.setAge(40);
		
		
		
//		//회원 탈퇴
//		if(dao.delete("hds1234")) {
//			System.out.println("회원탈퇴 성공");
//		}
		
		
		
		
//		//정보수정
//		if(dao.update(vo)) {
//			System.out.println("수정 성공");
//		}
		
		
		
		
//		if(!dao.checkId(vo.getId())) {
//			dao.join(vo);
//		}
//		//회원가입부분 문제 없음...

		
		
		
		//로그인 확인
//		if(dao.login("hds1234", "1111")) {//저장을 안해서...성공이 나왔었음...ㄹㅈㄷ
//			System.out.println("로그인 성공");
//		}else {
//			System.out.println("로그인 실패");
//		}
	}
}
