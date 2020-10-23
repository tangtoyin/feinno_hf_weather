package com.ucss.elementary.weather.util;

/**
 * @author Smile
 * @date 2018/11/15 9:50
 */
public class CheckSqlUtil {
    //一般的sql注入字符串过滤
    final static String inj_str = "'|and|exec|insert|select|delete|report|count|*|%|chr|mid|master|truncate|declare|;|or|-|+|,";
    //判断select查询的
    final static String inj_str_select = "exec|insert|delete|report|mid|master|truncate|declare|;";
    //判断where后的查询
    final static String inj_str_where = "exec|insert|select|delete|report|count|*|mid|master|truncate|declare|;";
    public static boolean  sqlInj(String str){
        String inj_stra[] = inj_str.split("|");
        for (int i=0 ; i <inj_stra.length ; i++ ) {
            if (str.indexOf(inj_stra[i])>=0) {
                return true;
            }
        }
        return false;
    }
    //select的sql注入
    public static boolean  sqlInjFromSelect(String str){
        String inj_stra[] = inj_str_select.split("\\|");
        for (int i=0 ; i <inj_stra.length ; i++ ) {
            if (str.indexOf(inj_stra[i])>=0) {
                return true;
            }
        }
        return false;
    }
    //where的sql注入
    public static boolean  sqlInjFromWhere(String str){
        String inj_stra[] = inj_str_where.split("\\|");
        for (int i=0 ; i <inj_stra.length ; i++ ) {
            if (str.indexOf(inj_stra[i])>=0) {
                return true;
            }
        }
        return false;
    }
}
