package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TDIpWhitelist;
import com.ucss.elementary.tnwn.model.database.TDIpWhitelistExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TDIpWhitelistMapper {
    int countByExample(TDIpWhitelistExample example);

    int deleteByExample(TDIpWhitelistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDIpWhitelist record);

    int insertSelective(TDIpWhitelist record);

    List<TDIpWhitelist> selectByExample(TDIpWhitelistExample example);

    TDIpWhitelist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDIpWhitelist record, @Param("example") TDIpWhitelistExample example);

    int updateByExample(@Param("record") TDIpWhitelist record, @Param("example") TDIpWhitelistExample example);

    int updateByPrimaryKeySelective(TDIpWhitelist record);

    int updateByPrimaryKey(TDIpWhitelist record);
}