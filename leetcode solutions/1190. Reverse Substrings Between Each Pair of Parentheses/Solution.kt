/*
1190. Reverse Substrings Between Each Pair of Parentheses

Intuition

    we are given an string s, consisting of lowercase letters and brackets
    we need to reverse sub-strings between brackets, and return it
    we need to start operations from the innermost bracket

Approach

    As evident in the question we need to solve it using StringBuilder and Stack
    But how to solve it using Stack
    we need to add all chars to StringBuilder eventually
    we will store index of open parenthesis in Stack
    when we encounter close parenthesis, we will pop top no of stack which will represent start of a sub-string
    for reverse start will be Stack top and end will be curr size of StringBuilder, reverse just this part and leave rest
    Finally return StrinBuilder as a res by converting it to a string

Complexity

    Time complexity: O(n^2), in worst case we need to reverse the whole string many times

    Space complexity: O(n), for stack

*/
class Solution {
    fun reverseParentheses(s: String): String {

        var stack = ArrayDeque<Int>()
        var sb = StringBuilder()
        var i = 0

        for (char in s) {
            when (char) {
                '(' -> stack.addLast(sb.length)
                ')' -> {
                    val start = stack.removeLast()
                    reverse(sb, start, sb.length - 1)
                }
                else -> {
                    sb.append(char)
                }
            }
        }
        return sb.toString()
    }

    private fun reverse(sb: StringBuilder, start: Int, end: Int) {
        var s = start
        var e = end
        while (s < e) {
            val temp = sb[e]
            sb.setCharAt(e--, sb[s])
            sb.setCharAt(s++, temp)
        }
    }
}
