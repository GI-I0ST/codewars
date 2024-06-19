package com.ghost.maximum_subarray_sum;

public class Max {
    public static int sequence(int[] arr) {
        int maxSum = 0;
        int currSum = 0;

        for (int j : arr) {
            currSum = currSum + j;
            if (maxSum < currSum)
                maxSum = currSum;
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}