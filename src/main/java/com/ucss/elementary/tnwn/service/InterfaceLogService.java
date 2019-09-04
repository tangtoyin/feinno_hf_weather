package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.TLServiceMapper;
import com.ucss.elementary.tnwn.model.database.TLServiceWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HL on 2017/12/29.
 */
@Service
public class InterfaceLogService {
    @Autowired
    TLServiceMapper tlServiceMapper;

    //新增记录
    public void newLog(TLServiceWithBLOBs tlservice) {
        tlServiceMapper.insertSelective(tlservice);
    }


}
