package com.ucss.elementary.tnwn.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ucss.elementary.tnwn.model.database.TLServiceWithBLOBs;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.InterfaceLogService;
import com.ucss.elementary.tnwn.service.UATService;
import com.ucss.elementary.tnwn.util.IpUtils;
import com.ucss.elementary.tnwn.util.StringHelper;
import com.ucss.elementary.tnwn.util.TConverter;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author smile
 */

@Aspect
@Component
public class ServiceLogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UATService uatService;

    @Autowired
    private InterfaceLogService logService;

    @Pointcut("execution(* com.ucss.elementary.tnwn.controller..*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Date startTime = new Date();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //方法名
        String path = request.getRequestURI();
        //请求参数
        String paramsString = "";
        //appcode
        String appCode = "";
        //返回值
        String response = "";
        //结果编码
        String resultCode = "";
        //结果描述
        String resultMessage = "";
        //客户端IP
        String clientIP = IpUtils.getIpAddr(request);
        //用时
        int elapsedTime = 0;
        String uat = "";

        try {
            Map<String, String[]> params = request.getParameterMap();
            for (String pkey : params.keySet()) {
                if ("file".equals(pkey)) {
                    continue;
                }
                if (!StringUtils.isEmpty(paramsString)) {
                    paramsString += "&";
                }
                if ("appcode".equals(pkey)) {
                    appCode = TConverter.toSafeString(params.get(pkey)[0]);
                }
                if ("uat".equals(pkey)) {
                    uat = TConverter.toSafeString(params.get(pkey)[0]);
                }
                paramsString += pkey + "=" + TConverter.toSafeString(params.get(pkey)[0]);
            }
        } catch (Exception ex) {
            logger.error("记录接口日志请求时出错", ex);
        }
        /**System.out.println(DateHelper.date2Str(startTime) + "开始执行：" + path + " 参数：" + paramsString);
         //若paramsString为空，则为body参数*/
        if (StringHelper.isTrimEmpty(paramsString)) {
            Object[] objects = pjp.getArgs();
            if (objects.length == 1) {
                paramsString = StringHelper.toSafeString(objects[0]);
                if (!StringHelper.isTrimEmpty(paramsString)) {
                    JSONObject json = JSONObject.parseObject(paramsString);
                    if (json != null) {
                        appCode = json.getString("appcode");
                    }
                }
            }

        }

        //执行方法
        Object result = pjp.proceed();// result 为方法的返回值

        //执行完成
        Date endTime = new Date();
        /**System.out.println(DateHelper.date2Str(endTime) + "执行完毕：" + TConverter.toSafeString(endTime.getTime() - startTime.getTime()));
         //System.out.println("执行结果：" + JSON.toJSONString(result));*/

    /*    try {
            if (result != null) {
                response = JSON.toJSONString(result);
                resultCode = ((BaseResponse) result).getCode();
                resultMessage = ((BaseResponse) result).getMessage();
            }
            elapsedTime = TConverter.ObjectToInt(endTime.getTime() - startTime.getTime());
            TLServiceWithBLOBs tlService = new TLServiceWithBLOBs();
            tlService.setCreatetime(new Date());
            tlService.setRequest(paramsString);
            tlService.setResponse(response);
            tlService.setAppcode(appCode);
            tlService.setClientip(clientIP);
            tlService.setMethod(path);
            tlService.setResultmessage(resultMessage);
            tlService.setResultcode(resultCode);
            tlService.setUserId(uatService.getUserIDByUAT(uat));
            tlService.setElapsedtime(elapsedTime);
            logService.newLog(tlService);
        } catch (Exception ex) {
            logger.error("记录接口日志结果时出错", ex);
        }*/
        return result;

    }
}
