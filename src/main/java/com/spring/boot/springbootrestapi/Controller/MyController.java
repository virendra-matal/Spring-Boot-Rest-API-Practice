package com.spring.boot.springbootrestapi.Controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    
    @GetMapping("/home")
    public String ShowHome( Model model){

        model.addAttribute("Name", "Virendra Matal");
        model.addAttribute("Date",new Date());
        return "Home";
    }

    @GetMapping("/about")
    public String ShowAbout( Model model){

        List<String> data = List.of("Virendra", "Vikram","Abhishek", "Sakshi");
        String Gender="F";
        model.addAttribute("Data", data);
        model.addAttribute("Gender",Gender);
        model.addAttribute("title", "I Love Java Coding...");
        model.addAttribute("subtitle", LocalDateTime.now().toString());
        return "about";
    }


    @GetMapping("/footer")
    public String ShowpagewithFooter(){

        return "Footer";
    }

    @GetMapping("/base")
    public String ShowbasePage(){

        return "Base";
    }

}
