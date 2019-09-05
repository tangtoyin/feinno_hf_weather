package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.SysApikeyMapper;
import com.ucss.elementary.tnwn.model.database.SysApiKeyExtension;
import com.ucss.elementary.tnwn.model.database.SysApikey;
import com.ucss.elementary.tnwn.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ApiKeyService  {

    @Autowired
    private SysApikeyMapper sysApikeyMapper ;

    public void insert(SysApikey sysApikey){
        sysApikeyMapper.insertSelective(sysApikey);
    }

    public List<SysApiKeyExtension> getapikeyList(Short isforbidden, String keyword, Long userid){
        HashMap<String,Object> parms=new HashMap<>();

        parms.put("isvalid",1);

        if(isforbidden != null && isforbidden >= 0){
            parms.put("isforbidden",isforbidden);
        }

        if(!StringHelper.isTrimEmpty(keyword)){
            parms.put("keyword","%"+keyword+"%");
        }

        if(userid!=null){
            parms.put("userid",userid);
        }

        return sysApikeyMapper.getapikeyList(parms);
    }

    public int update(SysApikey sysApikey){
        return sysApikeyMapper.updateByPrimaryKeySelective(sysApikey);
    }
}
