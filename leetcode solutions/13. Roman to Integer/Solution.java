// 13. Roman to Integer

/*
Intuition
we will traverse roman string, if the curr char is less than the next char reduce res by curr char otherwise increase res by curr char value
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
*/

//Kotlin
class Solution {
    fun romanToInt(s: String): Int {
        var res = 0

        var roman = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        for(i in 0 until s.length - 1) {
            if(roman.getValue(s[i])<roman.getValue(s[i+1]))
                res -= roman.getValue(s[i])
            else
                res += roman.getValue(s[i])
        }

        return res + roman.getValue(s[s.length-1])
    }
}

    // Java
class Solution {
    public int romanToInt(String s) {
        int res = 0, n = s.length();
        Map<Character, Integer> m = new HashMap();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        for (int i = 0; i < n - 1; i++) {
            int curr = m.get(s.charAt(i));
            int next = m.get(s.charAt(i + 1));
            if (curr < next)
                res -= curr;
            else
                res += curr;
        }

        return res + m.get(s.charAt(n - 1));
    }
}