package com.hz.admin.convert;

import com.dzzh.hz.hzsf.common.pojo.dto.page.PageDTO;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @Classname PageConvert
 * @Description TODO
 * @Date 2020-08-30 23:00
 * @Created by hzong
 */
public final class PageConvert {
    private PageConvert() {
    }


    /**
     * 转换分页ResultDTO对象
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageDTO<T> convertPageResultDTO(List<T> list) {
        if (list instanceof Page) {
            return convertPageResultDTO(list);
        }
        return null;
    }

    public static <T> PageDTO<T> convertPageResultDTO(Page<T> list) {
        PageDTO<T> result = new PageDTO<>();
        Page<T> page = (Page<T>) list;
        result.setTotal((int) page.getTotal());
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setPages(page.getPages());
        result.setList(page.getResult());
        return result;
    }


    /**
     * 转换分页ResultDTO对象
     *
     * @param <T>
     * @return
     */
    public static <T> PageDTO<T> convertPageResultDTO(Page page, List<T> list) {
        if (page == null) {
            return null;
        }
        PageDTO<T> result = new PageDTO<>();
        result.setTotal((int) page.getTotal());
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setPages(page.getPages());
        result.setList(list);
        return result;
    }
}
