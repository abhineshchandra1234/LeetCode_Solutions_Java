// 88. Merge Sorted Array

//kotlin
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var index = nums1.size - 1
        var i = m - 1
        var j = n - 1

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--]
            } else {
                nums1[index--] = nums2[j--]
            }
        }

        while (j >= 0) {
            nums1[index--] = nums2[j--]
        }
    }
}

    // java

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int n1 = m - 1;
        int n2 = n - 1;
        int n1End = m + n - 1;

        while (n2 >= 0) {
            if (n1 >= 0 && nums1[n1] > nums2[n2]) {
                nums1[n1End] = nums1[n1];
                n1--;
            } else {
                nums1[n1End] = nums2[n2];
                n2--;
            }
            n1End--;
        }
    }
}