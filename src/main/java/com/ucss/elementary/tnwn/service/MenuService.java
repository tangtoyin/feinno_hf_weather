package com.ucss.elementary.tnwn.service;


import com.ucss.elementary.tnwn.mapper.tnwn.SysMenuMapper;
import com.ucss.elementary.tnwn.model.database.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class MenuService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    SysMenuMapper sysMenuMapper;
    @Autowired
    CmsUserService cmsUserService;
    //通过角色与父级id获取菜单列表
    public List<SysMenu> getMenu(long partentid, long roleid) {
        HashMap<String,Object> parms=new HashMap<>();
        parms.put("parentid",partentid);
        parms.put("roleid",roleid);
        return sysMenuMapper.getMenuList(parms);
    }
    //判断userid是否具备code权限
    public boolean isPermission(long userid,String premissioncode){
        HashMap<String,Object> parms=new HashMap<>();
        parms.put("userid",userid);
        parms.put("premissioncode",premissioncode);
        return sysMenuMapper.isPermission(parms)>0;
    }
    //endregion
    //获取登录用户的菜单列表
    public List<SysMenu> getUserMenuList(long id,String systemcode)
    {
            if(cmsUserService.isSuperAdmin(id))
            {//是系统管理员
                return   sysMenuMapper.getAllMenuList(systemcode);
            }else {
                return sysMenuMapper.getMenuListByUserid(id,systemcode);
            }
    }
    //菜单列表
    public List<SysMenu> getMenuList(String systemcode)
    {
        return sysMenuMapper.getAllMenuList(systemcode);
    }
    //保存菜单
    public void saveMenu(SysMenu menu)
    {
        if(menu.getId()!=null)
        {//修改
            sysMenuMapper.updateByPrimaryKeySelective(menu);
        }else{
            sysMenuMapper.insertSelective(menu);
        }
    }

    //删除菜单
    public void deleteMenu(long id)
    {
        if(id<=0)
        {
            return;
        }
        SysMenu menu=new SysMenu();
        menu.setId(id);
        menu.setIsvalid((short)0);
        sysMenuMapper.updateByPrimaryKeySelective(menu);
    }

    //菜单详情
    public SysMenu getMenuDetail(long id)
    {
        return sysMenuMapper.getMenuDetail(id);
    }
}
