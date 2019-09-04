package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TDVericode;
import com.ucss.elementary.tnwn.model.database.TDVericodeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TDVericodeMapper {
    int countByExample(TDVericodeExample example);

    int deleteByExample(TDVericodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDVericode record);

    int insertSelective(TDVericode record);

    List<TDVericode> selectByExample(TDVericodeExample example);

    TDVericode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDVericode record, @Param("example") TDVericodeExample example);

    int updateByExample(@Param("record") TDVericode record, @Param("example") TDVericodeExample example);

    int updateByPrimaryKeySelective(TDVericode record);

    int updateByPrimaryKey(TDVericode record);
}