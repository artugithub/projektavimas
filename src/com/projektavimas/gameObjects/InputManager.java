package com.projektavimas.gameObjects;

import com.projektavimas.GameSettings;
import com.projektavimas.gameObjects.cell.Position;

import java.util.Scanner;

public class InputManager {

    private GameSettings gameSettings;
    private View view;
    private Position playerCellPosition;
    private  Scanner scanner;

    public InputManager(GameSettings gameSettings, View view, Position playerCellPosition, Scanner scanner) {
        this.gameSettings = gameSettings;
        this.view = view;
        this.playerCellPosition = playerCellPosition;
        this.scanner = scanner;
    }

    public void setupField() {
        int i = 0;
        while(i < 3) {
            view.setupFieldSize();
            i = scanner.nextInt();
            if (i < 3) {
               view.printMessage("\nTry at least 3 or higher");
            }
        }
        gameSettings.setFieldBorderLength(i);
    }

    public Position getPlayerCellPosition() {
        int column = getInput();
        int row = getInput();
        playerCellPosition.setColRow(column, row);
        return playerCellPosition;
    }

    public int getInput() {
        int i = -1;
        boolean isWrong = true;
        while(isWrong) {
            view.selectColumn();
            i = scanner.nextInt();
            isWrong = validatePositionInput(i);
        }
        return i;
    }

    public boolean validatePositionInput(int i) {

        if (i < 0 || i >= gameSettings.getFieldBorderLength()) {
            view.printMessage("\nValue must be within board size (0 - " + (gameSettings.getFieldBorderLength() - 1) +")");
            return true;
        } else {
            return false;
        }
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
            System.out.println("Closing");
        }
    }
}
