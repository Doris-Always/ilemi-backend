package com.thistletechnologies.ilemi;

import com.thistletechnologies.ilemi.dto.request.JoinWaitingListRequest;
import com.thistletechnologies.ilemi.dto.response.JoinWaitingListResponse;
import com.thistletechnologies.ilemi.model.Category;
import com.thistletechnologies.ilemi.model.User;
import com.thistletechnologies.ilemi.serviceImplementation.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class UserServiceTest {
    @Autowired
    private  UserService userService;
//    @Test
//    public void test(){
//
//    }

    private JoinWaitingListRequest waitingListRequest;

    private JoinWaitingListResponse joinWaitingListResponse;




    @BeforeEach
    void setup(){
        waitingListRequest= new JoinWaitingListRequest();
        waitingListRequest.setFullName("John Doe");
        waitingListRequest.setEmail("johndoe@gmail.com");
        waitingListRequest.setPhoneNumber("08123456788");
        waitingListRequest.setWhatsappNumber("08123456788");
        waitingListRequest.setCategory(Category.TENANT);


    }
    @AfterEach
    void afterEach(){
    }
    @Test
    void testThatAUserCanJoinWaitingList(){
        joinWaitingListResponse = userService.joinWaitingList(waitingListRequest);
        assertNotNull(joinWaitingListResponse.getId());
    }
    @Test
    void testThatAUserCanBeFoundByEmail(){
        joinWaitingListResponse = userService.joinWaitingList(waitingListRequest);
        assertNotNull(joinWaitingListResponse.getId());
        Optional<User> foundUser = userService.getUserByEmail(joinWaitingListResponse.getEmail());
        assertTrue(foundUser.isPresent());
    }

    @Test
    void testThatAUserCanBeFoundById(){
        joinWaitingListResponse = userService.joinWaitingList(waitingListRequest);
        assertNotNull(joinWaitingListResponse.getId());
        Optional<User> foundUser = userService.getUserById(joinWaitingListResponse.getId());
        assertTrue(foundUser.isPresent());
    }
    @Test
    void testThatAllUserInTheWaitingListCanBeViewedByAdmin(){
        joinWaitingListResponse = userService.joinWaitingList(waitingListRequest);
        assertNotNull(joinWaitingListResponse.getId());
        List<User> users = userService.getAllUser();
        assertEquals(1,users.size());
    }
}
