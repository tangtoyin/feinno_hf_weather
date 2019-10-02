package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TBLongareacodePla;
import com.ucss.elementary.tnwn.model.database.TBLongareacodePlaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBLongareacodePlaMapper {
    int countByExample(TBLongareacodePlaExample example);

    int deleteByExample(TBLongareacodePlaExample example);

    int insert(TBLongareacodePla record);

    int insertSelective(TBLongareacodePla record);

    List<TBLongareacodePla> selectByExample(TBLongareacodePlaExample example);

    int updateByExampleSelective(@Param("record") TBLongareacodePla record, @Param("example") TBLongareacodePlaExample example);

    int updateByExample(@Param("record") TBLongareacodePla record, @Param("example") TBLongareacodePlaExample example);
}