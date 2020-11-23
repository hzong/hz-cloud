package com.dzzh.hz.hzsf.common.pojo.dto.page;


import java.io.Serializable;
import java.util.List;

/**
 * Page返回对象
 *
 */
public class PageDTO<T> implements Serializable {

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页的数量
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Integer total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 结果集
     */
    private List<T> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public PageDTO<T> setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageDTO<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public PageDTO<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPages() {
        return pages;
    }

    public PageDTO<T> setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public PageDTO<T> setList(List<T> list) {
        this.list = list;
        return this;
    }
}
