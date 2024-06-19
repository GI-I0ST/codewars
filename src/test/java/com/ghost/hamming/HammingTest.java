package com.ghost.hamming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingTests {

    @Test
    void Test1() {
        assertEquals(1L, Hamming.hamming(1));
        assertEquals(2L, Hamming.hamming(2));
        assertEquals(3L, Hamming.hamming(3));
        assertEquals(4L, Hamming.hamming(4));
        assertEquals(5L, Hamming.hamming(5));
        assertEquals(6L, Hamming.hamming(6));
        assertEquals(8L, Hamming.hamming(7));
        assertEquals( 9L, Hamming.hamming(8));
        assertEquals(10L, Hamming.hamming(9));
        assertEquals(12L, Hamming.hamming(10));
        assertEquals(15L, Hamming.hamming(11));
        assertEquals(16L, Hamming.hamming(12));
        assertEquals(18L, Hamming.hamming(13));
        assertEquals(20L, Hamming.hamming(14));
        assertEquals(24L, Hamming.hamming(15));
        assertEquals(25L, Hamming.hamming(16));
        assertEquals(27L, Hamming.hamming(17));
        assertEquals(30L, Hamming.hamming(18));
        assertEquals(32L, Hamming.hamming(19));
    }

}