/**
 * 2870. Minimum Number of Operations to Make Array Empty
 * 
 * Intuition
 * 
 * we will solve this using freq of each element
 * We will first calculate freq of each element and store it in map
 * If the freq is 1 we will return -1. Rest all nos can be achieved through 2 &
 * 3.
 * no of operations will be ceiling value of freq/3
 * 
 * 2 -> 0.0 -> 1
 * 3 -> 1.0 -> 1
 * 4 -> 1.33 -> 2
 * 5 -> 1.66 -> 2
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int minOperations(int[] nums) {

        Map<Integer, Integer> mp = new HashMap();

        for (int n : nums)
            mp.put(n, mp.getOrDefault(n, 0) + 1);

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int t = entry.getValue();

            if (t == 1)
                return -1;

            count += Math.ceil((double) t / 3);
        }
        return count;
    }
}