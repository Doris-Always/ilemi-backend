package com.thistletechnologies.ilemi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinWaitingListResponse {
    private String id;
    private String email;
}
