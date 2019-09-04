package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TDUser;
import com.ucss.elementary.tnwn.model.database.TDUserExample;
import com.ucss.elementary.tnwn.model.database.TDUserNewExtension;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface TDUserMapper {
    int countByExample(TDUserExample example);

    int deleteByExample(TDUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDUser record);

    int insertSelective(TDUser record);

    List<TDUser> selectByExample(TDUserExample example);

    TDUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDUser record, @Param("example") TDUserExample example);

    int updateByExample(@Param("record") TDUser record, @Param("example") TDUserExample example);

    int updateByPrimaryKeySelective(TDUser record);

    int updateByPrimaryKey(TDUser record);

    void addGovBatch(HashMap<String, Object> parms);

    List<TDUserNewExtension> getUserList(HashMap<String, Object> parms);
}