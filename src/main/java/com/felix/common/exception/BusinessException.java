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

	private String message;

	public BusinessException(int errorCode, Object... objects) {
		this.errorCode = errorCode;
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
}
