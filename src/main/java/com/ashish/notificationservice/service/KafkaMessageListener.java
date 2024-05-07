package com.ashish.notificationservice.service;

import com.ashish.notificationservice.dto.MsgDTO;
import com.ashish.notificationservice.otp.utils.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

//    @Autowired
//    private EmailService emailService;
//    @Autowired
//    private SMSService smsService;
//    @KafkaListener(topics = "OneMoreRep",groupId = "OneMoreRep-group")
//    public void consumeEvents(MsgDTO message) throws MessagingException {
//        log.info("consumer consume the events {} ",message.toString());
//
//        emailService.sendPlanDetails(message);
//        smsService.sendSMS(message);
//
//
//    }
}
