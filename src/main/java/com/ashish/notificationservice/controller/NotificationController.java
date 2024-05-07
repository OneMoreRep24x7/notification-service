package com.ashish.notificationservice.controller;

import com.ashish.notificationservice.dto.MsgDTO;
import com.ashish.notificationservice.otp.utils.EmailService;
import com.ashish.notificationservice.service.SMSService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private SMSService smsService;

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody MsgDTO message) throws MessagingException {
        emailService.sendPlanDetails(message);
        smsService.sendSMS(message);
    }
}
