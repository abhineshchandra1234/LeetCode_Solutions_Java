/**
 * 49. Group Anagrams
 * 
 * Intuition
 * 
 * we will use hashmap to solve this
 * sorted word will be key and all the anagrams word stored in the list as
 * values
 * we will traverse each word, sort it and store it in map
 * Finally return map values as list
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(m∗nlogn), traversing each word and
 * sorting it
 * 
 * Space complexity: O(n), storing each word mapping in the map
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            map.putIfAbsent(sortedWord, new ArrayList());
            map.get(sortedWord).add(word);
        }
        return new ArrayList(map.values());
    }
}