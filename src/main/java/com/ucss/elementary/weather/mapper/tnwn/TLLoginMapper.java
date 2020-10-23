package com.ucss.elementary.weather.mapper.tnwn;

import com.ucss.elementary.weather.model.database.TLLogin;
import com.ucss.elementary.weather.model.database.TLLoginExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TLLoginMapper {
    int countByExample(TLLoginExample example);

    int deleteByExample(TLLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TLLogin record);

    int insertSelective(TLLogin record);

    List<TLLogin> selectByExample(TLLoginExample example);

    TLLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TLLogin record, @Param("example") TLLoginExample example);

    int updateByExample(@Param("record") TLLogin record, @Param("example") TLLoginExample example);

    int updateByPrimaryKeySelective(TLLogin record);

    int updateByPrimaryKey(TLLogin record);
}