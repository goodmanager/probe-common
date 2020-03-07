package com.felix.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.felix.common.response.ExceptionResponseResult;
import com.felix.common.util.ResponseUtil;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public Mono<ResponseEntity<String>> gottaCatchEmAll(Exception ex) {
		ExceptionResponseResult<String> responseResult = new ExceptionResponseResult<>();
		if (ex instanceof BusinessException) {
			BusinessException businessException = (BusinessException) ex;
			responseResult = ResponseUtil.createExceptionResponseResult(businessException.getErrorCode(),
					businessException.getHttpStatus(), businessException.getMessage());
		} else if (ex instanceof ApplicationException) {
			ApplicationException applicationException = (ApplicationException) ex;
			responseResult = ResponseUtil.createExceptionResponseResult(-1, applicationException.getHttpStatus(),
					ex.getMessage());
		} else {
			responseResult = ResponseUtil.createExceptionResponseResult(-1, 500, ex.getMessage());
		}
		logger.error(ex.getMessage(), ex);
		return Mono.just(ResponseEntity.status(responseResult.getHttpStatus()).body(responseResult.toString()));
	}

}
