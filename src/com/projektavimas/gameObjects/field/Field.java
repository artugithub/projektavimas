package com.projektavimas.gameObjects.field;

import com.projektavimas.gameObjects.cell.RandomCell;
import com.projektavimas.GameSettings;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private GameSettings gameSettings;
    private List<List<RandomCell>> fieldArray = new ArrayList<>();

    public Field() {
    }

    public Field(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void setFieldSize(int size) {
        this.fieldArray = new ArrayList<>();
    }

    public int getBorderSize() {
        return gameSettings.getFieldBorderLength();
    }

    public List<List<RandomCell>> getFieldArray() {
        return fieldArray;
    }

    public void printOutCellsStatus() {
        List<List<RandomCell>> fieldMatrix = getFieldArray();
        for (int i = 0; i < fieldMatrix.size(); i++) {
            for (int j = 0; j < fieldMatrix.get(i).size(); j++) {
                RandomCell currentRandomCell = fieldMatrix.get(i).get(j);
                if (j == fieldMatrix.size() - 1) {
                    System.out.print(currentRandomCell.getStatus().toString() + "\n");
                } else {
                    System.out.print(currentRandomCell.getStatus().toString() + " ");
                }
            }
        }
    }

    public void printOutCellsMineCount() {
        List<List<RandomCell>> fieldMatrix = getFieldArray();
        for (int i = 0; i < fieldMatrix.size(); i++) {
            for (int j = 0; j < fieldMatrix.get(i).size(); j++) {
                RandomCell currentRandomCell = fieldMatrix.get(i).get(j);
                if (j == fieldMatrix.size() - 1) {
                    System.out.print(currentRandomCell.getAdjacentMineCount() + "\n");
                } else {
                    System.out.print(currentRandomCell.getAdjacentMineCount() + " ");
                }
            }
        }
    }

    public void printOutCellsIsMine() {
        List<List<RandomCell>> fieldMatrix = getFieldArray();
        for (int i = 0; i < fieldMatrix.size(); i++) {
            for (int j = 0; j < fieldMatrix.get(i).size(); j++) {
                RandomCell currentRandomCell = fieldMatrix.get(i).get(j);
                if (j == fieldMatrix.size() - 1) {
                    System.out.print(currentRandomCell.isMine() + "\n");
                } else {
                    System.out.print(currentRandomCell.isMine() + " ");
                }
            }
        }
    }
}
