package com.felix.common.util;

import java.util.List;

import com.felix.common.response.PageVo;
import com.felix.common.response.ResponseResult;
import com.felix.common.response.ResponseRecordVo;

public class ResponseUtil {

	/**
	 * 返回所有数据
	 * 
	 * @param <T>
	 * @param errorCode
	 * @param message
	 * @param recordsList
	 * @return
	 */
	public static <T> ResponseRecordVo<T> createResponseResult(int errorCode, String message, List<T> recordsList) {

		ResponseRecordVo<T> responseRecordVo = new ResponseRecordVo<>();
		responseRecordVo.setErrorCode(errorCode);
		responseRecordVo.setMessage(message);
		responseRecordVo.setRecordsList(recordsList);

		return responseRecordVo;
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
	public static <T> ResponseResult<T> createResponseResult(int errorCode, String message, List<T> recordsList,
			PageVo pageVo) {

		ResponseResult<T> responseResult = new ResponseResult<>();
		responseResult.setPageVo(pageVo);

		ResponseRecordVo<T> responseRecordVo = new ResponseRecordVo<>();
		responseRecordVo.setErrorCode(errorCode);
		responseRecordVo.setMessage(message);
		responseRecordVo.setRecordsList(recordsList);

		responseResult.setResponseRecordVo(responseRecordVo);
		return responseResult;
	}
}
