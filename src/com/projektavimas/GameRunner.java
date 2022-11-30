package com.projektavimas;

import com.projektavimas.gameObjects.InputManager;
import com.projektavimas.gameObjects.Player;
import com.projektavimas.gameObjects.View;
import com.projektavimas.gameObjects.cell.RandomCell;
import com.projektavimas.gameObjects.cell.Position;
import com.projektavimas.gameObjects.field.FieldCellsManager;

import java.util.ArrayList;
import java.util.List;

public class GameRunner {

    private SetupInitializer setupInitializer;

    public GameRunner(SetupInitializer setupInitializer) {
        this.setupInitializer = setupInitializer;
    }

    public void start() {

        List<List<RandomCell>> cellMatrix = setupInitializer.getFieldCellsManager().getField().getFieldArray();
        View view = new View(setupInitializer.getFieldCellsManager());
        InputManager inputManager = setupInitializer.getInputManager();
        FieldCellsManager fieldCellsManager = setupInitializer.getFieldCellsManager();
        Position position = new Position();
        Player player = new Player(position);
        boolean isTrue = true;
        boolean isGameWon = false;
        while(isTrue) {
            view.printField();
            player.setPosition(inputManager.getPlayerCellPosition());
            RandomCell selectedRandomCell = cellMatrix.get(player.getPosition().getRow()).get(player.getPosition().getCol());
            fieldCellsManager.revealNeighbors(selectedRandomCell);
            if (selectedRandomCell.isMine()) {
                isTrue = false;
                view.printMessage("LOOSER");
            }
            if (isGameWon) {
                isTrue = false;
                view.printMessage("GOOD JOB");
            }
        }
        System.out.println();
        inputManager.closeScanner();
    }
}
