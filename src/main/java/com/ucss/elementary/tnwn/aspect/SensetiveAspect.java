/*
package com.ucss.elementary.uaf.aspect;


import com.alibaba.fastjson.JSONObject;
import com.ucss.elementary.uaf.constant.ReturnCodeConst;
import com.ucss.elementary.uaf.model.response.BaseResponse;
import com.ucss.elementary.uaf.util.SensetiveHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

*/
/**
 * Created by lq on 2018/3/17.
 * 敏感词校验
 *//*

@Aspect
@Component
public class SensetiveAspect {
    
    @Pointcut("execution(* com.ucss.elementary.tnwn.controller..*(..))")
    public void sensetivePointCut() {
    }
    @Before("sensetivePointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }


    @AfterReturning(returning = "ret", pointcut = "sensetivePointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    @Around("sensetivePointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            if(request.getParameterMap()!=null) {
                if (SensetiveHelper.haveSensetive(JSONObject.toJSONString(request.getParameterMap()))) {
                    return new BaseResponse(ReturnCodeConst.Sensetivecode, ReturnCodeConst.SensetiveMsg);
                }
            }
            //执行方法
            return pjp.proceed();
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResponse("-1","系统异常");
        }
    }
}
*/
