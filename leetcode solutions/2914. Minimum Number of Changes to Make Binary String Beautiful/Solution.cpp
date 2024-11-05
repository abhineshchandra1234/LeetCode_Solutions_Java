/**
 * 2914. Minimum Number of Changes to Make Binary String Beautiful
 *
 *
 * Intuition
we will divide the string into pairs of 2
and check if any changes are required in the pair
we will take sum of changes and return it
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
 */

class Solution
{

public:
    int minChanges(string s)
    {

        int changes = 0;

        for (int i = 0; i < s.length(); i += 2)
            if (s[i] != s[i + 1])
                changes++;

        return changes;
    }
};