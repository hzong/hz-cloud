package com.hz.admin.db.entity.ex;

import com.hz.hzsf.common.pojo.CommonPojo;

/**
 * @Classname AccountRoleDO
 * @Description TODO
 * @Date 2020-01-26 20:15
 * @Created by hzong
 */
public class AccountRoleDO extends CommonPojo {

    protected String id;
    protected String roleName;
    protected String roleNo;
    protected Integer roleLevel;
    protected Integer isEnable;

    public String getId() {
        return id;
    }

    public AccountRoleDO setId(String id) {
        this.id = id;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public AccountRoleDO setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public AccountRoleDO setRoleNo(String roleNo) {
        this.roleNo = roleNo;
        return this;
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public AccountRoleDO setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public AccountRoleDO setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }
}
