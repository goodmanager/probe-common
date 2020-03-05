package com.felix.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.felix.common.response.ExceptionResponseResult;
import com.felix.common.util.ResponseUtil;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public Mono<ResponseEntity<String>> gottaCatchEmAll(Exception ex) {
		ExceptionResponseResult<String> responseResult = new ExceptionResponseResult<>();
		if (ex instanceof BusinessException) {
			BusinessException businessException = (BusinessException) ex;
			responseResult = ResponseUtil.createExceptionResponseResult(businessException.getErrorCode(),
					businessException.getHttpStatus(), businessException.getMessage());
		} else {
			responseResult = ResponseUtil.createExceptionResponseResult(-1, 500, ex.getMessage());
		}
		log.error(ex.getMessage(), ex);
		return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult.toString()));
	}

}
