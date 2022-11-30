package com.projektavimas.gameObjects.cell;

public class Position {

    private int col;
    private int row;

    public Position() {
    }

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void setColRow(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public Position getPosition() {
        return this;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
