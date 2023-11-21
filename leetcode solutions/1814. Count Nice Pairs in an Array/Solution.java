/**
 * 1814. Count Nice Pairs in an Array
 * 
 * 
 * Intuition
 * 
 * credits lee215
 * 
 * A[i] + rev(A[j]) == A[j] + rev(A[i])
 * A[i] - rev(A[i]) == A[j] - rev(A[j])
 * B[i] = A[i] - rev(A[i])
 * 
 * we just need to find how many nos are equal to B[i]
 * there are n-1 pairs for n nos.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nloga), traverse each no and find its reverse
 * 
 * Space complexity:
 * 
 * O(n), store freq of difference of no & its reverse
 * 
 */
class Solution {
    public int countNicePairs(int[] nums) {

        int res = 0, mod = (int) 1e9 + 7;
        Map<Integer, Integer> count = new HashMap();
        for (int a : nums) {
            int b = rev(a), v = count.getOrDefault(a - b, 0);
            count.put(a - b, v + 1);
            // n-1 pairs for n nos
            res = (res + v) % mod;
        }
        return res;
    }

    // reverse any no
    public int rev(int a) {
        int b = 0;
        while (a > 0) {
            b = b * 10 + (a % 10);
            a /= 10;
        }
        return b;
    }
}