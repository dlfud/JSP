package com.hds.app.action;

//어디로 갈건지, 어떤 타입으로 전송될건지를 리턴해줘야 함
//2개를 리턴할순 없으니 미리 클래스로 만들어 둠

public class ActionForward {
	private String path;//어디로 갈건지
	private boolean isRedirect;//어떤 타입으로 갈건지(true = redirect, false = forward)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
