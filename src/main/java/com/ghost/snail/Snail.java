package com.ghost.snail;

public class Snail {

    public static int[] snail(int[][] array) {
        int eAmount = isTrickyInput(array) ? 0 : array.length * array.length; //n*n array by description
        int[] result = new int[eAmount];
        int[] axisLimits = new int[] {array.length - 1, array.length};
        int[] axisModificators = new int[] {1, 1};
        int axisFlag = 1;
        int eCounter = 0;
        int x = 0;
        int y = -1;

        while (eCounter < eAmount) {
            for (int i = 0; i < axisLimits[axisFlag]; i++) {
                if (axisFlag == 0) {
                    x += axisModificators[axisFlag];
                } else {
                    y += axisModificators[axisFlag];
                }

                result[eCounter++] = array[x][y];
            }

            axisLimits[axisFlag] = axisLimits[axisFlag] - 1;
            axisModificators[axisFlag] = axisModificators[axisFlag] * (-1);
            if (axisFlag == 0) {
                axisFlag = 1;
            } else {
                axisFlag = 0;
            }

        }

        return result;
    }

    private static boolean isTrickyInput(int[][] array) {
        return array == null || array.length == 0 || array[0] == null || array[0].length == 0;
    }
}