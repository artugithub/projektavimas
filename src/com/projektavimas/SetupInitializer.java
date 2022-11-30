package com.projektavimas;

import com.projektavimas.gameObjects.InputManager;
import com.projektavimas.gameObjects.View;
import com.projektavimas.gameObjects.cell.Position;
import com.projektavimas.gameObjects.cell.RandomCellBuilder;
import com.projektavimas.gameObjects.field.Field;
import com.projektavimas.gameObjects.field.FieldCellsManager;
import com.projektavimas.gameObjects.field.FieldPopulator;
import com.projektavimas.utils.Utils;

public class SetupInitializer {

    private GameSettings gameSettings;
    private FieldPopulator fieldPopulator;
    private FieldCellsManager fieldCellsManager;
    private InputManager inputManager;

    public SetupInitializer(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void start() {
        Field field = new Field(gameSettings);
        fieldCellsManager = new FieldCellsManager(field);

        View view = new View(getFieldCellsManager());
        inputManager = new InputManager(gameSettings, view, new Position(), Utils.getScanner());
        inputManager.setupField();

        RandomCellBuilder randomCellBuilder = new RandomCellBuilder(gameSettings);

        fieldPopulator = new FieldPopulator(field, randomCellBuilder);
        fieldPopulator.populateField();
        fieldCellsManager.setCellsMineCount();
        fieldCellsManager.setCellsNeighbours();
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public FieldPopulator getFieldPopulator() {
        return fieldPopulator;
    }

    public FieldCellsManager getFieldCellsManager() {
        return fieldCellsManager;
    }

    public InputManager getInputManager() {
        return inputManager;
    }
}
