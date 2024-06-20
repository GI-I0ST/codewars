package com.ghost.perimeter_of_squares_in_a_rectangle;

import java.math.BigInteger;

public class SumFct {

    public static BigInteger fibonacci(BigInteger n) {
        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;
        BigInteger curr = BigInteger.ONE;

        for (BigInteger i = BigInteger.valueOf(3); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            curr = n1.add(n2);
            n1 = n2;
            n2 = curr;
        }

        return curr;
    }

    public static BigInteger fibonacciSum(BigInteger n) {
        return fibonacci(n.add(BigInteger.valueOf(2))).subtract(BigInteger.ONE);
    }

    public static BigInteger perimeter(BigInteger n) {
        return fibonacciSum(n.add(BigInteger.ONE)).multiply(BigInteger.valueOf(4)); //strange task's condition for n
    }
}