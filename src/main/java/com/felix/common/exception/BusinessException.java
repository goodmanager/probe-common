package com.felix.common.exception;

/**
 * 业务异常
 * 
 * @author coral
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8175638207304045557L;

	private int errorCode;

	private int httpStatus;

	private String message;

	private Object[] objects;

	public BusinessException(int errorCode, Object... objects) {
		this.errorCode = errorCode;
		this.httpStatus = 500;
		this.objects = objects;
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

	public Object[] getObjects() {
		return objects;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
}
