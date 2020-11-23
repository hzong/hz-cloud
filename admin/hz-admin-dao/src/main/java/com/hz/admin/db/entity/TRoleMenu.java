package com.hz.admin.db.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table hz_role_menu
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class TRoleMenu implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role_menu.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role_menu.menu_id
     *
     * @mbg.generated
     */
    private Long menuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role_menu.role_id
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role_menu.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role_menu.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role_menu.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role_menu.id
     *
     * @return the value of hz_role_menu.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role_menu.id
     *
     * @param id the value for hz_role_menu.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role_menu.menu_id
     *
     * @return the value of hz_role_menu.menu_id
     *
     * @mbg.generated
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role_menu.menu_id
     *
     * @param menuId the value for hz_role_menu.menu_id
     *
     * @mbg.generated
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role_menu.role_id
     *
     * @return the value of hz_role_menu.role_id
     *
     * @mbg.generated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role_menu.role_id
     *
     * @param roleId the value for hz_role_menu.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role_menu.status
     *
     * @return the value of hz_role_menu.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role_menu.status
     *
     * @param status the value for hz_role_menu.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role_menu.update_time
     *
     * @return the value of hz_role_menu.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role_menu.update_time
     *
     * @param updateTime the value for hz_role_menu.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role_menu.create_time
     *
     * @return the value of hz_role_menu.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role_menu.create_time
     *
     * @param createTime the value for hz_role_menu.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}