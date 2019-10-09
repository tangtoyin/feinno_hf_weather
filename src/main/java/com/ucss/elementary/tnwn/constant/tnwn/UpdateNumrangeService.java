package com.ucss.elementary.tnwn.constant.tnwn;


import com.ucss.elementary.tnwn.mapper.tnwn.TBNumrangeMapper;
import com.ucss.elementary.tnwn.model.database.TBNumrange;
import com.ucss.elementary.tnwn.model.database.TBNumrangeExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  留言处理类
 **/

@Component
public class UpdateNumrangeService {

    @Autowired
    private TBNumrangeMapper tbNumrangeMapper;

    private static final Logger log= LoggerFactory.getLogger(UpdateNumrangeService.class);



    //每天凌晨自动更新号段表缓存数据
    @Scheduled(cron = "0 0 0 */1 * ?")
    public void timerToNow(){
        {
            Long start=System.currentTimeMillis();
            TBNumrangeExample example=new TBNumrangeExample();
            example.createCriteria().andIsvalidEqualTo((short) 1);
            List<TBNumrange> list=tbNumrangeMapper.selectByExample(example);
            for(TBNumrange tbNumrange:list){
                String SUBSTRBEG=tbNumrange.getNumrange().substring(0,5);
                if(Cache.hash_numranges_temp.containsKey(SUBSTRBEG)){
                    List<TBNumrange> l=Cache.hash_numranges_temp.get(SUBSTRBEG);
                    l.add(tbNumrange);
                }else{
                    List<TBNumrange> l=new ArrayList<TBNumrange>();
                    l.add(tbNumrange);
                    Cache.hash_numranges_temp.put(SUBSTRBEG,l);
                }
            }
            //TODO 三步操作
            Cache.hash_numranges.clear();
            Cache.hash_numranges=Cache.hash_numranges_temp;
            Cache.hash_numranges_temp.clear();
            Long end=System.currentTimeMillis();
            log.info("凌晨执行加载号段表:"+(end-start)+"ms");

        }
    }

}
