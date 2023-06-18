/**
 * 347. Top K Frequent Elements
 * 
 * Intuition
 * we will use adjacency list to solve this
 * we will create a freqmap using hashmap
 * then we will update list with freqmap
 * later we will traverse list from back and add nos to the resultant list,
 * which we can return as an array.
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> freqMap = new HashMap();

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList();
            bucket[freq].add(key);
        }

        List<Integer> res = new ArrayList();

        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null)
                res.addAll(bucket[i]);
        }

        int[] output = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            output[i] = res.get(i);

        return output;
    }
}