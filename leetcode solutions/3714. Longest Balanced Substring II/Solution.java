// 3714. Longest Balanced Substring II

/**
 * Intuition
 * we have 3 scenrios, and we are taking max of all three
 * First we are calculating length of subarray for one char only. ie only a or b
 * or c
 * Second we are calculating longest balanced subarray for two chars. ie ab or
 * bc or ac
 * Third we are calculating longest balanced subarray for three chars ie abc
 * In first scenario we are taking length of continous chars and updating res
 * In second scenario, if we have encountered the diff of two chars earlier,
 * then we are updating res
 * In third scenario, if we have encountered the diff of three chars earlier,
 * then we are updating res
 * Approach
 * 
 * Complexity
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */

class Solution {

    static class Pair {
        int d1, d2;

        Pair(int d1, int d2) {
            this.d1 = d1;
            this.d2 = d2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Pair))
                return false;
            Pair p = (Pair) o;
            return d1 == p.d1 && d2 == p.d2;
        }

        @Override
        public int hashCode() {
            return 31 * d1 + d2;
        }
    }

    public int longestBalanced(String s) {

        char[] c = s.toCharArray();
        int n = c.length;

        int res = 0;

        // Case-1
        int cur = 1;

        for (int i = 1; i < n; i++) {
            if (c[i] == c[i - 1]) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        res = Math.max(res, cur);

        // Case-2
        res = Math.max(res, find2(c, 'a', 'b'));
        res = Math.max(res, find2(c, 'a', 'c'));
        res = Math.max(res, find2(c, 'b', 'c'));

        // Case-3
        int ca = 0, cb = 0, cc = 0;

        Map<Pair, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (c[i] == 'a')
                ca++;
            else if (c[i] == 'b')
                cb++;
            else
                cc++;

            if (ca == cb && ca == cc)
                res = Math.max(res, ca + cb + cc);

            Pair key = new Pair(ca - cb, ca - cc);

            Integer prev = mp.get(key);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                mp.put(key, i);
            }
        }

        return res;
    }

    private int find2(char[] c, char x, char y) {

        int n = c.length;
        int max_len = 0;

        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int clear_idx = -1;
        int diff = n;

        first[diff] = -1;

        for (int i = 0; i < n; i++) {

            if (c[i] != x && c[i] != y) {

                clear_idx = i;
                diff = n;
                first[diff] = clear_idx;

            } else {

                if (c[i] == x)
                    diff++;
                else
                    diff--;

                if (first[diff] < clear_idx) {
                    first[diff] = i;
                } else {
                    max_len = Math.max(max_len, i - first[diff]);
                }
            }
        }

        return max_len;
    }
}