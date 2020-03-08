package com.felix.common.exception;

import lombok.ToString;

@ToString
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 3183257827849708210L;

	private int errorCode;

	private String message;

	private int httpStatus;

	private Object[] objects;

	public ApplicationException(int errorCode, int httpStatus, Object... objects) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.objects = objects;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Object[] getObjects() {
		return objects;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}

}
