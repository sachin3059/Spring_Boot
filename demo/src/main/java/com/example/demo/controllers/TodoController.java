package com.example.demo.controllers;


import com.example.demo.dtos.CreateTodoDto;
import com.example.demo.schema.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/getAll")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/addTodo")
    public void addTodo(@RequestBody CreateTodoDto createTodoDto) {
         todoService.addTodo(createTodoDto);
    }

    @PutMapping("/updateTodo")
    public String updateTodo(@RequestBody CreateTodoDto createTodoDto) {
        return todoService.updateTodo(createTodoDto);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public String deleteTodo(@RequestParam int id) {
        return todoService.deleteTodo(id);
    }


    //  create more api and play around it.

}
