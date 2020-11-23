package com.dzzh.hz.hzsf.common.pojo.dto.common;

import com.dzzh.hz.hzsf.common.constants.SystemConstants;

/**
 * @Classname RequestPageDTO
 * @Description TODO
 * @Date 2020-09-11 01:34
 * @Created by hzong
 */
public class RequestPageDTO extends RequestDTO {

    private Integer pageNum = 1;

    private Integer pageSize = SystemConstants.PAGE_ROW;

    private Integer orderBy;

    public Integer getPageNum() {
        return pageNum;
    }

    public RequestPageDTO setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public RequestPageDTO setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public RequestPageDTO setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
        return this;
    }
}
