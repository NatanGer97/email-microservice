package com.backend.emailmicroservice.Controllers;

import com.backend.emailmicroservice.Models.*;
import com.backend.emailmicroservice.Services.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private ObjectMapper objectMapper;
    private Logger  logger = LoggerFactory.getLogger(EmailController.class);
    @PostMapping("/email")
    public ResponseEntity<?> sendEmailAll(@RequestBody String request) {
        logger.info(request);
        try {
            MessageAndEmails messageAndEmails = objectMapper.readValue(request, MessageAndEmails.class);
            new Thread(() -> {
                messageAndEmails.getEmails()
                        .parallelStream()
                        .forEach(email -> {
                            emailService.sendSimpleMail(EmailDetails.of(email, messageAndEmails.getMessage(),
                                    "none"));
                        });
            }).start();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return new ResponseEntity<>("SENDING", HttpStatus.OK);

    }
}
