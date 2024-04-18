package com.ghost.codewars_style_ranking_system;

import java.util.List;

public class UserV2 {
    private static final List<Integer> RANKS = List.of(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8);
    private static final int RANK_MAX = 15;
    private static final int PROGRESS_MAX = 100;

    private int internalRank = 0;
    public int rank = -8;
    public int progress = 0;

    public UserV2() {
    }

    // Only for test
    public void setInternalRank(int internalRank) {
        this.internalRank = internalRank;
    }

    public void incProgress(int taskLevel) {
        if (!RANKS.contains(taskLevel)) {
            throw new IllegalArgumentException("Invalid parameter. Should be -8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8");
        }

        progress += calcProgressValue(publicTaskLevelToInternalLevel(taskLevel));
        checkProgress();
        rank = RANKS.get(internalRank);
    }

    private static int publicTaskLevelToInternalLevel(int publicTaskLevel) {
        int result = publicTaskLevel + 8;
        if (publicTaskLevel > 0) {
            result -= 1;
        }
        return result;
    }

    private int calcProgressValue(int internalTaskLevel) {
        if (internalTaskLevel == internalRank) {
            return 3;
        }

        if (internalTaskLevel == internalRank - 1) {
            return 1;
        }

        if (internalTaskLevel < internalRank - 1) {
            return 0;
        }

        return 10 * (int) Math.pow(internalTaskLevel - internalRank, 2);
    }

    private void checkProgress() {
        internalRank += progress / PROGRESS_MAX;
        progress = progress % PROGRESS_MAX;

        if (internalRank >= RANK_MAX) {
            internalRank = RANK_MAX;
            progress = 0;
        }
    }
}
