package com.ucss.elementary.tnwn.controller.base;

import com.ucss.elementary.tnwn.constant.CacheKeyConst;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.mapper.tnwn.TDUserMapper;
import com.ucss.elementary.tnwn.model.database.TDUser;
import com.ucss.elementary.tnwn.model.database.TDUserApply;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.*;
import com.ucss.elementary.tnwn.util.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PicVericodeService picVericodeService;
    @Autowired
    private UserService userService;
    @Autowired
    SysService sysService;
    @Autowired
    private UATService uatService;
    @Autowired
    private VericodeService vericodeService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RoleService roleService;
    @Autowired
    TDUserMapper tdUserMapper;




    @ApiOperation(value = "获取图片验证码", notes = "获取图片验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/getpicvericode", method = RequestMethod.POST)
    BaseResponse getPicVericode(@RequestParam(value = "imagewidth", required = false) Integer imageWidth
            , @RequestParam(value = " imageheight", required = false) Integer imageHeight
            , @RequestParam(value = "codelength", required = false) Integer codeLength) throws Exception {

        //默认图片宽度
        if (imageWidth == null) {
            imageWidth = 115;
        }
        //默认图片高度
        if (imageHeight == null) {
            imageHeight = 48;
        }
        //默认验证码位数
        if (codeLength == null) {
            codeLength = 4;
        }

        //输出图片流
        ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
        //生成图片
        String veriCode = PicVericodeUtils.outputVerifyImage(imageWidth, imageHeight, imageStream, codeLength);
        // 转码成图片字符串
        String imgString = Base64Util.encode(imageStream.toByteArray());
        //生成token
        String token = UUIDUtil.getUUID();
        //保存验证码数据到redis
        picVericodeService.savePicVericode(token, veriCode);
        //返回结果
        Map<String, Object> result = new HashMap();
        result.put("image", imgString);
        result.put("token", token);
        return new BaseResponse(result);
    }


    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query",required = true),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    BaseResponse register(
            @RequestParam("appcode") String appCode,
            @RequestParam(value="loginname",required = false) String loginname,
            @RequestParam(value="phone",required = false) String phone
            , @RequestParam("password") String password
            , @RequestParam(value="vericode",required = false) String veriCode
            , @RequestParam(value = "picvericode", required = false) String picVericode
            , @RequestParam(value = "regioncode", required = false) String regionCode
            , @RequestParam(value = "pictoken", required = false) String picToken
            , @RequestParam(value = "imei", required = false) String imei
    ) {
        //密码盐：0oJ%Pl;O0lc1L3
        //type: 1 手机号注册，2用户名注册
        int registertype=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.user_register","type"),1);
        if(registertype==1){
            if(StringHelper.isTrimEmpty(phone)) {
                return new BaseResponse(ReturnCodeConst.EMPTY, "请输入手机号码");
            }
            if (phone.length() < 11) {
                return new BaseResponse("102", "手机号格式有误");
            }
            //校验验证码
            if (!vericodeService.verifyCode(phone, (short) 1, veriCode)) {
                return new BaseResponse("102", "验证码错误");
            }
            loginname=phone;
        }else {
            if(StringHelper.isTrimEmpty(loginname)) {
                return new BaseResponse(ReturnCodeConst.EMPTY, "请输入账号");
            }
            phone=null;
        }
        //是否需要图形验证码
        if(TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.user_register","ispic"),0)==1){
            if (StringUtils.isEmpty(picVericode)) {
                return new BaseResponse(ReturnCodeConst.EMPTY, "图片验证码不能为空");
            }
            if (StringUtils.isEmpty(picToken)) {
                return new BaseResponse("113", "图片验证码错误");
            }
            if (!picVericodeService.verify(picToken, picVericode)) {
                return new BaseResponse("113", "图片验证码错误");
            }
        }
        //判断用户是否已经注册
        TDUser userInfo = registertype==1?userService.getUserByLoginName(phone):userService.getUserByLoginName(loginname);
        if (userInfo != null ) {
            return new BaseResponse("103", "用户已经注册");
        }
        //新增用户
        String nickName = registertype==1?StringHelper.toOmit(phone):StringHelper.toOmit(loginname);
        long userID = userService.newUser(phone,loginname, password, nickName, regionCode, (short) 1);
        if (userID == 0) {
            return new BaseResponse("105", "注册失败");
        }
        //根据userID生成uat
        Object uatandrt = uatService.generateUATandRT(userID, appCode,imei);
        userService.addLoginLog(userID, phone, imei, appCode, null, 1, 4);
        return new BaseResponse(uatandrt);
    }


    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "source",value = "来源 1：乡村振兴",dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    BaseResponse login(@RequestParam("username") String userName,
                       @RequestParam("password") String password,
                       @RequestParam("appcode") String appCode,
                       @RequestParam(value = "imei", required = false) String imei
    ) {
        BaseResponse response = userService.getUserByLoginNameAndPwd2(userName, password);
        if (!"0".equals(response.getCode())) {
            userService.addLoginLog(TConverter.ObjectToLong(response.getData()), userName, imei, appCode, null, 0, 1);
            response.setData("");
            return response;
        }
        TDUser userInfo = TConverter.safeConvert(response.getData());
        if (userInfo == null || userInfo.getId() == 0) {
            return new BaseResponse("101", "登录信息有误");
        }
        if (TConverter.ObjectToShort(userInfo.getIsvalid()) != 1) {
            userService.addLoginLog(userInfo.getId(), userName, imei, appCode, null, 0, 1);
            return new BaseResponse("104", "用户被封禁");
        }
        //根据userID生成uat
        Object uatandrt = uatService.generateUATandRT(userInfo.getId(), appCode,imei);
        userService.addLoginLog(userInfo.getId(), userInfo.getPhonebind(), imei, appCode, null, 1, 1);
        return new BaseResponse(uatandrt);
    }

    @ApiOperation(value = "短信登录", notes = "短信登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/smslogin", method = RequestMethod.POST)
    BaseResponse smsLogin(@RequestParam("phone") String phone,
                          @RequestParam("vericode") String veridCode,
                          @RequestParam("appcode") String appCode,
                          @RequestParam(value = "imei", required = false) String imei
    ) {
        int isregister=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.smslogin","isregister"),0);
        int verifycodeType=isregister==0?2:5;
        if (!vericodeService.verifyCode(phone, (short) verifycodeType, veridCode)) {
            userService.addLoginLog(0, phone, null, appCode, null, 0, 2);
            return new BaseResponse("101", "登录信息有误");
        }
        TDUser userInfo = userService.getUserByLoginName(phone);
        long userID = 0;
        if (userInfo == null || userInfo.getId() == 0) {
            if(isregister!=1){
                return new BaseResponse(ReturnCodeConst.ERROR, "登录信息有误");
            }
            //用户不存在,则注册 //phone.substring(0, 3) + "********";
            String nickName =StringHelper.toOmit(phone);
            userID = userService.newUser(phone, phone,null, nickName, null, (short) 1);
            if(userID<=0){
                return new BaseResponse("101", "登录信息有误");
            }
        }else {
            if (userInfo.getIsvalid() != 1) {
                userService.addLoginLog(userInfo.getId(), userInfo.getPhonebind(), imei, appCode, null, 0, 2);
                return new BaseResponse("104", "用户被封禁");
            }
            userID=userInfo.getId();
        }
        //根据userID生成uat
        Object uatandrt = uatService.generateUATandRT(userID, appCode,imei);
        userService.addLoginLog(userID, phone, imei, appCode, null, 1, 2);
        return new BaseResponse(uatandrt);
    }


    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    BaseResponse getUserInfo(@RequestParam("uat") String uat) {
        long userid = uatService.getUserIDByUAT(uat);
        if (userid <= 0) {
            return new BaseResponse("110", "请登录后重试");
        }
        TDUser user = uatService.getUserByUAT(uat);
        return new BaseResponse(user);
    }

    @ApiOperation("获取用户信息-若uat失效，不返回110")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/infono110", method = RequestMethod.POST)
    BaseResponse getUserInfoNo110(@RequestParam("uat") String uat) {
        TDUser user = uatService.getUserByUAT(uat);
        return new BaseResponse(user);
    }

    @ApiOperation(value = "退出登录", notes = "退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    BaseResponse logout(@RequestParam("uat") String uat,
                        @RequestParam(value = "rt", required = false) String rt,
                        @RequestParam("appcode") String appCode
    ) {
        uatService.deleteCacheByUAT(uat);
        userService.deleteRefreshtoken(rt);
        return new BaseResponse("");
    }


    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/modifypwd", method = RequestMethod.POST)
    BaseResponse modifyPassword(@RequestParam("uat") String uat
            , @RequestParam("newpwd") String newpwd
            , @RequestParam("oldpwd") String oldpwd) {
        //// TODO: 2018/1/29
        long userid = uatService.getUserIDByUAT(uat);
        if (userid <= 0) {
            return new BaseResponse("110", "请登录后重试");
        }
        if (StringHelper.isEmpty(oldpwd)) {
            return new BaseResponse("130", "旧密码不能为空");
        }
        if (StringHelper.isEmpty(newpwd)) {
            return new BaseResponse("130", "新密码不能为空");
        }
        TDUser user = userService.getByID(userid);
        if (user == null || user.getId() == 0) {
            //// TODO: 2018/1/25  用户为空，但有可能已经提交信息员注册申请，需要进行不同提示
            return new BaseResponse("101", "登录信息有误");
        }
        if (user.getIsvalid() != 1) {
            return new BaseResponse("104", "用户被封禁");
        }
        if (!user.getPassword().toLowerCase().equals(oldpwd.toLowerCase())) {
            return new BaseResponse("133", "旧密码输入错误");
        }
        user.setPassword(newpwd.toLowerCase());
        userService.updateUser(user);
        return new BaseResponse("密码修改成功");
    }


    @ApiOperation(value = "找回密码", notes = "找回密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/findpwd", method = RequestMethod.POST)
    BaseResponse findPassword(@RequestParam("phone") String phone
            , @RequestParam("vericode") String veriCode
            , @RequestParam("newpwd") String newpwd) {
        //// TODO: 2018/1/29
        if (StringHelper.isEmpty(phone)) {
            return new BaseResponse("130", "请输入手机号码");
        }
        if (StringHelper.isEmpty(veriCode)) {
            return new BaseResponse("130", "请输入验证码");
        }
        if (StringHelper.isEmpty(newpwd)) {
            return new BaseResponse("130", "新密码不能为空");
        }
        if (!vericodeService.verifyCode(phone, (short) 3, veriCode)) {
            return new BaseResponse("102", "验证码错误");
        }
        TDUser userInfo = userService.getByPhone(phone);
        if (userInfo == null || userInfo.getId() == 0) {
            //// TODO: 2018/1/25  用户为空，但有可能已经提交信息员注册申请，需要进行不同提示
            return new BaseResponse("101", "用户不存在");
        }
        if (userInfo.getIsvalid() != 1) {
            return new BaseResponse("104", "用户被封禁");
        }
        userInfo.setPassword(newpwd.toLowerCase());
        userService.updateUser(userInfo);
        return new BaseResponse("找回密码成功");
    }

    @ApiOperation(value = "修改用户资料", notes = "修改用户资料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/modifyinfo", method = RequestMethod.POST)
    BaseResponse modifyInfo(@RequestParam("uat") String uat
            , @RequestParam(value = "nickname", required = false) String nickName
            , @RequestParam(value = "headimage", required = false) String headImage
            , @RequestParam(value = "gender", required = false) String gender,
                            @RequestParam(value = "regioncode", required = false) String regionCode
    ) {

        long userid = uatService.getUserIDByUAT(uat);
        if (userid <= 0) {
            return new BaseResponse("110", "请登录后重试");
        }
        TDUser user = userService.getByID(userid);
        if (user == null || user.getId() == 0) {
            return new BaseResponse("101", "登录信息有误");
        }
        if (user.getIsvalid() != 1) {
            return new BaseResponse("104", "用户被封禁");
        }
        int isapply = TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.modifyinfo","isapply"));
        if(isapply==1) {
            TDUserApply apply = new TDUserApply();
            if (!StringHelper.isEmpty(nickName)) {
                apply.setNickname(nickName);
            }
            if (!StringHelper.isEmpty(headImage)) {
                apply.setHeadimage(headImage);
            }
            if (!StringHelper.isEmpty(gender)) {
                apply.setGender(TConverter.ObjectToShort(gender));
            }
            if(!StringHelper.isTrimEmpty(regionCode)){
                apply.setRegioncode(regionCode);
            }
            apply.setUserId(userid);
            apply.setCreatetime(new Date());
            apply.setAuditstatus((short) 0);
            userService.addUserApply(apply);
            return new BaseResponse("提交成功，请耐心等待审核");
        }else {
            if (!StringHelper.isEmpty(nickName)) {
                user.setNickname(nickName);
            }
            if (!StringHelper.isEmpty(headImage)) {
                user.setHeadimage(headImage);
            }
            if (!StringHelper.isEmpty(gender)) {
                user.setGender(TConverter.ObjectToShort(gender));
            }
            if(!StringHelper.isTrimEmpty(regionCode)){
                user.setRegioncode(regionCode);
            }
            userService.updateUser(user);
            return new BaseResponse("修改成功");
        }
    }

    @ApiOperation("通过refreshtoken获取新的uat")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rt", value = "refresh token", dataType = "String", paramType = "query", required = true),
    })
    @PostMapping("newuat")
    BaseResponse getNewUatByLoginToken(
            @RequestParam("rt") String rt,
            @RequestParam(value = "appcode", required = false) String appcode,
            @RequestParam(value = "imei", required = false) String imei
    ) {
        if (StringHelper.isEmpty(rt)) {
            return new BaseResponse(ReturnCodeConst.EMPTY, "refreshtoken不能为空");
        }
        //判断logintoken是否有效
        long userid = userService.getUseridByRefreshtoken(rt);
        if (userid <= 0) {
            return new BaseResponse(null);
        }
        //删除旧的rt
        userService.deleteRefreshtoken(rt);
        return new BaseResponse(uatService.generateUATandRT(userid, appcode,imei));
    }

    //region 重置密码
    @ApiOperation("重置密码-第一步，验证用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @PostMapping("resetpassword1")
    BaseResponse resetPassword1(
            @RequestParam("phone") String phone,
            @RequestParam("vericode") String veriCode,
            @RequestParam("picvericode") String picVericode,
            @RequestParam("pictoken") String picToken
    ){
        if (phone.length() < 11) {
            return new BaseResponse("102", "手机号格式有误");
        }
        if (!picVericodeService.verify(picToken, picVericode)) {
            return new BaseResponse("113", "图片验证码错误");
        }
        //校验验证码
        if (!vericodeService.verifyCode(phone, (short) 4, veriCode)) {
            return new BaseResponse("102", "验证码错误");
        }
        TDUser userInfo = userService.getByPhone(phone);
        if (userInfo == null || userInfo.getId() == 0) {
            return new BaseResponse("101", "用户不存在");
        }
        if (userInfo.getIsvalid() != 1) {
            return new BaseResponse("104", "用户被封禁");
        }
        //生成token
        String token = UUIDUtil.getUUID();
        //保存验证码数据到redis
        uatService.savaResetPasswordToken(token, userInfo.getId());
        return new BaseResponse(token);
    }

    @ApiOperation("重置密码-第二步，设置新密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @PostMapping("resetpassword2")
    BaseResponse resetPassword2(
            @RequestParam("rptoken") String rptoken,
            @RequestParam("password") String password
    ){
        Long userid=uatService.getUseridByRPToken(rptoken);
        if(userid==null||userid<=0){
            return new BaseResponse(ReturnCodeConst.ERROR,"操作有误");
        }
        TDUser userInfo=new TDUser();
        userInfo.setId(userid);
        userInfo.setPassword(password.toLowerCase());
        userService.updateUser(userInfo);
        return new BaseResponse("重置密码成功");
    }

    //endregion


    //region 单一登录
    @ApiOperation("检查用户登录uat：有效返回1，无效返回0")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @PostMapping("checkuat")
    BaseResponse checkUAT(
            @RequestParam(value = "uat",required = false) String uat
    ){
        //若uat为空，返回0
        if(StringHelper.isTrimEmpty(uat)) {
            return new BaseResponse(0);
        }
        //若uat失效,则返回110
        long userid = uatService.getUserIDByUAT(uat);
        if (userid <= 0) {
            return new BaseResponse("110", "请登录后重试");
        }
        //是否开启单一登录
        int isopen=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.single_login","isopen"));
        if(isopen==1) {
            String oldUat = TConverter.toSafeString(redisTemplate.opsForHash().get(CacheKeyConst.UAT_USERID_PRE + userid, "uat"));
            if (!uat.equals(oldUat)) {
                return new BaseResponse(0);
            }
        }
        return new BaseResponse(1);
    }

    @ApiOperation("判断是否已经登录app，已经登录返回1，未登录返回0")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @PostMapping("islogined")
    BaseResponse isLogined(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            @RequestParam(value = "imei", required = false) String imei
    ){
        //是否开启单一登录
        int isopen=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.single_login","isopen"));
        //未开启单一登录，直接返回0
        if(isopen!=1){
            return new BaseResponse(0);
        }
        BaseResponse response = userService.getUserByLoginNameAndPwd2(userName, password);
        if (!"0".equals(response.getCode())) {
            response.setData("");
            return response;
        }
        TDUser userInfo =(TDUser) response.getData();
        if(userInfo==null){
            return new BaseResponse("101", "登录信息有误");
        }
        String uat = TConverter.toSafeString(redisTemplate.opsForHash().get( CacheKeyConst.UAT_USERID_PRE + userInfo.getId(), "uat"));
        if(StringHelper.isTrimEmpty(uat)) {
            return new BaseResponse(0);
        }
        String oldime=TConverter.toSafeString(redisTemplate.opsForHash().get( CacheKeyConst.UAT_USERID_PRE +userInfo.getId(), "imei"));
        if(!StringHelper.isTrimEmpty(imei)&&imei.equals(oldime)) {
            return new BaseResponse(0);
        }
        return new BaseResponse(1);
    }

    @ApiOperation("判断是否已经登录app，已经登录返回1，未登录返回0")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @PostMapping("issmslogined")
    BaseResponse isSmsLogined(
            @RequestParam("phone") String phone,
            @RequestParam("vericode") String veridCode,
            @RequestParam(value = "imei", required = false) String imei
    ){
        //是否开启单一登录
        int isopen=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.single_login","isopen"));
        //未开启单一登录，直接返回0
        if(isopen!=1){
            return new BaseResponse(0);
        }
        if (!vericodeService.verifyCode2(phone, (short) 2, veridCode)) {
            return new BaseResponse("101", "登录信息有误");
        }
        TDUser userInfo = userService.getByPhone(phone);
        if (userInfo == null || userInfo.getId() == 0) {
            return new BaseResponse(0);
            //return new BaseResponse("101", "登录信息有误");
        }
        if (userInfo.getIsvalid() != 1) {
            return new BaseResponse("104", "用户被封禁");
        }
        String uat = TConverter.toSafeString(redisTemplate.opsForHash().get( CacheKeyConst.UAT_USERID_PRE + userInfo.getId(), "uat"));
        if(StringHelper.isTrimEmpty(uat)) {
            return new BaseResponse(0);
        }
        String oldime=TConverter.toSafeString(redisTemplate.opsForHash().get( CacheKeyConst.UAT_USERID_PRE + userInfo.getId(), "imei"));
        if(!StringHelper.isTrimEmpty(imei)&&imei.equals(oldime)) {
            return new BaseResponse(0);
        }
        return new BaseResponse(1);
    }
    //endregion


    @ApiOperation("获取用户是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "phone", dataType = "String", paramType = "query", required = true),
    })
    @PostMapping("userPhone")
    BaseResponse getUserPhone(
            @RequestParam("phone") String phone
    ) throws Exception {
        TDUser userInfo = userService.getByPhone(phone);
        return new BaseResponse(userInfo);
    }

    @ApiOperation("账号登录--登录名或手机号登录")
    @PostMapping("accountlogin")
    BaseResponse accountLogin(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            @RequestParam("appcode") String appCode,
            @RequestParam(value = "imei", required = false) String imei,
            @RequestParam(value = "picvericode", required = false) String picVericode,
            @RequestParam(value = "pictoken", required = false) String picToken
    ) {
        if (StringHelper.isTrimEmpty(picVericode) || StringHelper.isTrimEmpty(picToken)) {
            return new BaseResponse(ReturnCodeConst.EMPTY, "登录信息有误");
        }
        if (!picVericodeService.verify(picToken, picVericode)) {
            //调试用图形验证码
            if (!picToken.equals("asdfzxcv")) {
                return new BaseResponse(ReturnCodeConst.LOGIN_ERROR, "验证码有误");
            }
        }
        TDUser user = userService.getUserByLoginName(userName);
        if (user==null) {
            userService.addLoginLog(0, userName, imei, appCode, null, 0, 1);
            return new BaseResponse(ReturnCodeConst.ERROR,"登录信息有误");
        }
        //获取登录失败设置--账号封禁
        int limittimes=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("LIMITTIMES","SYSUSER_LOGINERROR"),5);
        //若为0，则不设置登录错误次数限制
        if(limittimes!=0) {
            if (TConverter.ObjectToInt(user.getLoginerrorcount()) >= limittimes) {
                long minutes = TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("MINUTES", "SYSUSER_LOGINERROR"), 30);
                String errormsg = "您已连续错误超过%s次，请耐心等待%s分钟后重试";
                // 计算差多少分钟
                long min = (System.currentTimeMillis() - user.getLastloginerrortime().getTime()) % (1000 * 24 * 60 * 60) % (1000 * 60 * 60) / (1000 * 60);
                if(min<minutes) {
                    return new BaseResponse(ReturnCodeConst.ERROR, String.format(errormsg,limittimes,minutes-min));
                }else {
                    user.setLoginerrorcount((short)0);
                }
            }
        }
        if (StringHelper.isTrimEmpty(user.getPassword()) ||!user.getPassword().toLowerCase().equals(password.toLowerCase())) {
            userService.addLoginLog(user.getId(), userName, imei, appCode, null, 0, 1);
            user.setLoginerrorcount((short)(TConverter.ObjectToInt(user.getLoginerrorcount())+1));
            user.setLastloginerrortime(new Date());
            userService.updateUser(user);
            return new BaseResponse(ReturnCodeConst.ERROR,"登录信息有误");
        }else {
            user.setLoginerrorcount((short) 0);
            userService.updateUser(user);
        }

        if (TConverter.ObjectToShort(user.getIsvalid()) != 1) {
            userService.addLoginLog(user.getId(), userName, imei, appCode, null, 0, 1);
            return new BaseResponse("104", "用户被封禁");
        }
        //根据userID生成uat
        Object uatandrt = uatService.generateUATandRT(user.getId(), appCode,imei);
        userService.addLoginLog(user.getId(), userName, imei, appCode, null, 1, 1);
        return new BaseResponse(uatandrt);
    }

}
