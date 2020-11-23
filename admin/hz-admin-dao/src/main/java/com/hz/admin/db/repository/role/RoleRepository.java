package com.hz.admin.db.repository.role;

import com.hz.admin.db.entity.TRole;
import com.hz.admin.db.entity.TRoleExample;
import com.hz.admin.db.entity.ex.SysRoleMenuDO;
import com.hz.admin.db.repository.IRepository;

import java.util.List;

/**
 * @Classname RoleRepository
 * @Description TODO
 * @Date 2020-04-28 20:13
 * @Created by hzong
 */
public interface RoleRepository extends IRepository<TRoleExample, TRole, Long> {


    /**
     * 查找角色菜单ROOT
     * @param roleIds
     * @return
     */
     List<SysRoleMenuDO> selectRoleMenuRootList(List<String> roleIds);

    /**
     * 获取子角色菜单
     * @param menuParentNo
     * @return
     */
    List<SysRoleMenuDO> getChildRoleMenus(String menuParentNo);




    /**
     * 查找角色菜单ROOT
     * @return
     */
    List<SysRoleMenuDO> selectCustnoRoleMenuRootList(String custno);

    /**
     * 获取子角色菜单
     * @param menuParentNo
     * @return
     */
    List<SysRoleMenuDO> getChildCustnoRoleMenus(String custno,Integer menuParentNo);



}
