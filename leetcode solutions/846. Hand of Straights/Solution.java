/**
 * 846. Hand of Straights
 * 
 * Intuition
 * 
 * we will solve this problem with greedy approach using priorityqueue
 * we will pick smallest no from the queue and generate rest nos of its group,
 * since all nos are consecutive in a group
 * we will remove all nos of the curr group from the queue, and keep doing it
 * till the queue is empty
 * If we do not find no of the group in queue return false, else return true at
 * the end.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : hand)
            pq.add(n);

        while (!pq.isEmpty()) {
            int start = pq.poll();

            for (int i = 1; i < groupSize; i++)
                if (!(pq.remove(start + i)))
                    return false;
        }

        return true;
    }
}