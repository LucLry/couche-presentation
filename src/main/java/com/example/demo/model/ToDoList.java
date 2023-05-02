package com.example.demo.model;

import java.util.HashMap;

import lombok.Getter;

@Getter
public class ToDoList {
    HashMap<String, String> toDoList = new HashMap<>();

    public String addItem(String name, String description) {
        return toDoList.put(name, description);
    }

    public boolean deleteItem(String name) {
        return toDoList.remove(name) != null;
    }

    public String readItem(String name) {
        return toDoList.get(name);
    }
}
