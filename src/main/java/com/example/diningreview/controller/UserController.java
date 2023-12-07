package com.example.diningreview.controller;

import com.example.diningreview.model.dto.UsersDto;
import com.example.diningreview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UsersDto dto){
        service.addUser(dto);
        return ResponseEntity.ok().build();
    }


}
