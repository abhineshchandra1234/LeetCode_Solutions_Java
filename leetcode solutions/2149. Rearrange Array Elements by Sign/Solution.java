/**
 * 2149. Rearrange Array Elements by Sign
 * 
 * Intuition
 * 
 * we will solve this problem using two ptrs for index.
 * Initially both ptrs will point to initial index of pos and neg nos ie 0 & 1
 * Then we will traverse each no and check if it is pos or neg
 * we will add pos no at pos idx and increase it by 2 and same we will do for
 * neg no
 * we cannot do it inplace as we can have many pos or neg nos continously, and
 * if we change the nos, we cannot access it later as ptrs will point to changed
 * nos
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), parsing each no once
 * 
 * Space complexity: O(1), res array has some value
 * 
 */
class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int posIdx = 0, negIdx = 1;

        for (int no : nums) {
            if (no > 0) {
                ans[posIdx] = no;
                posIdx += 2;
            } else {
                ans[negIdx] = no;
                negIdx += 2;
            }
        }

        return ans;
    }
}