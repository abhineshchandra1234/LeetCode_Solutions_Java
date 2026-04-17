// 401. Binary Watch

/**
 * Intuition
 * we will try every combinations of hrs and mins using two loops
 * If the sum of bit counts of hrs and mins is equal to turned on, we will add
 * string of hrs and min to res
 * Finally return res at the end
 * Approach
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(1)
 */

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {

        List<String> res = new ArrayList();

        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    String hr = String.valueOf(h);
                    String mi = (m < 10 ? "0" : "") + m;
                    res.add(hr + ":" + mi);
                }
            }
        }

        return res;
    }
}