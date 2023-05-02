package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ToDoListItem;
import com.example.demo.service.ToDoListService;

@RestController
public class ToDoListAPI {
    @Autowired
    private ToDoListService toDoListService;

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody ToDoListItem toDoListItem) {
        return ResponseEntity.ok(toDoListService.addItem(toDoListItem.getName(), toDoListItem.getDescription()));
    }

    @GetMapping("/delete/{name}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable String name) {
        return ResponseEntity.ok(toDoListService.deleteItem(name));
    }

    @GetMapping("/read/{name}")
    public ResponseEntity<ToDoListItem> readItem(@PathVariable String name) {
        ToDoListItem toDoListItem = new ToDoListItem(name, toDoListService.readItem(name));
        return ResponseEntity.ok(toDoListItem);
    }
}
