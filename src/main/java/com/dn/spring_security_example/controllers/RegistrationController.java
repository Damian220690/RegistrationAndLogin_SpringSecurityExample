package com.dn.spring_security_example.controllers;

import com.dn.spring_security_example.model.User;
import com.dn.spring_security_example.model.UserDto;
import com.dn.spring_security_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user" , new UserDto());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String processLogForm(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result){
        User existingUser = userService.findByEmail(userDto.getEmail());
        if(existingUser != null){
            result.rejectValue("email",null, "There is already an account registered with that email");
        }
        if(result.hasErrors()){
            return "registrationForm";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
