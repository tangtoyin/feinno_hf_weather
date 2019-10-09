package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TLTnwninterlog;
import com.ucss.elementary.tnwn.model.database.TLTnwninterlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLTnwninterlogMapper {
    int countByExample(TLTnwninterlogExample example);

    int deleteByExample(TLTnwninterlogExample example);

    int insert(TLTnwninterlog record);

    int insertSelective(TLTnwninterlog record);

    List<TLTnwninterlog> selectByExampleWithBLOBs(TLTnwninterlogExample example);

    List<TLTnwninterlog> selectByExample(TLTnwninterlogExample example);

    int updateByExampleSelective(@Param("record") TLTnwninterlog record, @Param("example") TLTnwninterlogExample example);

    int updateByExampleWithBLOBs(@Param("record") TLTnwninterlog record, @Param("example") TLTnwninterlogExample example);

    int updateByExample(@Param("record") TLTnwninterlog record, @Param("example") TLTnwninterlogExample example);
}