package com.ucss.elementary.tnwn.filters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ucss.elementary.tnwn.model.response.BaseResponse;
import com.ucss.elementary.tnwn.model.response.TnwnBaseResponse;
import com.ucss.elementary.tnwn.model.tnwn.NumberArea;
import com.ucss.elementary.tnwn.service.SysService;
import com.ucss.elementary.tnwn.service.tnwn.SegmentService;
import com.ucss.elementary.tnwn.service.tnwn.UserInfoService;
import com.ucss.elementary.tnwn.util.EntityUtil;
import com.ucss.elementary.tnwn.util.IpUtils;
import io.undertow.servlet.spec.HttpServletRequestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**ip黑/白名单设置
 * @author Smile
 * @date 2018/10/22 17:11
 * 说明：区域白名单
 */
@Component
public class AreaFilter implements Filter {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysService sysService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    SegmentService segmentService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequestImpl) req).getRequestURI();
        Object o=null;
        String code="222";
        try{

        if(url.equals("/tnwn/UserInfo/detail")){
            String PARAM = req.getParameter("PARAM");
            JSONObject jsonObject = JSONObject.parseObject(PARAM);
            String phonenumber = jsonObject.get("phonenum").toString();
            List<String> l=new ArrayList<String>();
            l.add(phonenumber);
            if(segmentService.AreaFilterSearch(l)!=null){
                o=new TnwnBaseResponse(code,null);
                filterErrorExtend(req,res,o);
                return;
            }else{
                filterChain.doFilter(req, res);
            }

        }else if(url.equals("/tnwn/UserInfo/details")){
            String PARAM = req.getParameter("PARAM");
            JSONObject jsonObject = JSONObject.parseObject(PARAM);
            String phonenumber = jsonObject.get("phonenumbatch").toString();
            List<String> list = EntityUtil.checkCellphone(phonenumber);
            if(segmentService.AreaFilterSearch(list)!=null){
                o=new TnwnBaseResponse(code,null);
                filterErrorExtend(req,res,o);
                return;
            }else{
                filterChain.doFilter(req, res);
            }

        }else if(url.equals("/tnwn/segmentArea/detail")){
                String PARAM = req.getParameter("PARAM");
                JSONObject jsonObject = JSONObject.parseObject(PARAM);
                String phonenumber = jsonObject.get("phonenum").toString();
                List<String> l=new ArrayList<String>();
                l.add(phonenumber);
                if(segmentService.AreaFilterSearch(l)!=null){
                    o=new NumberArea(code,null,null,null);
                    filterErrorExtend(req,res,o);
                    return;
                }else{
                    filterChain.doFilter(req, res);
                }
        }else{
            filterChain.doFilter(req, res);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

    private void filterErrorExtend(ServletRequest req, ServletResponse res, Object response) throws IOException, ServletException {
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
    }
}
