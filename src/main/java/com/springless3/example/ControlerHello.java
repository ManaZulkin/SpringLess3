package com.springless3.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlerHello {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(){
        return "index.jsp";
    }

    @GetMapping(value = "/bye")
    public String bye(){
        return "bye.jsp";
    }

    @GetMapping(value = "/pass")
    public String pass(){
        return "pass.jsp";
    }

    @PostMapping(value = "/pass")
    public ModelAndView pass(@ModelAttribute("user") User user, ModelAndView modelAndView){
        System.out.println(user);
        modelAndView.setViewName("forward:summary.jsp");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
