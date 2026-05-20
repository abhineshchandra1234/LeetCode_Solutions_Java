// 2657. Find the Prefix Common Array of Two Arrays

/**
 * Intuition
 * we will solve this problem using hashmap
 * since the elements are unique in arrays A and B
 * so if we get a freq 2, for the same element, it means it is present in both
 * and we will increase the count
 * freq cannot exceed 2, and both arrays will contibute to the freq
 * Later add this count to res
 * Approach
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];

        HashMap<Integer, Integer> m = new HashMap();
        int count = 0;
        for (int i = 0; i < n; i++) {
            m.put(A[i], m.getOrDefault(A[i], 0) + 1);
            if (m.get(A[i]) == 2)
                count++;

            m.put(B[i], m.getOrDefault(B[i], 0) + 1);
            if (m.get(B[i]) == 2)
                count++;

            res[i] = count;
        }

        return res;
    }
}