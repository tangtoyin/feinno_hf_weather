package com.ucss.elementary.tnwn.service.tnwn;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucss.elementary.tnwn.mapper.tnwn.SysApikeyMapper;
import com.ucss.elementary.tnwn.mapper.tnwn.TBNumrangeMapper;
import com.ucss.elementary.tnwn.model.database.SysApiKeyExtension;
import com.ucss.elementary.tnwn.model.database.SysApikey;
import com.ucss.elementary.tnwn.model.database.TBNumrange;
import com.ucss.elementary.tnwn.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class BasicDataService {

    public  Logger log= LoggerFactory.getLogger(BasicDataService.class);

    @Autowired
    private SysApikeyMapper sysApikeyMapper ;

    @Autowired
    private TBNumrangeMapper tbNumrangeMapper;
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


    public List<TBNumrange> getBasicData(TBNumrange tbNumrange){
        if(tbNumrange.getNumrange().trim().length()>7&&tbNumrange.getNumrange().trim()!="") {
            tbNumrange.setNumrange(tbNumrange.getNumrange().substring(0, 7));
        }
        //如果numrange为空证明是查询所有的号段表信息
            List<TBNumrange> tbNumranges = tbNumrangeMapper.selectByNumrange(tbNumrange);
            PageInfo<TBNumrange> tbNumrangePageInfo=new PageInfo<>(tbNumranges);
            List<TBNumrange> tbNumrangePageInfoList = tbNumrangePageInfo.getList();
            return tbNumrangePageInfoList;
    }

    public int deleteById(BigDecimal id){
        return tbNumrangeMapper.deleteById(id);
    }

    public int updataTBNumrange(TBNumrange tbNumrange){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        try {
            String format = sdf.format(date);
            Date updatetime = sdf.parse(format);
            tbNumrange.setCreatetime(updatetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  tbNumrangeMapper.updataByTBNumrange(tbNumrange);
    }

    public int insertTBNumrange(TBNumrange tbNumrange){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        try {
            String format = sdf.format(date);
            Date createtime = sdf.parse(format);
            tbNumrange.setCreatetime(createtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tbNumrangeMapper.insertTBNumrange(tbNumrange);
    }
}
