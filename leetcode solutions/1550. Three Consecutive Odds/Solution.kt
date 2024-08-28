/* 
1550. Three Consecutive Odds

Intuition

    given integer array arr
    return true if there is three consecutive odd nos otherwise return false
    we will count consecutive odd, if the curr no is odd increase the count else reset it
    when the count is 3 return true else return false at the end

Approach
Complexity

    Time complexity: O(n)

    Space complexity: O(1)

*/



class Solution {

    fun threeConsecutiveOdds(arr: IntArray): Boolean {

        var consecutive = 0

        for (i in 0..arr.size - 1) {
            if (arr[i] % 2 != 0) consecutive++ else consecutive = 0

            if (consecutive == 3) return true
        }

        return false
    }
}
