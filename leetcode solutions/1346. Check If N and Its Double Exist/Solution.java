/**
 * 1346. Check If N and Its Double Exist
 * 
 * Intuition
 * we can solve this problem using frequency hash map
 * add all nos and their freq to hash map first
 * while traversing nos just check if double exist
 * we have a corner case of 0
 * if we have no as 0, check if its freq is greater than 1
 * if it is return true
 * Note - if 0 occurs once, then also it will return true
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * For each configuration, BFS is visiting m*n states
 * Space complexity: O(n)
 */

class Solution {

    public boolean checkIfExist(int[] arr) {

        Map<Integer, Integer> m = new HashMap();

        for (int no : arr) {
            m.put(no, m.getOrDefault(no, 0) + 1);
        }

        for (int no : arr) {
            if (no != 0 && m.containsKey(no * 2))
                return true;

            if (no == 0 && m.get(no) > 1)
                return true;
        }

        return false;
    }
}