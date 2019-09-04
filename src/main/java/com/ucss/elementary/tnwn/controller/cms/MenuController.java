package com.ucss.elementary.tnwn.controller.cms;


import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.model.database.SysMenu;
import com.ucss.elementary.tnwn.model.database.TDUser;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.MenuService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @author zhouhui
 */
@RestController
@RequestMapping("/cms/menu")
@Api(description = "CMS菜单模块")
public class MenuController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private UATService uatService;

    @ApiOperation(value = "获取登录用户的菜单列表及个人信息", notes = "获取登录用户的菜单列表及个人信息")
    @CmsPermission
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/getUserMenuList", method = RequestMethod.POST)
    BaseResponse getUserMenuList(
            @RequestParam(value = "uat") String uat,
            @RequestParam(value = "systemcode",defaultValue = "cms") String systemcode
    ) {
        long userId = uatService.getUserIDByUAT(uat);
        if(userId<=0) {
            return new BaseResponse("110", "请登录后重试");
        }
        TDUser user = userService.getByID(userId);
        List<SysMenu> menuList = menuService.getUserMenuList(userId,systemcode);
        HashMap<String, Object> result = new HashMap<>();
        result.put("user", user);
        result.put("menuList", menuList);
        return new BaseResponse(result);
    }

    @ApiOperation(value = "获取菜单列表", notes = "获取菜单列表")
    @CmsPermission("menu:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
    BaseResponse getMenuList(
            @RequestParam(value = "systemcode",required = false) String systemcode
    ) {
        return new BaseResponse(menuService.getMenuList(systemcode));
    }

    @ApiOperation(value = "保存新增/修改/添加下级菜单", notes = "保存新增/修改/添加下级菜单")
    @CmsPermission("menu:modify")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "id新增填0", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "leve", value = "层级", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "isshow", value = "是否展示", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
    BaseResponse save(
            @RequestParam(value = "uat", required = true) String uat,
            @RequestParam("parentid") Long parentid,
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "leve", required = true) Short leve,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "premissioncode", required = false) String premissioncode,
            @RequestParam(value = "href", required = false) String href,
            @RequestParam(value = "icon", required = false) String icon,
            @RequestParam(value = "sort", required = false) Short sort,
            @RequestParam(value = "isshow", required = true) Short isshow,
            @RequestParam("systemcode") String systemcode
    ) {
        long userId = uatService.getUserIDByUAT(uat);
        //层级
        SysMenu menu = new SysMenu();
        //修改菜单
        if (id > 0) {
            menu.setId(id);
            menu.setUpdater(userId);
            menu.setUpdatetime(new Date());
        }
        menu.setSystemcode(systemcode);
        menu.setParentId(parentid);
        menu.setLeve(leve);
        menu.setName(name);
        menu.setPremissioncode(premissioncode);
        menu.setHref(href);
        menu.setIcon(icon);
        menu.setIsshow(isshow);
        menu.setIsvalid((short) 1);
        menu.setSort(sort);
        menu.setCreatetime(new Date());
        menu.setCreator(userId);
        menuService.saveMenu(menu);
        return new BaseResponse("");
    }

    @ApiOperation(value = "删除", notes = "删除")
    @CmsPermission("menu:audit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
    BaseResponse delete(
            @RequestParam("id") Long id) {
        menuService.deleteMenu(id);
        return new BaseResponse("");
    }

    @ApiOperation(value = "菜单详情", notes = "菜单详情")
    @CmsPermission("menu:detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/detailMenu", method = RequestMethod.POST)
    BaseResponse detail(
            @RequestParam("id") Long id) {
        return new BaseResponse(menuService.getMenuDetail(id));
    }

}
