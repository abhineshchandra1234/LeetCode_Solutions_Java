// 12. Integer to Roman

/*
Intuition
we will create two maps, one will contain values other will contain symbols in descending order
then we will just traverse nums, if curr nums value is greater or equal to curr values, then append its curr symbol to string builder and reduce curr value from num
Finally return string builder as string
Approach

Complexity
Time complexity: O(1)
Space complexity: O(1)
*/

//Kotlin
class Solution {
    fun intToRoman(num: Int): String {
        var n = num
        var values = arrayOf(1000, 900, 500, 400, 100, 
        90, 50, 40, 10, 9, 5, 4, 1)
        var symbols = arrayOf("M", "CM", "D", "CD", "C", 
        "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var sb = StringBuilder()

        for(i in values.indices) {
            if(n==0)
                break
            while(n>=values[i]) {
                sb.append(symbols[i])
                n -= values[i]
            }
        }

        return sb.toString()
    }
}

    // Java
class Solution {
    public String intToRoman(int num) {
        int[] vals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] sign = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vals.length; i++) {
            if (num == 0)
                break;
            while (num >= vals[i]) {
                sb.append(sign[i]);
                num -= vals[i];
            }
        }
        return sb.toString();
    }
}