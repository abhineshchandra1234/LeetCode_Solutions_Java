/**
 * 646. Maximum Length of Pair Chain
 * 
 * Intuition
 * 
 * we will solve this problem through greedy approach
 * since question ask us to return a chain where b[0] > a[1].
 * So we will sort the pairs array based on a[1],b[1]
 * this way we are discarding all the equal a[1]==b[0] pairs, and the chain will
 * have unique a[1],b[0] pairs as the question demands
 * we can have pairs [1,4],[4,5],[7,10]
 * here we are discarding [4,5] bcs we need strictly increasing b[0].
 * pairs [10,40],[30,40], here we can pick any pair since they are displacing
 * same value 40 and next b[0] should be greater than 40.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curr = Integer.MIN_VALUE;
        int ans = 0;

        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                ans++;
                curr = pair[1];
            }
        }
        return ans;
    }
}