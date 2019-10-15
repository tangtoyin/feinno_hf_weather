//package com.ucss.elementary.tnwn.rabbitmq;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ucss.elementary.tnwn.config.RabbitmqConfig;
//import com.ucss.elementary.tnwn.model.tnwn.PhoneEntity;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//
///**
// * Created by Administrator on 2019-9-11.
// */
//
//@Component
//public class UserTnwnRabbitmqListener {
//    private static final Logger log= LoggerFactory.getLogger(UserTnwnRabbitmqListener.class);
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
///*
//    @RabbitListener(queues = "${rabbitmq.user.tnwn.queue.name}",containerFactory = "singleListenerContainer")
//    public void consume(@Payload byte[] msg){
//        try{
//            PhoneEntity phone=objectMapper.readValue(msg,PhoneEntity.class);
//            //log.info("监听到的消息",phone);
//            log.info("监听到消息了:"+phone.getPhoneNum()+","+phone.getPlatFormtype());
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//    }*/
//}
