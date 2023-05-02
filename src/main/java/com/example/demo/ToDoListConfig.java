package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.ToDoListService;

@Configuration
public class ToDoListConfig {
    @Bean
    public ToDoListService toDoListServiceConfig() {
        return new ToDoListService();
    }
}
