/*
1380. Lucky Numbers in a Matrix

Intuition
given an n*m matrix, we need to return an array of lucky nos
a lucky no is min in its row and max in its col

Approach
we will solve this problem through simulation
we will traverse matrix row first and store min of each row
we will then traverse matrix col first and store max of each col
we will then traverse matrix and if curr no is max of its col and min of its row, add it to res
you compare using index of row and col

Complexity
Time complexity: O(m*n), traverse matrix
Space complexity: O(n), store max and min
*/
class Solution {

    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {

        var n = matrix.size
        var m = matrix[0].size

        val row = mutableListOf<Int>()
        for (i in 0 ..< n) {
            var min = Int.MAX_VALUE
            for (j in 0 ..< m) {
                min = minOf(min, matrix[i][j])
            }
            row.add(min)
        }

        val col = mutableListOf<Int>()
        for (i in 0 ..< m) {
            var max = Int.MIN_VALUE
            for (j in 0 ..< n) {
                max = maxOf(max, matrix[j][i])
            }
            col.add(max)
        }

        val res = mutableListOf<Int>()
        for (i in 0 ..< n) {
            for (j in 0 ..< m) {
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) res.add(matrix[i][j])
            }
        }

        return res
    }
}