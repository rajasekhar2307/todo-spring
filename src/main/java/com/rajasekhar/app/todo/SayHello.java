package com.rajasekhar.app.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHello {

    @RequestMapping("say-hello")
    public String sayHelloWorld(){
        return "sayHello";
    }
}
