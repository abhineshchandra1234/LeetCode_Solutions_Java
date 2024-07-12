/*
1717. Maximum Score From Removing Substrings

Intuition

    we are given a string s and two integers x and y
    we can can perform two operations any no of times on s
    remove 'ab' and gain x points
    remove 'ba' and gain y points
    return max points you can gain by doing by above operations

Approach

    As evident in the question we will use greedy approach to solve it
    we will first remove high priority pair from the string and add its score to res
    similarly do it for low priority pair using above modified string
    then finally return the res
    to remove pair from the string we will use stack

Complexity

    Time complexity: O(n), removing pairs

    Space complexity: O(n), using stack to remove pairs

*/
class Solution {

    fun maximumGain(s: String, x: Int, y: Int): Int {
        var res = 0
        val highPair = if (x > y) "ab" else "ba"
        val lowPair = if (highPair.equals("ab")) "ba" else "ab"

        val highString = helper(s, highPair)
        var removedPair = (s.length - highString.length) / 2

        res += removedPair * max(x, y)

        val lowString = helper(highString, lowPair)
        removedPair = (highString.length - lowString.length) / 2

        res += removedPair * min(x, y)

        return res
    }

    private fun helper(s: String, p: String): String {
        var st = ArrayDeque<Char>()

        for (char in s) {
            if (!st.isEmpty() && char == p[1] && st.last() == p[0]) st.removeLast()
            else st.addLast(char)
        }

        var new = StringBuilder()
        while (!st.isEmpty()) {
            new.append(st.removeLast())
        }

        return new.reverse().toString()
    }
}
