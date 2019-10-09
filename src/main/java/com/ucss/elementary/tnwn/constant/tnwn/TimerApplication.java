package com.ucss.elementary.tnwn.constant.tnwn;

import com.ucss.elementary.tnwn.mapper.tnwn.TBNumrangeMapper;
import com.ucss.elementary.tnwn.model.database.TBNumrange;
import com.ucss.elementary.tnwn.model.database.TBNumrangeExample;
import com.ucss.elementary.tnwn.service.tnwn.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动加载到缓存
 */
@Component
public class TimerApplication implements ApplicationRunner {
    @Autowired
    private TBNumrangeMapper tbNumrangeMapper;

    private static final Logger log= LoggerFactory.getLogger(TimerApplication.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Long start=System.currentTimeMillis();
        TBNumrangeExample example=new TBNumrangeExample();
       // example.createCriteria().andIsvalidEqualTo((short) 1).andNumrangeEqualTo("1511190");
         example.createCriteria().andIsvalidEqualTo((short) 1);
        List<TBNumrange> list=tbNumrangeMapper.selectByExample(example);
        for(TBNumrange tbNumrange:list){
            String SUBSTRBEG=tbNumrange.getNumrange().substring(0,5);
            if(Cache.hash_numranges.containsKey(SUBSTRBEG)){
                List<TBNumrange> l=Cache.hash_numranges.get(SUBSTRBEG);
                l.add(tbNumrange);
            }else{
                List<TBNumrange> l=new ArrayList<TBNumrange>();
                l.add(tbNumrange);
                Cache.hash_numranges.put(SUBSTRBEG,l);
            }
        }
        Long end=System.currentTimeMillis();
        log.info("号段表加载时间:"+(end-start));
       /* for(Object obj :  Cache.hash_numranges.keySet()) {
            Object key = obj;
            List<TBNumrange> value =  Cache.hash_numranges.get(obj);
            for(TBNumrange t:value){
                log.info(key+"-->"+t.getBeginno()+"->"+t.getEndno());
            }
        }*/
    }
}
