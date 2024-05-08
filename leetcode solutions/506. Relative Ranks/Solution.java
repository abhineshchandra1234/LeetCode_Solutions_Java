/**
 * 506. Relative Ranks
 * 
 * Intuition
 * Given
 * 
 * we are given score of different athelets
 * 
 * Target
 * 
 * we need to return the rank of each athelete
 * 
 * Solution
 * 
 * If we sort the scores array, thier original index will be lost
 * So we will create a mapping of score and original index
 * we will sort this mapping based on score
 * Then we traverse mapping and assign rank based on original index in the res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {

            if (i == 0)
                res[pair[i][1]] = "Gold Medal";
            else if (i == 1)
                res[pair[i][1]] = "Silver Medal";
            else if (i == 2)
                res[pair[i][1]] = "Bronze Medal";
            else
                res[pair[i][1]] = (i + 1) + "";
        }

        return res;
    }
}