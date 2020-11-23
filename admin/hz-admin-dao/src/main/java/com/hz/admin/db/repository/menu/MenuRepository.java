package com.hz.admin.db.repository.menu;

import com.hz.admin.db.entity.TMenu;
import com.hz.admin.db.entity.TMenuExample;
import com.hz.admin.db.repository.IRepository;

import java.util.List;

/**
 * @Classname MenuRepository
 * @Description TODO
 * @Date 2020-04-28 20:13
 * @Created by hzong
 */
public interface MenuRepository extends IRepository<TMenuExample, TMenu, Long> {
    /**
     * 获取子菜单
     *
     * @param pid
     * @return
     */
    List<TMenu> getChildMenus(Integer pid);

    /**
     * 获跟菜单
     * @return
     */
    List<TMenu> getRootMenus();

    /**
     * 获取级别菜单
     * @return
     */
    List<TMenu> queryLevelMenus(Integer level);
}
