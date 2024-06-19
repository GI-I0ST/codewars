package com.ghost.stop_gninnips_my_sdrow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpinWordsTest {
    @Test
    void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }

}