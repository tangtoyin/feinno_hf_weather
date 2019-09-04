package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TDIpBlacklist;
import com.ucss.elementary.tnwn.model.database.TDIpBlacklistExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TDIpBlacklistMapper {
    int countByExample(TDIpBlacklistExample example);

    int deleteByExample(TDIpBlacklistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDIpBlacklist record);

    int insertSelective(TDIpBlacklist record);

    List<TDIpBlacklist> selectByExample(TDIpBlacklistExample example);

    TDIpBlacklist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDIpBlacklist record, @Param("example") TDIpBlacklistExample example);

    int updateByExample(@Param("record") TDIpBlacklist record, @Param("example") TDIpBlacklistExample example);

    int updateByPrimaryKeySelective(TDIpBlacklist record);

    int updateByPrimaryKey(TDIpBlacklist record);
}