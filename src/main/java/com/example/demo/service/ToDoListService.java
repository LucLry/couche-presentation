package com.example.demo.service;

import com.example.demo.model.ToDoList;

public class ToDoListService {
    private ToDoList toDoList = new ToDoList();

    public String addItem(String name, String description) {
        return toDoList.addItem(name, description);
    }

    public boolean deleteItem(String name) {
        return toDoList.deleteItem(name);

    }

    public String readItem(String name) {
        return toDoList.getToDoList().get(name);
    }
}
