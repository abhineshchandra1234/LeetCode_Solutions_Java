// 1784. Check if Binary String Has at Most One Segment of Ones

/**
 * Intuition
 * we will simply count consecutive 1's and if the count is greater than 1,
 * return false, else true
 * In our second approach, we will just check if string contains "01", then
 * return false, as there are no trailing 0s
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int count = 0;

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                count++;
                while (i < n && s.charAt(i) == '1')
                    i++;
            } else
                i++;
            if (count > 1)
                return false;
        }

        return true;
    }
}

class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}