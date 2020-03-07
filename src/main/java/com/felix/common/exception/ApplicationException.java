package com.felix.common.exception;

import com.felix.common.util.MessageSourceUtils;

import lombok.ToString;

@ToString
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 3183257827849708210L;

	private int errorCode;

	private String message;

	private int httpStatus;

	public ApplicationException(int errorCode, int httpStatus, String message, Object... objects) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.message = String.format(message, objects);
	}

	public ApplicationException(int errorCode, int httpStatus, String message) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public ApplicationException(int errorCode, int httpStatus, Object... objects) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.message = MessageSourceUtils.getMessage(String.valueOf(errorCode), objects);
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

}
