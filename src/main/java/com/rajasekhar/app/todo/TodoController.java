package com.rajasekhar.app.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    @RequestMapping("todos")
    public String getAllTodos(ModelMap model) {
        var todos = TodoService.findByUsername("rajasekhar");
        model.put("todos", todos);
        return "todos";
    }
}
