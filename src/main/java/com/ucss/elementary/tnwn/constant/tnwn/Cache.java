package com.ucss.elementary.tnwn.constant.tnwn;

import com.ucss.elementary.tnwn.model.database.TBNumrange;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by Administrator on 2019-10-8.
 */
public class Cache {
    //存储号段表的缓存
    public static Hashtable<String,List<TBNumrange>> hash_numranges=new Hashtable<String,List<TBNumrange>>();


    //存储号段表的缓存临时使用
    public static Hashtable<String,List<TBNumrange>> hash_numranges_temp=new Hashtable<String,List<TBNumrange>>();

}
