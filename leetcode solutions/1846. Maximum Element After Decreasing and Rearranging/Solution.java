/**
 * 1846. Maximum Element After Decreasing and Rearranging
 * 
 * Intuition
 * 
 * credits lee215
 * we can arrange in any order and decrease elements to any value
 * so will arrange elements in ascending order so that we can decrease them to
 * satisfy the condition abs(arr[i] - arr[i - 1]) <= 1
 * 
 * Approach
 * 
 * we will use a var prev to format array to satisfy the cond of first element
 * as 1 and abs(arr[i] - arr[i - 1]) <= 1
 * curr element should be max prev + 1
 * If curr element is greater then abs(arr[i] - arr[i - 1]) <= 1 it will be
 * reduced to prev + 1 , as cond requires using pre = Math.min(pre + 1, a);
 * If curr element already satisfy the cond abs(arr[i] - arr[i - 1]) <= 1, prev
 * and curr element will remain as it is.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting
 * 
 * Space complexity:
 * 
 * O(1)
 * 
 */
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        int pre = 0;
        for (int a : arr)
            pre = Math.min(pre + 1, a);
        return pre;
    }
}