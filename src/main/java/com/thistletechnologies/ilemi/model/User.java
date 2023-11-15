package com.thistletechnologies.ilemi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String whatsappNumber;
    private Category category;

}
