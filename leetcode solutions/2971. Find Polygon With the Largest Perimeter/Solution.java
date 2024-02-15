/**
 * 2971. Find Polygon With the Largest Perimeter
 * 
 * Intuition
 * 
 * credit kreakEmp
 * we will sort the array so that we can consider the last element as the
 * largest side
 * Then we will compare last element with prefix sum of rest element
 * If prefix sum is more which is suitable for polygon return prefix sum + last
 * element
 * 
 * Approach
 * 
 * we have a used a var sum to store prefix sum of all nos
 * we are traversing array from back till 2, as polygon require atleast 3 sides
 * then we are coparing nums[i] & sum - nums[i] (prefix sum of rest)
 * and returning the res(largest perimeter) as prefix sum of rest + nums[i]
 * 
 * Complexity
 * 
 * Time complexity: O(nlogn), sorting
 * 
 * Space complexity: O(logn), sorting
 * 
 */
class Solution {
    public long largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        long sum = 0;
        for (int no : nums)
            sum += no;
        for (int i = nums.length - 1; i >= 2; i--) {
            sum -= nums[i];
            if (nums[i] < sum)
                return sum + nums[i];
        }
        return -1;
    }
}