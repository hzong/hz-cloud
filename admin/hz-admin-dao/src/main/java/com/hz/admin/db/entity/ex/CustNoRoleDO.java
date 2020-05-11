package com.hz.admin.db.entity.ex;

/**
 * @Classname CustNoRoleDO
 * @Description TODO
 * @Date 2020-01-31 15:51
 * @Created by hzong
 */
public class CustNoRoleDO {
    /**
     * 会员
     */
    private String custNo;
    /**
     * 角色
     */
    private String roleName;
    private String updateTime;
    private String createTime;


    public String getCustNo() {
        return custNo;
    }

    public CustNoRoleDO setCustNo(String custNo) {
        this.custNo = custNo;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public CustNoRoleDO setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public CustNoRoleDO setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public CustNoRoleDO setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
}
