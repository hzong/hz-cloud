package com.hz.admin.service.sysmenu;

import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import com.dzzh.hz.hzsf.common.pojo.dto.page.PageDTO;
import com.hz.admin.db.entity.TMenu;
import com.hz.admin.model.pojo.dto.menu.SysMenuDTO;
import com.hz.admin.model.pojo.dto.menu.SysMenuItemDTO;
import com.hz.admin.pojo.bo.menu.MenuQueryPageBO;

import java.util.List;

/**
 * @Classname SysMenuService
 * @Description TODO
 * @Date 2020-05-10 19:54
 * @Created by hzong
 */
public interface SysMenuService {

    /**
     * 读取角色菜单
     *
     * @return
     */
    ResponseDTO<List<SysMenuDTO>> queryCustnoRoleMenus();


    /**
     * 获取子菜单
     *
     * @param menuParentNo
     * @return
     */
    ResponseDTO<List<SysMenuDTO>> getCustnoRoleChildMenus(Integer menuParentNo);

    /**
     * 查询分页
     * @param query
     * @return
     */
    ResponseDTO<PageDTO<SysMenuItemDTO>> queryPage(MenuQueryPageBO query);

    /**
     * 根据等级查询
     * @param level
     * @return
     */
    ResponseDTO<List<TMenu>> queryLevelMenus(Integer level);

}
