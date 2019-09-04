package com.ucss.elementary.tnwn.service;


import com.ucss.elementary.tnwn.mapper.tnwn.SysRoleMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.SysRoleMenuMapper;
import com.ucss.elementary.tnwn.model.database.SysRole;
import com.ucss.elementary.tnwn.model.database.SysRoleExample;
import com.ucss.elementary.tnwn.model.database.SysRoleMenu;
import com.ucss.elementary.tnwn.model.database.SysRoleMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;



    /**
     * 获取角色列表
     * @return 所有角色信息
     */
    public List<SysRole> getRoleList(){

        SysRoleExample example = new SysRoleExample();
        example.createCriteria()
                .andIsvalidEqualTo((short) 1)
                .andIdNotEqualTo((long) 1);
        example.setOrderByClause("updatetime desc nulls last,createtime desc nulls last");
        return sysRoleMapper.selectByExample(example);
    }

    /**
     * 根据ID获取角色
     * @return 对应角色信息
     */
    public SysRole getRole(Long id){

        return sysRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 者修改角色
     * @return 被修改的影响行数
     */
    public int updateRole(Long roleId,String name,Long updater){

        SysRole sysRole = new SysRole();
        sysRole.setId(roleId);
        sysRole.setName(name);
        sysRole.setUpdatetime(new Date());
        sysRole.setUpdater(updater);
        int count = sysRoleMapper.updateByPrimaryKeySelective(sysRole);

        return count;


    }

    /**
     * 新增角色
     * @return 被新增对象ID
     */
    public Long insertRole(String name,Long creator){

        SysRole sysRole = new SysRole();
        sysRole.setName(name);
        sysRole.setIsvalid((short)1);
        sysRole.setCreatetime(new Date());
        sysRole.setCreator(creator);
        int count = sysRoleMapper.insertSelective(sysRole);
        Long roleId = sysRole.getId();
        return roleId;


    }



    /**
     * 通过ID删除角色
     * @param id
     * @return 影响行数
     */
    public int deleteRole(Long id){

        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setUpdatetime(new Date());
        sysRole.setIsvalid((short)0);
        int count = sysRoleMapper.updateByPrimaryKeySelective(sysRole);

        return count;
    }

    /**
     * 批量插入角色与用户关系
     * @param userRoleKeys
     * @return 影响行数
     */
    public int insertUserRoses(List userRoleKeys){

        int count = sysRoleMapper.batchInsert(userRoleKeys);
        return count;
    }

    /**
     * 在角色与菜单表中通过角色ID删除角色与菜单信息
     * @param id
     * @return 影响行数
     */
    public int deleteRoleMenu(Long id){

        SysRoleMenuExample example = new SysRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(id);
        int count = sysRoleMenuMapper.deleteByExample(example);

        return count;
    }

    /**
     * 批量插入角色与菜单关系
     * @param roleMenus
     * @return 影响行数
     */
    public int insertRoleMenus(List roleMenus){

        int count = sysRoleMenuMapper.batchInsert(roleMenus);
        return count;
    }

    //通过角色Id查询对应菜单
    public List<SysRoleMenu> selectRoleMenus(Long roleId){
        SysRoleMenuExample example = new SysRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return sysRoleMenuMapper.selectByExample(example);
    }

    //判断改角色名称是否重复
    public boolean existRoleName(String roleName,Long outid){
        SysRoleExample example=new SysRoleExample();
        example.createCriteria().andNameEqualTo(roleName).andIdNotEqualTo(outid);
        return sysRoleMapper.countByExample(example)>0;
    }
}