// 3514. Number of Unique XOR Triplets II

/**
 * Intuition
 * we will first find the max no in nums
 * then we would find T, which is equal 2^power greater than max no
 * our xor max value will be less than or equal to T
 * then we have taken two arrays
 * first array will store xor values of all the pairs
 * second array will store xor values of all the triplets ie xor of pairs and
 * all the nums
 * Next we will count all the triplets and return it as the ans
 * Approach
 * 
 * Complexity
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int T = 1;
        while (T <= max) {
            T <<= 1;
        }

        boolean[] s1 = new boolean[T];
        boolean[] s2 = new boolean[T];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        for (int i = 0; i < T; i++) {
            if (s1[i] == true) {
                for (int num : nums) {
                    s2[i ^ num] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < T; i++) {
            if (s2[i] == true)
                count++;
        }
        return count;
    }
}