package com.ucss.elementary.weather.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhone {

    /** 电话格式验证 **/
       private static final String PHONE_CALL_PATTERN = "^(\\(\\d{3,4}\\)|\\d{3,4}-)?\\d{7,8}(-\\d{1,4})?$";

    /**
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700
     * **/
              private static final String CHINA_TELECOM_PATTERN = "(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /**
    * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
    **/
              private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";

              /**
        * 中国移动号码格式验证
        * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
        * ,187,188,147,178,1705
        * **/
              private static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";
      /**
        * 验证电话号码的格式
        *
        * @author LinBilin
        * @param str
        *            校验电话字符串
        * @return 返回true,否则为false
        */
              public static boolean isPhoneCallNum(String str) {

                 return str == null || "".equals(str.trim()) ? false : match(
                                 PHONE_CALL_PATTERN, str);
             }

              /**
        * 验证【电信】手机号码的格式
        *
        * @author LinBilin
        * @param str 校验手机字符串
        * @return 返回true,否则为false
        */
              public static boolean isChinaTelecomPhoneNum(String str) {

                 return str == null || "".equals(str.trim()) ? false : match(
                                 CHINA_TELECOM_PATTERN, str);
             }

              /**
        * 验证【联通】手机号码的格式
        *
        * @author LinBilin
        * @param str 校验手机字符串
        * @return 返回true,否则为false
        */
              public static boolean isChinaUnicomPhoneNum(String str) {

                 return str == null || "".equals(str.trim()) ? false : match(
                                 CHINA_UNICOM_PATTERN, str);
             }

              /**
        * 验证【移动】手机号码的格式
        *
       * @author LinBilin
        * @param str
       *            校验手机字符串
        * @return 返回true,否则为false
        */
              public static boolean isChinaMobilePhoneNum(String str) {

                return str == null || "".equals(str.trim()) ? false : match(
                                 CHINA_MOBILE_PATTERN, str);
             }
    /**
           * 执行正则表达式
           *
           * @param pat
           *            表达式
           * @param str
           *            待验证字符串
           * @return 返回true,否则为false
    */
     private static boolean match(String pat, String str) {
                 Pattern pattern = Pattern.compile(pat);
                 Matcher match = pattern.matcher(str);
                 return match.find();
             }

}