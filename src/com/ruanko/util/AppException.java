package com.ruanko.util;

public class AppException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int exceptionCode;
	private String message;
	
	public AppException (String message) {
		this.message = message;
	}
	
	public AppException (String message, int exceptionCode) {
		this.message = message;
		this.exceptionCode = exceptionCode;
	}
	
	//��ȡ�쳣���
	public int getExceptionCode () {
		return exceptionCode;		
	}
	
	//��ȡ�쳣����Ϣ
	public String getMessage () {
		return message;		
	}
	
	//��ȡ�쳣��ϸ��Ϣ
	public String getDetailMessage () {		
		return "Detail message��"+exceptionCode+"��"+message;
	}
	
	
}
