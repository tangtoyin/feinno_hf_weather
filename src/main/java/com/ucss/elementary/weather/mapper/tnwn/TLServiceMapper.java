package com.ucss.elementary.weather.mapper.tnwn;

import com.ucss.elementary.weather.model.database.TLService;
import com.ucss.elementary.weather.model.database.TLServiceExample;
import com.ucss.elementary.weather.model.database.TLServiceWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TLServiceMapper {
    int countByExample(TLServiceExample example);

    int deleteByExample(TLServiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TLServiceWithBLOBs record);

    int insertSelective(TLServiceWithBLOBs record);

    List<TLServiceWithBLOBs> selectByExampleWithBLOBs(TLServiceExample example);

    List<TLService> selectByExample(TLServiceExample example);

    TLServiceWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TLServiceWithBLOBs record, @Param("example") TLServiceExample example);

    int updateByExampleWithBLOBs(@Param("record") TLServiceWithBLOBs record, @Param("example") TLServiceExample example);

    int updateByExample(@Param("record") TLService record, @Param("example") TLServiceExample example);

    int updateByPrimaryKeySelective(TLServiceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TLServiceWithBLOBs record);

    int updateByPrimaryKey(TLService record);
}