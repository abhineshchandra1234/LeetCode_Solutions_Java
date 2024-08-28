/**
1823. Find the Winner of the Circular Game

Intuition

    we are given integers n and k, and we need to return the winner of the game
    n represents players standing in the circle
    we can move in the clockwise direction
    we need to remove the kth player starting from first player
    we will repeat this process from next player in clockwise direction till there is only 1 player left in the circle
    we will solve this problem using simulation through queue

Approach

    we will solve it using queue
    add all nos to queue first
    then run a loop till there is single no left
    remove k-1 nos and add them to queue again
    remove kth no
    Finally return the last no of the queue

Complexity

    Time complexity: O(nk), removing k-1 nos for n-1 nos

    Space complexity: O(n)

**/
class Solution {

    fun findTheWinner(n: Int, k: Int): Int {

        var q: Queue<Int> = LinkedList()

        for (i in 1..n) q.add(i)

        while (q.size > 1) {
            for (i in 0..k - 2) q.add(q.poll())
            q.poll()
        }

        return q.peek()
    }
}
