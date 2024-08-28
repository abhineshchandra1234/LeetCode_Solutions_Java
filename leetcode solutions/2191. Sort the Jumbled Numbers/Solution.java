/**
 * 2191. Sort the Jumbled Numbers
 * 
 * Intuition
 * we are given integer array mappings, where mapping[i] = j, means digit i
 * should be mapped to digit j
 * we are also given integer array nums
 * we need to sort nums in increasing order based on mapped value obtained after
 * converting its nos
 * if the mapped value is equal follow the relative order given in the question
 * 
 * 
 * Approach
 * we will traverse nums and generate its mapped value
 * we will store this mapped value along with index in a list
 * we will then simply sort the list based on mapped value,
 * if they are equal we will use index for sorting, we can skip this step, as
 * mapped value is already stored serially and will remain same after sorting
 * one edge case is of generating mapped value of 0, in this we need to directly
 * add value as we are generating mapped values of nos greater than 0
 * then we will traverse list, assign values to res and return it, the index
 * will also be used to fetch the values of nums
 * 
 * 
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(n), storing mapped values, res
 */

class Solution {

    public int[] sortJumbled(int[] mapping, int[] nums) {

        int n = nums.length;
        List<int[]> l = new ArrayList();

        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            int place = 1;
            int value = 0;

            if (temp == 0) {
                l.add(new int[] { mapping[0], i });
                continue;
            }
            while (temp != 0) {
                value = place * mapping[temp % 10] + value;
                place *= 10;
                temp /= 10;
            }
            l.add(new int[] { value, i });
        }

        Collections.sort(l, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[l.get(i)[1]];
        }
        return res;
    }
}