/***
 * 3011. Find if Array Can Be Sorted
 *
 * Intuition
we can solve this problem through bubble sort as adjacent nos are involved
but it will take O(n^2) time
we can further optimize it, by grouping the nos into segments
and comparing the prev segment max with curr segment min
if prev segment max is greater return false
notice segment groups with same bits should come in order otherwise we cannot swap them
like - [8,4,2,30,15] all same bits are in order
[3,16,8,4,2] all same bits are not in order as 3 with 2 bits is coming before
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
 */

class Solution
{

public:
    bool canSortArray(vector<int> &nums)
    {

        int bits = __builtin_popcount(nums[0]);
        int maxCurr = nums[0];
        int minCurr = nums[0];

        int max_prev = INT_MIN;

        for (int i = 1; i < nums.size(); i++)
        {

            if (__builtin_popcount(nums[i]) == bits)
            {
                maxCurr = max(maxCurr, nums[i]);
                minCurr = min(minCurr, nums[i]);
            }
            else
            {

                if (minCurr < max_prev)
                    return false;

                max_prev = maxCurr;

                maxCurr = nums[i];
                minCurr = nums[i];
                bits = __builtin_popcount(nums[i]);
            }
        }

        if (minCurr < max_prev)
            return false;

        return true;
    }
};