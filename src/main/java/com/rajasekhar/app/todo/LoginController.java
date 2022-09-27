package com.rajasekhar.app.todo;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationService authService;

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password,
                                  ModelMap model
    ) {

        if(authService.authenticate(name, password)){
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }
        return "login";
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
}
