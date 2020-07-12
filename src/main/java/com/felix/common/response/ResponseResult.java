package com.felix.common.response;

import java.io.Serializable;

public class ResponseResult implements Serializable {

	private static final long serialVersionUID = -4296742914196870305L;

	private int errorCode;

	private int httpStatus;

	private String message;

	private Pager pager;

	private Object records;

	public static ResponseResult success(Pager pager, Object object) {
		ResponseResult result = new ResponseResult();
		result.setErrorCode(0);
		result.setMessage("");
		result.setHttpStatus(200);
		result.setPager(pager);
		result.setRecords(object);
		return result;
	}

	public static ResponseResult success(Object object) {
		ResponseResult result = new ResponseResult();
		result.setErrorCode(0);
		result.setMessage("");
		result.setHttpStatus(200);
		result.setRecords(object);
		return result;
	}

	public static ResponseResult error(int errorCode, int httpStatus, String message) {
		ResponseResult result = new ResponseResult();
		result.setErrorCode(errorCode);
		result.setMessage(message);
		result.setHttpStatus(httpStatus);
		return result;
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

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Object getRecords() {
		return records;
	}

	public void setRecords(Object records) {
		this.records = records;
	}

}
