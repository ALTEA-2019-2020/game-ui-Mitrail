package com.miage.altea.game_ui.pokemonTypes.bo;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PokemonType {

    private int id;
    private int baseExperience;
    private int height;
    private String name;
    private Sprites sprites;
    private Stats stats;
    private int weight;
    private List<String> types;



}
