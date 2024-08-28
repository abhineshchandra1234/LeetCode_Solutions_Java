/**
 * 2053. Kth Distinct String in an Array
 * 
 * Intuition
 * we are given array of Strings arr and also given integer k
 * we need to return kth distinct string or empty string if its not available
 * 
 * Approach
 * we can solve it using set, but we need to use two sets
 * one for duplicate and another for distinct
 * here we are solving it using hashmap, for simplification
 * we will store freq of each string in hashmap
 * then we will again traverse strings, if the freq is 1, k will be reduced
 * when k reaches 0 return the string
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {

    public String kthDistinct(String[] arr, int k) {

        HashMap<String, Integer> map = new HashMap();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (map.get(s) == 1)
                k--;
            if (k == 0)
                return s;
        }

        return "";
    }
}