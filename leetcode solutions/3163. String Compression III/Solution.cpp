/**
 * 3163. String Compression III
 *
 * Intuition
we can solve this problem through string manipulation
we will break consecutive chars to max 9 times
and append char with its count into res
we would use two ptrs, one will point to empty string which we are building
second ptr will point to word string
we will then move to next char, using word ptr
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
 */

class Solution
{

public:
    string compressedString(string word)
    {

        string res = "";
        int pos = 0;

        while (pos < word.length())
        {

            int cons = 0;
            char curr = word[pos];
            while (pos < word.length() && cons < 9 && word[pos] == curr)
            {
                cons++;
                pos++;
            }
            res += to_string(cons) + curr;
        }

        return res;
    }
};