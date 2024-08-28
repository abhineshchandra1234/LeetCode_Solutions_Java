/**
 * 1636. Sort Array by Increasing Frequency
 * 
 * Intuition
 * we are given integer array nums, we need to sort the numbers based on the
 * frequency in increasing order
 * if the frequency is same, sort them in decreasing order of their value
 * 
 * 
 * Approach
 * we will use the most common method to solve this
 * create a hashmap of no and its freq
 * since java doesn't allow sorting with lambda comparator for primitive types
 * convert it to integer object, use comparator to sort it
 * convert back to primitive object and return it
 * 
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

class Solution {

    public int[] frequencySort(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer> m = new HashMap();

        for (int i = 0; i < n; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        Integer[] obj = new Integer[n];

        for (int i = 0; i < n; i++)
            obj[i] = nums[i];

        Arrays.sort(obj, (a, b) -> {
            if (m.get(a) == m.get(b))
                return Integer.compare(b, a);
            return Integer.compare(m.get(a), m.get(b));
        });

        for (int i = 0; i < n; i++)
            nums[i] = obj[i];

        return nums;
    }
}