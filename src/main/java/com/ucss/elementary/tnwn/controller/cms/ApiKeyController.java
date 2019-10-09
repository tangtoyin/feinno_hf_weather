package com.ucss.elementary.tnwn.controller.cms;

import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.SysApiKeyExtension;
import com.ucss.elementary.tnwn.model.database.SysApikey;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.ApiKeyService;
import com.ucss.elementary.tnwn.service.UATService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cms/apikey")
@Api(description = "cms密钥管理")
public class ApiKeyController {

    @Autowired
    private ApiKeyService apiKeyService;
    @Autowired
    private UATService uatService;

    @ApiOperation("获取APIKey列表")
    @CmsPermission("apikey:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isforbidden", dataType = "short", value = "-1为所有，0为禁用，1为有效", paramType = "query"),
            @ApiImplicitParam(name = "keyword", dataType = "String", paramType = "query",value = "查询关键字"),
            @ApiImplicitParam(name = "type", dataType = "String", paramType = "query",value = "类型 0为我的密钥，秘钥管理", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping
    public BaseResponse getApiKeyList(
            @RequestParam(value ="pagenum", required = false,defaultValue = "1") Integer pagenum,
            @RequestParam(value ="pagesize", required = false,defaultValue = "10") Integer pagesize,
            @RequestParam(value ="keyword", required = false) String keyword,
            @RequestParam(value ="isforbidden",required = false) Short isforbidden,
            @RequestParam(value ="type") short type,
            @RequestParam(value ="uat") String uat
    ){
        Long userId = null;
        if (type==0){
             userId = uatService.getUserIDByUAT(uat);
        }

        PageHelper.startPage(pagenum,pagesize);
        List<SysApiKeyExtension> list=apiKeyService.getapikeyList(isforbidden,keyword,userId);

        return new BaseResponse(new MapFromPageInfo<>(list));
    }

    @ApiOperation("更改APIKey和新增加")
    @CmsPermission("apikey:updateApiKey")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "名称", paramType = "query"),
            @ApiImplicitParam(name = "type", dataType = "String", paramType = "query",value = "类型 0为我的密钥，1 秘钥管理", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping("updateApiKey")
    public BaseResponse updateApiKey(
            @RequestParam(value ="id",required = false) Long id,
            @RequestParam(value ="type") short type,
            @RequestParam(value ="name") String name,
            @RequestParam(value ="uat") String uat){


        if(id!=null) {

            SysApikey sysApikey = new SysApikey();
            sysApikey.setName(name);
            sysApikey.setUpdatetime(new Date());
            sysApikey.setId(id);
            int i = apiKeyService.update(sysApikey);
            if (i <= 0)
                return new BaseResponse(ReturnCodeConst.ERROR,"NOT MODIFIED");

        }else {

            SysApikey sysApikey = new SysApikey();

            String partnerid = UUID.randomUUID().toString().replaceAll("-", "").substring(0,24);
            sysApikey.setPartnerid(partnerid);

            String key = UUID.randomUUID().toString().replaceAll("-", "").substring(0,24);
            sysApikey.setAppkey(key);

            Long userId = uatService.getUserIDByUAT(uat);
            sysApikey.setUserId(userId);

            sysApikey.setName(name);
            sysApikey.setIsvalid((short)1);
            sysApikey.setIsforbidden((short) 0);
            sysApikey.setUpdatetime(new Date());
            sysApikey.setCreatetime(new Date());

            try {
                apiKeyService.insert(sysApikey);
            }
            catch (Exception e){
                e.printStackTrace();
                return new BaseResponse(ReturnCodeConst.ERROR,"Server error");
            }

        }

        return new BaseResponse("Success");
    }


    @ApiOperation("删除APIKey")
    @CmsPermission("apikey:deleteApiKey")
    @PostMapping("deleteApiKey")
    public BaseResponse deleteApiKey(
            @RequestParam(value ="id") Long id){

        SysApikey sysApikey = new SysApikey();
        sysApikey.setIsvalid((short) 0);
        sysApikey.setUpdatetime(new Date());
        sysApikey.setId(id);
        int i = apiKeyService.update(sysApikey);
        if(i>0)
            return new BaseResponse("Success");
        else
            return new BaseResponse(ReturnCodeConst.ERROR,"NOT MODIFIED");
    }

    @ApiOperation("禁用/启用APIKey")
    @CmsPermission("apikey:forbiddenApiKey")
    @PostMapping("forbiddenApiKey")
    public BaseResponse forbiddenApiKey(
            @RequestParam(value ="forbidden") Short forbidden,
            @RequestParam(value ="id") Long id){

        SysApikey sysApikey = new SysApikey();
        sysApikey.setIsforbidden(forbidden);
        sysApikey.setUpdatetime(new Date());
        sysApikey.setId(id);
        int i = apiKeyService.update(sysApikey);
        if(i>0)
            return new BaseResponse("Success");
        else
            return new BaseResponse(ReturnCodeConst.ERROR,"NOT MODIFIED");
    }

    @ApiOperation("重新生成APIKey")
    @CmsPermission("apikey:resetApiKey")
    @PostMapping("resetApiKey")
    public BaseResponse resetApiKey(
            @RequestParam(value ="id") Long id){
        
        String key = UUID.randomUUID().toString().replaceAll("-", "").substring(0,24);
        SysApikey sysApikey = new SysApikey();
        sysApikey.setAppkey(key);
        sysApikey.setUpdatetime(new Date());
        sysApikey.setId(id);
        int i = apiKeyService.update(sysApikey);
        if(i>0)
            return new BaseResponse("Success");
        else
            return new BaseResponse(ReturnCodeConst.ERROR,"NOT MODIFIED");
    }



}
