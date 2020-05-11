package com.hz.admin.db.service.role.impl;

import com.hz.admin.db.entity.TRole;
import com.hz.admin.db.entity.TRoleExample;
import com.hz.admin.db.mapper.TRoleMapper;
import com.hz.admin.db.result.PageResult;
import com.hz.admin.db.service.BaseService;
import com.hz.admin.db.service.role.RoleService;
import com.hz.admin.model.pojo.dto.role.RoleRequestQueryPageDTO;
import com.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname RoleBiz
 * @Description TODO
 * @Date 2020-01-07 21:10
 * @Created by hzong
 */
@Component
public class RoleServiceImpl extends BaseService<TRoleExample, TRole, Long> implements RoleService {
    @Autowired
    private TRoleMapper tRoleMapper;

    @Override
    public int insert(TRole record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insert(record);
    }

    @Override
    public int insertSelective(TRole record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TRole record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TRole record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKey(record);
    }

    @Override
    public int updateByExampleSelective(TRole record, TRoleExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(TRole record, TRoleExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExample(record, example);
    }
//    public PageResult<TRole> selectPage(RoleRequestQueryPageDTO dto) {
//
//        //条件查询
//        TRoleExample example = new TRoleExample();
//        TRoleExample.Criteria criteria = example.createCriteria();
//        //分页插件
//        return selectPages(dto.getPageNum(), dto.getPageSize(), example);
//    }
    @Override
    protected Object mapper() {
        return tRoleMapper;
    }
}
