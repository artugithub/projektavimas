package com.projektavimas.gameObjects.cell;

import com.projektavimas.GameSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RandomRandomCellBuilderTest {

    private Position positionMock;
    private Status testStatus;
    private RandomCell testRandomCell;
    private RandomCellBuilder randomCellBuilder;

    @BeforeEach
    void setUp() {
       GameSettings gameSettingsMock = mock(GameSettings.class);
       positionMock = mock(Position.class);
       testStatus = Status.UNOPENED;
       randomCellBuilder = new RandomCellBuilder(gameSettingsMock);
    }

    @Test
    void buildRandomCell() {
        testRandomCell = randomCellBuilder.buildRandomCell(positionMock);
        assertNotNull(testRandomCell);
    }

    @Test
    void generateIfMineIs_returnsZeroOrOneRandomly() {
        int intToTest = randomCellBuilder.generateIfMineIs();
        assertEquals(intToTest, 1, 1);
    }

    @Test
    void buildCell_generatesCell_WhenStatusUnopenedAndMineTrue() {
        testRandomCell = randomCellBuilder.buildCell(positionMock, testStatus, 0, true);
        assertNotNull(testRandomCell);
    }

    @Test
    void buildCell_generatesCell_WhenStatusUnopenedAndMineFalse() {
        testRandomCell = randomCellBuilder.buildCell(positionMock, testStatus, 0, false);
        assertNotNull(testRandomCell);
    }
}