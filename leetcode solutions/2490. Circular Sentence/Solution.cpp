/**
 * 2490. Circular Sentence
 *
 * Intuition
we can solve this problem by splitting words into an array and comparing words char
further optimizing approach
for every space we can compare first and last chars, and return false if there is no match
At last we can compare first and last chars and return false in no match
Approach
Complexity
Time complexity: O(n)
Space complexity: O(1)
 */

class Solution
{

public:
    bool isCircularSentence(string sentence)
    {

        int n = sentence.size();

        for (int i = 0; i < n; i++)
            if (sentence[i] == ' ' && sentence[i - 1] != sentence[i + 1])
                return false;

        return sentence[0] == sentence[n - 1];
    }
};