/**
 * 2864. Maximum Odd Binary Number
 * 
 * Intuition
 * 
 * For max odd no we need atleast one 1 bit at the least significant place and
 * rest of the 1 bit at the most significant place
 * we will first count no of 1s in the string
 * then put count-1 1s at the start of res
 * then put n-count, zeros in middle
 * At last add 1 to the last of the res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), traversing string to count 1
 * 
 * Space complexity: O(n), building string of n length
 * 
 */
class Solution {
    public String maximumOddBinaryNumber(String s) {

        int n = s.length();

        int count = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                count++;

        StringBuilder st = new StringBuilder();
        for (int i = 0; i < count - 1; i++)
            st.append(1);
        for (int i = 0; i < n - count; i++)
            st.append(0);
        st.append(1);

        return st.toString();
    }
}