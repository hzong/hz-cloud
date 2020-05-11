package com.hz.admin.db.mapper.ex;

import com.hz.admin.db.entity.ex.CustNoRoleDO;
import com.hz.admin.model.pojo.dto.custrole.CustNoRoleQueryPageDTO;

import java.util.List;

/**
 * @Classname CustNoRoleExtMapper
 * @Description TODO
 * @Date 2020-01-31 15:54
 * @Created by hzong
 */
public interface CustNoRoleExtMapper {

    /**
     * 查询分页
     */
    List<CustNoRoleDO> selectCustNoRoleList(CustNoRoleQueryPageDTO custNoRoleQueryPageDTO);

}
