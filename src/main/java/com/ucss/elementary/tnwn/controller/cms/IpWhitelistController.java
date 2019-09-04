package com.ucss.elementary.tnwn.controller.cms;

import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.TDIpWhitelist;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.IpWhitelistService;
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
@RequestMapping("cms/ipwhitelist")
@Api(description = "ip白名单")
public class IpWhitelistController {
    @Autowired
    IpWhitelistService ipWhitelistService;

    @ApiOperation("获取白名单列表")
    @CmsPermission("ipwhitelist:list")
    @PostMapping
    BaseResponse getIpWhitelists(
            @RequestParam(value = "pagenum", required = false, defaultValue = "1") Integer pagenum,
            @RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pagesize,
            @RequestParam(value = "keyword", required = false) String keyword
    ) {
        PageHelper.startPage(pagenum, pagesize);
        List<TDIpWhitelist> list = ipWhitelistService.getCmsIpWhitelists(keyword);
        return new BaseResponse(new MapFromPageInfo<>(list));
    }

    @ApiOperation("获取详情")
    @CmsPermission("ipwhitelist:detail")
    @PostMapping("detail")
    BaseResponse getIpWhitelistDetail(
            @RequestParam(value = "id") Long id
    ) {
        return new BaseResponse(ipWhitelistService.detail(id));
    }

    @ApiOperation("删除")
    @CmsPermission("ipwhitelist:del")
    @PostMapping("del")
    BaseResponse delIpWhitelist(
            @RequestParam("ids") List<Long> ids
    ) {
        if (ids == null || ids.size() <= 0) {
            return new BaseResponse(ReturnCodeConst.ERROR, "没有待删除项");
        }
        return new BaseResponse(ipWhitelistService.del(ids));
    }

    @ApiOperation("新增/编辑")
    @CmsPermission("ipwhitelist:modify")
    @ApiImplicitParam(name = "ipsegment", value = "ip段,*号结尾代表所有，例如*就是所有ip，113*为113开始的所有ip", required = true, dataType = "String", paramType = "query")
    @PostMapping("modify")
    BaseResponse modifyIpWhitelist(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "ipsegment") String ipsegment
    ) {
        TDIpWhitelist IpWhitelist = new TDIpWhitelist();
        IpWhitelist.setId(id);
        IpWhitelist.setIpsegment(ipsegment);
        if (id != null && id > 0) {
            ipWhitelistService.edit(IpWhitelist);
        } else {
            ipWhitelistService.add(IpWhitelist);
        }
        return new BaseResponse("成功");
    }
}
