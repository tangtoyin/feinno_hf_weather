package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TUserInfoTemp;
import com.ucss.elementary.tnwn.model.database.TUserInfoTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserInfoTempMapper {
    int countByExample(TUserInfoTempExample example);

    int deleteByExample(TUserInfoTempExample example);

    int insert(TUserInfoTemp record);

    int insertSelective(TUserInfoTemp record);

    List<TUserInfoTemp> selectByExample(TUserInfoTempExample example);

    int updateByExampleSelective(@Param("record") TUserInfoTemp record, @Param("example") TUserInfoTempExample example);

    int updateByExample(@Param("record") TUserInfoTemp record, @Param("example") TUserInfoTempExample example);
}