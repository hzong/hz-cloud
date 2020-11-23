package com.hz.admin.controller.limit;

import com.dzzh.hz.hzsf.common.pojo.dto.common.ResponseDTO;
import com.hz.admin.db.entity.TRole;
import com.hz.admin.db.entity.TRoleExample;
import com.hz.admin.db.repository.role.RoleRepository;
import com.hz.admin.controller.base.BaseController;
import com.hz.admin.model.pojo.dto.role.RoleRequestQueryPageDTO;
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
 * @Classname AccountLimitApiController
 * @Description TODO
 * @Date 2020-01-27 13:59
 * @Created by hzong
 */
@Api(value = "账号控制台")
@RestController
@Validated
@RequestMapping(UrlConstants.LIMIT + "/role")
public class RoleLimitApiController extends BaseController {

    @Autowired
    private RoleRepository roleService;

    /**
     * 添加
     * @return
     */
    @ApiOperation(value = "添加", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/add")

    public ResponseDTO add(@RequestBody @Valid TRole role) {
        roleService.insert(role);
        return ResponseDTO.ok();
    }

    /**
     * 修改
     * @return
     */
    @ApiOperation(value = "修改", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/update")

    public ResponseDTO update(@RequestBody @Valid TRole role) {
        roleService.insert(role);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     * @return
     */
    @ApiOperation(value = "删除", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/del")

    public ResponseDTO del(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long actId = MapUtils.getLong(map, "roleId");
        roleService.deleteByPrimaryKey(actId);
        return ResponseDTO.ok();
    }

    /**
     * 获取
     * @return
     */
    @ApiOperation(value = "获取", notes = "获取")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/get")

    public ResponseDTO get(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long roleId = MapUtils.getLong(map, "roleId");
        return ResponseDTO.ok(roleService.selectByPrimaryKey(roleId));
    }

    /**
     * 分页
     * @return
     */
    @ApiOperation(value = "分页", notes = "分页")
    @ApiImplicitParam(name = "dto", value = "对象", required = true, dataType = "MenuRequestQueryPageDTO")
    @PostMapping(value = "v1/queryPage")

    public ResponseDTO queryPage(@RequestBody @Valid RoleRequestQueryPageDTO dto) {
        return ResponseDTO.ok(roleService.selectPages(dto.getPageNum(),dto.getPageSize(),new TRoleExample()));
    }


}
