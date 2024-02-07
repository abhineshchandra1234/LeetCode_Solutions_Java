/**
 * 451. Sort Characters By Frequency
 * 
 * Intuition
 * 
 * credits rexue70
 * we will first build freq map for each character
 * Then we will traverse freq map and do bucket sort
 * Then we will just traverse sorted array and build res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n), freq map, bucket sort, building res using
 * sorted array
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public String frequencySort(String s) {

        // char freq map
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // grouping char according to freq or bucket sort
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(key);
        }

        // building res with max freq first
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] == null)
                continue;
            for (char c : bucket[pos]) {
                for (int i = 0; i < pos; i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}