/*
 * 350. Intersection of Two Arrays II
 * 
 * Intuition

    given two integer arrays nums1 and nums2, we need to return an array of intersection elements including duplicates
    we can solve this using hashmap, but it will take O(n) space
    we can do it using two ptrs
    we first need to sort the array
    we will increase first ptr if nums1 no is small and increase second ptr if nums2 no is small
    In intersection both nos are equal, we will add it to the list

Approach
Complexity

    Time complexity: O(nlogn), sorting

    Space complexity: O(n), storing list

 * 
 */

 class Solution {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        nums1.sort()
        nums2.sort()
        var temp = ArrayList<Int>()
        var first = 0
        var sec = 0
        while (first < nums1.size && sec < nums2.size) {

            if (nums1[first] < nums2[sec]) first++
            else if (nums1[first] > nums2[sec]) sec++
            else {
                temp.add(nums1[first])
                first++
                sec++
            }
        }

        return temp.toIntArray()
    }
}
