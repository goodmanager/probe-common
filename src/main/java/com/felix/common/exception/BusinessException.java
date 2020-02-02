package com.felix.common.exception;

import com.felix.common.util.MessageSourceUtils;

/**
 * 业务异常
 * 
 * @author coral
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1936557387495630539L;

	private String message;

	public BusinessException(int errorCode, Object... objects) {
		this.message = MessageSourceUtils.getMessage(String.valueOf(errorCode), objects);
	}

	@Override
	public String toString() {
		return "BusinessException[message=" + message + "]";
	}

}
