package com.projektavimas.gameObjects.cell;

import java.util.ArrayList;

public class RandomCell extends Cell {

    private int adjacentMineCount;
    private boolean isMine;
    private boolean isAdjacentMinesShown;
    private ArrayList<RandomCell> neighbors = new ArrayList<>();

    public RandomCell() {
        super();
    }

    public RandomCell(Position position, Status status, int adjacentMineCount, boolean isMine) {
        super(position, status);
        this.adjacentMineCount = adjacentMineCount;
        this.isMine = isMine;
    }

    public void increaseMineCount() {
        ++adjacentMineCount;
    }

    public void addNeighBor(RandomCell randomCell) {
        neighbors.add(randomCell);
    }

    public void setNeighbors(ArrayList<RandomCell> neighbors) {
        this.neighbors = neighbors;
    }

    public ArrayList<RandomCell> getNeighbors() {
        return neighbors;
    }

    public Status getStatus() {
        return super.getStatus();
    }

    public void setStatus(Status status) {
        super.setStatus(status);
    }

    public int getAdjacentMineCount() {
        return adjacentMineCount;
    }

    public void setAdjacentMineCount(int adjacentMineCount) {
        this.adjacentMineCount = adjacentMineCount;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isAdjacentMinesShown() {
        return isAdjacentMinesShown;
    }

    public void setAdjacentMinesShown(boolean adjacentMinesShown) {
        isAdjacentMinesShown = adjacentMinesShown;
    }

    @Override
    public void setPosition() {

    }
}

