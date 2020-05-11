package com.hz.admin.db.service.custnorole.impl;

import com.github.pagehelper.PageHelper;
import com.hz.admin.db.entity.TCustnoRole;
import com.hz.admin.db.entity.TCustnoRoleExample;
import com.hz.admin.db.entity.ex.CustNoRoleDO;
import com.hz.admin.db.mapper.TCustnoRoleMapper;
import com.hz.admin.db.mapper.ex.CustNoRoleExtMapper;
import com.hz.admin.db.result.PageResult;
import com.hz.admin.db.service.BaseService;
import com.hz.admin.db.service.custnorole.CustnoRoleService;
import com.hz.admin.model.pojo.dto.custrole.CustNoRoleQueryPageDTO;
import com.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname BaseService
 * @Description TODO
 * @Date 2020-01-07 21:10
 * @Created by hzong
 */
@Component
public class CustnoRoleServiceImpl extends BaseService<TCustnoRoleExample, TCustnoRole, Long> implements CustnoRoleService {

    @Autowired
    private TCustnoRoleMapper custnoRoleMapper;
    @Autowired
    private CustNoRoleExtMapper custNoRoleExtMapper;

    @Override
    public int insertSelective(TCustnoRole record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insertSelective(record);
    }

    @Override
    public int insert(TCustnoRole record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insert(record);
    }

    @Override
    public int updateByExample(TCustnoRole record, TCustnoRoleExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(TCustnoRole record, TCustnoRoleExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByPrimaryKey(TCustnoRole record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TCustnoRole record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKeySelective(record);
    }


//    public PageResult<CustNoRoleDO> selectPages(CustNoRoleQueryPageDTO dto) {
//        //分页插件
//        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
//        //条件查询
//        PageResult pageResult = new PageResult(selectList(dto));
//        //分页插件
//        return pageResult;
//    }


//
//    public List<CustNoRoleDO> selectList(CustNoRoleQueryPageDTO dto) {
//        //条件查询
//        List<CustNoRoleDO> custNoRoles = custNoRoleExtMapper.selectCustNoRoleList(dto);
//        return custNoRoles;
//    }


    @Override
    protected Object mapper() {
        return custnoRoleMapper;
    }
}
