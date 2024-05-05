package com.ashish.notificationservice.otp.utils;

import com.ashish.notificationservice.dto.MsgDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender emailSender;

    public void sendPlanDetails(MsgDTO customer) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true); // true indicates multipart message

        helper.setTo(customer.getUserEmail());
        helper.setSubject("Plan Details Notification");

// HTML content for the email body
        String htmlContent = "<div style=\"padding: 20px; background-color: #f2f2f2; border-radius: 10px;\">"
                + "<h3 style=\"color: #333;\">Dear " + customer.getUserFullName() + ",</h3>"
                + "<p>Your plan details are as follows:</p>"
                + "<ul>"
                + "<li>Trainer Full Name: " + customer.getTrainerFullName() + "</li>"
                + "<li>Plan Name: " + customer.getPlanName() + "</li>"
                + "<li>Plan Start Date: " + customer.getPlanStart() + "</li>"
                + "<li>Plan Expiry Date: " + customer.getPlanExpire() + "</li>"
                + "<li>User Email: " + customer.getUserEmail() + "</li>"
                + "<li>Phone Number: " + customer.getPhoneNumber() + "</li>"
                + "</ul>"
                + "</div>";

// Set email message with HTML content
        helper.setText(htmlContent, true); // true indicates HTML content

// Send email
        emailSender.send(message);
    }

}
