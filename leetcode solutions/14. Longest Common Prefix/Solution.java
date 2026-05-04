// 14. Longest Common Prefix

/*
Intuition
we will sort the array alphabetically
then we will compare first and last word
if curr chars is not same return the ans
if the curr chars are same append it to the ans
Approach

Complexity
Time complexity: O(nlogn), sorting
Space complexity: O(logn), sorting
*/

//java
class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i))
                return ans.toString();
            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}

// kotlin
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        
        var ans = StringBuilder()

        strs.sort()

        var first = strs[0]
        var last = strs[strs.size-1]

        for(i in 0

    until minOf(first.length, last.length)) {
            if(first[i]!=last[i])
                return ans.toString()
            ans.append(first[i])
        }

        return ans.toString()
    }
}