package com.felix.common.util;

import java.util.List;

import com.felix.common.response.ExceptionResponseResult;
import com.felix.common.response.PageVo;
import com.felix.common.response.ResponseResult;

public class ResponseUtil {

	public static <T> ExceptionResponseResult<T> createExceptionResponseResult(int errorCode, int httpStatus,
			String message) {
		ExceptionResponseResult<T> responseResult = new ExceptionResponseResult<>();
		responseResult.setErrorCode(errorCode);
		responseResult.setHttpStatus(httpStatus);
		responseResult.setMessage(message);
		return responseResult;
	}

	/**
	 * 返回数据及分页信息
	 * 
	 * @param <T>
	 * @param errorCode
	 * @param message
	 * @param recordsList
	 * @param pageVo
	 * @return
	 */
	public static <T> ResponseResult<T> createResponseResult(int errorCode, int httpStatus, String message,
			List<T> records, PageVo pageVo) {

		ResponseResult<T> responseResult = new ResponseResult<>();
		responseResult.setPageVo(pageVo);

		responseResult.setErrorCode(errorCode);
		responseResult.setHttpStatus(httpStatus);
		responseResult.setRecords(records);
		return responseResult;
	}
}
