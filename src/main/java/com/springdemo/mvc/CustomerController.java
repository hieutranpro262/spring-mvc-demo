package com.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        theModel.addAttribute("theCustomer", new Customer());

        return "customer-form";
    }

    @RequestMapping({"/", "/homepage"})
    public String showPage() {
        return "main-menu";
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("theCustomer") Customer theCustomer, 
            BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-confirm";
    }

}
