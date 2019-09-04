package com.ucss.elementary.tnwn.util;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TConverter {
    //转为字符串
    public static String toSafeString(Object value) {
        try {
            return (value == null) ? "" : value.toString();
        } catch (Exception e) {
            return "";
        }

    }

    /*
    转为long型
     */
    public static long ObjectToLong(Object value) {
        return ObjectToLong(value, 0L);
    }

    /*
    转为long型
     */
    public static long ObjectToLong(Object value, long defalutValue) {
        if (value == null) {
            return defalutValue;
        }
        String strValue = value.toString();
        if (strValue.indexOf(".") >= 0) {
            strValue = strValue.substring(0, strValue.indexOf("."));
        }
        try {
            return Long.parseLong(strValue);
        } catch (Exception ex) {
            return defalutValue;
        }
    }


    public static short ObjectToShort(Object value, short defualtValue) {
        if (value == null) {
            return defualtValue;
        }
        String strValue = value.toString();
        if (strValue.indexOf(".") >= 0) {
            strValue = strValue.substring(0, strValue.indexOf("."));
        }

        try {
            return Short.parseShort(strValue);
        } catch (Exception ex) {
            return defualtValue;
        }
    }

    public static BigDecimal ObjectToBigDecimal(Object value, BigDecimal defualtValue) {
        if (value == null) {
            return defualtValue;
        }
        String strValue = value.toString();
        try {
            return new BigDecimal(strValue);
        } catch (Exception ex) {
            return defualtValue;
        }
    }

    public static BigDecimal ObjectToBigDecimal(Object value) {
        if (value == null) {
            return new BigDecimal(0);
        }
        String strValue = value.toString();
        try {
            return new BigDecimal(strValue);
        } catch (Exception ex) {
            return new BigDecimal(0);
        }
    }

    public static short ObjectToShort(Object value) {
        return ObjectToShort(value, (short) 0);
    }


    /*
    转为int
     */
    public static int ObjectToInt(Object value, int defualtValue) {
        if (value == null) {
            return defualtValue;
        }

        String strValue = value.toString();
        if (strValue.indexOf(".") >= 0) {
            strValue = strValue.substring(0, strValue.indexOf("."));
        }
        try {
            return Integer.parseInt(strValue);
        } catch (Exception ex) {

        }
        return defualtValue;
    }

    /*
    转为int
     */
    public static int ObjectToInt(Object value) {
        return ObjectToInt(value, 0);
    }

    public static float ObjectToFloat(Object value, float defualtValue) {
        if (value == null) {
            return defualtValue;
        }
        String strValue = value.toString();
        try {
            return Float.parseFloat(strValue);
        } catch (Exception ex) {
            return defualtValue;
        }
    }

    public static float ObjectToFloat(Object value) {
        return ObjectToFloat(value, 0);
    }

    //获取列表首元素
    public static <T> T GetFirstOrDefault(List<T> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    //安全转换类型
    public static <T> T safeConvert(Object obj) {
        try {
            if (obj == null) {
                return null;
            }

            return (T) obj;
        } catch (Exception ex) {
            return null;
        }
    }


    //对象转为map
    public static Map<String, Object> convertObjToMap(Object thisObj) {
        Map map = new HashMap();
        Class c;
        try {
            c = Class.forName(thisObj.getClass().getName());
            Method[] m = c.getMethods();
            for (int i = 0; i < m.length; i++) {
                String method = m[i].getName();
                if (method.startsWith("get")) {
                    try {
                        Object value = m[i].invoke(thisObj);
                        if (value != null) {
                            String key = method.substring(3);
                            key = key.substring(0, 1).toLowerCase() + key.substring(1);
                            map.put(key, value);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
        }
        return map;
    }

    public static <T> T GetListFromMap(Object result) {
        if (result == null) {
            return null;
        }
        Map<String, Object> map = (Map<String, Object>) result;
        Object list = map.get("list");
        if (list == null) {
            return null;
        }
        return (T) list;
    }

    public static String getURLEncoderString(String str) throws Exception {//url编码
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String URLDecoderString(String str) throws Exception {//url解码
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object getDataFromSupersetChartid(String url,Long sliceid)throws Exception{
        if(StringHelper.isTrimEmpty(url)||sliceid==null||sliceid<=0){
            return null;
        }
        String param=String.format("{\"slice_id\":%d}",sliceid);
        String result= HttpClientHelper.getInstance().sendHttpPost(String.format(url,TConverter.getURLEncoderString(param)));
        if(result!=null){
            JSONObject o=JSONObject.parseObject(result);
            if(o!=null){
                return o.get("data");
            }
        }
        return null;
    }
    //获取列表首元素
    public static <T> T GetFirstOrDefualt(List<T> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}