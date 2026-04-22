// 2452. Words Within Two Edits of Dictionary

/**
 * Intuition
 * we will solve this problem using brute force
 * we will compare every query with each string in dictonary
 * if the length of diff for query is equal or less than 2, we will add that in
 * res
 * Finally return res
 * Approach
 * 
 * Complexity
 * Time complexity:O(q*d*n), n = query length
 * Space complexity: O(1)
 */

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList();
        for (String query : queries) {
            for (String s : dictionary) {
                int diff = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i))
                        diff++;
                    if (diff > 2)
                        break;
                }
                if (diff <= 2) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }
}