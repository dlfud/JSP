package com.hds.app.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;

public class FileDownloadOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//절대경로
		String saveFolder = "C:\\JSP\\workspace\\board_mvc\\WebContent\\app\\upload";
		String fileName = req.getParameter("fileName");
		boolean check = true;
		
		InputStream in = null;
		OutputStream out = null;
		
		File file = null;
		
		try {
			//파일을 가져와서
			file = new File(saveFolder, fileName);
			in = new FileInputStream(file);
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}
		
		//보낼 설정을 하고
		resp.setContentType("application/ocatat-stream");//파일 다운로드를 위한 전송할 데이터 타입 설정
		resp.setHeader("Content-description", "JSP Generated Data");//헤더에 담을 데이터의 내용에 대한 설명 수정
		
		if(check) {//파일을 잘 가져 왔다면
			try {
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
				resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
				resp.setHeader("Content-Type", "application/ocatat-stream;charset=utf-8");
				resp.setHeader("Content-length", "" + file.length());//""를 연결해서 문자열로 변환시켜줌
				
				//보내기
				out = resp.getOutputStream();
				byte[] b = new byte[(int)(file.length())];//파일의 길이만큼 바이트 배열 만듬
				int data = 0;
				
				while((data = in.read(b)) > 0) {//in에서 읽어와서 b에 담음
					out.write(b, 0, data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(in != null) {
						in.close();
					}
					if(out != null) {
						out.close();
					}
				} catch (Exception e) {
					//오류나면 강종때림
					throw new RuntimeException(e);
				}
			}
		}
		return null;
	}

}


