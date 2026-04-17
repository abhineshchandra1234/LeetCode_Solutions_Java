// 1415. The k-th Lexicographical String of All Happy Strings of Length n

/**
 * Intuition
 * we will use backtracking to solve this problem
 * we will generate string in lexicographical order
 * we will also maintain a counter for it
 * when n char length is achieved, and the counter equals k, we will store the
 * curr string into res and return it
 * If there arent enough strings, empty string is returned once nth char length
 * is achieved
 * Approach
 * 
 * Complexity
 * Time complexity: O(n*2^n)- trying each char, 2 different chars are used for n
 * places
 * Space complexity: O(n), recursion stack
 */

class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        String[] res = { "" };
        int[] cnt = { 0 };

        solve(n, curr, cnt, k, res);

        return res[0];
    }

    private void solve(int n, StringBuilder curr, int[] cnt, int k, String[] res) {
        if (curr.length() == n) {
            cnt[0]++;
            if (cnt[0] == k)
                res[0] = curr.toString();
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch)
                continue;

            curr.append(ch);
            solve(n, curr, cnt, k, res);
            if (!res[0].isEmpty())
                return;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}