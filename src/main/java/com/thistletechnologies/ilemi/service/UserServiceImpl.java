package com.thistletechnologies.ilemi.service;

import com.thistletechnologies.ilemi.dto.request.JoinWaitingListRequest;
import com.thistletechnologies.ilemi.dto.response.JoinWaitingListResponse;
import com.thistletechnologies.ilemi.exceptions.UserException;
import com.thistletechnologies.ilemi.exceptions.UserExistException;
import com.thistletechnologies.ilemi.model.User;
import com.thistletechnologies.ilemi.repository.UserRepository;
import com.thistletechnologies.ilemi.serviceImplementation.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public JoinWaitingListResponse joinWaitingList(JoinWaitingListRequest waitingListRequest) {
        if (userRepository.findUserByEmail(waitingListRequest.getEmail().toLowerCase()).isPresent()) throw new UserExistException("user already exist");
        User user = User.builder()
                .fullName(waitingListRequest.getFullName())
                .phoneNumber(waitingListRequest.getPhoneNumber())
                .whatsappNumber(waitingListRequest.getWhatsappNumber())
                .email(waitingListRequest.getEmail())
                .category(waitingListRequest.getCategory())
                .build();
        userRepository.save(user);


        return JoinWaitingListResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        if (userRepository.findUserByEmail(email).isEmpty())
            throw new UserException("user does not exist");
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> getUserById(String id) {
        if (userRepository.findUserById(id).isEmpty()) throw new UserException("user id not found")
;        return userRepository.findUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        if (userRepository.findAll().size() == 0) throw new UserException("no user found");
        return userRepository.findAll();
    }
}
