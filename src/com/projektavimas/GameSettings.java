package com.projektavimas;

public class GameSettings {

    private int mineCount;
    private int fieldBorderLength;

    public GameSettings() {
    }

    public GameSettings(int mineCount, int fieldBorderLength) {
        this.mineCount = mineCount;
        this.fieldBorderLength = fieldBorderLength;
    }

    public static GameSettings createGameSettings() {
        return new GameSettings();
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public void setFieldBorderLength(int fieldBorderLength) {
        this.fieldBorderLength = fieldBorderLength;
    }

    public int getMineCount() {
        return mineCount;
    }

    public int getFieldBorderLength() {
        return fieldBorderLength;
    }
}
