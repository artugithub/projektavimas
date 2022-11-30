package com.projektavimas.gameObjects;

import com.projektavimas.gameObjects.cell.RandomCell;
import com.projektavimas.gameObjects.cell.Status;
import com.projektavimas.gameObjects.field.FieldCellsManager;

import java.util.ArrayList;

public class View {

    private FieldCellsManager fieldCellsManager;

    public View(FieldCellsManager fieldCellsManager) {
        this.fieldCellsManager = fieldCellsManager;
    }

    public void setupFieldSize() {
        System.out.print("\nEnter game board length (for e.g. 3 means 3x3 size, which is a minimum size): ");
    }

    public void selectColumn() {
        System.out.print("\nEnter column: ");
    }

    public void selectRow() {
        System.out.print("\nEnter row: ");
    }

    public void printField() {
        System.out.print("\t");
        ArrayList<ArrayList<RandomCell>> fieldMatrix = fieldCellsManager.getField().getFieldArray();
        for(int i = 0; i < fieldMatrix.size(); i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print("\n\n");
        for (int i = 0; i < fieldMatrix.size(); i++) {
            System.out.print(i + " " + "\t");
            for (int j = 0; j < fieldMatrix.get(i).size(); j++) {
                RandomCell currentRandomCell = fieldMatrix.get(i).get(j);
                ifCellUnopened(currentRandomCell);
                ifCellOpened(currentRandomCell);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void ifCellUnopened(RandomCell randomCell) {
        if (randomCell.getStatus() == Status.UNOPENED && !randomCell.isAdjacentMinesShown()) {
            System.out.print(" " + "?" + " ");
        }
        if (randomCell.getStatus() == Status.UNOPENED && randomCell.isAdjacentMinesShown()) {
            System.out.print(" " + randomCell.getAdjacentMineCount() + " ");
        }
    }

    public void ifCellOpened(RandomCell randomCell) {
        if (randomCell.getStatus() == Status.OPENED) {
            if (randomCell.isMine()) {
                System.out.print(" " + "X" + " ");
            }
            if (randomCell.getAdjacentMineCount() == 0) {
                System.out.print(" " + " " + " ");
            } else if (randomCell.getAdjacentMineCount() > 0) {
                System.out.print(" " + randomCell.getAdjacentMineCount() + " ");
            }
        }
    }

    public void printMessage(String string) {
        System.out.print(string);
    }
}
