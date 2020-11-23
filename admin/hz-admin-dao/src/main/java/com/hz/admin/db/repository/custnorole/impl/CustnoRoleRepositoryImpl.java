package com.hz.admin.db.repository.custnorole.impl;

import com.hz.admin.db.entity.TCustnoRole;
import com.hz.admin.db.entity.TCustnoRoleExample;
import com.hz.admin.db.mapper.TCustnoRoleMapper;
import com.hz.admin.db.mapper.ex.CustNoRoleExtMapper;
import com.hz.admin.db.repository.BaseRepository;
import com.hz.admin.db.repository.custnorole.CustnoRoleRepository;
import com.dzzh.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname BaseRepository
 * @Description TODO
 * @Date 2020-01-07 21:10
 * @Created by hzong
 */
@Component
public class CustnoRoleRepositoryImpl extends BaseRepository<TCustnoRoleExample, TCustnoRole, Long> implements CustnoRoleRepository {

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


//    public PageResult<CustNoRoleDO> selectPages(CustNoRoleQueryPageRequest dto) {
//        //分页插件
//        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
//        //条件查询
//        PageResult pageResult = new PageResult(selectList(dto));
//        //分页插件
//        return pageResult;
//    }


//
//    public List<CustNoRoleDO> selectList(CustNoRoleQueryPageRequest dto) {
//        //条件查询
//        List<CustNoRoleDO> custNoRoles = custNoRoleExtMapper.selectCustNoRoleList(dto);
//        return custNoRoles;
//    }


    @Override
    protected Object mapper() {
        return custnoRoleMapper;
    }
}
