package com.hz.admin.model.pojo.dto.menu;

import com.hz.hzsf.common.pojo.CommonPojo;

import javax.validation.constraints.NotNull;

/**
 * @Classname MenuRequestQueryPageDTO
 * @Description TODO
 * @Date 2019-08-31 19:57
 * @Created by hzong
 */
public class MenuRequestDTO extends CommonPojo {
    @NotNull(message = "{required}")
    protected Long menuParent;


    public Long getMenuParent() {
        return menuParent;
    }

    public MenuRequestDTO setMenuParent(Long menuParent) {
        this.menuParent = menuParent;
        return this;
    }
}
