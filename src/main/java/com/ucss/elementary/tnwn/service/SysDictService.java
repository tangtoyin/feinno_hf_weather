package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.SysDictMapper;
import com.ucss.elementary.tnwn.model.database.SysDict;
import com.ucss.elementary.tnwn.model.database.SysDictExample;
import com.ucss.elementary.tnwn.util.StringHelper;
import com.ucss.elementary.tnwn.util.TConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lq on 2018/5/25.
 */
@Service
public class SysDictService {
    @Autowired
    SysDictMapper dictMapper;

    public List<SysDict> getDictList(String typecode, String keyword, Short isdel){
        HashMap<String,Object> parms=new HashMap<>();
        if(!StringHelper.isTrimEmpty(typecode)){
            parms.put("typecode",typecode);
        }
        if(isdel!=null){
            parms.put("isdel",isdel);
        }
        if(!StringHelper.isTrimEmpty(keyword)){
            parms.put("keyword","%"+keyword+"%");
        }
        return dictMapper.getDictList(parms);
    }

    public int add(SysDict dict){
        return dictMapper.insertSelective(dict);
    }
    public int edit(SysDict dict){
        return dictMapper.updateByPrimaryKeySelective(dict);
    }
    public SysDict getDict(String id){
        return dictMapper.selectByPrimaryKey(id);
    }
    public int del(List<String> ids){
        SysDictExample example=new SysDictExample();
        example.createCriteria().andIdIn(ids);
        SysDict dict=new SysDict();
        dict.setDelFlag("1");
        return dictMapper.updateByExampleSelective(dict,example);
    }
    //获取有效的type列表
    public List<String> getTypeList(){
        return dictMapper.getTypeList();
    }

    //根据type和value获取name
    public SysDict getDict(String type,String value){
        SysDictExample example = new SysDictExample();
        example.createCriteria().andTypeEqualTo(type).andValueEqualTo(value);
        return TConverter.GetFirstOrDefualt(dictMapper.selectByExample(example));
    }

    //根据type获取到数据
    public SysDict queryDict(String label,String type){
        HashMap<String,Object> parms=new HashMap<>();
        if(!StringHelper.isTrimEmpty(label)){
            parms.put("label",label+"%");
        }
        if(!StringHelper.isTrimEmpty(type)){
            parms.put("type",type);
        }
        List<SysDict> sysDict = dictMapper.queryDictList(parms);
        if(sysDict.size()>=1){
            SysDict sysDict1 = sysDict.get(0);
            return sysDict1;
        }
        return null;
    }
}
