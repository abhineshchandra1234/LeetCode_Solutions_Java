/*
1605. Find Valid Matrix Given Row and Column Sums

Intuition
we are given two two integer arrays rowSum and colSum
where rowSumi is the sum of nos of ith row and colSumj is the sum of nos of jth col of a 2d matrix
total rowSum is equal to colSum
we need to return a 2d matrix of dimensions rowSum.length * colSum.length, that satisfy above conditions


Approach
From the question it is evident that we need to assign some min value to curr cell and fill rest of the cell with remaining value and reduce it from respective rowSum and colSum
we will solve this problem greedily
so this min value will be min of rowSum and colSum, for that particular row and col
we will take min value so that one of the row or col criteria is satisfied
Since one of the criteria is satisfied we can move to next row or col as rest of the cells will be 0


Complexity
Time complexity: O(m*n)
Space complexity: O(1)

*/
class Solution {

    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {

        var n = rowSum.size
        var m = colSum.size

        var res = Array(n) { IntArray(m) }
        var i = 0
        var j = 0

        while (i < n && j < m) {
            res[i][j] = minOf(rowSum[i], colSum[j])
            rowSum[i] -= res[i][j]
            colSum[j] -= res[i][j]

            if (rowSum[i] == 0) i++

            if (colSum[j] == 0) j++
        }

        return res
    }
}