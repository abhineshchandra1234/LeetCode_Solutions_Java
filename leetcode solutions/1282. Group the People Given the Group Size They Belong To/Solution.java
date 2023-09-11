/**
 * 1282. Group the People Given the Group Size They Belong To
 * 
 * Intuition
 * 
 * the questions says we need to return a list of groups, where list size is
 * equal to group size in it.
 * we will use an hashmap to create a list of groups of similar size
 * As soon as the list size become equal to the group size in it, we will add
 * the list to the res and reset list to empty in hashmap.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> res = new ArrayList();
        Map<Integer, List<Integer>> groups = new HashMap();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = groups.computeIfAbsent(groupSizes[i],
                    k -> new ArrayList());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                res.add(list);
                groups.put(groupSizes[i], new ArrayList());
            }
        }

        return res;
    }
}