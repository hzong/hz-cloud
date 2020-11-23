package com.hz.admin.db.repository.rolemenu.impl;

import com.hz.admin.db.entity.TRoleMenu;
import com.hz.admin.db.entity.TRoleMenuExample;
import com.hz.admin.db.mapper.TRoleMenuMapper;
import com.hz.admin.db.repository.BaseRepository;
import com.hz.admin.db.repository.rolemenu.RoleMenuRepository;
import com.dzzh.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname RoleMenuRepository
 * @Description TODO
 * @Date 2020-01-07 21:11
 * @Created by hzong
 */
@Component
public class RoleMenuRepositoryImpl extends BaseRepository<TRoleMenuExample, TRoleMenu, Long> implements RoleMenuRepository {

    @Autowired
    private TRoleMenuMapper roleMenuMapper;

    @Override
    protected Object mapper() {
        return roleMenuMapper;
    }

    @Override
    public int insertSelective(TRoleMenu record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insertSelective(record);
    }

    @Override
    public int insert(TRoleMenu record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insert(record);
    }

    @Override
    public int updateByExample(TRoleMenu record, TRoleMenuExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(TRoleMenu record, TRoleMenuExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByPrimaryKey(TRoleMenu record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TRoleMenu record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKeySelective(record);
    }
}
