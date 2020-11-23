package com.hz.admin.db.repository.role.impl;

import com.hz.admin.db.repository.BaseRepository;
import com.hz.admin.db.repository.role.RoleRepository;
import com.hz.admin.db.entity.TRole;
import com.hz.admin.db.entity.TRoleExample;
import com.hz.admin.db.entity.ex.SysRoleMenuDO;
import com.hz.admin.db.mapper.TRoleMapper;
import com.hz.admin.db.mapper.ex.RoleExtMapper;
import com.dzzh.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname RoleBiz
 * @Description TODO
 * @Date 2020-01-07 21:10
 * @Created by hzong
 */
@Component
public class RoleRepositoryImpl extends BaseRepository<TRoleExample, TRole, Long> implements RoleRepository {
    @Autowired
    private TRoleMapper tRoleMapper;
    @Autowired
    private RoleExtMapper roleExtMapper;
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

    @Override
    public List<SysRoleMenuDO> selectRoleMenuRootList(List<String> roleIds){
        return roleExtMapper.selectRoleMenuRootList(roleIds);
    }

    @Override
    public List<SysRoleMenuDO> getChildRoleMenus(String menuParentNo) {
        return roleExtMapper.getChildRoleMenus(menuParentNo);
    }

    @Override
    public List<SysRoleMenuDO> selectCustnoRoleMenuRootList(String custno) {
        return roleExtMapper.selectCustnoRoleMenuRootList(custno);
    }

    @Override
    public List<SysRoleMenuDO> getChildCustnoRoleMenus(String custno, Integer menuParentNo) {
        return roleExtMapper.getChildCustnoRoleMenus(custno,menuParentNo);
    }


    @Override
    protected Object mapper() {
        return tRoleMapper;
    }
}
