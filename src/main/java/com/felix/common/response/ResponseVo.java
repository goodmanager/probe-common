package com.felix.common.response;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseVo<T> implements Serializable {

	private static final long serialVersionUID = -3765792961154517369L;

	private int errorCode;

	private String message;

	private T result;
}