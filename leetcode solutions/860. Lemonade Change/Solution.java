/**
 * 860. Lemonade Change
 * 
 * Intuition
 * we are given integer array bills, where bills[i], is the money ith customer
 * paid
 * we need to return true or false, based on we are able to provide customer
 * with correct change, based on the bills we received
 * 
 * Approach
 * we will solve this by simulation
 * if the bill is 5, that is the cost no change required
 * if the bill is 10, one 5 is required
 * if bill is 20, either one 10 and one 5 or three 5s are required
 * remember to add or deduct bills based on amount received and changes provided
 * for each bill type
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for (int bill : bills) {

            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else
                    return false;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3)
                    five -= 3;
                else
                    return false;
            }
        }
        return true;
    }
}