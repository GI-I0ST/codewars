package com.ghost.perimeter_of_squares_in_a_rectangle;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumFctTest {

    @Test
    void test1() {
        assertEquals(BigInteger.valueOf(80), SumFct.perimeter(BigInteger.valueOf(5)));
    }
    @Test
    void test2() {
        assertEquals(BigInteger.valueOf(216), SumFct.perimeter(BigInteger.valueOf(7)));
    }

    @Test
    void test3() {
        assertEquals(BigInteger.valueOf(14098308), SumFct.perimeter(BigInteger.valueOf(30)));
    }
}
