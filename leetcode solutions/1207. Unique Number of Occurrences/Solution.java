/*
 * 1207. Unique Number of Occurrences
 * 
 * Intuition
 * 
 * Brute force evident in the question is the solution here
 * we can use hashmap to calculate freq of each no
 * Then we can use set to find duplicate value
 * to optimize set computation you can simply compare freq size with duplicate
 * (map values) with unique freq size (set)
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
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> count = new HashMap();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        return count.size() == new HashSet(count.values()).size();
    }
}