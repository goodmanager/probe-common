package com.felix.common.util;

import java.util.List;

import com.felix.common.response.PageVo;
import com.felix.common.response.ResponseListResult;
import com.felix.common.response.ResponseListVo;
import com.felix.common.response.ResponseVo;

public class ResponseUtil {

	/**
	 * 返回单个 object
	 * 
	 * @param <T>
	 * @param errorCode
	 * @param message
	 * @param target
	 * @return
	 */
	public static <T> ResponseVo<T> createResponseResult(int errorCode, String message, T target) {

		ResponseVo<T> responseVo = new ResponseVo<>();
		responseVo.setErrorCode(errorCode);
		responseVo.setMessage(message);
		responseVo.setResult(target);

		return responseVo;
	}

	/**
	 * 分页返回object及分页信息
	 * 
	 * @param <T>
	 * @param errorCode
	 * @param message
	 * @param list
	 * @param pageVo
	 * @return
	 */
	public static <T> ResponseListResult<T> createResponseResult(int errorCode, String message, List<T> list,
			PageVo pageVo) {

		ResponseListResult<T> responseResult = new ResponseListResult<>();
		responseResult.setPageVo(pageVo);

		ResponseListVo<T> responseVo = new ResponseListVo<>();
		responseVo.setErrorCode(errorCode);
		responseVo.setMessage(message);
		responseVo.setResult(list);

		responseResult.setResponseListVo(responseVo);
		return responseResult;
	}
}
