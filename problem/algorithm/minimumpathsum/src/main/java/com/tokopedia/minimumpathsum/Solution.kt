package com.tokopedia.minimumpathsum

import java.util.ArrayList

object Solution {
    fun minimumPathSum(matrix: Array<IntArray>): Int {
        // TODO, find a path from top left to bottom right which minimizes the sum of all numbers along its path, and return the sum
        // below is stub

        val m = matrix.size // OK
        var n = -1 // column
        if (m != 0) {
            n = matrix[0].size
        }
        val A = Array<IntArray>(m, {IntArray(n)})
        for (i in 0 until m)
        {
            for (j in 0 until n)
            {
                if (i == 0 || j == 0)
                {
                    if (i == 0 && j != 0)
                    {
                        A[i][j] = A[i][j - 1] + matrix[i][j] // first row value equal to the previous value plus the current value of a
                    }
                    else if (i != 0 && j == 0)
                    {
                        A[i][j] = A[i - 1][j] + matrix[i][j] // first column value plus the current value is equal to the lattice
                    }
                    else
                    {
                        A[i][j] = matrix[i][j] // start point to itself as a starting point the value of
                    }
                }
                else
                {
                    A[i][j] = Math.min(A[i][j - 1] + matrix[i][j], A[i - 1][j] + matrix[i][j])
                }
            }
        }
        return A[m - 1][n - 1]
    }
}

