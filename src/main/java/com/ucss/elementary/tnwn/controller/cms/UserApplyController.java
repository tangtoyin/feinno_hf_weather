package com.ucss.elementary.tnwn.controller.cms;


import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.TDUserApply;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.service.UserService;
import com.ucss.elementary.tnwn.util.StringHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Smile
 */

@RestController
@RequestMapping("/cms/userapply")
@Api(description = "CMS用户修改资料申请管理")
public class UserApplyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UATService uatService;
    @Autowired
    private UserService userService;
    @ApiOperation(value = "获取用户修改资料列表", notes = "获取用户修改资料列表")
    @CmsPermission("userapply:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @PostMapping
    BaseResponse getUserApplyList(
            @RequestParam(value ="pagenum", required = false,defaultValue = "1") Integer pagenum,
            @RequestParam(value ="pagesize", required = false,defaultValue = "10") Integer pagesize,
            @RequestParam(value ="phone", required = false) String phone,
            @RequestParam(value ="gender", required = false) Short gender,
            @RequestParam("auditstatus") Short auditstatus
    ) {
        PageHelper.startPage(pagenum,pagesize);
        List<TDUserApply> list=userService.getUserApplyList(phone,auditstatus,gender);
        for(TDUserApply apply:list)
        {
            apply.setPhongbind(StringHelper.toOmit(apply.getPhongbind()));
        }
        return new BaseResponse(new MapFromPageInfo<>(list));
    }

    @ApiOperation(value = "批量审核用户修改申请", notes = "批量审核用户修改申请")
    @CmsPermission("userapply:audit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "uat", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    BaseResponse audit(
            @RequestParam(value ="uat") String uat,
            @RequestParam("ids") List<Long> ids,
            @RequestParam("auditstatus") Short auditstatus,
            @RequestParam(value ="auditreason",required = false) String auditreason) {
        long userid=uatService.getUserIDByUAT(uat);
        if(ids==null||ids.size()<=0) {
            return new BaseResponse(ReturnCodeConst.ERROR, "没有待审核项");
        }
        
        short isvalid=0;
        if(auditstatus==1){
            isvalid=1;
        }
        userService.auditUserApply(ids,isvalid,auditstatus,userid,auditreason);
        return new BaseResponse("成功");
    }
}
