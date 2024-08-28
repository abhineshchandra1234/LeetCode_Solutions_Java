/**
 * 995. Minimum Number of K Consecutive Bit Flips
 * 
 * Intuition
 * 
 * we are given a binary array nums and integer k
 * we can flip the subarray of size k
 * we need to return min no of flips required, so that there are no 0s in the
 * array
 * If it is not possible return -1
 * Using brute force we need to do k flips for each index,TC - O(n*k)
 * we need to see how one no flip is impacting others
 * (no + no of flips)%2 = actual no
 * (1 + 3 ) % 2 = 0
 * 
 * Approach
 * 
 * we will traverse nums
 * we will add flipped index to deque and its size will represent flips count
 * First we will handle unsuitable window, if the index is out of bounds of the
 * prev window, remove first no from deque
 * Now we have a suitable window, if the curr no after total flips for current
 * window is 0
 * we need to flip the no
 * so we will increase res by 1 and add index to deque
 * we will also check out of bounds by i+k>n then return -1.
 * ie we cannot flip 3 nos including curr no
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(k), we are storing flip indices of curr window whose max
 * size is k
 * 
 */
class Solution {

    public int minKBitFlips(int[] nums, int k) {

        int n = nums.length;

        LinkedList<Integer> q = new LinkedList();
        int res = 0;

        for (int i = 0; i < n; i++) {

            // unsuitable window
            while (!q.isEmpty() && i > (q.get(0) + k - 1))
                q.poll();

            // suitable window
            if ((nums[i] + q.size()) % 2 == 0) {
                if (i + k > n)
                    return -1;
                res += 1;
                q.add(i);
            }
        }

        return res;
    }
}