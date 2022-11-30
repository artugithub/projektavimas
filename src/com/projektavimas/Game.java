package com.projektavimas;

public class Game {

    public void run() {
        GameSettings gameSettings = new GameSettings();
        SetupInitializer setupInitializer = new SetupInitializer(gameSettings);
        setupInitializer.start();

        GameRunner gameRunner = new GameRunner(setupInitializer);
        gameRunner.start();
    }
}
