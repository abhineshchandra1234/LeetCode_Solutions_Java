// 80. Remove Duplicates from Sorted Array II

/*
Intuition
It is very similar to 26. Remove Duplicates from Sorted Array
we will use two ptrs here as well
Instead of comparing 1 no back, we will compare curr and 2 places back no
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
*/

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        
        var k = 2

        for(i in 2 until nums.size) {
            if(nums[i]!=nums[k-2]) {
                nums[k++] = nums[i]
            }
        }

        return k
    }
}

    class Solution {
        public int removeDuplicates(int[] nums) {
            Map<Integer, Integer> freq = new HashMap();
            int k = 0;

            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                if (freq.get(num) <= 2) {
                    nums[k++] = num;
                }
            }

            return k;
        }
    }

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}