package com.felix.probe.common.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseVo<T> {

	private int errorCode;

	private String message;

	private T result;
}
