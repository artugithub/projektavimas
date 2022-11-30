package com.projektavimas.gameObjects;

import com.projektavimas.gameObjects.cell.Position;

public class Player {

    private Position position;

    public Player(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
