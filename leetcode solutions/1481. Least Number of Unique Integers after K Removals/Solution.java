
/**
 * 1481. Least Number of Unique Integers after K Removals
 * 
 * Intuition
 * 
 * credits rock
 * we will first calculate freq of each no using hashmap
 * Then we will group the freq using array
 * then we will start removing element from k till its value is greater than 0
 * we start from freq group 1 ie those elements whose freq is 1
 * total elements = occur * occurCount[occur]
 * In this two cases arrive
 * if total elements <= k, then remove the whole group and update k and
 * remaining
 * if total elements > k, then try to remove as much unique no as possible
 * through k/occur
 * 
 * Approach
 * 
 * k= 3, total elements = 4, (2->1,5)
 * 
 * max element we can remove 3/2 -> 1
 * 
 * so we can max remove either 1 or 5
 * 
 * remaining signifies unique nos count
 * 
 * Complexity
 * 
 * Time complexity: O(n), calculating freq and then grouping it
 * 
 * Space complexity: O(n), storing freq and freq grouping
 * 
 */

import java.util.*;

class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> count = new HashMap();

        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));

        int remaining = count.size(), occur = 1;

        int[] occurCount = new int[arr.length + 1];

        for (int v : count.values())
            occurCount[v]++;

        while (k > 0) {

            // remove all unique no of occurrence
            if (k - occur * occurCount[occur] >= 0) {
                k -= occur * occurCount[occur];
                remaining -= occurCount[occur++];
            }
            // remove some unique no of occurrence
            else
                return remaining - (k / occur);
        }

        return remaining;
    }
}
