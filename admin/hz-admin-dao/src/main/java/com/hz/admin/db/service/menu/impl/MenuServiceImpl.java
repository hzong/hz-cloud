package com.hz.admin.db.service.menu.impl;

import com.hz.admin.db.entity.TMenu;
import com.hz.admin.db.entity.TMenuExample;
import com.hz.admin.db.mapper.TMenuMapper;
import com.hz.admin.db.result.PageResult;
import com.hz.admin.db.service.BaseService;
import com.hz.admin.db.service.menu.MenuService;
import com.hz.admin.model.pojo.dto.menu.MenuRequestQueryPageDTO;
import com.hz.hzsf.common.codes.NumberCodeEnum;
import com.hz.hzsf.common.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname MenuService
 * @Description TODO
 * @Date 2020-01-06 23:26
 * @Created by hzong
 */
@Component
public class MenuServiceImpl extends BaseService<TMenuExample, TMenu, Long> implements MenuService {

    @Autowired
    TMenuMapper menuMapper;

    @Override
    public int insert(TMenu record) {

        record.setCreateTime(DateUtils.getCurrentDate());

        return super.insert(record);
    }

    @Override
    public int insertSelective(TMenu record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        if(record.getMenuParent() == null){
            record.setMenuParent(NumberCodeEnum.N00.getLval());
        }
        return super.insertSelective(record);
    }


    @Override
    public int updateByExample(TMenu record, TMenuExample example) {

        record.setUpdateTime(DateUtils.getCurrentDate());

        return super.updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(TMenu record, TMenuExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByPrimaryKey(TMenu record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKey(record);
    }


    @Override
    public int updateByPrimaryKeySelective(TMenu record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKeySelective(record);
    }



    @Override
    public List<TMenu> getChildMenus(Long pid) {

        if(pid == null){
            return null;
        }

        TMenuExample example = new TMenuExample();
        example.createCriteria().andMenuParentEqualTo(pid).andStatusEqualTo(NumberCodeEnum.N00.getIval());
        return selectByExample(example);
    }

    @Override
    public List<TMenu> getRootMenus() {
        TMenuExample example = new TMenuExample();
        example.createCriteria().andMenuParentEqualTo(NumberCodeEnum.N00.getLval());
        return selectByExample(example);
    }


    @Override
    protected Object mapper() {
        return menuMapper;
    }
}
