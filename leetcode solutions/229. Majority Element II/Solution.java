/**
 * 229. Majority Element II
 * 
 * Intuition
 * 
 * by looking at the question, first thought come to our mind is to solve it
 * using hashmap
 * optimized solution is to use Boyer-Moore Majority Vote algorithm
 * Take example of long stick and divide it into 3 equal parts, you cannot have
 * more than 2 sticks greater than 1/3.
 * Similarly try it with 2 equal parts -> 1, 4 equal parts -> 3
 * So we will track two frequent element using this algorithm
 * 
 * Approach
 * 
 * Instead of hashmap we will use two variables to track two frequent elements
 * If the count of any of the variables is 0 assign no to that var and make its
 * count as 1
 * If the no matches any of the variables, increase its count
 * If the vars are not zero, and we get a new no cancel count of vars by 1, as
 * new no can replace these vars if its count is more by cancelling these vars.
 * dry run with 1,1,1,3,3,2,2,2 -> 1,2 to understand better
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int no1 = -1, no2 = -1, cnt1 = 0, cnt2 = 0, len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == no1)
                cnt1++;
            else if (nums[i] == no2)
                cnt2++;
            else if (cnt1 == 0) {
                no1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                no2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList();
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == no1)
                cnt1++;
            else if (nums[i] == no2)
                cnt2++;
        }

        int target = len / 3;
        if (cnt1 > target)
            res.add(no1);
        if (cnt2 > target)
            res.add(no2);

        return res;
    }
}