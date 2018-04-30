package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/funny")
public class HomeController {

    @RequestMapping({"/", "/homepage"})
    public String showPage() {
        return "main-menu";
    }

    @RequestMapping("/showform")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processform")
    public String processForm() {
        return "helloworld";
    }

    // new controller method to read form data and add data to the model
    @RequestMapping("/processformuppercase")
    public String turnItUp(
            @RequestParam("studentName") String name, Model model) {
        name = name.toUpperCase();
         
        model.addAttribute("name", name + name);
        
        return "helloworld";
    }

}
