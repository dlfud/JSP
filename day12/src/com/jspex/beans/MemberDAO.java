package com.jspex.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public ArrayList<MemberVO> select(String name) {
		String query = "SELECT * FROM TBL_MEMBER WHERE NAME = ?";
		ArrayList<MemberVO> members = new ArrayList<>();
		MemberVO member = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		try {
			conn = DBconnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);//1부터 시작함, ?자리에 사용자가 입력한 이름이 들어감
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setNum(rs.getInt(1));//number
				member.setName(rs.getString(2));//name
				member.setBirthday(sdf.format(rs.getDate(3)));//birthday
				members.add(member);//배열에 하나씩 넣어줌
			}
		} catch (SQLException e) {
			System.out.println("select(String) 쿼리오류"+e);
		}catch(Exception e) {
			System.out.println("select(String) 알 수 없는 오류" + e);
		}finally {//열어놓은 순서 반대로 닫아주기
			try {
				if(rs !=null) {
					rs.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return members;
	}
}
