/**
 * 1218. Longest Arithmetic Subsequence of Given Difference
 * 
 * Intuition
 * 
 * credits PhoenixDD
 * we will solve this problem using dp
 * we will treat each no as the end of arithmetic sequence and check if the
 * previous no of sequence exist, then will add 1 to its length.
 * If the previous no doesnt exist, it will create its own sequence of length 1.
 * we will update max las with curr sequence length.
 * 
 * Approach
 * 
 * Input: arr = [1,2,3,4], difference = 1
 * Output: 4
 * 1 -> there is no 1-1=0, so res is 1-> 0+1 ->1.
 * 2 -> there is 2-1=1, so res is 2-> 1 + 1 ->2.
 * 3 -> there is 3-1=2, so res is 3-> 2 + 1 ->3.
 * 4 -> there is 4-1=3, so res is 4-> 3 + 1 ->4.
 * update max at each step, so ans is 4.
 * try ex
 * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * to understand better.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n) , we are visiting each no once.
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer, Integer> dp = new HashMap();
        int longest = 0;
        for (int i : arr) {
            dp.put(i, dp.getOrDefault(i - difference, 0) + 1);
            longest = Math.max(longest, dp.get(i));
        }
        return longest;
    }
}