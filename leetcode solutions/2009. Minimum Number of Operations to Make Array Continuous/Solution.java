/**
 * 2009. Minimum Number of Operations to Make Array Continuous
 * 
 * Intuition
 * 
 * we need a continuous array, so in the answer we will have nos whose diff will
 * be 1 and it can be in any order.
 * we will first remove duplicates and then sort the array
 * we need unique elements so we remove duplicates
 * we do sorting so that we can do binary serach to find maximum.
 * then we will treat every index as minimum and try to find the maximum
 * maximum will be minimum + nums.length - 1
 * As the array is sorted we will use binary search to point to index one
 * greater than maximum
 * Using j(max) - i(min), we will get count of nos already in the range
 * we need to construct array of n length
 * so nos we need to change is n - count.
 * 
 * Approach
 * 
 * considering min as 2
 * [2,3,4,7,12,15,44] -> maximum index is 4 -> 4 - 0 -> 4
 * [2,3,4,7,9,15,44] -> maximu index is 5 -> 5 - 0 -> 5
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), every index we are treating as left and trying to find right
 * 
 * Space complexity:
 * 
 * O(n), hashset
 * 
 */
class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;
        int ans = n;

        HashSet<Integer> unique = new HashSet();
        for (int num : nums) {
            unique.add(num);
        }

        int[] newNums = new int[unique.size()];
        int index = 0;

        for (int num : unique) {
            newNums[index++] = num;
        }

        Arrays.sort(newNums);

        for (int i = 0; i < newNums.length; i++) {
            int left = newNums[i];
            int right = left + n - 1;
            int j = binarySearch(newNums, right);
            int count = j - i;
            ans = Math.min(ans, n - count);
        }
        return ans;
    }

    public int binarySearch(int[] newNums, int target) {
        int left = 0;
        int right = newNums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target < newNums[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}