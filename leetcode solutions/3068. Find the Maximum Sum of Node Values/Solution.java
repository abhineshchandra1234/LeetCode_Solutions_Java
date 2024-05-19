/**
 * 3068. Find the Maximum Sum of Node Values
 * 
 * Intuition
 * Given
 * 
 * An undirected graph, with 1 root and multiple childs
 * 
 * Target
 * 
 * Tranform nodes or not but find max sum of graph
 * 
 * Solution
 * 
 * we will solve this problem through greedy
 * we can either transform 2 nodes or even count and add in res
 * or we can transform 1 node and sacrifice some value of the other node and add
 * in res
 * we are assuming greedily that if we take max of node value or its
 * transformation, it will lead to max sum but we need to take care of
 * sacrifices too
 * we will try to transform all the nodes whose xor value with k is greater than
 * its value
 * If the tranform node count is even, then there would be no loss as both will
 * be converted and added to res
 * If the transform node count is odd, there would be some loss of other node
 * value
 * This min loss is happening only once as there is only one parent, and we will
 * not transform other lossy nodes
 * Finally we will subtract min sacrifice from res, if the tranformed node count
 * is odd and return the res
 * 
 * Approach
 * 
 * //even transform nodes
 * Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
 * Output: 6
 * if we transform edge [0,2]
 * 
 * //odd transform nodes
 * Input: nums = [7,1,7,7,7,7], k = 3, edges = [[0,1],[0,2],[0,3],[0,4],[0,5]]
 * Output: 36
 * if we pick edge [0,1], there would be 7^3=4, 1^3=2
 * sacrifice 7-4=3, 1-2= 1
 * res = 7 + 2 + 7 + 7 + 7 + 7 - (1)
 * = 37 - 1
 * = 36
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        long res = 0;
        int count = 0;
        long sacrifice = Integer.MAX_VALUE;

        for (int n : nums) {
            res += Math.max(n, n ^ k);

            if ((n ^ k) > n)
                count++;

            sacrifice = Math.min(sacrifice, Math.abs(n - (n ^ k)));
        }

        return res - (count % 2 == 1 ? sacrifice : 0);
    }
}