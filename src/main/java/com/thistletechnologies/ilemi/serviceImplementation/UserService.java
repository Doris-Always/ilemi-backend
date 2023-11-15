package com.thistletechnologies.ilemi.serviceImplementation;

import com.thistletechnologies.ilemi.dto.request.JoinWaitingListRequest;
import com.thistletechnologies.ilemi.dto.response.JoinWaitingListResponse;
import com.thistletechnologies.ilemi.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    JoinWaitingListResponse joinWaitingList(JoinWaitingListRequest waitingListRequest);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserById(String id);

    List<User> getAllUser();
}
