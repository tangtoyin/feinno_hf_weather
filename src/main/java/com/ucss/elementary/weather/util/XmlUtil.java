package com.ucss.elementary.weather.util;

import com.ucss.elementary.weather.model.entity.XmlRequest;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;


/**
 * Created by Administrator on 2019/10/28.
 */
public class XmlUtil {

    public static String SmsSRequest(XmlRequest xmlRequest) {

        StringBuffer soapRequestData = new StringBuffer();
		/* 2.短信调用接口 */
        soapRequestData.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        soapRequestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:rinp=\"http://rinp.chinamobile.com/\" xmlns:bean=\"http://bean.interfaces.iiss.huawei.com\">");
        soapRequestData.append("<soapenv:Header/>");
        soapRequestData.append("<soapenv:Body>");
        soapRequestData.append("<rinp:sendSMS>");
        soapRequestData.append("<rinp:header>");
        soapRequestData.append("<bean:code>" + xmlRequest.getCode() + "</bean:code>");
        soapRequestData.append("<bean:sid>" + xmlRequest.getSid() + "</bean:sid>");
        soapRequestData.append("<bean:sourceCode>" + xmlRequest.getSourceCode() + "</bean:sourceCode>");
        soapRequestData.append("<bean:timestamp>" + xmlRequest.getTimestamp() + "</bean:timestamp>");
        soapRequestData.append("</rinp:header>");
        soapRequestData.append("<rinp:sessionId>" + xmlRequest.getSessionId() + "</rinp:sessionId>");
        soapRequestData.append("<rinp:sender>" + xmlRequest.getSender() + "</rinp:sender>");
        soapRequestData.append("<rinp:smsContent>" + xmlRequest.getSmsContent() + "</rinp:smsContent>");
        soapRequestData.append("<rinp:receiverList>" + xmlRequest.getReceiverList() + "</rinp:receiverList>");
        soapRequestData.append("<rinp:productCode>" + xmlRequest.getProductCode() + "</rinp:productCode>");
        soapRequestData.append("<rinp:pseudoFlag>" + xmlRequest.getPseudoFlag() + "</rinp:pseudoFlag>");
        soapRequestData.append("</rinp:sendSMS>");
        soapRequestData.append("</soapenv:Body>");
        soapRequestData.append("</soapenv:Envelope>");
        return soapRequestData.toString();
    }

    public static void getXml(String xml) {
        InputSource in = new InputSource(new StringReader(xml));
        in.setEncoding("UTF-8");
        SAXReader reader = new SAXReader();
        try{
        Document document = reader.read(in);
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        for (Iterator<Element> it = elements.iterator(); it.hasNext(); ) {
            Element element = it.next();
            System.out.println(element.getName() + " : " + element.getTextTrim());
        }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String args[]){
        String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><sendSMSResponse xmlns=\"http://rinp.chinamobile.com/\"><sendSMSResult>180922161823015</sendSMSResult></sendSMSResponse></soap:Body></soap:Envelope>";
        getXml(xml);

    }

}
