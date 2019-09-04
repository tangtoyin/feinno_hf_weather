package com.ucss.elementary.tnwn.controller.cms;

import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.CacheKeyConst;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.SysDict;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.SysDictService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.util.StringHelper;
import com.ucss.elementary.tnwn.util.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * @author Smile
 */
@RestController
@RequestMapping("/cms/dict")
@Api(description = "cms字典表")
public class SysDictController {

    @Autowired
    SysDictService sysDictService;
    @Autowired
    UATService uatService;
    @Autowired
    RedisTemplate redisTemplate;

    @ApiOperation("获取字典表列表")
    @CmsPermission("dict:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping
    BaseResponse index(
            @RequestParam(value ="pagenum", required = false,defaultValue = "1") Integer pagenum,
            @RequestParam(value ="pagesize", required = false,defaultValue = "10") Integer pagesize,
            @RequestParam(value ="keyword", required = false) String keyword,
            @RequestParam(value ="typecode", required = false) String typecode
    ){
        PageHelper.startPage(pagenum,pagesize);
        List<SysDict> list=sysDictService.getDictList(typecode,keyword,(short) 0);
        return new BaseResponse(new MapFromPageInfo<>(list));
    }

    @ApiOperation("添加/编辑字典表")
    @CmsPermission("dict:modify")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "value",value = "编码",dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "label",value = "编码名称", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "type",value = "类型编码", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "description",value = "描述", dataType = "String", paramType = "query", required = true),
    })
    @PostMapping("edit")
    BaseResponse edit(
            @RequestParam("uat") String uat,
            @RequestParam(value = "id",required = false) String id,
            @RequestParam("value") String value,
            @RequestParam("label") String label,
            @RequestParam("type") String type,
            @RequestParam("description") String description,
            @RequestParam(value ="sort",defaultValue = "0") Long sort,
            @RequestParam(value = "remarks",required = false) String remarks
    ){
        long userid=uatService.getUserIDByUAT(uat);
        SysDict dict=new SysDict();
        dict.setValue(value);
        dict.setLabel(label);
        dict.setType(type);
        dict.setDescription(description);
        dict.setSort(sort);
        dict.setRemarks(remarks);
        dict.setDelFlag("0");
        dict.setUpdateDate(new Date());
        dict.setUpdateBy(StringHelper.toSafeString(userid));
        if(!StringHelper.isTrimEmpty(id)){
            dict.setId(id);
            sysDictService.edit(dict);
        }else {
            dict.setId(UUIDUtil.getUUID());
            dict.setCreateBy(StringHelper.toSafeString(userid));
            dict.setCreateDate(new Date());
            sysDictService.add(dict);
        }
        //清除缓存
        if(redisTemplate.opsForHash().hasKey(CacheKeyConst.DICT, type)){
            redisTemplate.opsForHash().delete(CacheKeyConst.DICT, type);
        }
        return new BaseResponse("成功");
    }

    @ApiOperation("获取字典表详情")
    @CmsPermission("dict:detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping("detail")
    BaseResponse detail(
            @RequestParam("id") String id
    ){
        return new BaseResponse(sysDictService.getDict(id));
    }

    @ApiOperation("删除字典表")
    @CmsPermission("dict:audit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping("del")
    BaseResponse del(
            @RequestParam(value ="ids") List<String> ids
    ){
        if(ids==null||ids.size()<=0) {
            return new BaseResponse(ReturnCodeConst.ERROR, "没有待删除项");
        }
        sysDictService.del(ids);
        //清除缓存
        redisTemplate.delete(CacheKeyConst.DICT);
        return new BaseResponse(1);
    }

    @ApiOperation("获取类型列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping("types")
    BaseResponse getTypeList(){
        return new BaseResponse(sysDictService.getTypeList());
    }
}
