package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.UserVO;

//private int num;
//private String id;
//private String name;
//private String password;
//private String gender;
//private String zipcode;
//private String address;
//private String address_detail;
//private String address_etc;

public class UserDAO {
	Connection conn; //외부 저장소인 DBMS를 드라이버를 통해 가져온 연결 객체
	PreparedStatement pstm; //문자열 안에 있는 SQL문을 객체로 저장, 변수가 들어갈 자리에 알맞는 갑을 넣어줌, SQL문 실행시킴
	ResultSet rs; //SELECT의 결과를 담는 객체
	
	public void join(UserVO user) {//변수 다 가져오기 위해서 UserVO로 객체 가져옴
		//SQL문 작성
		String query = "INSERT INTO TBL_USER VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ? ,?, ?)";
		
		try {
			//connection객체 전달받음
			conn = DBConnecter.getconnection();
			//위에서 작성한 쿼리문을 prepareStatement에 전달한다.
			pstm = conn.prepareStatement(query);
			//?자리에 알맞는 변수를 전달해준다.
			pstm.setString(1, user.getId());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getGender());
			pstm.setString(5, user.getZipcode());
			pstm.setString(6, user.getAddress());
			pstm.setString(7, user.getAddress_detail());
			pstm.setString(8, user.getAddress_etc());
//			pstm.executeQuery() : return타입이 있음, select문법을 썼을 떄에만 씀
			//DML중 INSERT쿼리를 실행하는 메소드를 사용한다.
			pstm.executeUpdate();//select외에 모든 것들, 실행된 건수, 결과 건수
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	//아이디 중복 검사
	public boolean checkId(String id) {
		//1개 나오면 중복 있음
		//0개 나오면 중복 없음
		String query = "SELECT COUNT(ID) FROM TBL_USER WHERE ID = ?";
		boolean check = false;
		try {
			//DBMS연결객체 가져오기
			conn = DBConnecter.getconnection();
			//String 으로 선언된 쿼리를 pstm객체에 전달하기
			pstm = conn.prepareStatement(query);
			//SQL쿼리에 ?가 있다면 알맞는 값으로 지정해 주기
			pstm.setString(1, id);
			//쿼리 실행 후 결과를 rs객체에 담기
			rs = pstm.executeQuery();
			
			//행 가져오기
			rs.next();
			//위에서 가져온 행의 열을 타입에 맞춰서 가져오기
			check = rs.getInt(1) == 1;//0일떄 중복 없음(false), 1일때 중복 있음(true)
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}
	
	
	public boolean login(String id, String pw) {
		String query = "SELECT COUNT(ID) FROM TBL_USER WHERE ID = ? AND PASSWORD = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getconnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			rs.next();//행을 갖고옴
			check = rs.getInt(1) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {//역순으로 닫아주기
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}
}
