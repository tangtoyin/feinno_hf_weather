package com.ucss.elementary.tnwn.util;


import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 封装了常用字符串操作的方法
 * <p>
 * Created by IntelliJ IDEA.
 * User: jianglin
 * Date: 2007-10-15
 * Time: 8:26:37
 * To change this template use File | Settings | File Templates.
 */
public final class StringHelper {
    //-----------------------------------
    //该类不能被继承，不能被实例化
    //-------------------------------------


    //复杂匹配--邮箱正则表达式
    static Pattern EMILE_PATTERN = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    /**
     * 字符串是否为空
     *
     * @param s
     * @return boolean
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    /**
     * 字符串去掉空格后是否为空
     *
     * @param s
     * @return boolean
     */
    public static boolean isTrimEmpty(String s) {
        return s == null || s.length() == 0 || s.trim().length() == 0;
    }

    /**
     * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符)
     * Character.isLetter(char c);
     *
     * @param c, 需要判断的字符
     * @return boolean, 返回true,Ascill字符
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }


    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param s ,需要得到长度的字符串
     * @return int, 得到的字符串长度
     */
    public static int length(String s) {
        if (s == null) {
            return 0;
        }
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;  //是单字符加1
            if (!isLetter(c[i])) {
                len++;//是汉字再加1
            }
        }
        return len;
    }


    /**
     * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
     *
     * @param origin, 原始字符串
     * @param len,    截取长度(一个汉字长度按2算的)
     * @return String, 返回的字符串
     */
    public static String substring(String origin, int len) {
        if (origin == null || "".equals(origin) || len < 1) {
            return ""; //如果原字符串为空则返回;
        }
        byte[] strByte = new byte[len];
        if (len > length(origin)) {
            return origin;
        }
        System.arraycopy(origin.getBytes(), 0, strByte, 0, len);//将要截取的字符串拷贝到新的byte数组中.
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = strByte[i];
            if (value < 0) { //如是字符为汉字,那么value值将小于0;
                count++;
            }
        }
        if (count % 2 != 0) {
            len = (len == 1) ? ++len : --len;
        }
        return new String(strByte, 0, len);
    }

    //截取汉字
    public static String getSubString(String str, int length) {
        int count = 0;
        int offset = 0;
        char[] c = str.toCharArray();
        int size = c.length;
        if (size >= length) {
            for (int i = 0; i < c.length; i++) {
                if (c[i] > 256) {
                    offset = 2;
                    count += 2;
                } else {
                    offset = 1;
                    count++;
                }
                if (count == length) {
                    return str.substring(0, i + 1);
                }
                if ((count == length + 1 && offset == 2)) {
                    return str.substring(0, i);
                }
            }
        } else {
            return str;
        }
        return "";
    }

    /**
     * 把10进制数转换成16进制字符串
     *
     * @param value
     * @return hexString
     */
    public static String formatHexString(int value) {
        if (value < 16) {
            return "0" + Integer.toHexString(value);
        } else {
            return Integer.toHexString(value);
        }
    }


    public static String htmlEncode(String str) {
        if (isEmpty(str)) {
            return "";
        }

        StringBuffer sb = new StringBuffer(str.length());
        // true if last char was blank
        boolean lastWasBlankChar = false;
        int len = str.length();
        char c;

        for (int i = 0; i < len; i++) {
            c = str.charAt(i);

            if (c == ' ') {
                // blank gets extra work,
                // this solves the problem you get if you replace all
                // blanks with &nbsp;, if you do that you loss
                // word breaking
                if (lastWasBlankChar) {
                    lastWasBlankChar = false;
                    sb.append("&nbsp;");
                } else {
                    lastWasBlankChar = true;
                    sb.append(' ');
                }
            } else {
                lastWasBlankChar = false;
                //
                // HTML Special Chars
                if (c == '"') {
                    sb.append("&quot;");
                } else if (c == '&') {
                    sb.append("&amp;");
                } else if (c == '<') {
                    sb.append("&lt;");
                } else if (c == '>') {
                    sb.append("&gt;");
                } else if (c == '\n') {
                    // Handle Newline
                    sb.append("<br>");
                }
                else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String toString(int value, int r) {
        StringBuffer buffer = new StringBuffer();
        String str = null;
        str = Integer.toString(value);
        int len = str.length();
        if (len < r) {
            int need = r - len;
            for (int i = 0; i < need; i++) {
                buffer.append("0");
            }
        }
        buffer.append(str);
        return buffer.toString();
    }

    public static int getTime(String str, int time) {
        String[] s = str.split(":");
        int i = Integer.parseInt(s[time]);
        return i;
    }

    public static String toSafeString(Object value) {
        try {
            return (value == null) ? "" : value.toString();
        } catch (Exception e) {
            return "";
        }

    }

    //检查特殊字符
    public static String checkSpecial(String item) {
        if (item == "-1") {
            return "[-1::-1]";
        }
        if (item == "-1 ") {
            return "[-1 ::-1 ]";
        }
        return item;
    }

    //返回更新时间范围
    public static String getUpdateTimeRange(String i) {
        Date startStr = DateHelper.getDayStartTime(new Date());
        Date endStr = DateHelper.getDayEndTime(new Date());
        String returnStr = null;
        switch (i) {
            case "1":
                returnStr = DateHelper.date2Str(startStr) + "::" + DateHelper.date2Str(endStr);
                break;
            case "2":
                returnStr = DateHelper.date2Str(DateHelper.addDays(startStr, -2)) + "::" + DateHelper.date2Str(endStr);
                break;
            case "3":
                returnStr = DateHelper.date2Str(DateHelper.addDays(startStr, -6)) + "::" + DateHelper.date2Str(endStr);
                break;
            case "4":
                returnStr = DateHelper.date2Str(DateHelper.addDays(startStr, -9)) + "::" + DateHelper.date2Str(endStr);
                break;
            case "5":
                returnStr = DateHelper.date2Str(DateHelper.addDays(startStr, -30)) + "::" + DateHelper.date2Str(endStr);
                break;
            default:
        }
        return returnStr != null ? returnStr.replace("/", "-") : null;
    }

    ///regionCode去掉右侧0，再补齐偶数位
    public static String getRegionCode(String regionCode) {
        regionCode = regionCode.replaceAll("0+?$", "");
        if (regionCode.length() % 2 == 1) {
            regionCode = regionCode + "0";
        }
        return regionCode;
    }

    public static boolean isEmail(String email) {
        if (null == email || "".equals(email)) {
            return false;
        }
        Matcher m = EMILE_PATTERN.matcher(email);
        return m.matches();
    }

    //验证码生成器
    public static String getVerificationCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += random.nextInt(10);
        }
        return code;
    }

    //返回最后4位
    public static String getlast4(String phone) {
        if (StringHelper.isTrimEmpty(phone)) {
            return "";
        }
        if (phone.length() <= 4) {
            return phone;
        }
        return phone.substring(phone.length() - 4, phone.length());
    }


    //获取省略信息
    public static String toOmit(String item) {
        if (StringHelper.isTrimEmpty(item)) {
            return item;
        }
        //身份证
        if (item.length() == 18) {
            return item.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
        }

        //银行卡号
        if (item.length() >= 16 && item.length() <= 21) {
            item = item.substring(0, 5) + "********" + item.substring(item.length() - 4, item.length());
            return item;
        }

        //手机号或QQ号之类的
        long num = TConverter.ObjectToLong(item, 0);
        if (num > 0) {
            if (item.length() == 11) {
                item = item.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            } else {
                if (item.length() >= 5) {
                    String m = "(\\d{2})\\d{%d}(\\d{2})";
                    item = item.replaceAll(String.format(m, item.length() - 4), "$1****$2");
                }
            }
            return item;
        }
        if (item.startsWith("QQ") || item.startsWith("qq")) {
            String m = "(\\w{4})\\d{%d}(\\d{2})";
            item = item.replaceAll(String.format(m, item.length() - 6), "$1****$2");
            return item;
        }
        if (item.contains("@")) {
            int index = item.indexOf("@");
            if (index > 0) {
                item = StringUtils.rightPad(StringUtils.left(item, 0), index, "*").concat(StringUtils.mid(item, index, StringUtils.length(item)));
            }
            return item;
        }

        //姓名
        if (item.length() > 2) {
            item = item.substring(0, item.length() - 2) + "**";
        } else if (item.length() == 2) {
            item = item.substring(0, 1) + "*";
        }
        return item;
    }

    public static String toOmit_bak(String item) {
        if (StringHelper.isTrimEmpty(item)) {
            return item;
        }
        long num = TConverter.ObjectToLong(item, 0);
        if (num > 0) {
            if (item.length() == 11) {
                item = item.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            } else {
                if (item.length() >= 5) {
                    String m = "(\\d{2})\\d{%d}(\\d{2})";
                    item = item.replaceAll(String.format(m, item.length() - 4), "$1****$2");
                }
            }
            return item;
        }
        if (item.startsWith("QQ") || item.startsWith("qq")) {
            String m = "(\\w{4})\\d{%d}(\\d{2})";
            item = item.replaceAll(String.format(m, item.length() - 6), "$1****$2");
            return item;
        }
        if (item.contains("@")) {
            int index = item.indexOf("@");
            if (index > 2) {
                item = StringUtils.rightPad(StringUtils.left(item, 2), index, "*").concat(StringUtils.mid(item, index, StringUtils.length(item)));
            }
        }
        return item;
    }

    //不区分中英文
    public static String bSubstring(String s, int length) throws Exception {
        byte[] bytes = s.getBytes("Unicode");
        int n = 0; // 表示当前的字节数
        int i = 2; // 要截取的字节数，从第3个字节开始
        for (; i < bytes.length && n < length; i++) {
            // 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
            if (i % 2 == 1) {
                n++; // 在UCS2第二个字节时n加1
            } else {
                // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
                if (bytes[i] != 0) {
                    n++;
                }
            }
        }
        // 如果i为奇数时，处理成偶数
        if (i % 2 == 1) {
            // 该UCS2字符是汉字时，去掉这个截一半的汉字
            if (bytes[i - 1] != 0) {
                i = i - 1;
            }// 该UCS2字符是字母或数字，则保留该字符
            else {
                i = i + 1;
            }
        }
        return new String(bytes, 0, i, "Unicode");
    }

    /*
 * Java文件操作 获取文件扩展名
 *
 *  Created on: 2011-8-2
 *      Author: blueeagle
 */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /*
     * Java文件操作 获取不带扩展名的文件名
     *
     *  Created on: 2011-8-2
     *      Author: blueeagle
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
    /**
     * 去掉文本中的html标签
     *
     * @param htmlStr
     * @return
     */
    public static String html2Text(String htmlStr) {
        if(StringHelper.isEmpty(htmlStr)){
            return "";
        }
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
        String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签

        /** 删除转义字符 */
        htmlStr = htmlStr.replaceAll("&.{2,6}?;", "");
        return htmlStr.trim(); //返回文本字符串
    }

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
    public static String autoGenericCode(String code, int num) {
        // 保留num的位数
        // 0 代表前面补充0
        // num 代表长度为4
        // d 代表参数为正数型
        String result  = String.format("%0" + num + "d", Integer.parseInt(code) + 1);

        return result;
    }

}
