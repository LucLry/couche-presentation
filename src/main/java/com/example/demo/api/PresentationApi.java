package com.example.demo.api;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PresentationApi {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    public PresentationApi(UserService userService, TaskService taskService){
        this.userService = userService;
        this.taskService = taskService;

    }

    @PostMapping("/saveTask")
    public Task saveTask (@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @GetMapping("/allTasks")
    public List<Task> findAllTasks (){
        return taskService.findAllTasks();
    }

    @GetMapping("/getTask/{id}")
    public Task findTaskById(@PathVariable Long id){
        Optional<Task> optionalTask = taskService.findTaskById(id);
        if (optionalTask.isPresent()){
            return optionalTask.get();
        }else{
            return null;
        }
    }

    @GetMapping("/deleteTask/{id}")
    public Boolean deleteTaskById(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }



    @PostMapping("/saveUser")
    public User saveUser (@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/allUsers")
    public List<User> findAllUsers (){
        return userService.findAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User findUserById(@PathVariable Long id){
        Optional<User> optionalUser = userService.findUserById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            return null;
        }
    }

    @GetMapping("/deleteUser/{id}")
    public Boolean deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }
}
