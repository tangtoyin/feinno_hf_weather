package com.ucss.elementary.tnwn.aspect;


import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.CustomException;
import com.ucss.elementary.tnwn.model.database.TDUser;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.CmsUserService;
import com.ucss.elementary.tnwn.service.MenuService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.util.StringHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author smile
 */
@Aspect
@Component
public class PermissionAspect {
    @Autowired
    UATService uatService;
    @Autowired
    MenuService menuService;
    @Autowired
    CmsUserService cmsUserService;
    @Pointcut("execution(* com.ucss.elementary.tnwn.controller.cms..*(..))")
    public void permissionPointCut() {
    }
    @Before("permissionPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }


    @AfterReturning(returning = "ret", pointcut = "permissionPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    @Around("permissionPointCut()&&@annotation(cmsPermission)")
    public Object doAround(ProceedingJoinPoint pjp, CmsPermission cmsPermission) throws Throwable {
        try {
            //region 验证uat--同时若为超级管理员，则在cms中无权限限制
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String uat = request.getParameter("uat");
            TDUser user=uatService.getUserByUAT(uat);
            if(user==null) {
                return new BaseResponse("110", "请登录后重试");
            }
            //用户身份不明
            if(!cmsUserService.existRole(user.getId())){
                return new BaseResponse(ReturnCodeConst.ERROR, "无此权限");
            }
            //管理员，cms包含所有权限
            if(cmsUserService.isSuperAdmin(user.getId())){
                return pjp.proceed();
            }
            //endregion

            //region 非管理员登录cms
            String code = cmsPermission.value();
            if(!StringHelper.isTrimEmpty(code)) {
                if (!menuService.isPermission(user.getId(), code)) {
                    return new BaseResponse(ReturnCodeConst.ERROR, "无此权限");
                }
            }
            //endregion
            //执行方法
            return pjp.proceed();
        }catch (CustomException e1){
            return new BaseResponse(e1.getCode(),e1.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResponse("-1","系统异常");
        }
    }
}
