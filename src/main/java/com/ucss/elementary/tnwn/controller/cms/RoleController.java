package com.ucss.elementary.tnwn.controller.cms;


import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.SysRole;
import com.ucss.elementary.tnwn.model.database.SysRoleMenu;
import com.ucss.elementary.tnwn.model.database.SysUserRoleKey;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.MenuService;
import com.ucss.elementary.tnwn.service.RoleService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.util.TConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @author Smile
 */
@RestController
@RequestMapping("/cms/role")
@Api(description = "CMS角色模块")
public class RoleController {


    @Autowired
    private RoleService roleService;
    @Autowired
    private UATService uatService;
    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "角色详情列表")
    @CmsPermission("role:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    BaseResponse info(
            @RequestParam(value = "roleid",required = false) Long roldid,
            @RequestParam(value = "uat",required = true) String uat
    ) {
        long userId = uatService.getUserIDByUAT(uat);
        HashMap<String,Object> parms=new HashMap<>();
        if(roldid != null){
            //根据ID查询对应角色
            SysRole role = roleService.getRole(roldid);
            if(role == null) {
                return new BaseResponse("0", "roleId参数不存在");
            }else {
                parms.put("role",role);
                List<SysRoleMenu> sysRoleMenus = roleService.selectRoleMenus(roldid);
                List<Long> userMenuId = new ArrayList<>();
                for (SysRoleMenu sysRoleMenu:sysRoleMenus){
                    userMenuId.add(sysRoleMenu.getMenuId());
                }
                parms.put("userMenuId",userMenuId);
            }

        }else {
            List<SysRole> roles =roleService.getRoleList();
            parms.put("roleList",roles);
        }
        return new BaseResponse("0", "成功",parms);
    }

    @ApiOperation(value = "角色新增/编辑")
    @CmsPermission("role:modify")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roleid",value = "id新增填0",dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/editrole", method = RequestMethod.POST)
    BaseResponse editRole(
            @RequestParam(value = "roleid",required = true) Long roleid,
            @RequestParam(value = "rolename",required = true) String rolename,
            @RequestParam(value = "menuids",required = false) List menuids,
            @RequestParam(value = "uat",required = true) String uat
    ) {

        long sysUserId = uatService.getUserIDByUAT(uat);
        if(roleService.existRoleName(rolename, TConverter.ObjectToLong(roleid))){
            return new BaseResponse(ReturnCodeConst.ERROR,"该角色名称已存在，请重新输入");
        }
        if(roleid==null||roleid==0){
            Long resultRoleId = roleService.insertRole(rolename,sysUserId);
            roleid = resultRoleId;
        }else {
           roleService.updateRole(roleid,rolename,sysUserId);
        }

        if (menuids != null){
            //在角色与菜单表中通过角色ID删除角色菜单信息
            int count = roleService.deleteRoleMenu(roleid);
            List sysRoleMenus = new ArrayList();
            for(int i=0;i<menuids.size();i++){
                SysRoleMenu roleMenu = new SysRoleMenu();
                roleMenu.setRoleId(roleid);
                roleMenu.setMenuId(TConverter.ObjectToLong(menuids.get(i)));
                sysRoleMenus.add(roleMenu);
            }
            //批量插入角色与菜单关系
            int count1 = roleService.insertRoleMenus(sysRoleMenus);
            if(count1 <= 0){
                return new BaseResponse("101","批量插入角色菜单失败");
            }
        }
        return new BaseResponse("0","成功");
    }

    @ApiOperation(value = "删除角色")
    @CmsPermission("role:audit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/deleterole",method = RequestMethod.POST)
    BaseResponse deleteRole(
            @RequestParam(value = "roleid",required = true) Long roleid,
            @RequestParam(value = "uat",required = true) String uat
    ) {
        if(roleid <= 0) {
            return new BaseResponse("101", "参数有误");
        }
        int result = roleService.deleteRole(roleid);
        if(result > 0) {
            return new BaseResponse("0", "删除成功");
        }
        return new BaseResponse("101", "删除失败");
    }


    @ApiOperation(value = "创建用户角色关系")
    @CmsPermission("role:modify")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/insertuserrole",method = RequestMethod.POST)
    BaseResponse insertUserRole(
            @RequestParam(value = "userid",required = true) Long userid,
            @RequestParam(value = "roleids",required = true) List roleids,
            @RequestParam(value = "uat",required = true) String uat
    ) {

        List sysUserRoles = new ArrayList();
        for(int i=0;i<roleids.size();i++){
            SysUserRoleKey userRole = new SysUserRoleKey();
            userRole.setUserId(userid);
            userRole.setRoleId(TConverter.ObjectToLong(roleids.get(i)));
            sysUserRoles.add(userRole);
        }
        //批量插入角色与用户关系
        int result = roleService.insertUserRoses(sysUserRoles);
        if(result > 0) {
            return new BaseResponse("0", "创建成功");
        }
        return new BaseResponse("101", "建创失败");
    }








}