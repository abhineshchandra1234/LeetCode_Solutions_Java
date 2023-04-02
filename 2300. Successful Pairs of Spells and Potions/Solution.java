/**
 * 2300. Successful Pairs of Spells and Potions
 * 
 * Intuition
 * The naive approach is to multiply all spells with potions check which is
 * successful pair and increase its count
 * We can optimize it further by sorting the potions and repeating the same
 * process as above
 * Since it is a sorted array we can apply binary search to potions to find
 * minIndex for successful pair, rest elements after minIndex will satisfy the
 * conditions by default.
 * 
 * Approach
 * We will first sort potions
 * Then we will traverse through spells
 * We will apply binary search on a potion to find the index of the successful
 * pair
 * Then we will calculate total pairs by subtracting minIndex from potion length
 * I have used right as potion length, in case of no result it will point to m
 * and not the last index which is incorrect.
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] res = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int minInd = binarySearch(potions, success, spells[i]);
            res[i] = potions.length - minInd;
        }

        return res;
    }

    private int binarySearch(int[] potions, long success, int spell) {

        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            long product = 1l * spell * potions[mid];
            if (product < success)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}