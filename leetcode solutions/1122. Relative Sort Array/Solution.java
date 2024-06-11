/**
 * 1122. Relative Sort Array
 * 
 * Intuition
 * 
 * given two arrays, arr2 elements are present in arr1
 * sort arr1 according to relative order of elements in arr2 and return it
 * 
 * Approach
 * 
 * It is evident from question, we can traverse arr2 and add similar elements of
 * arr1 at the start
 * Then sort remaining nos of arr1 and add at the end
 * to make this process easier we can create a freq map for arr1 elements
 * we will traverse arr2, and keep adding arr1 nos at start till thier freq is
 * greater than 0
 * then we will traverse the freq map, in which nos are placed in ascending
 * order
 * and keep adding the remaining nos till thier freq is greater than 0
 * Finally return arr1
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1)
 * 
 * 
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] cnt = new int[1001];

        for (int no : arr1)
            cnt[no]++;

        int i = 0;

        for (int no : arr2)
            while (cnt[no]-- > 0)
                arr1[i++] = no;

        for (int j = 0; j < 1001; j++)
            while (cnt[j]-- > 0)
                arr1[i++] = j;

        return arr1;

    }
}