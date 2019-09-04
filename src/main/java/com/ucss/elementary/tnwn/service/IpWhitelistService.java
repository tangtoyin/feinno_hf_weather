package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.TDIpWhitelistMapper;
import com.ucss.elementary.tnwn.model.database.TDIpWhitelist;
import com.ucss.elementary.tnwn.model.database.TDIpWhitelistExample;
import com.ucss.elementary.tnwn.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Smile
 * @date 2018/10/23 10:01
 */
@Service
public class IpWhitelistService {
    @Autowired
    TDIpWhitelistMapper ipWhitelistMapper;

    //获取列表
    public List<TDIpWhitelist> getCmsIpWhitelists(String keyword) {
        TDIpWhitelistExample example = new TDIpWhitelistExample();
        if (!StringHelper.isTrimEmpty(keyword)) {
            example.createCriteria()
                    .andIpsegmentLike("%" + keyword + "%");
        }
        return ipWhitelistMapper.selectByExample(example);
    }

    public int add(TDIpWhitelist ipWhitelist) {
        return ipWhitelistMapper.insertSelective(ipWhitelist);
    }

    public int edit(TDIpWhitelist ipWhitelist) {
        return ipWhitelistMapper.updateByPrimaryKeySelective(ipWhitelist);
    }
    //删除
    public int del(List<Long> ids) {
        TDIpWhitelistExample example = new TDIpWhitelistExample();
        example.createCriteria().andIdIn(ids);
        return ipWhitelistMapper.deleteByExample(example);
    }

    public TDIpWhitelist detail(long id) {
        return ipWhitelistMapper.selectByPrimaryKey(id);
    }
}
