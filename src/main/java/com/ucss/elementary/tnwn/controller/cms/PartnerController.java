package com.ucss.elementary.tnwn.controller.cms;

import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.TDPartner;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.PartnerService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.util.DateHelper;
import com.ucss.elementary.tnwn.util.TConverter;
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

/**
 * @author Smile
 */
@RestController
@RequestMapping("/cms/partner")
@Api(description = "cms合作方管理")
public class PartnerController {

    @Autowired
    PartnerService partnerService;
    @Autowired
    UATService uatService;

    @ApiOperation("获取合作方列表")
    @CmsPermission("partner:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "isvalid",value = "-1代表全部",dataType = "short", paramType = "query", required = true)
    })
    @PostMapping
    BaseResponse getpartnerList(
            @RequestParam(value ="pagenum", required = false,defaultValue = "1") Integer pagenum,
            @RequestParam(value ="pagesize", required = false,defaultValue = "10") Integer pagesize,
            @RequestParam(value ="name", required = false) String name,
            @RequestParam(value ="partnerid", required = false) String partnerid,
            @RequestParam(value = "isvalid", required = false) Short isvalid,
            @RequestParam(value = "starttime", required = false) String starttime,
            @RequestParam(value = "endtime", required = false) String endtime
    )throws Exception{
        Date stime= DateHelper.str2Date(starttime);
        Date etime= DateHelper.str2Date(endtime);
        PageHelper.startPage(pagenum,pagesize);
        List<TDPartner> list=partnerService.getCmsPartnerList(isvalid,name,partnerid,stime,etime);
        return new BaseResponse(new MapFromPageInfo<>(list));
    }

    @ApiOperation("获取详情")
    @CmsPermission("partner:detail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping("detail")
    BaseResponse getpartnerDetail(
            @RequestParam(value ="id") Integer id
    ){
        return new BaseResponse(partnerService.detail(id));
    }

    @ApiOperation("批量审核")
    @CmsPermission("partner:audit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping("audit")
    BaseResponse auditpartner(
            @RequestParam(value ="uat") String uat,
            @RequestParam("ids") List<Integer> ids,
            @RequestParam(value = "isvalid",defaultValue = "1") Short isvalid
    ){
        Long userId = uatService.getUserIDByUAT(uat);
        if(ids==null||ids.size()<=0) {
            return new BaseResponse(ReturnCodeConst.ERROR, "没有待审核项");
        }
        return new BaseResponse(partnerService.audit(ids,isvalid));
    }

    @ApiOperation("新增/编辑")
    @CmsPermission("partner:modify")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping("edit")
    BaseResponse editpartner(
            @RequestParam(value ="uat") String uat,
            @RequestParam(value ="id",required = false) Integer id,
            @RequestParam(value ="name") String name,
            @RequestParam(value ="partnerid") String partnerid,
            @RequestParam(value ="appkey") String appkey
    ){
        Long userId = uatService.getUserIDByUAT(uat);
        if(partnerService.existPartnerID(partnerid, TConverter.ObjectToInt(id))){
            return new BaseResponse(ReturnCodeConst.ERROR,"合作方ID已存在");
        }
        TDPartner partner=new TDPartner();
        partner.setId(id);
        partner.setName(name);
        partner.setIsvalid(1);
        partner.setPartnerid(partnerid);
        partner.setAppkey(appkey);
        partner.setUpdatetime(new Date());
        if(id!=null&&id>0){
            partnerService.edit(partner);
        }else {
            partner.setCreatetime(new Date());
            partnerService.add(partner);
        }
        return new BaseResponse("成功");
    }
}
