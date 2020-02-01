package com.felix.probe.common.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseListResult<T> {
	
	private PageVo pageVo;

	private ResponseListVo<T> responseListVo;
}
