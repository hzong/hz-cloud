package com.hz.admin.db.entity.ex;

import com.dzzh.hz.hzsf.common.pojo.CommonPojo;

/**
 * @Classname AccountRoleDO
 * @Description TODO
 * @Date 2020-01-26 20:15
 * @Created by hzong
 */
public class AccountMenuDO extends CommonPojo {

    /**
     * Database Column Remarks:
     *   主键字段
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.menu_id
     *
     * @mbg.generated
     */
    private Long menuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.menu_no
     *
     * @mbg.generated
     */
    private String menuNo;

    /**
     * Database Column Remarks:
     *   菜单名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.menu_name
     *
     * @mbg.generated
     */
    private String menuName;

    /**
     * Database Column Remarks:
     *   父菜单
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.menu_parent
     *
     * @mbg.generated
     */
    private Long menuParent;

    /**
     * Database Column Remarks:
     *   菜单序号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.seq
     *
     * @mbg.generated
     */
    private Integer seq;

    /**
     * Database Column Remarks:
     *   是否启用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.is_enable
     *
     * @mbg.generated
     */
    private Integer status;


    public Long getMenuId() {
        return menuId;
    }

    public AccountMenuDO setMenuId(Long menuId) {
        this.menuId = menuId;
        return this;
    }

    public String getMenuNo() {
        return menuNo;
    }

    public AccountMenuDO setMenuNo(String menuNo) {
        this.menuNo = menuNo;
        return this;
    }

    public String getMenuName() {
        return menuName;
    }

    public AccountMenuDO setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public Long getMenuParent() {
        return menuParent;
    }

    public AccountMenuDO setMenuParent(Long menuParent) {
        this.menuParent = menuParent;
        return this;
    }

    public Integer getSeq() {
        return seq;
    }

    public AccountMenuDO setSeq(Integer seq) {
        this.seq = seq;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public AccountMenuDO setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
