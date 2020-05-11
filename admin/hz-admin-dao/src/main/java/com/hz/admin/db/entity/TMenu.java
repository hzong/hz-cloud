package com.hz.admin.db.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table hz_menu
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class TMenu implements Serializable {
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
     *   从 1开始
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.level
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.url
     *
     * @mbg.generated
     */
    private String url;

    /**
     * Database Column Remarks:
     *   是否启用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hz_menu.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hz_menu
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.menu_id
     *
     * @return the value of hz_menu.menu_id
     *
     * @mbg.generated
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.menu_id
     *
     * @param menuId the value for hz_menu.menu_id
     *
     * @mbg.generated
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.menu_no
     *
     * @return the value of hz_menu.menu_no
     *
     * @mbg.generated
     */
    public String getMenuNo() {
        return menuNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.menu_no
     *
     * @param menuNo the value for hz_menu.menu_no
     *
     * @mbg.generated
     */
    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.menu_name
     *
     * @return the value of hz_menu.menu_name
     *
     * @mbg.generated
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.menu_name
     *
     * @param menuName the value for hz_menu.menu_name
     *
     * @mbg.generated
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.menu_parent
     *
     * @return the value of hz_menu.menu_parent
     *
     * @mbg.generated
     */
    public Long getMenuParent() {
        return menuParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.menu_parent
     *
     * @param menuParent the value for hz_menu.menu_parent
     *
     * @mbg.generated
     */
    public void setMenuParent(Long menuParent) {
        this.menuParent = menuParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.seq
     *
     * @return the value of hz_menu.seq
     *
     * @mbg.generated
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.seq
     *
     * @param seq the value for hz_menu.seq
     *
     * @mbg.generated
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.level
     *
     * @return the value of hz_menu.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.level
     *
     * @param level the value for hz_menu.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.url
     *
     * @return the value of hz_menu.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.url
     *
     * @param url the value for hz_menu.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.status
     *
     * @return the value of hz_menu.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.status
     *
     * @param status the value for hz_menu.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.update_time
     *
     * @return the value of hz_menu.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.update_time
     *
     * @param updateTime the value for hz_menu.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hz_menu.create_time
     *
     * @return the value of hz_menu.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hz_menu.create_time
     *
     * @param createTime the value for hz_menu.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}