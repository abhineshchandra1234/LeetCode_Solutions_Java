/**
 * 2551. Put Marbles in Bags
 * 
 * Intuition
 * 
 * This problem is easy to solve, I explain how, Main hoon na :P
 * credits user7570L
 * If k=1 or n. min and max distribution will be same and thier diff will be 0.
 * In k=1, all marbles will go in 1 bag
 * In k=n, one marble will go in each bag
 * we can put k-1 bars between marbles.
 * First and last marble will be in all the sum(min & max) and will cancel each
 * other out.
 * We need to take care of 1 to n-1 marbles.
 * We can put bars from [0,n-2]. 0 will cover all marbles, n-2 will cover all
 * marbles till n-1 and last marble.
 * n-1 will all cover all marbles which 0 is already doing.
 * so for i in [0,n-2], weight[i]+weight[i+1] will be added in the sum.
 * we will sort this sum and pick least and max k-1 sums and find thier diff.
 * 
 * Approach
 * 
 * Input: weights = [1,3,5,1], k = 2
 * Output: 4
 * for min put bar at 0
 * (1+1) + (3+1) = 6
 * for max put bat at 1
 * (1+3) + (5+1) = 10
 * so you can see first & last elements are added in both sum
 * min - weight[i] + weight[i+1] = 1 + 3 = 4
 * max - weight[i] + weight[i+1] = 3 + 5 = 8
 * ans = max - min = 8 - 4 = 4.
 * I am so smart :P
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting
 * 
 * Space complexity:
 * 
 * O(n), data on which sorting happend :P
 * 
 */
class Solution {
    public long putMarbles(int[] weights, int k) {

        int n = weights.length;
        if (k == 1 || k == n)
            return 0;

        List<Integer> candidates = new ArrayList();
        for (int i = 0; i < n - 1; i++)
            candidates.add(weights[i] + weights[i + 1]);
        Collections.sort(candidates);
        long min = 0, max = 0;
        for (int i = 0; i < k - 1; i++) {
            min += candidates.get(i);
            max += candidates.get(n - 2 - i);
        }
        return max - min;
    }
}