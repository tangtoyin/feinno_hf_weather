package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TDUserRefresh;
import com.ucss.elementary.tnwn.model.database.TDUserRefreshExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TDUserRefreshMapper {
    int countByExample(TDUserRefreshExample example);

    int deleteByExample(TDUserRefreshExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDUserRefresh record);

    int insertSelective(TDUserRefresh record);

    List<TDUserRefresh> selectByExample(TDUserRefreshExample example);

    TDUserRefresh selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDUserRefresh record, @Param("example") TDUserRefreshExample example);

    int updateByExample(@Param("record") TDUserRefresh record, @Param("example") TDUserRefreshExample example);

    int updateByPrimaryKeySelective(TDUserRefresh record);

    int updateByPrimaryKey(TDUserRefresh record);
}