package com.rajasekhar.app.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TodoController {

    @RequestMapping("todos")
    public String getAllTodos(ModelMap model) {
        var todos = TodoService.findByUsername("rajasekhar2307");
        model.put("todos", todos);
        return "todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addNewTodoView(ModelMap model){
        Todo todo = new Todo(0, (String)model.get("name"), "", LocalDate.now(), false);
        model.put("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "addTodo";
        }

        TodoService.addNewTodo((String)model.get("name"),todo.getDescription(), LocalDate.now(), false);
        return "redirect:todos";
    }

    @RequestMapping("/delete")
    public String deleteTodo(@RequestParam int id){
        TodoService.deleteTodoById(id);
        return "redirect:todos";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = TodoService.findTodoById(id);

        model.put("todo", todo);

        return "updateTodo";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTodoPage(Todo todo, BindingResult result, ModelMap model){

        if(result.hasErrors()){
            return "updateTodo";
        }
        todo.setUsername((String)model.get("name"));
        TodoService.updateTodoById(todo);

        return "redirect:todos";
    }
}
