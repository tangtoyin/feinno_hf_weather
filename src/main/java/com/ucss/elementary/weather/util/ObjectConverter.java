package com.ucss.elementary.weather.util;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by HL on 2017/12/21.
 */
public class ObjectConverter {

    /**
     * @param obj   转换源对象
     * @param toObj 转换类型
     * @param <T>   转换结果
     * @return
     * @throws Exception
     */
    public static <T> T objSimpleConvert(Object obj, Class<T> toObj) throws Exception {
        T toObjIns = (T) toObj.newInstance(); //创建目标对象实例
        Class sourCls = obj.getClass();
        //遍历源属性
        do {
            Field[] sourFlds = sourCls.getDeclaredFields(); //源属性集
            for (int i = 0; i < sourFlds.length; i++) { //遍历源所有属性
                Field sf = sourFlds[i];
                sf.setAccessible(true);
                System.out.println(sf.getName());
                //遍历目标所有属性
                Class toCls = toObj;
                do {
                    Field[] toFlds = toCls.getDeclaredFields(); //源属性集
                    for (int j = 0; j < toFlds.length; j++) { //遍历源所有属性
                        Field tof = toFlds[j];
                        tof.setAccessible(true);
                        if (sf.getName().equals(tof.getName())) { //属性名字相同
                            String type = tof.getType().toString();//得到此属性的类型
                            if (type.endsWith("String")) {
                                tof.set(toObjIns, (String) sf.get(obj));
                            } else if (type.endsWith("int") || type.endsWith("Integer")) {
                                tof.set(toObjIns, (Integer) sf.get(obj));
                            } else if (type.endsWith("Date")) {
                                tof.set(toObjIns, (Date) sf.get(obj));
                            } else if (type.endsWith("long") || type.endsWith("Long")) {
                                tof.set(toObjIns, (Long) sf.get(obj));
                            } else if (type.endsWith("short") || type.endsWith("Short")) {
                                tof.set(toObjIns, (Short) sf.get(obj));
                            } else {
                                return null;
                            }
                        }
                    }
                    toCls = toCls.getSuperclass();

                } while (toCls != Object.class);
            }
            sourCls = sourCls.getSuperclass();
        } while (sourCls != Object.class);
        return toObjIns;
    }
}
