package com.ucss.elementary.tnwn.controller.cms;


import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.mapper.tnwn.TDUserMapper;
import com.ucss.elementary.tnwn.model.database.SysUserRoleKey;
import com.ucss.elementary.tnwn.model.database.TDUser;
import com.ucss.elementary.tnwn.model.database.TDUserNewExtension;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.CmsUserService;
import com.ucss.elementary.tnwn.service.RoleService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.service.UserService;
import com.ucss.elementary.tnwn.util.StringHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhouhui
 */
@RestController
@RequestMapping("/cms/normaluser")
@Api(description = "CMS普通用户管理")
public class NormalUserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UATService uatService;
    @Autowired
    private UserService userService;
    @Autowired
    TDUserMapper tdUserMapper;
    @Autowired
    CmsUserService cmsUserService;
    @Autowired
    private RoleService roleService;


    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @CmsPermission("normaluser:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "roleid",value = "用户角色，-1查看所有用户，0查看所有角色",dataType = "Long", paramType = "query")
    })
    @PostMapping
    BaseResponse getUserList(
            @RequestParam(value ="pagenum", required = false,defaultValue = "1") Integer pagenum,
            @RequestParam(value ="pagesize", required = false,defaultValue = "10") Integer pagesize,
            @RequestParam(value ="keyword", required = false) String keyword,
            @RequestParam(value = "usertype",defaultValue = "1") Short usertype,
            @RequestParam("auditstatus") Short auditstatus,
            @RequestParam("roleid") Long roleid
    ) {
        PageHelper.startPage(pagenum,pagesize);
        List<TDUserNewExtension> list=userService.getUserList(keyword,auditstatus,usertype,roleid);
        for(TDUser user:list) {
            user.setPassword(null);
            if(!StringHelper.isTrimEmpty(user.getPhonebind())) {
                user.setPhonebind(user.getPhonebind().substring(0, 3) + "********");
            }
        }
        return new BaseResponse(new MapFromPageInfo<>(list));
    }


    @ApiOperation(value = "批量审核用户", notes = "批量审核用户")
    @CmsPermission("normaluser:audit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    BaseResponse audit(
            @RequestParam(value ="uat") String uat,
            @RequestParam("ids") List<Long> ids,
            @RequestParam("auditstatus") Short auditstatus,
            @RequestParam(value ="auditreason",required = false) String auditreason) {
        long userid=uatService.getUserIDByUAT(uat);
        if(ids==null||ids.size()<=0) {
            return new BaseResponse(ReturnCodeConst.ERROR, "没有待审核项");
        }
        short isvalid=0;
        if(auditstatus==1){
            isvalid=1;
        }
        return new BaseResponse(userService.audit(ids,isvalid,auditstatus,userid,auditreason));
    }

    @ApiOperation(value = "用户详情", notes = "用户详情")
    @CmsPermission("normaluser:detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    BaseResponse detail(
            @RequestParam("id") Long id) {
        TDUser user=userService.getByID(id);
        user.setPassword(null);
        if(!StringHelper.isTrimEmpty(user.getPhonebind())) {
            user.setPhonebind(user.getPhonebind().substring(0, 3) + "********");
        }
        user.setRoleList(cmsUserService.getRolebyuserId(id));
        return new BaseResponse(user);
    }

    @ApiOperation(value = "用户详情有手机号", notes = "用户详情有手机号")
    @CmsPermission("normaluser:detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/detailpgone", method = RequestMethod.POST)
    BaseResponse detailpgone(
            @RequestParam("id") Long id) {
        TDUser user=userService.getByID(id);
        user.setPassword("");
        user.setRoleList(cmsUserService.getRolebyuserId(id));
        return new BaseResponse(user);
    }

    @ApiOperation(value = "用户新增或者修改")
    @CmsPermission("user:modify")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/edituser", method = RequestMethod.POST)
    BaseResponse editUser(
            @RequestParam(value = "userid") Long userid,
            @RequestParam(value = "uat") String uat,
            @RequestParam(value = "loginname") String loginname,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "email",required = false) String email,
            @RequestParam(value = "headimage",required = false) String headimage,
            @RequestParam(value = "regioncode",required = false) String regioncode,
            @RequestParam(value = "gender",required = false) Short gender,
            @RequestParam(value = "password",required = false) String password,
            @RequestParam(value = "roleids",required = false) List<Long> roleids,
            @RequestParam(value = "usertype",defaultValue = "1") Short usertype
    ) {
        long loginUserId = uatService.getUserIDByUAT(uat);
        if (cmsUserService.existLoginname(loginname, userid)) {
            return new BaseResponse(ReturnCodeConst.ERROR, "该登录名已存在");
        }
        if (!StringHelper.isTrimEmpty(phone) && cmsUserService.existLoginname(phone, userid)) {
            return new BaseResponse(ReturnCodeConst.ERROR, "该手机号已存在");
        }
        TDUser user = new TDUser();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setNickname(name);
        user.setPhonebind(phone);
        user.setEmailbind(email);
        user.setHeadimage(headimage);
        user.setRegioncode(regioncode);
        user.setGender(gender);
        user.setUpdatetime(new Date());
        user.setUsertype(usertype);
        if (userid == null || userid == 0) {
            user.setAuditstatus((short) 0);
            user.setIsvalid((short) 0);
            user.setCreatetime(new Date());
            userService.add(user);
            userid = user.getId();
        } else {
            user.setId(userid);
            userService.updateUser(user);
        }
        if(roleids!=null&&roleids.size()>0&&roleids.contains(1L)){
            //若角色中存在“超级管理员”，则不更新角色，超级管理员为初始化设置，不能再后台配置
        }
        else {
            cmsUserService.deleteUserRoleByUserId(userid);
            List sysUserRoles = new ArrayList();
            if (roleids != null && roleids.size() > 0) {
                for (int i = 0; i < roleids.size(); i++) {
                    SysUserRoleKey userRole = new SysUserRoleKey();
                    userRole.setUserId(userid);
                    userRole.setRoleId(roleids.get(i));
                    sysUserRoles.add(userRole);
                }
                //批量插入用户与角色关系
                roleService.insertUserRoses(sysUserRoles);
            }
        }
        return new BaseResponse("成功");
    }

    @ApiOperation("判断登录名是否存在")
    @CmsPermission
    @PostMapping("existsloginname")
    BaseResponse existsLoginName(@RequestParam(value = "loginname") String loginname){
        return new BaseResponse(cmsUserService.existLoginname(loginname,0));
    }

}
