// 3867. Sum of GCD of Formed Pairs

/**
 * Intuition
 * First we will construct mx array by comparing curr no with existing max and
 * taking max of both
 * Then we will construct preGcd array by taking gcd of curr no and mx at curr
 * index
 * Then we will sort preGcd as question asks
 * then we will use two ptrs, one pointing to start of preGcd and other pointing
 * to last of preGcd
 * we will form pairs using both ptrs, take their sum and store in res
 * Finally return the res
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] mx = new int[n];
        int preMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            preMax = Math.max(preMax, nums[i]);
            mx[i] = preMax;
        }

        int[] preGcd = new int[n];
        for (int i = 0; i < n; i++) {
            preGcd[i] = gcd(nums[i], mx[i]);
        }

        Arrays.sort(preGcd);

        long res = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            res += gcd(preGcd[l], preGcd[r]);
            l++;
            r--;
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}