package com.ucss.elementary.tnwn.filters;

import com.ucss.elementary.tnwn.service.SysService;
import com.ucss.elementary.tnwn.util.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**ip黑/白名单设置
 * @author Smile
 * @date 2018/10/22 17:11
 * 说明：先白名单，再黑名单判断
 */
@Component
public class IpFilter implements Filter {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SysService sysService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        //获取ip地址
        String ipAddress = IpUtils.getRealIP((HttpServletRequest) req);
        //本机不判断是否为白/黑名单--0:0:0:0:0:0:0:1是ipv6的表现形式，对应ipv4来说相当于127.0.0.1，也就是本机
        if ("127.0.0.1".equals(ipAddress) || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
            filterChain.doFilter(req, res);
            return;
        }
        //若不是白名单或存在于黑名单中，则无权访问
        if (!sysService.isIPWhilelist(ipAddress) || sysService.isIPBlacklist(ipAddress)) {
            res.getWriter().append("<h1 style=\"text-align:center;\">Not allowed!</h1>");
            return;
        }
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
