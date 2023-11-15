package com.thistletechnologies.ilemi.dto.request;


import com.thistletechnologies.ilemi.model.Category;
import lombok.Data;

@Data
public class JoinWaitingListRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String whatsappNumber;
    private Category category;
}
