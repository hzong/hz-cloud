package com.hz.admin.db.repository.account.impl;

import com.hz.admin.db.repository.BaseRepository;
import com.hz.admin.db.repository.account.AccountRepository;
import com.hz.admin.db.entity.TAccount;
import com.hz.admin.db.entity.TAccountExample;
import com.hz.admin.db.entity.ex.AccountCustnoInfoDO;
import com.hz.admin.db.entity.ex.AccountMenuDO;
import com.hz.admin.db.entity.ex.AccountRoleDO;
import com.hz.admin.db.mapper.TAccountMapper;
import com.hz.admin.db.mapper.ex.AccountCustnoInfoExtMapper;
import com.hz.admin.db.mapper.ex.AccountExtMapper;
import com.dzzh.hz.hzsf.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname AccountRepository
 * @Description TODO
 * @Date 2020-01-07 20:14
 * @Created by hzong
 */
@Component
public class AccountRepositoryImpl extends BaseRepository<TAccountExample, TAccount, String> implements AccountRepository {

    @Autowired
    private TAccountMapper accountMapper;
    @Autowired
    private AccountExtMapper accountExtMapper;
    @Autowired
    private AccountCustnoInfoExtMapper accountCustnoInfoExtMapper;

    @Override
    public int insert(TAccount record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insert(record);
    }


    @Override
    public int insertSelective(TAccount record) {
        record.setCreateTime(DateUtils.getCurrentDate());
        return super.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TAccount record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TAccount record) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByPrimaryKey(record);
    }

    @Override
    public int updateByExampleSelective(TAccount record, TAccountExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(TAccount record, TAccountExample example) {
        record.setUpdateTime(DateUtils.getCurrentDate());
        return super.updateByExample(record, example);
    }


    /**
     * 查询账号角色列表
     * @param account
     * @return
     */
    @Override
    public List<AccountRoleDO> selectAccountRoleList(String account){
        return accountExtMapper.selectAccountRoleList(account);
    }

    /**查询账号的菜单
     * @param account
     * @return
     */
    @Override
    public List<AccountMenuDO> selectAccountMenuList(String account){
        return accountExtMapper.selectAccountMenuList(account);
    }

    @Override
    public AccountCustnoInfoDO selectAccountByCustnoInfo(String account){
        return accountCustnoInfoExtMapper.selectAccountByCustnoInfo(account);
    }


    @Override
    protected Object mapper() {
        return accountMapper;
    }
}
