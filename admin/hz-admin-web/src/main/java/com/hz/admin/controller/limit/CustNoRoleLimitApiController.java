package com.hz.admin.controller.limit;

import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import com.hz.admin.db.entity.TCustnoRole;
import com.hz.admin.db.entity.TCustnoRoleExample;
import com.hz.admin.controller.base.BaseController;
import com.hz.admin.db.repository.custnorole.CustnoRoleRepository;
import com.hz.admin.model.pojo.dto.custrole.CustNoRoleQueryPageRequest;
import com.hz.admin.web.common.constants.UrlConstants;
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
    CustnoRoleRepository custnoRoleService;

    /**
     * 添加
     */
    @ApiOperation(value = "添加", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/add")

    public ResponseDTO add(@RequestBody @Valid TCustnoRole role) {
        custnoRoleService.insert(role);
        return ResponseDTO.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/update")

    public ResponseDTO update(@RequestBody @Valid TCustnoRole role) {
        custnoRoleService.insert(role);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     */
    @ApiOperation(value = "删除", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/del")

    public ResponseDTO del(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long crId = MapUtils.getLong(map, "crId");
        custnoRoleService.deleteByPrimaryKey(crId);
        return ResponseDTO.ok();
    }

    /**
     * 获取
     */
    @ApiOperation(value = "获取", notes = "获取")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/get")

    public ResponseDTO get(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long crId = MapUtils.getLong(map, "crId");
        return ResponseDTO.ok(custnoRoleService.selectByPrimaryKey(crId));
    }



    /**
     * 集合-分页
     */
    @ApiOperation(value = "集合", notes = "分页")
    @ApiImplicitParam(name = "dto", value = "对象", required = true, dataType = "CustNoRoleQueryPageRequest")
    @PostMapping(value = "v1/queryPage")

    public ResponseDTO queryPage(@RequestBody @Valid CustNoRoleQueryPageRequest dto) {
        return ResponseDTO.ok(custnoRoleService.selectPages(dto.getPageNum(),dto.getPageSize(),new TCustnoRoleExample()));
    }


}
