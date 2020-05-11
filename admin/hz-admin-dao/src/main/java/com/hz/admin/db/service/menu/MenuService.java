package com.hz.admin.db.service.menu;

import com.hz.admin.db.entity.TMenu;
import com.hz.admin.db.entity.TMenuExample;
import com.hz.admin.db.service.IService;

import java.util.List;

/**
 * @Classname MenuService
 * @Description TODO
 * @Date 2020-04-28 20:13
 * @Created by hzong
 */
public interface MenuService extends IService<TMenuExample, TMenu, Long> {
    /**
     * 获取子菜单
     *
     * @param pid
     * @return
     */
    List<TMenu> getChildMenus(Long pid);

    /**
     * 获跟菜单
     * @return
     */
    List<TMenu> getRootMenus();
}
