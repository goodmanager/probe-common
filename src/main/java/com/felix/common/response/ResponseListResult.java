package com.felix.common.response;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseListResult<T> implements Serializable {

	private static final long serialVersionUID = -4296742914196870305L;

	private PageVo pageVo;

	private ResponseListVo<T> responseListVo;
}
