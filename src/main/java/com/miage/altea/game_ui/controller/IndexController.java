package com.miage.altea.game_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    // TODO
    @PostMapping("/registerTrainer")
    ModelAndView registerNewTrainer(String trainerName){
        Map<String, String> map = new HashMap<>();
        map.put("name", trainerName);
        return new ModelAndView("register", map);
    }
}
