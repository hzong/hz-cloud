package com.hz.admin.db.mapper.ex;

import com.hz.admin.db.entity.ex.AccountCustnoInfoDO;

/**
 * @Classname AccountCustnoInfoExtMapper
 * @Description TODO
 * @Date 2020-07-15 23:18
 * @Created by hzong
 */
public interface AccountCustnoInfoExtMapper {

    /**查询账号信息
     * @param account
     * @return
     */
    AccountCustnoInfoDO selectAccountByCustnoInfo(String account);
}
