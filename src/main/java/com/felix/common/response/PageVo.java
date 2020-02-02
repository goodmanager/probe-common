package com.felix.common.response;

import lombok.Data;

@Data
public class PageVo {

	private int totalPage;

	private int curPage;

	private int pageSize;

}
