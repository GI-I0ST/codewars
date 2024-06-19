package com.ghost.maximum_subarray_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSequenceTest {
    @Test
    void testEmptyArray() throws Exception {
        assertEquals(0, Max.sequence(new int[]{}));
    }
    @Test
    void testExampleArray() throws Exception {
        assertEquals(6, Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}