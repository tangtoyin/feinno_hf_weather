package com.ucss.elementary.weather.tasks;


import com.ucss.elementary.weather.model.entity.XmlRequest;
import com.ucss.elementary.weather.util.WebServUtil;
import com.ucss.elementary.weather.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * </p>
 *  * @author tangbo
 *  * @date OCT 28, 2019
 *  * @version 1.0
 */

@Component
public class SendSmsTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    //每分钟定时发送短信
    @Scheduled(cron = "*/5 * * * * ?")
    public void RunTimeNow() {
        logger.info("发送短信开始:");
        Long st=System.currentTimeMillis();
        XmlRequest xmlRequest=new XmlRequest();
        xmlRequest.setCode("sendSMS");
        xmlRequest.setSid("12131");
        xmlRequest.setSourceCode("12582");
        xmlRequest.setTimestamp(System.currentTimeMillis());
        xmlRequest.setSessionId("");
        xmlRequest.setSender("10658098");
        xmlRequest.setSmsContent("测试短信发送");
        xmlRequest.setReceiverList("18983829721");
        xmlRequest.setProductCode("HELP");
        xmlRequest.setPseudoFlag("0");
        String xml= XmlUtil.SmsSRequest(xmlRequest);
        String response= WebServUtil.doPostSoap1_1(env.getProperty("send.sms.url"),xml,"");
        System.out.println(response);
        XmlUtil.getXml(response);
        logger.info("发送短信结束,耗时:"+(System.currentTimeMillis()-st)+"ms");
       /* <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:rinp="http://rinp.chinamobile.com/" xmlns:bean="http://bean.interfaces.iiss.huawei.com">
   <soapenv:Header/>
   <soapenv:Body>
      <rinp:sendSMS>
         <!--Optional:-->
         <rinp:header>
            <bean:code>sendSMS</bean:code>
            <bean:sid>1222222</bean:sid>
            <bean:sourceCode>12582</bean:sourceCode>
            <bean:timestamp>1572253539445</bean:timestamp>
         </rinp:header>
         <!--Optional:-->
         <rinp:sessionId></rinp:sessionId>
         <!--Optional:-->
         <rinp:sender>10658098</rinp:sender>
         <!--Optional:-->
         <rinp:smsContent>测试信息</rinp:smsContent>
         <!--Optional:-->
         <rinp:receiverList>18996224031</rinp:receiverList>
         <!--Optional:-->
         <rinp:productCode>HELP</rinp:productCode>
         <!--Optional:-->
         <rinp:pseudoFlag>0</rinp:pseudoFlag>
      </rinp:sendSMS>
   </soapenv:Body>
</soapenv:Envelope>*/


    }

}
