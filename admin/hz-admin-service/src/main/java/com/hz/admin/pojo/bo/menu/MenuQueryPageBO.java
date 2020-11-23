package com.hz.admin.pojo.bo.menu;

import com.dzzh.hz.hzsf.common.pojo.RequestPage;

/**
 * @Classname MenuQueryPageBO
 * @Description TODO
 * @Date 2020-08-25 22:08
 * @Created by hzong
 */
public class MenuQueryPageBO extends RequestPage {
    /**
     * 查询功能
     */
    private MenuQueryBO menuQuery;

    public MenuQueryBO getMenuQuery() {
        return menuQuery;
    }

    public MenuQueryPageBO setMenuQuery(MenuQueryBO menuQuery) {
        this.menuQuery = menuQuery;
        return this;
    }
}
