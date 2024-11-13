/**
 * 2275. Largest Combination With Bitwise AND Greater Than Zero
 *
 * Intuition
we need & of combination of numbers greater than 0
we need to check ith bit of all nos are greater than 0
max bits can be 32
if any no ith bit is 0, & operation of all nos will be 0
a= 110, b = 001, c= 101
0th bit of b and c is 1, we got one valid combination with two nos(b,c)
1th bit of only a is 1, we got one valid combination with 1 nos (a)
we will update res with max nos combination for each bit
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
 */
class Solution
{

public:
    int largestCombination(vector<int> &candidates)
    {

        int res = 0;

        for (int i = 0; i < 32; i++)
        {

            int count = 0;
            for (int num : candidates)
            {

                if ((num & (1 << i)) != 0)
                    count++;
            }

            res = max(res, count);
        }
        return res;
    }
};