// 6. Zigzag Conversion

/*
Intuition
we will have one pointer to traverse string and other ptr to print chars in rows
we will print chars from up to down in rows, when we reach last rows we will print chars from down to up
when we reach top row, we will continue the cycle from up to down
Approach

Complexity
Time complexity: O(n)
Space complexity: O(n)
*/

// kotlin
class Solution {
    fun convert(s: String, numRows: Int): String {
        if(numRows==1)
            return s
        var idx = 0
        var d = 1

        val rows = Array(numRows) {mutableListOf<Char>()}

        for(c in s) {
            rows[idx].add(c)

            if(idx==0) {
                d = 1
            } else if(idx==numRows-1) {
                d = -1
            }

            idx+= d
        }

        val res = StringBuilder()
        for(row in rows) {
            for(c in row) {
                res.append(c)
            }
        }

        return res.toString()
    }
}

    // java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder res = new StringBuilder();
        int inc = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += inc) {
                res.append(s.charAt(j));
                int dia = inc - (2 * i);
                if (i > 0 && i < numRows - 1
                        && j + dia < s.length()) {
                    res.append(s.charAt(j + dia));
                }
            }
        }

        return res.toString();
    }
}