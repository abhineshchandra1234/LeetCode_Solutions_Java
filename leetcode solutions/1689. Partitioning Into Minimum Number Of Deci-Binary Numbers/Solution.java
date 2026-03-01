// 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

/**
 * Intuition
 * the minimum no of deci binary nos will be equal to max digit in the string
 * max digit will decrease by 1 each time, as deci binary no only contains 1 or
 * 0
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {
    public int minPartitions(String n) {

        char max = '0';
        for (char ch : n.toCharArray())
            max = (char) Math.max(max, ch);

        return max - '0';
    }
}