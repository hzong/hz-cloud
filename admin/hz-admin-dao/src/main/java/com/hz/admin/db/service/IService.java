package com.hz.admin.db.service;

import com.github.pagehelper.PageHelper;
import com.hz.admin.db.result.PageResult;

import java.util.List;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2020-04-12 22:03
 * @Created by hzong
 */
public interface IService<TE, T, KI> {

    String SELECT_BY_PRIMARY_KEY = "selectByPrimaryKey";
    String COUNT_BY_EXAMPLE = "countByExample";
    String DELETE_BY_EXAMPLE = "deleteByExample";
    String DELETE_BY_PRIMARY_KEY = "deleteByPrimaryKey";
    String INSERT = "insert";
    String INSERT_SELECTIVE = "insertSelective";
    String SELECT_BY_EXAMPLE = "selectByExample";
    String UPDATE_BY_EXAMPLE_SELECTIVE = "updateByExampleSelective";
    String UPDATE_BY_EXAMPLE = "updateByExample";
    String UPDATE_BY_PRIMARY_KEY_SELECTIVE = "updateByPrimaryKeySelective";
    String UPDATE_BY_PRIMARY_KEY = "updateByPrimaryKey";


    T selectByPrimaryKey(KI id);

    long countByExample(TE example);

    int deleteByExample(TE example);

    int deleteByPrimaryKey(KI id);

    int insert(T record);

    int[] batcherInsert(List<T> records);

    int insertSelective(T record);

    int[] insertSelective(List<T> records);


    List<T> selectByExample(TE example);


    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);


    int updateByExampleSelective(T record, TE example);

    PageResult<T> selectPages(int pageNum, int pageSize, TE te);


    int updateByExample(T record, TE example);

}
