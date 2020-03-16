package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.game_ui.trainers.bo.Pokemon;
import com.miage.altea.game_ui.trainers.bo.Trainer;
import com.miage.altea.game_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @GetMapping
    ModelAndView allTrainers() {
        String currentPrincipal = ((Trainer)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
        Trainer currentUser = trainerService.getTrainer(currentPrincipal);
        List<PokemonType> pokemons = currentUser.getTeam().stream()
                .map((Pokemon p) -> pokemonTypeService.getPokemonType(p.getPokemonTypeId()))
                .collect(Collectors.toList());
        Map<String, Object> map = new HashMap<>();
        map.put("user", currentUser);
        map.put("pokemons", pokemons);
        return new ModelAndView("profil", map);
    }
}
