package com.rajasekhar.app.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int count = 0;

    public static List<Todo> findByUsername(String username) {
        return todos;
    }

    public static void addNewTodo(String username,String description, LocalDate date, Boolean isDone) {
        todos.add(
                new Todo(++count, username, description, date, isDone)
        );
    }

    public static void deleteTodoById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;

        todos.removeIf(predicate);
    }

    public static Todo findTodoById(int id) {
        Todo filteredTodo = todos.stream().filter(todo -> todo.getId()==id).findAny().orElse(null);

        return filteredTodo;
    }

    public static void updateTodoById(Todo todo){
        deleteTodoById(todo.getId());
        todos.add(todo);
    }

}
