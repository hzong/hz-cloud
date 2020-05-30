package com.hz.admin.controller.limit;

import com.hz.admin.controller.base.BaseController;
import com.hz.admin.db.entity.TMenu;
import com.hz.admin.db.entity.TMenuExample;
import com.hz.admin.db.service.menu.MenuService;
import com.hz.admin.model.pojo.dto.menu.MenuRequestDTO;
import com.hz.admin.model.pojo.dto.menu.MenuRequestQueryPageDTO;
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
 * @Classname MenuLimitAccessController
 * @Description TODO
 * @Date 2020-01-07 19:46
 * @Created by hzong
 */
@Api(value = "菜单Controller")
@RestController
@Validated
@RequestMapping(UrlConstants.LIMIT + "/menu")
public class MenuLimitApiController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 菜单添加
     *
     * @param menu
     * @return
     */
    @ApiOperation(value = "添加菜单", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/add")
//    @RequiresPermissions("存放菜单编码")

    public ServerResult addMenu(@RequestBody @Valid TMenu menu) {
        menuService.insert(menu);
        return ServerResult.success();
    }

    /**
     * 菜单修改
     *
     * @param menu
     * @return
     */
    @ApiOperation(value = "修改菜单", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "menu", value = "菜单对象", required = true, dataType = "TMenu")
    @PostMapping(value = "v1/update")

    public ServerResult updateMenu(@RequestBody @Valid TMenu menu) {
        menuService.insert(menu);
        return ServerResult.success();
    }

    /**
     * 菜单更新
     *
     * @return
     */
    @ApiOperation(value = "修改菜单", notes = "将菜单信息传入")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/del")

    public ServerResult delMenu(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long menuId = MapUtils.getLong(map, "menuId");
        menuService.deleteByPrimaryKey(menuId);
        return ServerResult.success();
    }

    /**
     * 获取菜单
     *
     * @return
     */
    @ApiOperation(value = "获取菜单信息", notes = "获取")
    @ApiImplicitParam(name = "json", value = "菜单对象", required = true, dataType = "String")
    @PostMapping(value = "v1/get")
    public ServerResult get(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long menuId = MapUtils.getLong(map, "menuId");
        return ServerResult.success(menuService.selectByPrimaryKey(menuId));
    }

    /**
     * 菜单分页
     *
     * @return
     */
    @ApiOperation(value = "菜单分页", notes = "分页")
    @ApiImplicitParam(name = "dto", value = "菜单对象", required = true, dataType = "MenuRequestQueryPageDTO")
    @PostMapping(value = "v1/queryPage")
    public ServerResult queryPage(@RequestBody @Valid String json
    ) {
        MenuRequestQueryPageDTO dto = parseJson(json, MenuRequestQueryPageDTO.class);
        return ServerResult.success(menuService.selectPages(dto.getPageNum(), dto.getPageSize(), new TMenuExample()));
    }


    /**
     * 获取子菜单
     *
     * @return
     */
    @ApiOperation(value = "子菜单", notes = "分页")
    @ApiImplicitParam(name = "json", value = "子菜单", required = true, dataType = "MenuRequestDTO")
    @PostMapping(value = "v1/getChilds")
    public ServerResult getChildMenus(@RequestBody @NotBlank(message = "{required}") String json) {
        Map map = parseJson(json, Map.class);
        Long pid = MapUtils.getLong(map, "pid");
        return ServerResult.success(menuService.getChildMenus(pid));
    }




}
