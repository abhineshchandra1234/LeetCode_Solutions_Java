/*
2181. Merge Nodes in Between Zeros

Intuition

    we are given head of the linked list, contains a series of integers separated by 0s
    start and end of the linked list is 0
    we need to do following operations on the linked list
    merge all the nodes in between two consecutive 0s, by taking their sum
    return the modified list without any zeros
    we will solve it using two ptrs
    first ptr will traverse the list and sec ptr will help to calculate sum
    both ptr will initially point to non-zero node ie head.next
    †o calculate sum we will add one more condition to first ptr
    we will move it till we do not encounter 0, and calculate sum
    once we encounter zero, we will store sum to sec ptr
    move first ptr to non-zero node ie next block
    link sec ptr to first ptr ie non-zero node ie next block
    then make sec pr point to first ptr

Approach
Complexity

    Time complexity: O(n)

    Space complexity: O(1)


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

    fun mergeNodes(head: ListNode?): ListNode? {

        var nextSum: ListNode? = head?.next
        var modify: ListNode? = nextSum

        while (nextSum != null) {
            var sum = 0

            while (nextSum != null && nextSum.`val` != 0) {
                sum += nextSum.`val`
                nextSum = nextSum?.next
            }

            modify?.`val` = sum
            nextSum = nextSum?.next
            modify?.next = nextSum
            modify = nextSum
        }

        return head?.next
    }
}