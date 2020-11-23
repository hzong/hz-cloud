package com.hz.admin.db.repository.account;


import com.hz.admin.db.entity.TAccount;
import com.hz.admin.db.entity.TAccountExample;
import com.hz.admin.db.entity.ex.AccountCustnoInfoDO;
import com.hz.admin.db.entity.ex.AccountMenuDO;
import com.hz.admin.db.entity.ex.AccountRoleDO;
import com.hz.admin.db.repository.IRepository;

import java.util.List;

/**
 * @Classname AccountRepository
 * @Description TODO
 * @Date 2020-04-28 20:12
 * @Created by hzong
 */
public interface AccountRepository extends IRepository<TAccountExample, TAccount, String> {


    /**
     * 查询账号角色列表
     * @param account
     * @return
     */
     List<AccountRoleDO> selectAccountRoleList(String account);

    /**查询账号的菜单
     * @param account
     * @return
     */
     List<AccountMenuDO> selectAccountMenuList(String account);

    /**
     * 查询账号信息
     * @param account
     * @return
     */
     AccountCustnoInfoDO selectAccountByCustnoInfo(String account);






}
