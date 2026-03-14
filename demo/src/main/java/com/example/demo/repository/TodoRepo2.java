package com.example.demo.repository;


import com.example.demo.dtos.CreateTodoDto;
import com.example.demo.schema.Todo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class TodoRepo2 implements TodoRepo {
    @Override
    public List<Todo> getAllTodo() {
        List<Todo> todoList = new ArrayList<>();
        todoList.add(new Todo("3", "third"));
        todoList.add(new Todo("4", "fourth"));

        return todoList;
    }

    @Override
    public void updateTodo(String todoId, String todoTitle) {
        System.out.println("deleted todo");
    }

    @Override
    public void deleteTodo(String todoId) {
        System.out.println("deleted todo");
    }

    @Override
    public Todo addTodo(Todo todo) {

    }
}
