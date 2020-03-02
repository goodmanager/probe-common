package com.felix.common.exception;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.felix.common.response.ResponseRecordVo;
import com.felix.common.util.ResponseUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BusinessException.class)
	public ResponseRecordVo<String> businessException(BusinessException ex) {
		log.error(ex.getMessage(), ex);
		return ResponseUtil.createResponseResult(ex.getErrorCode(), ex.getMessage(), new ArrayList<String>());
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseRecordVo<String> applicationException(ApplicationException ex) {
		log.error(ex.getMessage(), ex);
		return ResponseUtil.createResponseResult(ex.getErrorCode(), ex.getMessage(), new ArrayList<String>());
	}

	@ExceptionHandler(Exception.class)
	public ResponseRecordVo<String> serverExceptionHandler(Exception ex) {
		log.error(ex.getMessage(), ex);
		return ResponseUtil.createResponseResult(-1, ex.getMessage(), new ArrayList<String>());
	}

}
