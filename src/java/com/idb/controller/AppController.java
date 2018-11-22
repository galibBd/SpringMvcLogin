package com.idb.controller;

import com.idb.model.Users;
import com.idb.service.AppService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    AppService appService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showloginForm() {
        ModelAndView model = new ModelAndView();
        Users users = new Users();
        model.getModelMap().put("login", users);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processForm(ModelAndView model, Users users) {
      List<Users> user = appService.checkUser(users.getName(), users.getPassword()); 
        if (user.size() > 0 ) {
               return "redirect:success.htm";
        }else{
            return "redirect:error.htm";
        }   
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView showRegForm() {
        ModelAndView model = new ModelAndView();
        Users users = new Users();
        List<Users> user = appService.grtAll();
        model.getModelMap().put("index", users);
        model.getModelMap().put("users", user);

        return model;
    }
    


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String addUser(ModelAndView model, Users users) {
        appService.add(users);
        model.getModelMap().put("index", users);
        return "redirect:login.htm";
    }

    
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView showSuccess() {
        ModelAndView model = new ModelAndView();
        Users users = new Users();
        model.getModelMap().put("success", users);
        return model;
    }
    
     @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView showError() {
        ModelAndView model = new ModelAndView();
        Users users = new Users();
        model.getModelMap().put("error", users);
        return model;
    }
}
