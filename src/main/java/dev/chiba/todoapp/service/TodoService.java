package dev.chiba.todoapp.service;

import dev.chiba.todoapp.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoService  {
    List<Todo> getToDoList();
    Todo getTodo(int id);
    Todo saveTodo(Todo todo);
    Todo updateTodo(Todo old, Todo todo);
    boolean deleteTodo(int id);
}
