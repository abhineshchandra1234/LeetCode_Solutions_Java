/*
2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

Intuition

    given the head of the linked list
    return an array of length 2, containing min and max distance between two critical points
    if there are less than 2 critical points return [-1, -1]
    A critical point is local minima or maxima
    that is curr value is strictly greater or lower than previous and next node
    so end nodes of the list cannot be critical points

Approach

    As evident in the question, we need to traverse from second node from start till second last node
    max distance will be difference of first and last critical point
    min distance will be min difference of any two consecutive critical points
    we will solve it using two ptrs, first ptr will point to curr node and will be used for traversal
    second ptr will point to previous node
    Both these ptrs will help in comparison for critical points
    we will also maintain curr index and prev critical index to calculate minima
    we will use first critical index and prev critical index at end to calculate maxima

Complexity

    Time complexity: O(n)

    Space complexity:O(1)

*/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {

    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {

        var res = intArrayOf(-1, -1)
        var dis = Int.MAX_VALUE
        var curr: ListNode? = head?.next
        var prev: ListNode? = head
        var currInd = 1
        var prevCric = 0
        var firstCric = 0

        while (curr != null && curr.next != null && prev != null && prev.next != null) {
            if (
                (curr.`val` > prev.`val` && curr.`val` > curr.next.`val`) ||
                    (curr.`val` < prev.`val` && curr.`val` < curr.next.`val`)
            ) {
                if (prevCric == 0) {
                    firstCric = currInd
                } else {
                    dis = min(dis, currInd - prevCric)
                }
                prevCric = currInd
            }
            currInd++
            prev = curr
            curr = curr.next
        }

        if (dis != Int.MAX_VALUE) {
            res[0] = dis
            res[1] = prevCric - firstCric
        }

        return res
    }
}
