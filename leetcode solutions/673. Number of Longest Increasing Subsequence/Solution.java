/**
 * 673. Number of Longest Increasing Subsequence
 * 
 * Intuition
 * 
 * credits caihao0727mail
 * This problem is similar to "300. Longest Increasing Subsequence"
 * we will use two dp array len[n] and cnt[n]
 * len[n] = lis that ends with nums[i]
 * cnt[n] = no of lis that ends with nums[i]
 * we will add ith element to existing jth element sequence
 * If it is a duplicate sequence ie same length, then we will add cnt of both
 * ith index and jth index.
 * If it is a unique sequence, then we have got a new lis ie new length, so both
 * len and cnt will be updated according to new lis.
 * 
 * Approach
 * 
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * suppose 4 has 3 lis of length 3 and 7 has 2 lis of length 4
 * so we add 7 to 4 sequence, 7 will be added to 3 sequences of 4 apart from 2
 * sequences it is already part of, which make the sequence count as 5
 * so there will be 5 lis of length 4 at 7.
 * 
 * - Input: nums = [1,3,5,4,7]
 * Output: 2
 * (0,0)
 * l = [1,1,1,1,1] c = [1,1,1,1,1]
 * (3,1)
 * l = [1,2,1,1,1] c = [1,1,1,1,1]
 * (2,0)
 * l = [1,2,2,1,1] c = [1,1,1,1,1]
 * (2,1)
 * l = [1,2,3,1,1] c = [1,1,1,1,1]
 * (3,0)
 * l = [1,2,3,2,1] c = [1,1,1,1,1]
 * (3,1)
 * l = [1,2,3,3,1] c = [1,1,1,1,1]
 * (3,2) -> skip
 * (4,0)
 * l = [1,2,3,3,2] c = [1,1,1,1,1]
 * (4,1)
 * l = [1,2,3,3,3] c = [1,1,1,1,1]
 * (4,2)
 * l = [1,2,3,3,4] c = [1,1,1,1,1]
 * (4,3)
 * l = [1,2,3,3,4] c = [1,1,1,1,2]
 * 
 * Complexity
 * 
 * Time complexity: O(n^2)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // duplicate lis
                    if (len[j] + 1 == len[i])
                        cnt[i] += cnt[j];
                    // unique lis
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i])
                res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}