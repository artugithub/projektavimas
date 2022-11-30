package com.projektavimas.gameObjects.field;

import com.projektavimas.gameObjects.cell.RandomCell;
import com.projektavimas.GameSettings;

import java.util.ArrayList;

public class Field {

    private GameSettings gameSettings;
    private ArrayList<ArrayList<RandomCell>> fieldArray = new ArrayList<>();

    public Field() {
    }

    public Field(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void setFieldSize(int size) {
        this.fieldArray = new ArrayList<ArrayList<RandomCell>>();
    }

    public int getBorderSize() {
        return gameSettings.getFieldBorderLength();
    }

    public ArrayList<ArrayList<RandomCell>> getFieldArray() {
        return fieldArray;
    }

    public void printOutCellsStatus() {
        ArrayList<ArrayList<RandomCell>> fieldMatrix = getFieldArray();
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
        ArrayList<ArrayList<RandomCell>> fieldMatrix = getFieldArray();
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
        ArrayList<ArrayList<RandomCell>> fieldMatrix = getFieldArray();
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
