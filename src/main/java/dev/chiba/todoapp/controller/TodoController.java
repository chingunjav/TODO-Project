package dev.chiba.todoapp.controller;

import dev.chiba.todoapp.domain.Todo;
import dev.chiba.todoapp.service.TodoService;
import dev.chiba.todoapp.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/")
public class TodoController {
    @Autowired
    public TodoServiceImpl service;

    @PostMapping("/create")
    public Todo createTodo(@RequestBody Todo todo){
        return service.saveTodo(todo);
    }

    @GetMapping("/list")
    public List<Todo> listTodo(){
        return service.getToDoList();
    }

    @GetMapping("/get/{id}")
    public Todo getTodo(@PathVariable int id){
          return service.getTodo(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody Todo todo){
       try{
           Todo existTodo = service.getTodo(id);
           service.updateTodo(existTodo, todo);
           return new ResponseEntity<>(existTodo, HttpStatus.OK);
       }catch(NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/todo/id")
    public boolean deleteTodo(@PathVariable Integer id){
        return service.deleteTodo(id);
    }

}
