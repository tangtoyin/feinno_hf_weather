package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.TDIpBlacklistMapper;
import com.ucss.elementary.tnwn.model.database.TDIpBlacklist;
import com.ucss.elementary.tnwn.model.database.TDIpBlacklistExample;
import com.ucss.elementary.tnwn.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Smile
 * @date 2018/10/23 10:01
 */
@Service
public class IpBlacklistService {
    @Autowired
    TDIpBlacklistMapper IpBlacklistMapper;

    //获取列表
    public List<TDIpBlacklist> getCmsIpBlacklists(String keyword) {
        TDIpBlacklistExample example = new TDIpBlacklistExample();
        if (!StringHelper.isTrimEmpty(keyword)) {
            example.createCriteria()
                    .andIpsegmentLike("%" + keyword + "%");
        }
        return IpBlacklistMapper.selectByExample(example);
    }

    public int add(TDIpBlacklist IpBlacklist) {
        return IpBlacklistMapper.insertSelective(IpBlacklist);
    }

    public int edit(TDIpBlacklist IpBlacklist) {
        return IpBlacklistMapper.updateByPrimaryKeySelective(IpBlacklist);
    }
    //删除
    public int del(List<Long> ids) {
        TDIpBlacklistExample example = new TDIpBlacklistExample();
        example.createCriteria().andIdIn(ids);
        return IpBlacklistMapper.deleteByExample(example);
    }

    public TDIpBlacklist detail(long id) {
        return IpBlacklistMapper.selectByPrimaryKey(id);
    }
}
