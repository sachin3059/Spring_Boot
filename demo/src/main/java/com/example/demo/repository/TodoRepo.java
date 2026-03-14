package com.example.demo.repository;

import com.example.demo.schema.Todo;

import java.util.List;

public interface TodoRepo {
    List<Todo> getAllTodo();
    void updateTodo(String todoId, String todoTitle);
    void deleteTodo(String todoId);
    Todo addTodo(Todo todo);
}
