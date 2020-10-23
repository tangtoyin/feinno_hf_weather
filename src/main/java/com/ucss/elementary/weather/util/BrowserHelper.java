package com.ucss.elementary.weather.util;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

public class BrowserHelper {
    private static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};

    public static boolean isMSBrowser(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        for (String signal : IEBrowserSignals) {
            if (userAgent.contains(signal)) {
                return true;
            }
        }
        return false;
    }

    //IE浏览器的乱码问题解决
    public static String getInfoByBrowser(HttpServletRequest request,String item){
        try {
            boolean isMSIE = isMSBrowser(request);
            if (isMSIE) {
                item = URLEncoder.encode(item, "UTF-8");                 }
            else {//万能乱码问题解决
                item = new String(item.getBytes("UTF-8"), "ISO-8859-1");
            }
        }catch (Exception e){

        }
        return item;
    }

}
