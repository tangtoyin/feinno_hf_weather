package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.*;
import com.ucss.elementary.tnwn.model.database.*;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.util.StringHelper;
import com.ucss.elementary.tnwn.util.TConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HL on 2017/12/29.
 */
@Service
public class UserService {
    @Autowired
    TDUserMapper tdUserMapper;
    @Autowired
    TDUserRefreshMapper userRefreshMapper;
    @Autowired
    TLLoginMapper loginMapper;
    @Autowired
    TDUserApplyMapper tdUserApplyMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysService sysService;
    //根据电话获取用户
    public TDUser getByPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return null;
        }
        TDUserExample example = new TDUserExample();
        example.createCriteria().andPhonebindEqualTo(phone);
        return TConverter.GetFirstOrDefualt(tdUserMapper.selectByExample(example));
    }
    public TDUser getByLoginname(String loginname) {
        if (StringUtils.isEmpty(loginname)) {
            return null;
        }
        TDUserExample example = new TDUserExample();
        example.createCriteria().andLoginnameEqualTo(loginname);
        return TConverter.GetFirstOrDefualt(tdUserMapper.selectByExample(example));
    }

    //新增用户
    public long newUser(String phone,String loginname, String password, String nickName, String regionCode, short userType) {
        if (StringUtils.isEmpty(phone)&&StringHelper.isTrimEmpty(loginname)) {
            return 0;
        }
        TDUser userInfo = new TDUser();
        userInfo.setCreatetime(new Date());
        userInfo.setPhonebind(phone);
        userInfo.setLoginname(loginname);
        userInfo.setUsertype(userType);
        userInfo.setAuditstatus((short) 1);
        userInfo.setIsvalid((short) 1);
        userInfo.setNickname(nickName);
        userInfo.setPassword(password);
        userInfo.setAuditstatus((short) 1);
        userInfo.setCreatetime(new Date());
        userInfo.setRegioncode(regionCode);
        userInfo.setUpdatetime(new Date());
        tdUserMapper.insertSelective(userInfo);
        return userInfo.getId();
    }

    //获取用户
    public TDUser getByID(long userID) {
        return tdUserMapper.selectByPrimaryKey(userID);
    }

    //启用用户
    public void enableUser(long userID) {
        TDUser userInfo = new TDUser();
        userInfo.setId(userID);
        userInfo.setIsvalid((short) 1);
        userInfo.setAuditstatus((short) 1);
        userInfo.setUpdatetime(new Date());
        tdUserMapper.updateByPrimaryKeySelective(userInfo);
    }

    //获取用户列表
    public List<TDUser> getlist(short isValid) {
        TDUserExample example = new TDUserExample();
        example.createCriteria().andIsvalidEqualTo(isValid);
        return tdUserMapper.selectByExample(example);
    }

    //根据登录名和密码查询用户
    public TDUser getUserByLoginNameAndPwd(String loginName, String password) {
        TDUserExample example = new TDUserExample();
        example.createCriteria().andPhonebindEqualTo(loginName);
        TDUser userInfo = TConverter.GetFirstOrDefualt(tdUserMapper.selectByExample(example));
        if (userInfo == null) {
            return null;
        }
        if (!StringUtils.isEmpty(userInfo.getPassword()) && userInfo.getPassword().toLowerCase().equals(password.toLowerCase())) {
            return userInfo;
        }
        return null;
    }

    //根据登录名和密码查询用户---若登录成功，data返回用户信息，否则返回用户id
    public BaseResponse getUserByLoginNameAndPwd2(String loginName, String password) {
        TDUser userInfo=null;
        if(TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.user_register","type"),1)==1) {
            userInfo=getByPhone(loginName);
        }else {
            userInfo=getByLoginname(loginName);
        }
        if (userInfo == null) {
            return new BaseResponse("101", "登录信息有误");
        }
        if (!StringUtils.isEmpty(userInfo.getPassword()) && userInfo.getPassword().toLowerCase().equals(password.toLowerCase())) {
            return new BaseResponse(userInfo);
        }
        return new BaseResponse("101", "登录信息有误", userInfo.getId());
    }

    //根据登录信息获取用户信息
    public TDUser getUserByLoginName(String loginName) {
        TDUser userInfo =getByLoginname(loginName);
        if(userInfo==null){
            userInfo = getByPhone(loginName);
        }
       return userInfo;
    }
    //获取用户数量
    public int getUserCount(short usertype) {
        TDUserExample example = new TDUserExample();
        example.createCriteria()
                .andIsvalidEqualTo((short) 1)
                .andUsertypeEqualTo(usertype);
        return tdUserMapper.countByExample(example);
    }


    //更新用户
    public int updateUser(TDUser user) {
        user.setUpdatetime(new Date());
        return tdUserMapper.updateByPrimaryKeySelective(user);
    }

    //新增用户基本资料修改申请
    //@Transactional(value = "transactionManagerVillagepro")
    public int addUserApply(TDUserApply apply)
    {
        TDUserApply apply1=new TDUserApply();
        apply1.setAuditstatus((short)3);
        TDUserApplyExample example=new TDUserApplyExample();
        example.createCriteria().andUserIdEqualTo(apply.getUserId());
        tdUserApplyMapper.updateByExampleSelective(apply1,example);
        return  tdUserApplyMapper.insertSelective(apply);
    }

    //通过refresh token获取userid
    public long getUseridByRefreshtoken(String refreshtoken) {
        TDUserRefreshExample example = new TDUserRefreshExample();
        example.createCriteria().andRefreshtokenEqualTo(refreshtoken)
                .andIsvalidEqualTo((short) 1);
        TDUserRefresh refresh = TConverter.GetFirstOrDefualt(userRefreshMapper.selectByExample(example));
        if (refresh != null) {
            return refresh.getUserId();
        }
        return 0;
    }

    //删除refresh token
    public void deleteRefreshtoken(String refreshtoken) {
        if (StringHelper.isEmpty(refreshtoken)) {
            return;
        }
        TDUserRefreshExample example = new TDUserRefreshExample();
        example.createCriteria().andRefreshtokenEqualTo(refreshtoken);
        userRefreshMapper.deleteByExample(example);
    }

    //新增user refreshtoken
    public int insertUserRefresh(long userid, String refreshtoken) {
        TDUserRefresh refresh = new TDUserRefresh();
        refresh.setIsvalid((short) 1);
        refresh.setUserId(userid);
        refresh.setCreatetime(new Date());
        refresh.setRefreshtoken(refreshtoken);
        refresh.setUpdatetime(new Date());
        return userRefreshMapper.insertSelective(refresh);
    }

    //插入登录日志  logintype登录类型(1密码 2验证码 3单点登录)
    public int addLoginLog(long userid, String phone, String imei, String appcode, String ip, int success, int logintype) {
        TLLogin login = new TLLogin();
        login.setUserId(userid);
        login.setAppcode(appcode);
        login.setPhone(phone);
        login.setImei(imei);
//        if (StringHelper.isEmpty(ip)) {
//            ip = IpUtils.getLocalIP();
//        }
        login.setIp(ip);
        login.setSuccess((short) success);
        login.setLogintype((short) logintype);
        login.setLogintime(new Date());
        return loginMapper.insertSelective(login);
    }

    public boolean isRegister(String phone){
        TDUserExample example = new TDUserExample();
        example.createCriteria().andPhonebindEqualTo(phone).andIsvalidEqualTo((short)1);
        return tdUserMapper.countByExample(example)>0;
    }

    //获取用户修改资料列表
    public List<TDUserApply> getUserApplyList(String phone, Short auditstatus, Short gender)
    {
        HashMap<String,Object> parms=new HashMap<>();
        parms.put("auditstatus",auditstatus);
        if(!StringHelper.isEmpty(phone)){
            parms.put("phone","%"+phone+"%");
        }
        if(gender!=null)
        {
            parms.put("gender",gender);
        }
        return tdUserApplyMapper.getUserApplyList(parms);
    }

    //审核用户修改申请
    public void auditUserApply(List<Long> ids,short isvalid,Short auditstatus,Long auditadminid,String auditreason)
    {
        HashMap<String,Object> parms=new HashMap<>();
        parms.put("ids",ids);
        parms.put("isvalid",isvalid);
        parms.put("auditstatus",auditstatus);
        parms.put("auditadminid",auditadminid);
        if(!StringHelper.isEmpty(auditreason))
        {
            parms.put("auditreason",auditreason);
        }
        tdUserApplyMapper.audit(parms);
    }

    //新增虚拟号码
    public void insertVirtualMobile(long id,String vitualMobile){
        if (id>0) {
            TDUser tdUser = tdUserMapper.selectByPrimaryKey(id);
            if (!StringHelper.isEmpty(vitualMobile)){
                tdUser.setId(id);
                tdUser.setVirtualphone(vitualMobile);
            }
            tdUserMapper.updateByPrimaryKeySelective(tdUser);
        }
    }
    /**
     * 获取用户信息
     */
    public TDUser getUser(long id){
        return tdUserMapper.selectByPrimaryKey(id);
    }
    //新增用户
    public void add(TDUser user) {
        tdUserMapper.insertSelective(user);
    }
    //启用用户为未审状态
    public void enableUserNoaudit(long userID) {
        TDUser userInfo = new TDUser();
        userInfo.setId(userID);
        userInfo.setIsvalid((short)0);
        userInfo.setAuditstatus((short)0);
        userInfo.setUpdatetime(new Date());
        tdUserMapper.updateByPrimaryKeySelective(userInfo);
    }
    //region cms
    //审核用户
    public int audit(List<Long> ids,short isvalid,Short auditstatus,Long auditadminid,String auditreason){
        TDUserExample example=new TDUserExample();
        example.createCriteria().andIdIn(ids);
        TDUser user=new TDUser();
        user.setIsvalid(isvalid);
        user.setAuditstatus(auditstatus);
        user.setUpdatetime(new Date());
        user.setAuditadminId(auditadminid);
        user.setAudittime(new Date());
        user.setAuditreason(auditreason);
        return tdUserMapper.updateByExampleSelective(user,example);
    }
    //用户列表
    public List<TDUserNewExtension> getUserList(String keyword,Short auditstatus,Short usertype,Long roleid)
    {
        HashMap<String,Object> parms=new HashMap<>();
        parms.put("auditstatus",auditstatus);
        parms.put("usertype",usertype);
        if(!StringHelper.isEmpty(keyword)){
            parms.put("keyword","%"+keyword+"%");
        }
        if(roleid!=null&&roleid!=-1){
            parms.put("roleid",roleid);
        }
        return tdUserMapper.getUserList(parms);
    }
    //endregion

}
