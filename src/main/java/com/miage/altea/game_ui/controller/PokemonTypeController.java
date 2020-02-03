package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PokemonTypeController {

    PokemonTypeService pokemonTypeService;

    @Autowired
    PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        Map<String, List<PokemonType>> map = new HashMap<>();
        map.put("pokemonTypes", pokemonTypeService.listPokemonsTypes());
        return new ModelAndView("pokedex", map);
    }

}
