package com.hz.admin.db.service.custnoinfo.impl;

import com.hz.admin.db.entity.TCustnoInfo;
import com.hz.admin.db.entity.TCustnoInfoExample;
import com.hz.admin.db.mapper.TCustnoInfoMapper;
import com.hz.admin.db.result.PageResult;
import com.hz.admin.db.service.BaseService;
import com.hz.admin.db.service.custnoinfo.CustnoInfoService;
import com.hz.admin.model.pojo.dto.custnoinfo.CustNoInfoQueryPageDTO;
import com.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname CustnoInfoService
 * @Description TODO
 * @Date 2020-01-07 21:08
 * @Created by hzong
 */
@Component
public class CustnoInfoServiceImpl extends BaseService<TCustnoInfoExample, TCustnoInfo, Long> implements CustnoInfoService

{
    @Autowired
    private TCustnoInfoMapper custnoInfoMapper;


    @Override
    protected Object mapper() {
        return custnoInfoMapper;
    }

    @Override
    public int insert(TCustnoInfo record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insert(record);
    }

    @Override
    public int insertSelective(TCustnoInfo record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insertSelective(record);
    }


    @Override
    public int updateByPrimaryKeySelective(TCustnoInfo record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TCustnoInfo record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKey(record);
    }

    @Override
    public int updateByExampleSelective(TCustnoInfo record, TCustnoInfoExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(TCustnoInfo record, TCustnoInfoExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExample(record, example);
    }
//
//    public PageResult<TCustnoInfo> selectPage(CustNoInfoQueryPageDTO dto) {
//
//        //条件查询
//        TCustnoInfoExample example = new TCustnoInfoExample();
//        TCustnoInfoExample.Criteria criteria = example.createCriteria();
//
//        //分页插件
//        return selectPages(dto.getPageNum(), dto.getPageSize(), example);
//    }

}
