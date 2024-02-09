/**
 * 368. Largest Divisible Subset
 * 
 * Intuition
 * 
 * Suppose we have array [1, 16, 7, 8, 4], if we sort this array we will get [1,
 * 4, 7, 8, 16]
 * It is very simliar in logic with longest increasing subsequence, and uses
 * same code template
 * 
 * 1 -> 1 is divisible by 1
 * 4 -> 4 is divisible by 1
 * 8 -> 8 is divisible by 4, and 4 is divisible by 1.
 * so 8 is divisible by 1
 * 16 -> 16 is divisible by 8. 8->4->1. So 16 is divisible by 1
 * 
 * so there is a pattern here in lds, if we add any no and it is divisble by
 * prev no, then it will be divisible by all prev nos in the list.
 * 
 * Approach
 * 
 * dp[i], will lds including ith no
 * hash[i], will be prev no of curr no in lds
 * Initially hash[i] will point to i, meaning the no divide itself and there is
 * no less divisor
 * Outer loop will run from 0 to n to traverse all nos
 * Inner loop will run from 0 to i, this is to find prev
 * If prev divides the curr no and lds length by adding the curr no to prev res
 * is greater than lds of curr no
 * then update dp[i] with new length and hash[i] with new prev
 * then we will run another loop to find which no has highest lds and its index
 * Then in the temp list we will add this no using its index, then add other nos
 * till we get hash[i]=i, which signifies end of lds
 * Then we will reverse the lds and return as res.
 * 
 * Complexity
 * 
 * Time complexity: O(n∗n), we are using two nested loops
 * 
 * Space complexity: O(n), storing dp and hash
 * 
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];

        // dp[i] = lds ending at i
        // hash[i] = prev value before i
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 &&
                        1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }

        int ans = -1;
        int lastIdx = -1;
        // ans is lds and lastIdx is index of lds
        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIdx = i;
            }
        }

        // construct lds
        List<Integer> temp = new ArrayList();
        temp.add(nums[lastIdx]);

        while (hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            temp.add(nums[lastIdx]);
        }

        Collections.reverse(temp);
        return temp;
    }
}