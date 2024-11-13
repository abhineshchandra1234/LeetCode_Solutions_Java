/**
 * 1331. Rank Transform of an Array
 * 
 * Intuition
 * we need to replace nos with their ranks
 * so we will create a copy of the array, sort it and store its rank in a
 * hashmap
 * then we will use hashmap, to replace nos with their ranks
 * 
 * Approach
 * Complexity
 * Time complexity: O(nlogn), sorting
 * Space complexity: O(n), creating a copy of the array
 */
class Solution {

    public int[] arrayRankTransform(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap();
        int[] sorted = Arrays.copyOf(arr, arr.length);

        Arrays.sort(sorted);

        int rank = 1;

        for (int i = 0; i < sorted.length; i++) {
            if (i > 0 && sorted[i] > sorted[i - 1])
                rank++;
            map.put(sorted[i], rank);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}