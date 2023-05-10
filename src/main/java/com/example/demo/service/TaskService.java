package com.example.demo.service;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private RestTemplate restTemplate;


    public List<Task> findAllTasks(){
        return Collections.singletonList(restTemplate.getForObject("http://localhost:8081/allTasks", Task.class));
    }

    public Task saveTask (Task task ){
        return restTemplate.postForObject(
                "http://localhost:8081/saveTask",
                task,
                Task.class
        );
    }

    public Optional<Task> findTaskById(Long id) {
        Task Task = restTemplate.getForObject("http://localhost:8081/getTask/"+ id, Task.class);
        return Optional.ofNullable(Task);
    }


    public boolean deleteTaskById(Long id){
        return Boolean.TRUE.equals(restTemplate.getForObject("http://localhost:8081/deleteTask/"+ id, boolean.class));
    }
}
