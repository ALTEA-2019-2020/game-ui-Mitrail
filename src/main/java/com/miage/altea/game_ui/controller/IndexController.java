package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.game_ui.trainers.bo.Pokemon;
import com.miage.altea.game_ui.trainers.bo.Trainer;
import com.miage.altea.game_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Controller
@RequestMapping("/")
public class IndexController {

    private TrainerService trainerService;

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @Autowired
    IndexController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/registerTrainer")
    public ModelAndView registerNewTrainer(String trainerName){
        Map<String, String> map = new HashMap<>();
        map.put("name", trainerName);
        return new ModelAndView("register", map);
    }

    @GetMapping("/trainers")
    public ModelAndView allTrainers() {
        String currentPrincipal = ((Trainer) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
        Trainer currentUser = trainerService.getTrainer(currentPrincipal);
        List<Trainer> trainers = Arrays.stream(trainerService.allTrainers())
                .filter(trainer -> !trainer.getName().equals(currentUser.getName()))
                .collect(Collectors.toList());

        trainers.forEach(trainer ->
                trainer.setTeamType(trainer.getTeam().stream()
                    .map((Pokemon p) -> pokemonTypeService.getPokemonType(p.getPokemonTypeId()))
                    .collect(Collectors.toList()))
        );
        Map<String, Object> map = new HashMap<>();
        // map.put("user", currentUser);
        map.put("trainers", trainers);
        return new ModelAndView("trainers", map);

    }
}
