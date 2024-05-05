package com.ashish.notificationservice.service;

import com.ashish.notificationservice.dto.MsgDTO;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSService {

    @Value("${TWILIO_ACCOUNT_SID}")
    private String TWILIO_ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    private String TWILIO_AUTH_TOKEN;
    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    private String TWILIO_OUTGOING_SMS_NUMBER;
    @PostConstruct
    private void  setUp(){
        Twilio.init(TWILIO_ACCOUNT_SID,TWILIO_AUTH_TOKEN);
    }

    public String sendSMS(MsgDTO reqMessage) {
        String smsContent = "Your plan updated successfully by " + reqMessage.getTrainerFullName();

        Message message = Message.creator(
                new PhoneNumber("+919497899460"), // Recipient phone number
                new PhoneNumber(TWILIO_OUTGOING_SMS_NUMBER), // Twilio phone number
                smsContent // SMS message content
        ).create();

        return message.getStatus().toString();
    }

}
