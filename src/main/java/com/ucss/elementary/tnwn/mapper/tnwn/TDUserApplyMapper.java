package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TDUserApply;
import com.ucss.elementary.tnwn.model.database.TDUserApplyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface TDUserApplyMapper {
    int countByExample(TDUserApplyExample example);

    int deleteByExample(TDUserApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDUserApply record);

    int insertSelective(TDUserApply record);

    List<TDUserApply> selectByExample(TDUserApplyExample example);

    TDUserApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDUserApply record, @Param("example") TDUserApplyExample example);

    int updateByExample(@Param("record") TDUserApply record, @Param("example") TDUserApplyExample example);

    int updateByPrimaryKeySelective(TDUserApply record);

    int updateByPrimaryKey(TDUserApply record);

    List<TDUserApply> getUserApplyList(HashMap<String, Object> parms);

    void audit(HashMap<String, Object> parms);

}