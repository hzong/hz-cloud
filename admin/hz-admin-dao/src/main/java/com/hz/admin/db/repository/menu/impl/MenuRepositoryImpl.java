package com.hz.admin.db.repository.menu.impl;

import com.hz.admin.db.entity.TMenu;
import com.hz.admin.db.entity.TMenuExample;
import com.hz.admin.db.mapper.TMenuMapper;
import com.hz.admin.db.repository.BaseRepository;
import com.hz.admin.db.repository.menu.MenuRepository;
import com.dzzh.hz.hzsf.common.codes.ENumberCode;
import com.dzzh.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname MenuRepository
 * @Description TODO
 * @Date 2020-01-06 23:26
 * @Created by hzong
 */
@Component
public class MenuRepositoryImpl extends BaseRepository<TMenuExample, TMenu, Long> implements MenuRepository {

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
        if(record.getMenuParentId() == null){
            record.setMenuParentId(ENumberCode.N00.getIval());
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
    public List<TMenu> getChildMenus(Integer pid) {

        if(pid == null){
            return null;
        }

        TMenuExample example = new TMenuExample();
        example.createCriteria().andMenuParentIdEqualTo(pid).andStatusEqualTo(ENumberCode.N01.getIval());
        return selectByExample(example);
    }

    @Override
    public List<TMenu> getRootMenus() {
        TMenuExample example = new TMenuExample();
        example.createCriteria().andMenuParentIdEqualTo(ENumberCode.N00.getIval());
        return selectByExample(example);
    }

    @Override
    public List<TMenu> queryLevelMenus(Integer level) {
        TMenuExample example = new TMenuExample();
        example.createCriteria().andLevelEqualTo(level);
        return selectByExample(example);
    }


    @Override
    protected Object mapper() {
        return menuMapper;
    }
}
