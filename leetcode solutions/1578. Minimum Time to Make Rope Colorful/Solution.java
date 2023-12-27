/**
 * 1578. Minimum Time to Make Rope Colorful
 * 
 * Intuition
 * 
 * credits vRohith
 * It is evident from the question that we need to parse the colors, if we find
 * two consecutive colors we will discard one of them
 * It looks colors cost is sorted in ascending order but it is not,
 * we need to find min among them and discard it as we want to keep cost
 * minimum, which will be added in res and keep the max one for further
 * operation
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int minCost(String colors, int[] neededTime) {

        int n = colors.length();
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                res += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return res;
    }
}