package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.TDPartnerMapper;
import com.ucss.elementary.tnwn.model.database.TDPartner;
import com.ucss.elementary.tnwn.model.database.TDPartnerExample;
import com.ucss.elementary.tnwn.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class PartnerService {
    @Autowired
    TDPartnerMapper partnerMapper;

    //region cms
    public List<TDPartner> getCmsPartnerList(Short isvalid, String name, String partnerid, Date stime, Date etime){
        HashMap<String,Object> parms=new HashMap<>();
        if(isvalid!=null&&isvalid!=-1) {
            parms.put("isvalid", isvalid);
        }
        if(!StringHelper.isTrimEmpty(name)){
            parms.put("name","%"+name+"%");
        }
        if(!StringHelper.isTrimEmpty(partnerid)){
            parms.put("partnerid","%"+partnerid+"%");
        }
        if(stime!=null){
            parms.put("stime", stime);
        }
        if(etime!=null){
            parms.put("etime", etime);
        }
        return partnerMapper.getCMSList(parms);
    }
    public int add(TDPartner partner){
        return partnerMapper.insertSelective(partner);
    }
    public int edit(TDPartner partner){
        return partnerMapper.updateByPrimaryKeySelective(partner);
    }
    public int audit(List<Integer> ids,int isvalid){
        TDPartnerExample example=new TDPartnerExample();
        example.createCriteria().andIdIn(ids);
        TDPartner partner=new TDPartner();
        partner.setIsvalid(isvalid);
        partner.setUpdatetime(new Date());
        return partnerMapper.updateByExampleSelective(partner,example);
    }
    public TDPartner detail(int id){
        return partnerMapper.selectByPrimaryKey(id);
    }

    //判断partnerid是否已存在
    public boolean existPartnerID(String partnerid,int outid){
        TDPartnerExample example=new TDPartnerExample();
        example.createCriteria()
                .andPartneridEqualTo(partnerid)
                .andIdNotEqualTo(outid);
        return partnerMapper.countByExample(example)>0;
    }
    //endregion

}
