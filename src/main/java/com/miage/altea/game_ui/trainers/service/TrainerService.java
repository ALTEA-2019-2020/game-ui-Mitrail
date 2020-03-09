package com.miage.altea.game_ui.trainers.service;

import com.miage.altea.game_ui.trainers.bo.Trainer;
import org.springframework.stereotype.Service;

public interface TrainerService {

    public Trainer getTrainer(String name);

}
