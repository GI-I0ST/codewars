package com.ghost.battleshi_field_validator;

public class BattleField {
    private static final int FIELD_LENGTH = 10;

    public static boolean fieldValidator(int[][] field) {
        int size1 = 0;
        int size2 = 0;
        int size3 = 0;
        int size4 = 0;

        try {
            for (int y = 0; y < FIELD_LENGTH; y++) {
                for (int x = 0; x < FIELD_LENGTH; x++) {
                    int size = getShipSize(field, x, y);
                    switch (size) {
                        case 0 -> {}
                        case 1 -> size1++;
                        case 2 -> size2++;
                        case 3 -> size3++;
                        case 4 -> size4++;
                        default -> throw new UnsupportedPositionException(); //size more than available
                    }
                }
            }
        } catch (UnsupportedPositionException e) {
            return false;
        }

        return size1 == 4 && size2 == 3 && size3 == 2 && size4 == 1;
    }

    private static int getShipSize(int[][] field, int x, int y) {
        boolean isVertical = isValidPosition(x, y + 1) && field[y + 1][x] == 1;
        boolean isHorizontal = isValidPosition(x + 1, y) && field[y][x + 1] == 1;

        if (isHorizontal && isVertical) throw new UnsupportedPositionException();

        if (!isHorizontal && !isVertical && field[y][x] == 1) {
            checkNeighbourPositions(field, x, y, true);
            checkNeighbourPositions(field, x, y, false);

            return 1;
        }

        int size = 0;
        if (isHorizontal) {
            int i = x;
            while (i < FIELD_LENGTH) {
                if (field[y][i] == 0) break;
                checkNeighbourPositions(field, i, y, true);
                size++;
                i++;
            }
        }
        if (isVertical) {
            int i = y;
            while (i < FIELD_LENGTH) {
                if (field[i][x] == 0) break;
                checkNeighbourPositions(field, x, i, false);
                size++;
                i++;
            }
        }

        deleteShip(field, x, y, isHorizontal, size);
        return size;
    }

    private static void checkNeighbourPositions(int[][] field, int x, int y, boolean isHorizontal) {
        int[][] neighborOffsets;

        if (isHorizontal) {
            neighborOffsets = new int[][]{
                    {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}
            };
        } else {
            neighborOffsets = new int[][]{
                    {0, -1}, {-1, -1}, {1, -1}, {0, 1}, {-1, 1}, {1, 1}
            };
        }

        for (int[] offset : neighborOffsets) {
            int newX = x + offset[1];
            int newY = y + offset[0];

            if (isValidPosition(newX, newY) && field[newY][newX] == 1) {
                throw new UnsupportedPositionException();
            }
        }
    }

    private static void deleteShip(int[][] field, int x, int y, boolean isHorizontal, int size) {
        for (int i = 0; i < size; i++) {
            field[y][x] = 0;
            if (isHorizontal) {
                x++;
            } else {
                y++;
            }
        }
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0
                && x < FIELD_LENGTH
                && y >= 0
                && y < FIELD_LENGTH;
    }

    public static class UnsupportedPositionException extends RuntimeException {
        public UnsupportedPositionException() {
            super();
        }
    }
}