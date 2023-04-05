/**
 * 2439. Minimize Maximum of Array
 * 
 * Intuition
 * As the question suggest we need minimize the maximum of the array
 * eg - Suppose after all operation you got max as 5 in the array then when you
 * try to further reduce it it becomes 6 and the cycle continues.
 * So minimum max you got is 5 and that is the ans.
 * 
 * Method 1 - Find max
 * you pick max of the array for each iteration
 * you picked the max value say 7 and then you reduce it by 1 in each iteration,
 * let say you got min max as 5 then you further try to reduce it becomes 6 but
 * never 4
 * TC - O(n*nums[i]) //nums[i] can be 10^9 in worst case
 * SC - O(1)
 * 
 * Method 2 - Binary search
 * We can consider a arbetiry no x as min max
 * In order to make curr no equal to x we need to increase of decrease it, if we
 * change curr no other no will also increase or decrease,as they are connected
 * in chain.
 * so for x to be valid we need to have all nos ie a<=x, b<=x, c<=x..
 * so we can say a+b+c<= x+x+x
 * a+b+c<=(i+1)*x
 * prefix sum of nos <= count of nos * x
 * we will apply binary serach with left as 0 and right as max of the array
 * mid of these two will be x, we will pass x to helper method and see if
 * condition satisfy, if it does we will move right to mid and try to find more
 * min value and same with left and finally return left
 * TC - O(n*log(max(nums[i])))
 * O(n*log10^9)
 * SC - O(1)
 * 
 * Method 3 - Most optimized one
 * we have a+b+c/(i+1)<=x
 * to maximize x we need to maximize a+b+c/(i+1)
 * we will calucate it at every index update res with max of two.
 * Finally we will have max a+b+c/(i+1) in res at end. We need x greater than or
 * equal to this. Since this is the max reachable value we will return this.
 * We will take ceil value of a+b+c/(i+1) to avoid computation value loss.
 * TC - O(n)
 * SC - O(1)
 * 
 * 
 * Approach
 * we will traverse through nums array and calculate prefix sum at each index
 * then we will update res with max of ceil of prefix sum/count
 * Finally return res
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int minimizeArrayValue(int[] nums) {

        long sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, (sum + i) / (i + 1));
        }
        return (int) res;
    }
}