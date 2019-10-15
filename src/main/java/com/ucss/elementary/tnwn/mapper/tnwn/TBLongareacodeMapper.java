package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.TBLongareacode;
import com.ucss.elementary.tnwn.model.database.TBLongareacodeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBLongareacodeMapper {
    int insertByTBLongareacode(TBLongareacode tbLongareacode);

    List<TBLongareacode> selectByTBLongareacode(TBLongareacode tbLongareacode);

    int deleteById(BigDecimal id);

    int updateByTBLongareacode(TBLongareacode tbLongareacode);

    int countByExample(TBLongareacodeExample example);

    int deleteByExample(TBLongareacodeExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TBLongareacode record);

    int insertSelective(TBLongareacode record);

    List<TBLongareacode> selectByExample(TBLongareacodeExample example);

    TBLongareacode selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TBLongareacode record, @Param("example") TBLongareacodeExample example);

    int updateByExample(@Param("record") TBLongareacode record, @Param("example") TBLongareacodeExample example);

    int updateByPrimaryKeySelective(TBLongareacode record);

    int updateByPrimaryKey(TBLongareacode record);
}