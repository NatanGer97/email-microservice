package com.backend.emailmicroservice.Models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailDetails {
 
    // Class data members
    @JsonIgnore  private String recipient;

    private String msgBody;
    private String subject;

    public static EmailDetails of(String recipient, String msgBody, String subject) {
        return new EmailDetails(recipient, msgBody, subject);
    }


}
