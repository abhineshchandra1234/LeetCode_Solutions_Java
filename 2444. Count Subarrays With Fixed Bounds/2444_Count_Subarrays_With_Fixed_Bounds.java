//2444. Count Subarrays With Fixed Bounds
/*
approach -
- we will solve this problem using three ptrs
- min - stores index of num equal to minK
- max - stores index of num equal to maxK
- bad - stores index of num out of range of minK & maxK
- we will solve this problem using sliding window approach.
- we maintain a maximum sliding window with all elements in the range [minK,maxK]
- we will traverse nums array and for each iteration we will update each index and calculate res.
- If the subarray is incomplete or there is a bad num in between it, then 0 is added to res.
- If the subarray is complete ie it contains both minK & maxK, then 1 is added for each increase in its length.

Time - O(n)
Space - O(1)
*/
class Solution {

    public static void main(String[] args) {
        System.out.println("hello");
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {

        long res=0, min=-1, max=-1, bad=-1;

        for(int i=0; i<nums.length; i++) {

            if(nums[i]<minK || nums[i]>maxK)
                bad = i;
            if(nums[i]==minK)
                min = i;
            if(nums[i]==maxK)
                max = i;
            //if not suitable array or incomplete array it will return 0
            //suitable array it will return 1
            res += Math.max(0,Math.min(min,max)-bad);
        }
        return res;
    }
}