package com.projektavimas.gameObjects.field;

import com.projektavimas.gameObjects.cell.RandomCell;
import com.projektavimas.gameObjects.cell.Position;
import com.projektavimas.gameObjects.cell.Status;
import com.projektavimas.utils.Utils;

import java.util.ArrayList;

public class FieldCellsManager {

    private Field field;

    public FieldCellsManager(Field field) {
        this.field = field;
    }

    public void revealNeighbors(RandomCell randomCell) {
        if (randomCell.getStatus() != Status.OPENED && !randomCell.isMine()) {
            randomCell.setStatus(Status.OPENED);
            if (randomCell.getAdjacentMineCount() == 0) {
                for (RandomCell neighBoringRandomCell : randomCell.getNeighbors()) {
                    revealNeighbors(neighBoringRandomCell);
                }
            }
        } else {
            randomCell.setAdjacentMinesShown(true);
        }
    }

    public void setCellsMineCount() {
        ArrayList<ArrayList<RandomCell>> fieldMatrix = field.getFieldArray();
        for (int i = 0; i < fieldMatrix.size(); i++) {
            for (int j = 0; j < fieldMatrix.get(i).size(); j++) {
                RandomCell currentRandomCell = fieldMatrix.get(i).get(j);
                Position offsetPos = new Position(i, j);

                setMineCount(i - 1, j - 1, currentRandomCell, offsetPos, fieldMatrix); //NW

                setMineCount(i, j - 1, currentRandomCell, offsetPos, fieldMatrix); //N

                setMineCount(i + 1, j - 1, currentRandomCell, offsetPos, fieldMatrix); //NE

                setMineCount(i - 1, j, currentRandomCell, offsetPos, fieldMatrix); //W

                setMineCount(i + 1, j, currentRandomCell, offsetPos, fieldMatrix); //E

                setMineCount(i - 1, j + 1, currentRandomCell, offsetPos, fieldMatrix); //SW

                setMineCount(i, j + 1, currentRandomCell, offsetPos, fieldMatrix); //S

                setMineCount(i + 1, j + 1, currentRandomCell, offsetPos, fieldMatrix); //SE
            }
        }
    }

    public void setMineCount(int col, int row, RandomCell randomCell, Position position, ArrayList<ArrayList<RandomCell>> fieldMatrix) {
        position.setColRow(col, row);
        validateAndMineIncrease(randomCell, position, fieldMatrix);
    }

    public void validateAndMineIncrease(RandomCell randomCellToAdjust, Position offsetPos, ArrayList<ArrayList<RandomCell>> fieldMatrix) {
        if (isCellInBounds(offsetPos.getPosition(), fieldMatrix.size())  && fieldMatrix.get(offsetPos.getCol()).get(offsetPos.getRow()).isMine()) {

            randomCellToAdjust.increaseMineCount();
        }
    }

    public boolean isCellInBounds(Position offsetPosition, int bound) {
        if (!Utils.isValidIndex(offsetPosition.getCol(), bound)) {
            return false;
        }
        return Utils.isValidIndex(offsetPosition.getRow(), bound);
    }

    public void setCellsNeighbours() {
        ArrayList<ArrayList<RandomCell>> fieldMatrix = field.getFieldArray();
        for (int i = 0; i < fieldMatrix.size(); i++) {
            for (int j = 0; j < fieldMatrix.get(i).size(); j++) {
                RandomCell currentRandomCell = fieldMatrix.get(i).get(j);
                Position offsetPos = new Position(i, j);

                setNeighbor(i - 1, j - 1, currentRandomCell, offsetPos, fieldMatrix); //NW

                setNeighbor(i, j - 1, currentRandomCell, offsetPos, fieldMatrix); //N

                setNeighbor(i + 1, j - 1, currentRandomCell, offsetPos, fieldMatrix); //NE

                setNeighbor(i - 1, j, currentRandomCell, offsetPos, fieldMatrix); //W

                setNeighbor(i + 1, j, currentRandomCell, offsetPos, fieldMatrix); //E

                setNeighbor(i - 1, j + 1, currentRandomCell, offsetPos, fieldMatrix); //SW

                setNeighbor(i, j + 1, currentRandomCell, offsetPos, fieldMatrix); //S

                setNeighbor(i + 1, j + 1, currentRandomCell, offsetPos, fieldMatrix); //SE
            }
        }
    }

    public void setNeighbor(int col, int row, RandomCell randomCell, Position position, ArrayList<ArrayList<RandomCell>> fieldMatrix) {
        position.setColRow(col, row);
        setCellNeighbor(randomCell, position, fieldMatrix);
    }

    public void setCellNeighbor(RandomCell randomCellToAdjust, Position cellNeighborPos, ArrayList<ArrayList<RandomCell>> fieldMatrix) {
        if (isCellInBounds(cellNeighborPos, fieldMatrix.size())) {
            randomCellToAdjust.addNeighBor(fieldMatrix.get(cellNeighborPos.getCol()).get(cellNeighborPos.getRow()));
        }
    }

    public Field getField() {
        return field;
    }
}
