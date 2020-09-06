package com.tokopedia.climbingstairs

object Solution {
    fun climbStairs(n: Int): Int {
        // TODO, return in how many distinct ways can you climb to the top. Each time you can either climb 1 or 2 steps.
        // 1 <= n < 90
        return climb_Stairs(0, n)
    }
    fun climb_Stairs(i:Int, n:Int):Int {
        if (i > n)
        {
            return 0
        }
        if (i == n)
        {
            return 1
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n)
    }
}

