package dev.chiba.todoapp.service;

import dev.chiba.todoapp.domain.Todo;
import dev.chiba.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository repo;

    @Override
    public List<Todo> getToDoList() {
        return repo.findAll();
    }

    @Override
    public Todo getTodo(int id) {
        Optional<Todo> todo = repo.findById(id);
        return todo.orElse(null);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return repo.save(todo);
    }

    @Override
    public boolean deleteTodo(int id) {
        boolean deleted = false;
        Optional<Todo> todo = repo.findById(id); 
        if(todo.isPresent()){
            repo.delete(todo.get());
            deleted = true;
        }
        return deleted;
    }
    public Todo updateTodo(Todo old, Todo newTodo){
        old.setDesc(newTodo.getDesc());
        old.setTitle(newTodo.getTitle());
        old.setScheduleOn(newTodo.getScheduleOn());
        old.setType(newTodo.getType());

     return  repo.save(old);
    }


}
