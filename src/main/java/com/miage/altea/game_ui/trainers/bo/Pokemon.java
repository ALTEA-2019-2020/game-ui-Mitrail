package com.miage.altea.game_ui.trainers.bo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    private int pokemonTypeId;
    private int level;
}
