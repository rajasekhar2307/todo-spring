package com.rajasekhar.app.todo.service;

import com.rajasekhar.app.todo.entity.Todo;
import com.rajasekhar.app.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int count = 0;

    @Autowired
    public TodoRepository todoRepository;

    public List<Todo> findByUsername(String username) {
        return todoRepository.findByUsername(username);
    }

    public void addNewTodo(String username,String description, LocalDate date, String isDone) {
        todoRepository.save(new Todo(0, username, description, date, isDone));
    }

    public void deleteTodoById(int id){
        todoRepository.deleteById(id);
    }

    public Todo findTodoById(int id) {
        return todoRepository.findById(id).get();
    }

    public void updateTodoById(Todo todo){
        todoRepository.save(todo);
    }

}
