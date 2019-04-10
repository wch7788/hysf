package com.example.demo.dto;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageResponseDto<T> {

	/**
	 * 记录集合
	 */
	private List<?> list = new ArrayList<>();

	/**
	 * 返回的result
	 */
	private Map<String, Object> resultMap = new HashMap<>();
	
	/**
	 * 存储分页信息
	 */
	private Map<String, Object> pageInfoMap = new HashMap<>();
	
	public PageResponseDto() {}
	
	public PageResponseDto(Page<T> page) {
		this.list = page.getResult();
		pageInfoMap.put("totalPage", page.getPages());
		resultMap.put("dataList", this.list);
		resultMap.put("pageInfo", pageInfoMap);
	}
	
	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
		resultMap.put("dataList", this.list);
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public Map<String, Object> getPageInfoMap() {
		return pageInfoMap;
	}

	public void setPageInfoMap(Map<String, Object> pageInfoMap) {
		this.pageInfoMap = pageInfoMap;
	}
	
}
