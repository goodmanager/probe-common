package com.felix.common.exception;

import lombok.ToString;

@ToString
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 3183257827849708210L;

	private String message;

	private int errorCode;

	public ApplicationException(String message, Object... objects) {
		this.errorCode = -1;
		this.message = String.format(message, objects);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
