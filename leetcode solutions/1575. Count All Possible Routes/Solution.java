/**
 * 1575. Count All Possible Routes
 * 
 * Intuition
 * 
 * If we understand the question, half of our problem is solved.
 * In the question location index and location of city is given.
 * We need to start from index of start city and reach the end city.
 * Moving from one city to another cost us location[i]-location[j]
 * If we have some fuel left we can continue our journey and if we reach end
 * city again that will be counted as one path.
 * eg - 1 -> 0 -> 1 -> 0 -> 1 -> 0
 * We can solve this using recursion, try to solve it first using graph draw.
 * Then you can easily right your code.
 * 
 * for Input: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
 * Output: 4
 * 1,5 -> 3,0
 * 1,5 -> 2,2 -> 3,0
 * 1,5 -> 4,4 -> 3,0
 * 1,5 -> 4,4 -> 2,2 -> 3,0
 * 
 * you can see for city 2 with fuel 2 there is only one path to end city.
 * To avoid this repeated computation we will use memoization.
 * dp will have two states currCity and fuel which will represent total paths
 * from currCity to endCity with the given fuel.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n*fuel * n), from each city we are visting every other city.
 * 
 * Space complexity:
 * 
 * O(fuel * n), dp space
 * 
 */
class Solution {
    int mod = (int) 1e9 + 7;
    Integer[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        int n = locations.length;
        dp = new Integer[n][fuel + 1];

        return solve(locations, start, finish, fuel);
    }

    private int solve(int[] locations, int currCity, int e, int fuel) {

        if (fuel < 0)
            return 0;
        if (dp[currCity][fuel] != null)
            return dp[currCity][fuel];

        int ans = (currCity == e) ? 1 : 0;

        for (int nextCity = 0; nextCity < locations.length; nextCity++) {
            if (nextCity != currCity)
                ans = (ans + solve(locations, nextCity, e, fuel -
                        Math.abs(locations[currCity] - locations[nextCity]))) % mod;
        }
        return dp[currCity][fuel] = ans;
    }
}