package com.mybankonline.userfront.controller;

import com.mybankonline.userfront.domain.User;
import com.mybankonline.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model){
        User user = new User();

        model.addAttribute("user", user);

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user, Model model){

        if(userService.checkUserExists(user.getUsername(), user.getEmail())){

            if(userService.checkEmailExists(user.getEmail()))
                model.addAttribute("emailExist", true);
            if(userService.checkUsernameExists(user.getUsername()))
                model.addAttribute("usernameExist", true);
            return "signup";
        }else{

            userService.save(user);
            return "redirect:/";

//            Set<UserRole> userRoles = new HashSet<>();
//            userRoles.add(new UserRole(user, roleDao.findByName("USER")));
//            userService.craeteUser(user, userRoles);
//            return "redirect:/";
        }

    }
}
