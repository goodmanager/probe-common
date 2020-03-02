package com.felix.common.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageVo {

	private int totalPage = 0;

	private int curPage = 1;

	private int pageSize = 10;

}
