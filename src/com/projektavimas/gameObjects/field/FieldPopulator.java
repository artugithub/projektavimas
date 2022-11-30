package com.projektavimas.gameObjects.field;

import com.projektavimas.gameObjects.cell.RandomCell;
import com.projektavimas.gameObjects.cell.Position;
import com.projektavimas.gameObjects.cell.RandomCellBuilder;

import java.util.ArrayList;
import java.util.List;

public class FieldPopulator {

    private Field fieldToPopulate;
    private RandomCellBuilder randomCellBuilder;

    public FieldPopulator(Field fieldToPopulate, RandomCellBuilder randomCellBuilder) {
        this.fieldToPopulate = fieldToPopulate;
        this.randomCellBuilder = randomCellBuilder;
    }

    public void populateField() {
        List<List<RandomCell>> fieldMatrix = fieldToPopulate.getFieldArray();
        for (int i = 0; i < fieldToPopulate.getBorderSize(); i++) {
            fieldMatrix.add(new ArrayList<RandomCell>());
            for (int j = 0; j < fieldToPopulate.getBorderSize(); j++) {
                Position cellPosition = new Position(i, j);
                RandomCell randomCell = randomCellBuilder.buildRandomCell(cellPosition);
                fieldMatrix.get(i).add(randomCell);
            }
        }
    }
}
