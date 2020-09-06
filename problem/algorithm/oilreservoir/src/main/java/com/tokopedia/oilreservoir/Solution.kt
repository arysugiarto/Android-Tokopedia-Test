package com.tokopedia.oilreservoir

/**
 * Created by fwidjaja on 2019-09-24.
 */
object Solution {
    fun collectOil(height: IntArray): Int {
        // TODO, return the amount of oil blocks that could be collected
        // below is stub
        var result = 0
        var start = 0
        var end = height.size - 1
        while (start < end) {
            if (height[start] <= height[end]) {
                val current = height[start]
                while (height[++start] < current) {
                    result += current - height[start]
                }
            } else {
                val current = height[end]
                while (height[--end] < current) {
                    result += current - height[end]
                }
            }
        }
        return result
    }
}
