// 3739. Count Subarrays With Majority Element II

/**
 * Intuition
 * we will have a map for cumilative sum and thier frequency
 * we will traverse nums, if the curr no is equal to traget, we will add freq of
 * curr no to validLeftPoints and increase cumalitive sum by 1
 * if the curr no is not equal to target, we will decrease cumalitive sum by 1
 * we will also reduce freq of curr culative sum from validLeftPoints
 * then we will update cumilative sum in the map
 * we will add validLeftPoints to res and finally return res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        // Instead of map you can use an array of size 2*n+1 as well because we can have
        // cumulative sum from -n to +n
        Map<Integer, Integer> mp = new HashMap<>(); // mp[cumSum] = frequency of how many times cumSum has occurred

        int currSum = 0;

        mp.put(0, 1); // we have seen cumSum = 0 in the beginning once
        long validLeftPoints = 0;
        long result = 0;
        for (int x : nums) {
            if (x == target) {
                validLeftPoints += mp.getOrDefault(currSum, 0);
                currSum++;
            } else {
                currSum--;
                validLeftPoints -= mp.getOrDefault(currSum, 0);
            }
            mp.merge(currSum, 1, Integer::sum);
            result += validLeftPoints;
        }
        return result;
    }
}