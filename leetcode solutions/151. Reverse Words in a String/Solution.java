// 151. Reverse Words in a String

/*
Intuition
we will first split the words in a list
then we will just reverse the words in the list using two-pointers
then we will traverse through the words and add them to stringbuilder or res alongwith spaces
Approach

Complexity
Time complexity: O(n)
Space complexity: O(n)
*/

//kotlin
class Solution {
    fun reverseWords(s: String): String {
        val words = s.split(" ").toMutableList()
        var left = 0
        var right = words.size - 1

        while(left<right) {
            var temp = words[left]
            words[left] = words[right]
            words[right] = temp
            left++
            right--
        }

        var res = StringBuilder()
        for(word in words) {
            if(word.isNotEmpty()) {
                if(res.isNotEmpty()) {
                    res.append(" ")
                }
                res.append(word)
            }
        }
        return res.toString()
    }
}

//java
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            if (i < 0)
                break;

            int j = i;

            while (j >= 0 && s.charAt(j) != ' ')
                j--;

            if (result.length() > 0)
                result.append(" ");

            result.append(s.substring(j + 1, i + 1));

            i = j;
        }

        return result.toString();
    }
}