package com.felix.common.exception;

import com.felix.common.util.MessageSourceUtils;

import lombok.ToString;

/**
 * 业务异常
 * 
 * @author coral
 *
 */
@ToString
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1936557387495630539L;

	private int errorCode;

	private int httpStatus;

	private String message;

	public BusinessException(int errorCode, String message, Object... objects) {
		this.errorCode = errorCode;
		this.httpStatus = 500;
		this.message = String.format(message, objects);
	}

	public BusinessException(int errorCode, String message) {
		this.errorCode = errorCode;
		this.httpStatus = 500;
		this.message = message;
	}

	public BusinessException(int errorCode, Object... objects) {
		this.errorCode = errorCode;
		this.httpStatus = 500;
		this.message = MessageSourceUtils.getMessage(String.valueOf(errorCode), objects);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
