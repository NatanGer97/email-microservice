package com.backend.emailmicroservice.Services;


import com.backend.emailmicroservice.Models.*;

public interface IEmailService {

    void sendSimpleMail(EmailDetails details);

    /*String sendMailWithAttachment(EmailDetails details);*/
}
