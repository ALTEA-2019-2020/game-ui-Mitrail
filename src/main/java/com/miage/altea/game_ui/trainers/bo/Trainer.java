package com.miage.altea.game_ui.trainers.bo;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    private String name;
    private List<Pokemon> team;
}

