package com.ucss.elementary.tnwn.controller.tnwn;

import com.github.pagehelper.PageHelper;
import com.ucss.elementary.tnwn.aspect.CmsPermission;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.database.SysApiKeyExtension;
import com.ucss.elementary.tnwn.model.database.SysApikey;
import com.ucss.elementary.tnwn.model.database.SysUserRoleKey;
import com.ucss.elementary.tnwn.model.database.TDUser;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.MapFromPageInfo;
import com.ucss.elementary.tnwn.service.ApiKeyService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.service.tnwn.BasicDataService;
import com.ucss.elementary.tnwn.util.StringHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tnwn/basicdata")
@Api(description = "号段基础数据管理")
public class BasicDataController {

    @Autowired
    private BasicDataService basicDataService;

}
