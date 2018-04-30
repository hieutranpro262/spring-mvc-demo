package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping({"/", "/homepage"})
    public String showPage() {
        return "main-menu";
    }

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        // creating a new student object
        Student theStudent = new Student();

        // add object to model
        theModel.addAttribute("theStudent", theStudent);

        return "student-form";
    }
    
    @RequestMapping("/processForm")
    public String processForm(
            @ModelAttribute("theStudent") Student theStudent) {

        // log the input data
        System.out.println(theStudent.getLastName() + 
                "--" + theStudent.getFirstName() + 
                "--" + theStudent.getCountry());

        return "student-confirm";
    }
}
