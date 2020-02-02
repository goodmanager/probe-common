package com.felix.common.response;

import java.util.List;

import lombok.Data;

@Data
public class ResponseListVo<T> {
	
	private int errorCode;

	private String message;

	private List<T> result;
}
