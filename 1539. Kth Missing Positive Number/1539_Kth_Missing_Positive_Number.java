/*
 * 1539. Kth Missing Positive Number
 * 
 * approach - 
 * Since it is strictly increasing array. we can find missing nos at any
 * point using the formula
 * missing no = arr[mid]-(mid+1)
 * then we will use this condition in binary search
 * At last we will get least index to which we can add k to get kth missing no.
 * 
 * Time - O(logn)
 * Space - O(1)
 */
class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int l=0,r=arr.length-1;
        while(l<=r) {
            int m = l + ((r-l)/2);
            if(arr[m]-(m+1)<k)
                l = m+1;
            else
                r = m-1;
        }
        return l+k;
    }
}