package com.ucss.elementary.weather.util;

import java.util.UUID;

public class UUIDUtil {

    //生成不带-的UUID
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}