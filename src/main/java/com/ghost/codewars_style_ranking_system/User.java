package com.ghost.codewars_style_ranking_system;

public class User {

    private static final int PROGRESS_MAX = 100;
    private static final int RANK_MAX = 8;
    private static final int RANK_NOT_AVAILABLE = 0;

    public int rank = -8;
    public int progress = 0;

    public User() {
    }

    public void incProgress(int taskLevel) {
        if (taskLevel < -8 || taskLevel == RANK_NOT_AVAILABLE || taskLevel > 8) {
            throw new IllegalArgumentException("Invalid parameter. Should be -8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8");
        }

        progress += calcProgressValue(taskLevel);
        checkProgress();
    }

    private int calcProgressValue(int taskLevel) {
        if (taskLevel == rank) {
            return 3;
        }

        boolean changedSign = taskLevel * rank < 0;
        if (!changedSign) {
            if (taskLevel == rank - 1) {
                return 1;
            }
            if (taskLevel < rank - 1) {
                return 0;
            }

            return 10 * (int) Math.pow(rank - taskLevel, 2);
        } else {
            if (taskLevel == rank - 2) {
                return 1;
            }
            if (taskLevel < rank - 3) {
                return 0;
            }

            return 10 * (int) Math.pow(Math.abs(rank - taskLevel) - 1, 2);
        }
    }

    private void checkProgress() {
        while (progress >= PROGRESS_MAX) {
            if (rank <= RANK_MAX) {
                if (rank == RANK_NOT_AVAILABLE - 1) {
                    rank += 2;
                } else {
                    rank++;
                }
            }

            progress -= PROGRESS_MAX;
        }

        if (rank == RANK_MAX) {
            progress = 0;
        }
    }
}
