package com.tartner.dancehours;

import com.tartner.utilities.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Assert.assertEquals(23L, Solution.findMultiples(10L));
        Assert.assertEquals(233333333166666668L,
            Solution.findMultiples(1000000000L));
    }
}
