/**
 * 1652. Defuse the Bomb
 * 
 * Intuition
 * we can solve this problem through brute force
 * if k is 0 we would return the res
 * if k>0, we would simply pick next k nos and add it in res
 * to cover circular nos, we would take modulo of j with code length
 * if k<0, we need to pick prev k nos, which is bit tricky
 * we will initialize j with i - mod(k)
 * for circular position we will take (j+ code length) mod (code length)
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] res = new int[n];

        if (k == 0)
            return res;

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = i + 1; j < i + k + 1; j++) {
                    res[i] += code[j % n];
                }
            } else {
                for (int j = i - Math.abs(k); j < i; j++) {
                    res[i] += code[(j + n) % n];
                }
            }
        }

        return res;
    }
}