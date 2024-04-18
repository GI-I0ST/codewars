package com.ghost.codewars_style_ranking_system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserV2Test {
    UserV2 user = new UserV2();
    private void do_test(int rank, int expectedRank, int expectedProgress) {
        if(rank!=0) user.incProgress(rank);
        assertEquals(expectedRank, user.rank);
        assertEquals(expectedProgress, user.progress);
    }
    @Test
    void testIncProgress() throws Exception {
        do_test(-8, -8, 3);

        user = new UserV2();
        do_test(-7, -8, 10);

        user = new UserV2();
        do_test(-6, -8, 40);

        user = new UserV2();
        do_test(-5, -8, 90);

        user = new UserV2();
        do_test(-4, -7, 60);

        user = new UserV2();
        do_test(-8, -8, 3);

        user = new UserV2();
        do_test(1, -2, 40);
        do_test(1, -2, 80);
        do_test(1, -1, 20);
        do_test(1, -1, 30);
        do_test(1, -1, 40);
        do_test(2, -1, 80);
        do_test(2, 1, 20);
        do_test(-1, 1, 21);
    }

    @Test
    void myTest() {
        user = new UserV2();
        user.setInternalRank(14);
        user.rank = 7;
        user.progress = 31;
        do_test(8, 7, 41);
    }

    @Test
    void myTest2() {
        user = new UserV2();
        user.setInternalRank(14);
        user.rank = 7;
        user.progress = 91;
        do_test(8, 8, 0);
    }
}