// 189. Rotate Array

/*
Intuition
we will first take remainder of k and nums size, incase k is bigger
then we will reverse the array
next we will reverse 0 to k-1
next we will reverse k to nums size
Approach

Complexity
Time complexity: O(n)
Space complexity: O(1)
*/

//kotlin
class Solution {
    fun rotate(nums: IntArray, k: Int) {
        
        val n = nums.size
        val steps = k%n

        reverse(nums, 0, n-1)
        reverse(nums, 0, steps-1)
        reverse(nums, steps, n-1)
    }

    private fun reverse(nums: IntArray, left: Int, right: Int) {
        var l = left
        var r = right

        while(l<r) {
            var temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
            l++
            r--
        }
    }
}

    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;

            int[] rotated = new int[n];

            for (int i = 0; i < n; i++) {
                rotated[(i + k) % n] = nums[i];
            }

            for (int i = 0; i < n; i++) {
                nums[i] = rotated[i];
            }
        }
    }

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}