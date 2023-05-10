package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private RestTemplate restTemplate;


    public List<User> findAllUsers(){

        ResponseEntity<List<User>> response = restTemplate.exchange(
                "http://localhost:8081/allUsers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        );
        return response.getBody();
    }
    public User saveUser (User user ){
        return restTemplate.postForObject(
                "http://localhost:8081/saveUser",
                user,
                User.class
        );
    }

    public Optional<User> findUserById(Long id) {
        User user = restTemplate.getForObject("http://localhost:8081/getUser/"+ id, User.class);
        return Optional.ofNullable(user);
    }

    public boolean deleteUserById(Long id){
        return Boolean.TRUE.equals(restTemplate.getForObject("http://localhost:8081/deleteUser/"+ id, boolean.class));
    }

}
