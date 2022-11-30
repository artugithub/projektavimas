package com.projektavimas.gameObjects.cell;

import com.projektavimas.GameSettings;

public class RandomCellBuilder implements CellBuilder {

    private GameSettings gameSettings;

    public RandomCellBuilder(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public RandomCell buildRandomCell(Position position) {
        if (generateIfMineIs() != 0) {
            return buildCell(position, Status.UNOPENED, 0, true);
        } else {
            return buildCell(position, Status.UNOPENED, 0, false);
        }
    }

    public int generateIfMineIs() {
        return (int)Math.floor(Math.random()*2);
    }

    public RandomCell buildCell(Position position, Status status, int adjacentMineCount, boolean isMine) {
        return new RandomCell(position, status, adjacentMineCount, isMine);
    }

    @Override
    public RandomCell buildCell() {
        return new RandomCell();
    }
}
