package com.hz.admin.db.mapper.ex;

import com.hz.admin.db.entity.ex.SysRoleMenuDO;

import java.util.List;

/**
 * @Classname CustNoRoleExtMapper
 * @Description TODO
 * @Date 2020-01-31 15:54
 * @Created by hzong
 */
public interface RoleExtMapper {




    /**
     * 角色关联的菜单
     * @return
     */
    List<SysRoleMenuDO> selectRoleMenuRootList(List<String> roleIds);

    /**
     * 获取角色权限子菜单
     * @param menuParentNo
     * @return
     */
    List<SysRoleMenuDO> getChildRoleMenus(String menuParentNo);


    /**
     * 角色关联的菜单
     * @return
     */
    List<SysRoleMenuDO> selectCustnoRoleMenuRootList(String custno);

    /**
     * 获取角色权限子菜单
     * @return
     */
    List<SysRoleMenuDO> getChildCustnoRoleMenus(String custno,Integer menuParentNo);

}
