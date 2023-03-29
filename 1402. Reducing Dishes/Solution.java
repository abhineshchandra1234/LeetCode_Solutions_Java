/**
 * 1402. Reducing Dishes
 * 
 * Intuition
 * If we cook some dishes, they should be the most satisfying dishes among all
 * dishes
 * We will cook the least satisfied dishes first and the most satisfied the last
 * If we add some dishes to the list all dishes will be cooked 1 unit time later
 * 
 * Approach
 * we will sort the array to get the most satisfactory dish at the last
 * then we will traverse through the array from the last so that the most
 * satisfied
 * dish is cooked at last.
 * if the total satisfaction + curr dish satisfaction is not negative we will
 * add it to total satisfaction.
 * we do this, as it will decrease its max satisfaction value which will
 * decrease max like-time coefficient if we add any -ve value
 * then we will add this total to res as all dishes will be cooked 1 unit of
 * Time
 * later. res represents the sum of the max like-time coefficient.
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
class Solution {
    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);
        int res = 0, total = 0, n = satisfaction.length;
        for (int i = n - 1; i >= 0; i--) {
            if (satisfaction[i] + total > 0) {
                total += satisfaction[i];
                res += total;
            }
        }
        return res;
    }
}