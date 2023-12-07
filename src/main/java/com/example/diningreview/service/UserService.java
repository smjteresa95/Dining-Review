package com.example.diningreview.service;

import com.example.diningreview.model.dto.UsersDto;
import com.example.diningreview.model.entity.Users;
import com.example.diningreview.repository.UserRepository;
import com.example.diningreview.service.mapper.Mapper;
import com.example.diningreview.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface{

    private final UserRepository repository;
    private final Mapper mapper;

    @Override
    public void addUser(UsersDto dto){
        if(!ValidationUtils.isValidZipcode(dto.getZipcode())){
            throw new IllegalArgumentException("invalid zipcode");
        }
        repository.save(dto.toEntity());
    }

    public UsersDto findByName(String name){
        Optional<Users> users = repository.findByName(name);
        if(!users.isPresent()){
            throw new NoSuchElementException("User not found by name");
        }
        return mapper.usersToDto(users.get());
    }
}
