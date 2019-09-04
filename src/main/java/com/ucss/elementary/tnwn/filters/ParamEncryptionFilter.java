package com.ucss.elementary.tnwn.filters;

import com.alibaba.fastjson.JSON;
import com.ucss.elementary.tnwn.constant.ReturnCodeConst;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.service.SysService;
import com.ucss.elementary.tnwn.util.EncryptHelper;
import com.ucss.elementary.tnwn.util.StringHelper;
import com.ucss.elementary.tnwn.util.TConverter;
import io.undertow.servlet.spec.HttpServletRequestImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/*
*
 * lq 参数加密，加密文件放入sig中的

*/

@Component
public class ParamEncryptionFilter implements Filter {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysService sysService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequestImpl) req).getRequestURI();
        BaseResponse response = null;
        //若地址为空，则操作失误
        if (StringHelper.isTrimEmpty(url)) {
            response = new BaseResponse("998", "请求地址有误");
            filterError(req, res, response);
            return;
        }
        //url地址判断
        if (!url.startsWith("/")) {
            url = "/" + url;
        }
        if (url.startsWith("//")) {
            url = url.replaceAll("//", "/");
        }
        //直接访问swagger地址，则不进行判断
        if (url.trim().contains("swagger") || url.trim().contains("/v2/api-docs")) {
            chain.doFilter(req, res);
            return;
        }
        String appcode = req.getParameter("appcode");
        if (StringHelper.isTrimEmpty(appcode)) {
            response = new BaseResponse(ReturnCodeConst.EMPTY, "appcode不存在");
            filterError(req, res, response);
            return;
        }
        if ("appcode_test0000".equals(appcode)) {
            chain.doFilter(req, res);
            return;
        }
        //时间戳
        String ts = req.getParameter("ts");
        if (StringHelper.isTrimEmpty(ts)) {
            response = new BaseResponse(ReturnCodeConst.EMPTY, "ts不存在");
            filterError(req, res, response);
            return;
        }
        long min=(System.currentTimeMillis()-TConverter.ObjectToLong(ts))/60000;
if(min>5||min<0){//验证时间戳是否超过五分钟
            response = new BaseResponse(ReturnCodeConst.ERROR, "ts已失效");
            filterError(req, res, response);
            return;
        }

        //随机数
        String rnd = req.getParameter("rnd");
        if (StringHelper.isTrimEmpty(rnd)) {
            response = new BaseResponse(ReturnCodeConst.EMPTY, "rnd不存在");
            filterError(req, res, response);
            return;
        }
        //获取加密串sig
        String sig = req.getParameter("sig");
        if (StringHelper.isTrimEmpty(sig)) {
            response = new BaseResponse(ReturnCodeConst.EMPTY, "加密sig不存在");
            filterError(req, res, response);
            return;
        }
        Map<String, Object> parms = new TreeMap<>();
        Map<String, String[]> map = req.getParameterMap();
        //获取不包含sig的参数到parms中
        for (String key : map.keySet()) {
            if (!StringHelper.isTrimEmpty(key)) {
                if (!"sig".equals(key) &&!"file".equals(key)) {
                    parms.put(key, req.getParameter(key));
                }
            }
        }
        //查看是否有body
        ServletRequest requestWrapper = null;
        if(req instanceof HttpServletRequest) {
            requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) req);  //替换
        }
        String param = getBodyString(requestWrapper.getReader());
        if(!StringHelper.isTrimEmpty(param)){
            parms.put("body",param);
        }
        //业务参数加上公共参数，按照参数名进行排序，然后再拼接成形如 para1=value&para2=value2&para3=value3的字符串
        String paramString = "";
        for (String key : parms.keySet()) {
            if (!StringUtils.isEmpty(paramString)) {
                paramString += "&";
            }
            paramString += key + "=" + TConverter.toSafeString(parms.get(key));
        }
        //拼接上方法如 /sample/getinfo?para1=value&para2=value2&para3=value3
        paramString = url + "?" + paramString;
        //使用hma-sha1进行加密
        String result = EncryptHelper.hmacsha1String(paramString,sysService.getPartnerAppkey(appcode) );
        if (!StringHelper.isTrimEmpty(result) && sig.toUpperCase().equals(result.toUpperCase())) {
            if (null == requestWrapper) {
                chain.doFilter(req, res);
            } else {
                chain.doFilter(requestWrapper, res);
            }
        } else {
            response = new BaseResponse("999", "参数有误");
            filterError(req, res, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

    //获取request请求body中参数
    public static String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return str;
    }
    private BaseResponse filterError(ServletRequest req, ServletResponse res, BaseResponse response) throws IOException, ServletException {
        PrintWriter writer = null;
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(res.getOutputStream(), "UTF-8");
            writer = new PrintWriter(osw, true);
            String jsonStr = JSON.toJSONString(response);
            writer.write(jsonStr);
            writer.flush();
            writer.close();
            osw.close();
        } catch (Exception e) {
            logger.error("过滤器返回信息失败:" + e.getMessage(), e);
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != osw) {
                osw.close();
            }
        }
        return response;
    }
}
