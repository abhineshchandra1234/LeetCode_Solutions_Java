/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * 
 * Intuition
 * 
 * credits lee215
 * we will traverse each string and discard string which contain duplicate chars
 * then we will add this unique string to each existing unique string of dp if
 * they do not conflict, and update res with max bitmask length
 * 
 * Approach
 * 
 * dup |= all & (1 << (c - 'a')); if there is any duplicate it will be non-zero
 * all |= 1 << (c - 'a');, it will contain both duplicate and unique chars
 * if ((dp.get(i) & all) > 0) comparison between two unique strings, if there is
 * a conflict move fwd
 * 
 * Complexity
 * 
 * Time complexity: O(m∗n), we are shifting each strings by n bits
 * to find duplicates or trying string with each existing unique strings of dp
 * 
 * Space complexity: O(2^n), max bitmask can be of n length, 2^n
 * different bitmask is possible like - 0000, 0101
 * 
 */
class Solution {
    public int maxLength(List<String> arr) {

        List<Integer> dp = new ArrayList();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
            int all = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= all & (1 << (c - 'a'));
                all |= 1 << (c - 'a');
            }

            if (dup > 0)
                continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & all) > 0)
                    continue;
                dp.add(dp.get(i) | all);
                res = Math.max(res, Integer.bitCount(dp.get(i) | all));
            }
        }
        return res;
    }
}