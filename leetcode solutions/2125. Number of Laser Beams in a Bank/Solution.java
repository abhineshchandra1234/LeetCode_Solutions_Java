/**
 * 2125. Number of Laser Beams in a Bank
 * 
 * Intuition
 * 
 * we will solve this problem using greedy approach and using two ptrs curr &
 * prev
 * curr will keep track of lasers in curr row and similarly prev will track
 * lasers in prev row
 * if total lasers in curr row is greater than 0 then update ans += prev * curr;
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m∗n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public int numberOfBeams(String[] bank) {

        int ans = 0, prev = 0;
        for (String s : bank) {
            int curr = 0;
            for (char c : s.toCharArray())
                if (c == '1')
                    curr++;
            if (curr > 0) {
                ans += prev * curr;
                prev = curr;
            }
        }
        return ans;
    }
}