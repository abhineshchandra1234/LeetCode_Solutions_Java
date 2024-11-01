/**

1957. Delete Characters to Make Fancy String

Intuition
we can solve this problem through 2 ptrs
j ptr will insert curr no, if it is not equal to j-1 or j-2
i ptr will be used to traverse curr no
At last we will return substring before j
we can have a case where i reached at end, and there are repeating chars between i & j
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
 */
class Solution
{

public:
    string makeFancyString(string s)
    {

        if (s.length() < 3)
            return s;

        int j = 2;
        for (int i = 2; i < s.length(); i++)
        {

            if (s[i] != s[j - 1] || s[i] != s[j - 2])
            {
                s[j++] = s[i];
            }
        }

        s.resize(j);
        return s;
    }
};