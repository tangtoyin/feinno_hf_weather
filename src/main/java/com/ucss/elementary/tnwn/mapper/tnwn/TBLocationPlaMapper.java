package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TBLocationPla;
import com.ucss.elementary.tnwn.model.database.TBLocationPlaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBLocationPlaMapper {
    int countByExample(TBLocationPlaExample example);

    int deleteByExample(TBLocationPlaExample example);

    int insert(TBLocationPla record);

    int insertSelective(TBLocationPla record);

    List<TBLocationPla> selectByExample(TBLocationPlaExample example);

    int updateByExampleSelective(@Param("record") TBLocationPla record, @Param("example") TBLocationPlaExample example);

    int updateByExample(@Param("record") TBLocationPla record, @Param("example") TBLocationPlaExample example);
}