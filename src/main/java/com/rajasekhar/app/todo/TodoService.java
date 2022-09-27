package com.rajasekhar.app.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
