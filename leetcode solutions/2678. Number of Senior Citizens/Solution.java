/**
 * 2678. Number of Senior Citizens
 * 
 * Intuition
 * we are given String array details, consisting of the details of the passenger
 * we need to return no of passengers who are strictly greater than 60 yrs old
 * 
 * 
 * Approach
 * We can solve it by string parsing or by processing chars
 * 
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 */

class Solution {

    public int countSeniors(String[] details) {

        int res = 0;
        for (String detail : details) {
            int age = Integer.valueOf(detail.substring(11, 13));

            if (age > 60)
                res++;
        }

        return res;
    }
}