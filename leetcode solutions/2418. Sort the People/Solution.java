/***
 * 
 * 2418. Sort the People
 * 
 * Intuition
 * It is a very good question to understand sorting based on mapped or linked
 * object
 * we are given String array names and integer array heights of length n
 * names[i] and heights[i] denote the name and height of the ith person
 * we need to return names sorted in descending order based on person heights
 * 
 * 
 * Approach
 * As evident in the question we will first create a hashmap with heights as key
 * and names as values
 * then we will sort heights in descending order
 * then traverse names and replace it with names fetched from heights using map
 * 
 * 
 * Complexity
 * Time complexity: O(nlogn), heights sort
 * Space complexity: O(n), map to store name & heights
 */

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {

        int n = names.length;
        HashMap<Integer, String> m = new HashMap();

        for (int i = 0; i < n; i++)
            m.put(heights[i], names[i]);

        Arrays.sort(heights);

        for (int i = 0; i < n / 2; i++) {
            int temp = heights[i];
            heights[i] = heights[n - i - 1];
            heights[n - i - 1] = temp;
        }

        String[] res = new String[n];

        for (int i = 0; i < n; i++)
            res[i] = m.get(heights[i]);

        return res;
    }
}