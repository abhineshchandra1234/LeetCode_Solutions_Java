/**
 * 1072. Flip Columns For Maximum Number of Equal Rows
 * 
 * Intuition
 * through brute force we have two options for each col flipped or not flipped,
 * and comparing rows
 * It will take O(2^n) time, which is not feasible
 * we can solve this problem through hashmap
 * we will convert row to string and store in hashmap alongwith its frequency
 * if the row starts with 1, flip all bits, to compare with other keys
 * if two keys are same, increase their frequency
 * At last return the max frequency
 * Approach
 * 
 * Complexity
 * Time complexity: O(m*n), traversing each row
 * Space complexity: O(m*n), m strings with n lengths
 */
class Solution {

    public int maxEqualRowsAfterFlips(int[][] matrix) {

        Map<String, Integer> m = new HashMap();

        for (int[] row : matrix) {

            StringBuilder key = new StringBuilder();

            if (row[0] == 1) {
                for (int n : row) {
                    key.append(n == 0 ? 1 : 0);
                }
            } else {
                for (int n : row) {
                    key.append(n);
                }
            }
            String _key = key.toString();
            if (m.containsKey(key)) {
                m.put(_key, m.get(_key) + 1);
            } else
                m.put(_key, m.getOrDefault(_key, 0) + 1);
        }

        int res = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            res = Math.max(res, entry.getValue());
        }

        return res;
    }
}