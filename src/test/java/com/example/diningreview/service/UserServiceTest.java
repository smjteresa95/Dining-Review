package com.example.diningreview.service;

import com.example.diningreview.model.dto.UsersDto;
import com.example.diningreview.model.entity.Users;
import com.example.diningreview.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void addUserTest(){
        UsersDto requestedUser = UsersDto.builder()
                .name("name")
                .city("city")
                .state("state")
                .zipcode("12345")
                .hasDairyAllergies(false)
                .hasEggAllergies(false)
                .hasPeanutAllergies(true)
                .build();

        service.addUser(requestedUser);

        UsersDto foundUser = service.findByName("name");
        assertEquals(requestedUser.getState(),foundUser.getState());
    }

}
