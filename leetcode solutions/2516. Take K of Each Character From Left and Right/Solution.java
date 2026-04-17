/**
 * 2516. Take K of Each Character From Left and Right
 * 
 * Intuition
 * we can solve this problem through recursion but that will take O(2^n) time
 * we can optimize it by solving through sliding window in O(n) time
 * we will determine the size of other window, which makes the outer window
 * valid
 * we will try to maximize the size of other window, so the outer window which
 * has all nos ie is valid and minimum
 * finally return difference of n - other window as res
 * 
 * Approach
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public int takeCharacters(String s, int k) {

        int n = s.length();

        int a = 0, b = 0, c = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a')
                a++;
            else if (ch == 'b')
                b++;
            else if (ch == 'c')
                c++;
        }

        if (a < k || b < k || c < k)
            return -1;

        int i = 0, j = 0;
        int otherWin = 0;

        while (j < n) {

            // outer window losing chars and other window gaining it
            if (s.charAt(j) == 'a')
                a--;
            else if (s.charAt(j) == 'b')
                b--;
            else if (s.charAt(j) == 'c')
                c--;

            // shrink other window if outer window is not valid
            while (i <= j && (a < k || b < k || c < k)) {
                if (s.charAt(i) == 'a')
                    a++;
                else if (s.charAt(i) == 'b')
                    b++;
                else if (s.charAt(i) == 'c')
                    c++;

                i++;
            }

            otherWin = Math.max(otherWin, j - i + 1);
            j++;
        }

        return n - otherWin;
    }
}