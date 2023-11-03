/**
 * 1441. Build an Array With Stack Operations
 * 
 * Intuition
 * 
 * we need to return stack operations needed to create an array equal to the
 * target
 * As it is evident we can use two ptrs to solve this problem
 * i->n, j->target
 * we will traverse target and n
 * we will add push to res symbolizing adding no to stack
 * if target[j]==i, we will move to next index of target j++
 * else we will add pop to res symbolizing removing no from stack
 * Finally return res
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(1), res array is not counted
 * 
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> res = new ArrayList();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            res.add("Push");
            if (target[j] == i)
                j++;
            else
                res.add("Pop");
        }
        return res;
    }
}