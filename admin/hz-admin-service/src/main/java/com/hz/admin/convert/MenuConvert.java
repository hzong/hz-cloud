package com.hz.admin.convert;

import com.dzzh.hz.hzsf.common.pojo.dto.page.PageDTO;
import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.hz.admin.db.entity.TMenu;
import com.hz.admin.db.entity.ex.SysRoleMenuDO;
import com.hz.admin.model.pojo.dto.menu.MenuRequestQueryPageDTO;
import com.hz.admin.model.pojo.dto.menu.SysMenuDTO;
import com.hz.admin.model.pojo.dto.menu.SysMenuItemDTO;
import com.hz.admin.pojo.bo.menu.MenuQueryBO;
import com.hz.admin.pojo.bo.menu.MenuQueryPageBO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Classname MenuConvert
 * @Description TODO
 * @Date 2020-07-28 23:31
 * @Created by hzong
 */
public final class MenuConvert {
    private MenuConvert() {
    }

    public static PageDTO<SysMenuItemDTO> convertPageResultDTO(Page<TMenu> page) {

        List<SysMenuItemDTO> list = Lists.newArrayList();
        SysMenuItemDTO item = null;
        for (TMenu menu : page.getResult()) {
            item = new SysMenuItemDTO();
            BeanUtils.copyProperties(menu, item);
            list.add(item);
        }
        return PageConvert.convertPageResultDTO(page, list);
    }

    public static MenuQueryPageBO convertMenuQueryPageBO(MenuRequestQueryPageDTO dto) {
        MenuQueryPageBO bo = new MenuQueryPageBO();
        bo.setMenuQuery(new MenuQueryBO()).setPageNum(dto.getPageNum()).setPageSize(dto.getPageSize());
        bo.getMenuQuery().setLevel(dto.getLevel()).setMenuName(dto.getMenuName());
        return bo;
    }


    private static List<SysMenuDTO> convertSysMenuDTO(List list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        List<SysMenuDTO> dtos = Lists.newArrayList();
        list.forEach(item -> {
            SysMenuDTO menu = new SysMenuDTO();
            BeanUtils.copyProperties(item, menu);
            dtos.add(menu);
        });
        return dtos;
    }

    public static List<SysMenuDTO> sysRoleMenuDOConvertSysMenuDTO(List<SysRoleMenuDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<SysMenuDTO> dtos = convertSysMenuDTO(list);


        return dtos;
    }

}
