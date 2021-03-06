package com.hz.admin.db.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table hz_role
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class TRole implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.role_name
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.role_no
     *
     * @mbg.generated
     */
    private String roleNo;

    /**
     * Database Column Remarks:
     *   等级越大级别越小1超级管理，
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.role_level
     *
     * @mbg.generated
     */
    private Integer roleLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_role.remarks
     *
     * @mbg.generated
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hz_role
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.id
     *
     * @return the value of hz_role.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.id
     *
     * @param id the value for hz_role.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.role_name
     *
     * @return the value of hz_role.role_name
     *
     * @mbg.generated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.role_name
     *
     * @param roleName the value for hz_role.role_name
     *
     * @mbg.generated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.role_no
     *
     * @return the value of hz_role.role_no
     *
     * @mbg.generated
     */
    public String getRoleNo() {
        return roleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.role_no
     *
     * @param roleNo the value for hz_role.role_no
     *
     * @mbg.generated
     */
    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.role_level
     *
     * @return the value of hz_role.role_level
     *
     * @mbg.generated
     */
    public Integer getRoleLevel() {
        return roleLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.role_level
     *
     * @param roleLevel the value for hz_role.role_level
     *
     * @mbg.generated
     */
    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.update_time
     *
     * @return the value of hz_role.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.update_time
     *
     * @param updateTime the value for hz_role.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.create_time
     *
     * @return the value of hz_role.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.create_time
     *
     * @param createTime the value for hz_role.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.status
     *
     * @return the value of hz_role.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.status
     *
     * @param status the value for hz_role.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_role.remarks
     *
     * @return the value of hz_role.remarks
     *
     * @mbg.generated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_role.remarks
     *
     * @param remarks the value for hz_role.remarks
     *
     * @mbg.generated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}