package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.SysRoleMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.SysUserRoleMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.TDUserMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.TLServiceMapper;
import com.ucss.elementary.tnwn.model.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by HL on 2017/12/29.
 */
@Service
public class CmsUserService {
    @Autowired
    TLServiceMapper tlServiceMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    TDUserMapper tdUserMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    //判断一个用户是否存在角色
    public boolean existRole(long userid){
        SysUserRoleExample example=new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userid);
        return sysUserRoleMapper.countByExample(example)>0;
    }
    //判断用户是否为管理员
    public boolean isSuperAdmin(long userid){
        SysUserRoleExample example=new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userid).andRoleIdEqualTo(1L);
        return sysUserRoleMapper.countByExample(example)>0;
    }


    //根据用户id删除用户对应角色
    public int deleteUserRoleByUserId(Long userId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        int count = sysUserRoleMapper.deleteByExample(example);
        return count;
    }


    //根据用户ID查询当前用户所有角色
    public List<SysUserRoleKey> getRoleIdByuserId(Long userId){
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return sysUserRoleMapper.selectByExample(example);
    }
    //根据用户ID查询当前用户所有角色
    public List<SysRole> getRolebyuserId(Long userId){
        return sysRoleMapper.getListByUserid(userId);
    }
    //批量插入政府干部
    public void addGovBatch(List<TDUser> list)
    {
        HashMap<String,Object> parms=new HashMap<>();
        if(list!=null && list.size()>0)
        {
            parms.put("list",list);
        }else {
            return;
        }
        tdUserMapper.addGovBatch(parms);
    }

    //判断登录名是否存在
    public boolean existLoginname(String loginname,long outid){
        TDUserExample example=new TDUserExample();
        example.createCriteria()
                .andLoginnameEqualTo(loginname).andIdNotEqualTo(outid);
        if(tdUserMapper.countByExample(example)>0) {
            return true;
        }
        example.clear();
        example.createCriteria()
                .andPhonebindEqualTo(loginname).andIdNotEqualTo(outid);
        if(tdUserMapper.countByExample(example)>0) {
            return true;
        }
        return false;
    }
}
