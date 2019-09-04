package com.ucss.elementary.tnwn.controller.cms;

import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.TDIpBlacklist;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.IpBlacklistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Smile
 * @date 2018/10/23 9:56
 */
@RestController
@RequestMapping("cms/ipblacklist")
@Api(description = "ip黑名单")
public class IpBlacklistController {
    @Autowired
    IpBlacklistService ipBlacklistService;

    @ApiOperation("获取黑名单列表")
    @CmsPermission("ipblacklist:list")
    @PostMapping
    BaseResponse getIpBlacklists(
            @RequestParam(value = "pagenum", required = false, defaultValue = "1") Integer pagenum,
            @RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pagesize,
            @RequestParam(value = "keyword", required = false) String keyword
    ) {
        PageHelper.startPage(pagenum, pagesize);
        List<TDIpBlacklist> list = ipBlacklistService.getCmsIpBlacklists(keyword);
        return new BaseResponse(new MapFromPageInfo<>(list));
    }

    @ApiOperation("获取详情")
    @CmsPermission("ipblacklist:detail")
    @PostMapping("detail")
    BaseResponse getIpBlacklistDetail(
            @RequestParam(value = "id") Long id
    ) {
        return new BaseResponse(ipBlacklistService.detail(id));
    }

    @ApiOperation("删除")
    @CmsPermission("ipblacklist:del")
    @PostMapping("del")
    BaseResponse delIpBlacklist(
            @RequestParam("ids") List<Long> ids
    ) {
        if (ids == null || ids.size() <= 0) {
            return new BaseResponse(ReturnCodeConst.ERROR, "没有待删除项");
        }
        return new BaseResponse(ipBlacklistService.del(ids));
    }

    @ApiOperation("新增/编辑")
    @CmsPermission("ipblacklist:modify")
    @ApiImplicitParam(name = "ipsegment", value = "ip段,*号结尾代表所有，例如*就是所有ip，113*为113开始的所有ip", required = true, dataType = "String", paramType = "query")
    @PostMapping("modify")
    BaseResponse modifyIpBlacklist(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "ipsegment") String ipsegment
    ) {
        TDIpBlacklist ipBlacklist = new TDIpBlacklist();
        ipBlacklist.setId(id);
        ipBlacklist.setIpsegment(ipsegment);
        if (id != null && id > 0) {
            ipBlacklistService.edit(ipBlacklist);
        } else {
            ipBlacklistService.add(ipBlacklist);
        }
        return new BaseResponse("成功");
    }
}
