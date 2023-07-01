/**
 * 2305. Fair Distribution of Cookies
 * 
 * Intuition
 * 
 * we will traverse through the cookies array.
 * we will add nos to one of k positions and using helper function move to next
 * index.
 * Then we will remove the no from the k position, bcs we need to place the no
 * at all k positions.
 * At the end of cookies array we will traverse k to find max distribution.
 * Then we will update ans with min of max distrubution obtained above.
 * 
 * Approach
 * 
 * if (v[i] == 0)
 * break;
 * 
 * We are optimizing the code with above line.
 * for Input: cookies = [8,15,10,20,8], k = 2
 * for start index 8 we can have following combinations [0,8], [8,0]
 * You can see both combination refer to same subset and will result in same max
 * distribution.
 * It can happen with n nos(first time) for k times, we are saving alot of
 * computation bcs of above code.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(k^n), for each k index or number of children we have option to add n
 * numbers
 * 
 * Space complexity:
 * 
 * O(k^n), recursive call stack
 * 
 */

class Solution {

    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {

        int n = cookies.length;
        int[] v = new int[k];
        solve(0, cookies, v, k);
        return ans;
    }

    private void solve(int start, int[] cookies, int[] v, int k) {

        if (start == cookies.length) {
            int maxm = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++)
                maxm = Math.max(maxm, v[i]);
            ans = Math.min(ans, maxm);
            return;
        }
        for (int i = 0; i < k; i++) {
            v[i] += cookies[start];
            solve(start + 1, cookies, v, k);
            v[i] -= cookies[start];
            if (v[i] == 0)
                break;
        }
    }
}