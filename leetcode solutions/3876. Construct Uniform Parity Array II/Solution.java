// 3876. Construct Uniform Parity Array II

/**
 * Intuition
 * we can have all odd, if the smallest no is odd
 * for [3,2,4,6] we can generate all odd
 * like 3,3-2=1,4-3=1,6-3=3
 * when we have smallest no as even
 * we cannot convert whole array to even, if we have one odd
 * for [5,2,4,6]
 * in order to convert 5 to even we need one more smaller odd like 3 which is
 * absent
 * Finally return true, means array do not contain any odd nos and only even nos
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for (int num : nums1)
            min = Math.min(min, num);
        // all odd
        // 3,2,4,6
        if (min % 2 == 1)
            return true;

        // all even
        // smallest is even, we do not have smallest odd
        // like 5, 2,4,6, 3 is absent
        for (int num : nums1)
            if (num % 2 == 1)
                return false;

        return true;
    }
}