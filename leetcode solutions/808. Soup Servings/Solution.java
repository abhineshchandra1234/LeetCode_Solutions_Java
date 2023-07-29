/**
 * 808. Soup Servings
 * 
 * Intuition
 * 
 * credits lee215
 * we will take 25 ml as 1 serving, max serving will be 200 ie 4800ml.
 * Above 4800 ml probabilty is always 1.
 * we need to do all 4 operations, and we need to stop if either a or b doesnt
 * have enough quantity.
 * if a and b becomes empty at same time we will return 0.5
 * we need to return probability of a being empty first.
 * 
 * Approach
 * 
 * (n + 24) is used to acheive celing value.
 * (n + 24) / 25 will be the no of servings
 * Subsequently will take out the servings and return thier propability.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(m*m), where m is the serving of soup if we take 25 ml as 1 serving, max 200
 * servings will be there
 * 
 * Space complexity: O(m*m)
 * 
 */
class Solution {

    Double[][] memo = new Double[200][200];

    public double soupServings(int n) {
        return n > 4800 ? 1.0 : f((n + 24) / 25, (n + 24) / 25);
    }

    public double f(int a, int b) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0)
            return 1;
        if (b <= 0)
            return 0;
        if (memo[a][b] != null)
            return memo[a][b];
        memo[a][b] = 0.25 * (f(a - 4, b) + f(a - 3, b - 1) + f(a - 2, b - 2) + f(a - 1, b - 3));
        return memo[a][b];
    }
}