package com.hz.admin.db.mapper;

import com.hz.admin.db.entity.TRoleMenu;
import com.hz.admin.db.entity.TRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    long countByExample(TRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int deleteByExample(TRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int insert(TRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int insertSelective(TRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    List<TRoleMenu> selectByExample(TRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    TRoleMenu selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TRoleMenu record, @Param("example") TRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TRoleMenu record, @Param("example") TRoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_role_menu
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TRoleMenu record);
}