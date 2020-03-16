package com.miage.altea.game_ui.trainers.service;

import com.miage.altea.game_ui.trainers.bo.Trainer;

public interface TrainerService {

    Trainer getTrainer(String name);
    Trainer[] allTrainers();

}
