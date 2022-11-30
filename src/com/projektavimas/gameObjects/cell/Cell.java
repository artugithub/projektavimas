package com.projektavimas.gameObjects.cell;

public class Cell extends AbstractCell {

    private Position position;
    private Status status;

    public Cell() {
    }

    public Cell(Position position, Status status) {
        this.position = position;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition() {

    }
}
