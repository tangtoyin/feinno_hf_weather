package com.ucss.elementary.tnwn.service.tnwn;

import com.alibaba.fastjson.JSONObject;
import com.ucss.elementary.tnwn.mapper.tnwn.TLTnwninterlogMapper;
import com.ucss.elementary.tnwn.model.database.TLTnwninterlog;
import com.ucss.elementary.tnwn.model.response.TnwnBaseResponse;
import com.ucss.elementary.tnwn.util.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2019-9-5.
 */

@Service
public class LogService {

    private static final Logger log= LoggerFactory.getLogger(LogService.class);
    @Autowired
    private Environment env;

    @Autowired
    private TLTnwninterlogMapper tnwninterlogMapper;

    /**
     * 日志记录
     * @param
     * @return
     * @throws Exception
     */
    public void insertLog(HttpServletRequest request, String phone, String platform, TnwnBaseResponse tnwnBaseResponse,Exception e,String OUTERIFCODE,String OUTERIFRESULT,String OUTERIFURL,String OUTERIFNAME) throws Exception{

        String message="";

        if(e!=null){
            message=e.toString();
        }

        TLTnwninterlog log=new TLTnwninterlog();
        log.setIfcode("1");
        log.setIfname(OUTERIFNAME);
        log.setRequester(platform);
        log.setPhone(phone);
        log.setIp(IpUtils.getRealIP((HttpServletRequest) request));
        log.setIfurl(request.getParameterMap().get("PARAM")[0]);
        log.setIfresultcode(tnwnBaseResponse.getResultcode());
        log.setIfresult(JSONObject.toJSONString(tnwnBaseResponse));
        log.setIfexception(message);
        log.setOuterifcode(OUTERIFCODE==null?"":OUTERIFCODE);
        log.setOuterifname(OUTERIFCODE==null?"":OUTERIFNAME);
        log.setOuterifurl(OUTERIFCODE==null?"":OUTERIFURL);
        log.setOuterifresult(OUTERIFCODE==null?"":OUTERIFRESULT);
        log.setCreatetime(new Date());
        tnwninterlogMapper.insert(log);

    }


}
