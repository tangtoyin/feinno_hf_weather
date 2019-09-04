package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TDPartner;
import com.ucss.elementary.tnwn.model.database.TDPartnerExample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TDPartnerMapper {
    int countByExample(TDPartnerExample example);

    int deleteByExample(TDPartnerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDPartner record);

    int insertSelective(TDPartner record);

    List<TDPartner> selectByExample(TDPartnerExample example);

    TDPartner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDPartner record, @Param("example") TDPartnerExample example);

    int updateByExample(@Param("record") TDPartner record, @Param("example") TDPartnerExample example);

    int updateByPrimaryKeySelective(TDPartner record);

    int updateByPrimaryKey(TDPartner record);

    List<TDPartner> getCMSList(HashMap<String,Object> parms);
}