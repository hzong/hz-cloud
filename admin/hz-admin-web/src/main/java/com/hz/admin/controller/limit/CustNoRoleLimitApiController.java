package com.hz.admin.controller.limit;

import com.hz.admin.controller.base.BaseController;
import com.hz.admin.db.entity.TCustnoRole;
import com.hz.admin.db.entity.TCustnoRoleExample;
import com.hz.admin.db.service.custnorole.CustnoRoleService;
import com.hz.admin.model.pojo.dto.custrole.CustNoRoleQueryPageDTO;
import com.hz.admin.web.common.constants.UrlConstants;
import com.hz.hzsf.common.pojo.result.ServerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @Classname CustNoRoleLimitApiController
 * @Description TODO
 * @Date 2020-01-27 21:28
 * @Created by hzong
 */

@Api(value = "会员和角色控制台")
@RestController
@Validated
@RequestMapping(UrlConstants.LIMIT + "/role/custno")
public class CustNoRoleLimitApiController extends BaseController {

    @Autowired
    CustnoRoleService custnoRoleService;

    /**
     * 添加
     */
    @ApiOperation(value = "添加", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/add")

    public ServerResult add(@RequestBody @Valid TCustnoRole role) {
        custnoRoleService.insert(role);
        return ServerResult.success();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/update")

    public ServerResult update(@RequestBody @Valid TCustnoRole role) {
        custnoRoleService.insert(role);
        return ServerResult.success();
    }

    /**
     * 更新
     */
    @ApiOperation(value = "删除", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/del")

    public ServerResult del(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long crId = MapUtils.getLong(map, "crId");
        custnoRoleService.deleteByPrimaryKey(crId);
        return ServerResult.success();
    }

    /**
     * 获取
     */
    @ApiOperation(value = "获取", notes = "获取")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/get")

    public ServerResult get(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long crId = MapUtils.getLong(map, "crId");
        return ServerResult.success(custnoRoleService.selectByPrimaryKey(crId));
    }



    /**
     * 集合-分页
     */
    @ApiOperation(value = "集合", notes = "分页")
    @ApiImplicitParam(name = "dto", value = "对象", required = true, dataType = "CustNoRoleQueryPageDTO")
    @PostMapping(value = "v1/queryPage")

    public ServerResult queryPage(@RequestBody @Valid CustNoRoleQueryPageDTO dto) {
        return ServerResult.success(custnoRoleService.selectPages(dto.getPageNum(),dto.getPageSize(),new TCustnoRoleExample()));
    }


}
