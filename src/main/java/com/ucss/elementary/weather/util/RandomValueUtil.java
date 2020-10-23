package com.ucss.elementary.weather.util;

import org.springframework.stereotype.Service;

/**
 * @author Smile
 * @date 2019/2/18 16:49
 */
@Service
public class RandomValueUtil {
    public  int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    public  long getNum(long start,long end) {
        return (long)(Math.random()*(end-start+1)+start);
    }
    private final String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    public  String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }
}
