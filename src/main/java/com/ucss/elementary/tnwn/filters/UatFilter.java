package com.ucss.elementary.tnwn.filters;

import com.ucss.elementary.tnwn.constant.CacheKeyConst;
import com.ucss.elementary.tnwn.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Component
public class UatFilter implements Filter {

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        /***************uat续期*********************/
        String uat=req.getParameter("uat");
        if(!StringHelper.isEmpty(uat)){
            if(redisTemplate.hasKey(CacheKeyConst.UAT_PRE + uat)){
                //若uat未过期，则续期
                redisTemplate.expire(CacheKeyConst.UAT_PRE + uat, 2*3600, TimeUnit.SECONDS);
            }
        }
        /***************uat续期*********************/
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
