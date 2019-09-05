package com.ucss.elementary.tnwn.mapper.tnwn;

import com.ucss.elementary.tnwn.model.database.SysApiKeyExtension;
import com.ucss.elementary.tnwn.model.database.SysApikey;
import com.ucss.elementary.tnwn.model.database.SysApikeyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface SysApikeyMapper {
    int countByExample(SysApikeyExample example);

    int deleteByExample(SysApikeyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysApikey record);

    int insertSelective(SysApikey record);

    List<SysApikey> selectByExample(SysApikeyExample example);

    SysApikey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysApikey record, @Param("example") SysApikeyExample example);

    int updateByExample(@Param("record") SysApikey record, @Param("example") SysApikeyExample example);

    int updateByPrimaryKeySelective(SysApikey record);

    int updateByPrimaryKey(SysApikey record);

    List<SysApiKeyExtension> getapikeyList(HashMap<String, Object> parms);
}