package com.dzzh.hz.hzsf.common.pojo;


import com.dzzh.hz.hzsf.common.constants.SystemConstants;

/**
 * @Classname RequestPage
 * @Description TODO
 * @Date 2019-08-31 20:07
 * @Created by hzong
 */
public class RequestPage extends CommonPojo {

    private Integer pageNum = 1;

    private Integer pageSize = SystemConstants.PAGE_ROW;

    private Integer orderBy;


    public Integer getPageNum() {
        return pageNum;
    }

    public RequestPage setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public RequestPage setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }


}
