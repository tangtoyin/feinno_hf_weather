package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.constant.CacheKeyConst;
import com.ucss.elementary.tnwn.mapper.tnwn.SysDictMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.TDIpBlacklistMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.TDIpWhitelistMapper;
import com.ucss.elementary.tnwn.model.database.*;
import com.ucss.elementary.tnwn.util.StringHelper;
import com.ucss.elementary.tnwn.util.TConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class SysService {

    @Autowired
    RedisTemplate redisTemplate;
    @Value("${spring.application.name}")
    String redisPrefix;
    @Autowired
    private SysDictMapper sysDictMapper;
    @Autowired
    TDIpWhitelistMapper ipWhitelistMapper;
    @Autowired
    TDIpBlacklistMapper ipBlacklistMapper;

    //region 清除缓存
    public void refreshRedisDataWithPrefix(String key) {
        //找到key
        Set<String> setkey = redisTemplate.keys(redisPrefix + "tnwn." + key);
        redisTemplate.delete(setkey);
    }
    //endregion

    //region 字典表
    public String getOptionNameByTypecodeAndCode(String typeCode, String code) {
        SysDict dict = getOptionByTypecodeAndCode(typeCode, code);
        if (dict != null) {
            return dict.getLabel();
        }
        return "";
    }
    public SysDict getOptionByTypecodeAndCode(String typeCode, String code) {
        if (StringUtils.isEmpty(typeCode) || StringUtils.isEmpty(code)) {
            return null;
        }
        List<SysDict> dicts = getOptionsByTypecode(typeCode);
        if (dicts == null) {
            return null;
        }
        return TConverter.GetFirstOrDefualt(dicts.stream().filter(a -> a.getValue().equals(code)).collect(Collectors.toList()));
    }
    public List<SysDict> getOptionsByTypecode(String typeCode) {
        if (StringUtils.isEmpty(typeCode)) {
            return null;
        }
        //尝试从缓存获取
        Object objOptions = redisTemplate.opsForHash().get(CacheKeyConst.DICT, typeCode);
        if (objOptions != null) {
            return (List<SysDict>) objOptions;
        }
        //缓存中未获取到则查询数据库
        SysDictExample example = new SysDictExample();
        example.createCriteria().andValueEqualTo(typeCode).andDelFlagEqualTo("0");
        example.setOrderByClause("sort desc");
        List<SysDict> dictInfos = sysDictMapper.selectByExample(example);
        if (dictInfos == null) {
            return null;
        }
        //保存到缓存
        redisTemplate.opsForHash().put(CacheKeyConst.DICT, typeCode, dictInfos);
        return dictInfos;
    }
    //endregion


    //region 白名单
    //获取所有白名单
    public List<TDIpWhitelist> getWhitelists(){
        //尝试从缓存获取
        Object obj = redisTemplate.opsForValue().get(CacheKeyConst.IP_WHITELIST);
        if (obj != null) {
            return (List<TDIpWhitelist>) obj;
        }
        //缓存中未获取到则查询数据库
        TDIpWhitelistExample example = new TDIpWhitelistExample();
        example.createCriteria();
        List<TDIpWhitelist> list = ipWhitelistMapper.selectByExample(example);
        if (list == null||list.size()==0) {
            return null;
        }
        //保存到缓存
        redisTemplate.opsForValue().set(CacheKeyConst.IP_WHITELIST, list);
        return list;
    }
    //判断是否为白名单
    public boolean isIPWhilelist(String ipSegment){
        List<TDIpWhitelist> list=getWhitelists();
        if(list==null||list.size()==0){
            return false;
        }
        for (TDIpWhitelist item:list){
            if(StringHelper.isTrimEmpty(item.getIpsegment())){
                continue;
            }
            //带*则表示范围
            if(item.getIpsegment().endsWith("*")){
                if(ipSegment.contains(item.getIpsegment().replaceFirst("\\*",""))){
                    return true;
                }
            }
            else {
                if(ipSegment.equals(item.getIpsegment())){
                    return true;
                }
            }
        }
        return false;
    }
    //endregion

    //region 黑名单
    public List<TDIpBlacklist> getBlacklists(){
        //尝试从缓存获取
        Object obj = redisTemplate.opsForValue().get(CacheKeyConst.IP_BLACKLIST);
        if (obj != null) {
            return (List<TDIpBlacklist>) obj;
        }
        //缓存中未获取到则查询数据库
        TDIpBlacklistExample example = new TDIpBlacklistExample();
        example.createCriteria();
        List<TDIpBlacklist> list = ipBlacklistMapper.selectByExample(example);
        if (list == null||list.size()==0) {
            return null;
        }
        //保存到缓存
        redisTemplate.opsForValue().set(CacheKeyConst.IP_BLACKLIST, list);
        return list;
    }
    //判断是否为黑名单
    public boolean isIPBlacklist(String ipSegment){
        List<TDIpBlacklist> list=getBlacklists();
        if(list==null||list.size()==0){
            return false;
        }
        for (TDIpBlacklist item:list){
            if(StringHelper.isTrimEmpty(item.getIpsegment())){
                continue;
            }
            //带*则表示范围
            if(item.getIpsegment().endsWith("*")){
                if(ipSegment.contains(item.getIpsegment().replaceFirst("\\*",""))){
                    return true;
                }
            }
            else {
                if(ipSegment.equals(item.getIpsegment())){
                    return true;
                }
            }
        }
        return false;
    }
    //endregion
}
