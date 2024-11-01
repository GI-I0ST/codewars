package com.ghost.insane_coloured_triangles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    void examples() {
        assertEquals('B', Kata.triangle("B"));
        assertEquals('R', Kata.triangle("GB"));
        assertEquals('R', Kata.triangle("RRR"));
        assertEquals('B', Kata.triangle("RGBG"));
        assertEquals('G', Kata.triangle("RBRGBRB"));
        assertEquals('G', Kata.triangle("RBRGBRBGGRRRBGBBBGG"));

    }
}