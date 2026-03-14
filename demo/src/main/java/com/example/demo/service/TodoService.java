package com.example.demo.service;


import com.example.demo.dtos.CreateTodoDto;
import com.example.demo.repository.TodoRepo;
import com.example.demo.schema.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    TodoRepo todoRepo;
    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> getAllTodos() {
        return todoRepo.getAllTodo();
    }

    public String updateTodo(CreateTodoDto todo) {
        return "updated successfully";
    }

    public String deleteTodo(int id) {
        return "deleted successfully";
    }

    public String addTodo(CreateTodoDto createTodoDto) {
        return "added successfully";
    }
}
