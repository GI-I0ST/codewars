package com.ghost.battleshi_field_validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static int[][] battleField = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                                          {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                                          {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                                          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                          {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                                          {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                                          {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                                          {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                                          {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    @Test
    void SampleTest() {
        assertEquals(true, BattleField.fieldValidator(battleField));
    }
}