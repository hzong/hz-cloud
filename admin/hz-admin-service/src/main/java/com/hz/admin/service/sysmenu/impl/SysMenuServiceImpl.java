package com.hz.admin.service.sysmenu.impl;

import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import com.github.pagehelper.Page;
import com.hz.admin.convert.MenuConvert;
import com.hz.admin.db.entity.TMenu;
import com.hz.admin.db.entity.TMenuExample;
import com.hz.admin.db.repository.menu.MenuRepository;
import com.hz.admin.db.repository.role.RoleRepository;
import com.hz.admin.pojo.bo.menu.MenuQueryPageBO;
import com.hz.admin.service.sysmenu.SysMenuService;
import com.hz.admin.utils.SessionUtil;
import com.hz.admin.db.entity.ex.SysRoleMenuDO;
import com.hz.admin.model.pojo.dto.menu.SysMenuDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname MenuRepositoryImpl
 * @Description TODO
 * @Date 2020-05-10 19:54
 * @Created by hzong
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private RoleRepository roleService;
    @Autowired
    private MenuRepository menuService;

    /**çç∂∂≈≈、、、
     * 查询分页
     * @param query
     * @return
     */
    @Override
    public ResponseDTO queryPage(MenuQueryPageBO query){
        if(query == null){
            ResponseDTO.fail("查询对象为空");
        }
        TMenuExample menuExample = new TMenuExample();
        TMenuExample.Criteria criteria = menuExample.createCriteria();
        //菜单名称菜单名称
        if(StringUtils.isNotBlank(query.getMenuQuery().getMenuName())){
            criteria.andMenuNameLike(query.getMenuQuery().getMenuName()+"%");
        }
        //层级
        if(query.getMenuQuery().getLevel() != null){
            criteria.andLevelEqualTo(query.getMenuQuery().getLevel());
        }

        Page<TMenu> page = menuService.selectPages(query.getPageNum(), query.getPageSize(),menuExample );
        return ResponseDTO.ok(MenuConvert.convertPageResultDTO(page));
    }


    @Override
    public ResponseDTO<List<SysMenuDTO>> queryCustnoRoleMenus() {
        List<SysRoleMenuDO> menus = roleService.selectCustnoRoleMenuRootList(SessionUtil.getSessionCustno());
        if (CollectionUtils.isEmpty(menus)) {
            return ResponseDTO.ok();
        }
        return ResponseDTO.ok(MenuConvert.sysRoleMenuDOConvertSysMenuDTO(menus));
    }

    @Override
    public ResponseDTO<List<SysMenuDTO>> getCustnoRoleChildMenus(Integer menuParentNo) {
        List<SysRoleMenuDO> menus = roleService.getChildCustnoRoleMenus(SessionUtil.getSessionCustno(), menuParentNo);
        if (CollectionUtils.isEmpty(menus)) {
            return ResponseDTO.ok();
        }
        return ResponseDTO.ok(MenuConvert.sysRoleMenuDOConvertSysMenuDTO(menus));
    }

    @Override
    public ResponseDTO<List<TMenu>> queryLevelMenus(Integer level) {
        return ResponseDTO.ok(menuService.queryLevelMenus(level));
    }


}
