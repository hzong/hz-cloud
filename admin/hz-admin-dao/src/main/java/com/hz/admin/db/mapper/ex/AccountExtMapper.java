package com.hz.admin.db.mapper.ex;

import com.hz.admin.db.entity.ex.AccountMenuDO;
import com.hz.admin.db.entity.ex.AccountRoleDO;

import java.util.List;

/**
 * @Classname AccountExtMapper
 * @Description TODO
 * @Date 2020-01-19 23:55
 * @Created by hzong
 */
public interface AccountExtMapper {
    /**查询账号信息
     * @param account
     * @return
     */
    List<AccountRoleDO> selectAccountRoleList(String account);


    /**查询账号信息
     * @param account
     * @return
     */
    List<AccountMenuDO> selectAccountMenuList(String account);
}
