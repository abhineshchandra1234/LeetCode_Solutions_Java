/**
 * 1431. Kids With the Greatest Number of Candies
 * 
 * Intuition
 * We will find max value in the array
 * Then we will traverse array and check the cond curr+extra candy>=max then add
 * true in the res
 * 
 * Approach
 * Taken max value as int min
 * traversing the candy array to update max
 * Then again traversing the candy array, checking the cond curr+extra
 * candy>=max and storing its output in the res array.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = Integer.MIN_VALUE;
        for (int candy : candies)
            max = Math.max(max, candy);
        List<Boolean> res = new ArrayList();
        for (int candy : candies)
            res.add(candy + extraCandies >= max);
        return res;
    }
}