/**
 * 1508. Range Sum of Sorted Subarray Sums
 * 
 * Intuition
 * we are given integer n
 * we are also given Integer array nums of size n, we are also given two 1
 * indexed variables left and right
 * we will create a new array by computing sub-array sums from each index
 * we need to sort this new array and return sum of nos from left to right index
 * the new array size will be n*(n+1)/2
 * 
 * Approach
 * we will solve this problem through brute force using simulation
 * we can optimize it in space using priority queue, but its approach cant be
 * reached on own
 * we will generate all nos and add it in list
 * we will then sort the list
 * we will then simply calculate sum between left and right index and return it
 * by taking mod
 * 
 * Complexity
 * Time complexity: O(n^2logn), sorting the list
 * Space complexity: O(n^2), storing the list
 */
class Solution {

    public int rangeSum(int[] nums, int n, int left, int right) {

        List<Integer> l = new ArrayList();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                l.add(sum);
            }
        }

        Collections.sort(l);
        int mod = (int) 1e9 + 7;
        int res = 0;
        for (int i = left - 1; i <= right - 1; i++) {
            res = (res + l.get(i)) % mod;
        }
        return res;
    }
}