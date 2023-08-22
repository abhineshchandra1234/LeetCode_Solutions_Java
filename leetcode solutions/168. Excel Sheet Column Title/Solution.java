/**
 * 168. Excel Sheet Column Title
 * 
 * Intuition
 * 
 * x372p
 * this problem is very useful to understand base conversion
 * we need to convert decimal to base 26
 * in base 26 0->A, 1->B, .., 25->Z
 * but we are given 1->A, 2->B, .., 26->Z. So we will subtract 1 from res to
 * obtain its base 26 equivalent.
 * to obtain res, we will divide n by 26 till it is equal to 0 and use mod to
 * find base 26 equivalent
 * we can solve this from back
 * Last digit we can obtain by taking mod 26 ie Z
 * Second last has 26 combinations at last place so we need to divide by 26 then
 * take mod 26 ie X
 * Third last has 26*26 combinations before it so we need to divide by 26 then
 * take mod 26 ie B
 * 
 * N = 2002 corresponds to BXZ
 * 2002/26 -> 77 -> 77/26 -> 2 -> 2/26 -> 0
 * using remainders
 * 2002 = 2*26^2 + 25 *26^1 + 0*26^0
 * 2002 = (B+1)*26^2 + (X+1)*26^1 + (Z+1)*26^0
 * n = (B+1)*26^2 + (X+1)*26^1 + (Z+1)*26^0
 * n-1 = (B+1)*26^2 + (X+1)*26^1 + Z
 * (n-1)%26 = Z
 * (n-1)/26 = (B+1)*26^1 + (X+1)*26^0
 * and loop continues
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(log26 n) -> O(log n) -> base is not relevant in big O, a constant factor is
 * used
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            ans.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return ans.reverse().toString();
    }
}