package com.example.demo.repository;


import com.example.demo.dtos.CreateTodoDto;
import com.example.demo.schema.Todo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TodoRepo1 implements TodoRepo {

    private List<Todo> todoList = new ArrayList<>(Arrays.asList(new Todo("1", "first"), new Todo("2", "second")));


    @Override
    public List<Todo> getAllTodo() {
        return todoList;
    }

    @Override
    public void updateTodo(String todoId, String todoTitle) {
        System.out.println("updated todo");
    }

    @Override
    public void deleteTodo(String todoId) {
        System.out.println("deleted todo");
    }

    @Override
    public Todo addTodo(Todo todo) {
        todoList.add(todo);
        return todo;
    }
}
