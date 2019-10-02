package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TBNumrange;
import com.ucss.elementary.tnwn.model.database.TBNumrangeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBNumrangeMapper {
    int countByExample(TBNumrangeExample example);

    int deleteByExample(TBNumrangeExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TBNumrange record);

    int insertSelective(TBNumrange record);

    List<TBNumrange> selectByExample(TBNumrangeExample example);

    TBNumrange selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TBNumrange record, @Param("example") TBNumrangeExample example);

    int updateByExample(@Param("record") TBNumrange record, @Param("example") TBNumrangeExample example);

    int updateByPrimaryKeySelective(TBNumrange record);

    int updateByPrimaryKey(TBNumrange record);
}