package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TBLocation;
import com.ucss.elementary.tnwn.model.database.TBLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBLocationMapper {
    int countByExample(TBLocationExample example);

    int deleteByExample(TBLocationExample example);

    int insert(TBLocation record);

    int insertSelective(TBLocation record);

    List<TBLocation> selectByExample(TBLocationExample example);

    int updateByExampleSelective(@Param("record") TBLocation record, @Param("example") TBLocationExample example);

    int updateByExample(@Param("record") TBLocation record, @Param("example") TBLocationExample example);
}