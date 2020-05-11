package com.hz.admin.controller.limit;

import com.hz.admin.controller.base.BaseController;
import com.hz.admin.db.entity.TAccount;
import com.hz.admin.db.entity.TAccountExample;
import com.hz.admin.db.service.account.AccountService;
import com.hz.admin.model.pojo.dto.account.AccountRequestQueryPageDTO;

import com.hz.admin.web.common.constants.UrlConstants;
import com.hz.hzsf.common.pojo.result.ServerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping(UrlConstants.LIMIT + "/act")
public class AccountLimitApiController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 添加
     *
     * @param menu
     * @return
     */
    @ApiOperation(value = "添加", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/add")
    @ResponseBody
    public ServerResult addMenu(@RequestBody @Valid TAccount menu) {
        accountService.insert(menu);
        return ServerResult.success();
    }

    /**
     * 修改
     *
     * @param menu
     * @return
     */
    @ApiOperation(value = "修改", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/update")
    @ResponseBody
    public ServerResult updateMenu(@RequestBody @Valid TAccount menu) {
        accountService.updateByPrimaryKey(menu);
        return ServerResult.success();
    }

    /**
     * 更新
     *
     * @return
     */
    @ApiOperation(value = "删除", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/del")
    @ResponseBody
    public ServerResult delMenu(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        String actId = MapUtils.getString(map, "actId");
        accountService.deleteByPrimaryKey(actId);
        return ServerResult.success();
    }

    /**
     * 获取
     *
     * @return
     */
    @ApiOperation(value = "获取", notes = "获取")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/get")
    @ResponseBody
    public ServerResult get(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        String actId = MapUtils.getString(map, "actId");
        return ServerResult.success(accountService.selectByPrimaryKey(actId));
    }

    /**
     * 分页
     *
     * @return
     */
    @ApiOperation(value = "菜单分页", notes = "分页")
    @ApiImplicitParam(name = "dto", value = "菜单对象", required = true, dataType = "MenuRequestQueryPageDTO")
    @PostMapping(value = "v1/queryPage")
    @ResponseBody
    public ServerResult queryPage(@RequestBody @Valid AccountRequestQueryPageDTO dto) {
        return ServerResult.success(accountService.selectPages(dto.getPageNum(),dto.getPageSize(),new TAccountExample()));
    }


}
