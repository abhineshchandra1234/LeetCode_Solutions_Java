/**
 * 17. Letter Combinations of a Phone Number
 * 
 * Intuition
 * 
 * credits annafan
 * There is a trick to solve this problem
 * we need to combine each digit with existing res to obtain new res
 * 
 * like - Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * i=0 -> res = combine(["abc",""]) -> [a,b,c]
 * i=1 -> res = combine(["def"],[a,b,c]) -> [ad, ae, af, bd, be, bf,
 * cd, ce, cf];
 * 
 * Complexity
 * 
 * Time complexity: O(3^n)
 * 
 * Space complexity: O(3^n)
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {

        String digitletter[] = { "0", "1", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList();

        if (digits.length() == 0)
            return res;

        res.add("");
        for (int i = 0; i < digits.length(); i++)
            res = combine(digitletter[digits.charAt(i) - '0'], res);

        return res;
    }

    public List<String> combine(String digit, List<String> res) {
        List<String> temp = new ArrayList();
        for (int i = 0; i < digit.length(); i++)
            for (String x : res)
                temp.add(x + digit.charAt(i));

        return temp;
    }
}