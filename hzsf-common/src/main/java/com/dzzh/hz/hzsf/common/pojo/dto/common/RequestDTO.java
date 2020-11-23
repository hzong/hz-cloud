package com.dzzh.hz.hzsf.common.pojo.dto.common;

import com.dzzh.hz.hzsf.common.pojo.CommonPojo;

import javax.validation.Valid;

/**
 * 请求dto
 * @author daoqidelv
 * @createdate 2017年10月15日
 * @param <T>
 */
public class RequestDTO<T> extends CommonPojo implements IDto {

	/**
	 * 请求渠道
	 * 例如:web,pc,wap
	 */
	private String clientType;
	/**
	 * 跟踪ID
	 * 客户端生成ID
	 */
	private String traceId;


	public String getClientType() {
		return clientType;
	}

	public RequestDTO<T> setClientType(String clientType) {
		this.clientType = clientType;
		return this;
	}

	public String getTraceId() {
		return traceId;
	}

	public RequestDTO<T> setTraceId(String traceId) {
		this.traceId = traceId;
		return this;
	}
}
