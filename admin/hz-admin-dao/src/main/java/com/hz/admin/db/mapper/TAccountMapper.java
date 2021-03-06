package com.hz.admin.db.mapper;

import com.hz.admin.db.entity.TAccount;
import com.hz.admin.db.entity.TAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    long countByExample(TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int deleteByExample(TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String account);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int insert(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int insertSelective(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    List<TAccount> selectByExample(TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    TAccount selectByPrimaryKey(String account);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TAccount record, @Param("example") TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TAccount record, @Param("example") TAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hz_account
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TAccount record);
}