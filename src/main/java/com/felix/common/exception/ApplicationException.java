package com.felix.common.exception;

import com.felix.common.util.MessageSourceUtils;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
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

	public ApplicationException(int errorCode, int httpStatus, Object... objects) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.message = MessageSourceUtils.getMessage(String.valueOf(errorCode), objects);
	}
}
