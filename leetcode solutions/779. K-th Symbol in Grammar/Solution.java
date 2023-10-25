/**
 * 779. K-th Symbol in Grammar
 * 
 * Intuition
 * 
 * credits grandyang
 * we will solve this problem using recursion
 * we can better understand it with help of binary tree where 0 will be root
 * node
 * Every parent node 0 will have 0 as left child & 1 as right child
 * Every parent node 1 will have 1 as left child & 0 as right child
 * Since the array is 0 indexed, every odd node will be left node & even node
 * will be right node
 * even node will have parent in prev row at k/2
 * odd node will have parent in prev row at k+1/2
 * it will recursively move to first row calculate value there then pass value
 * down and calculate in between till n
 * 
 * Approach
 * 
 * we will first check if the node is even or odd, based on it we will fetch
 * parent value
 * if the node is even and parent is 0 then right value of 0 is returned ie 1
 * if the node is even and parent is 1 then right value of 1 is returned ie 0
 * similar case will be for odd node
 * Its base case is when n=1, res is 0, since the table is 1-indexed.
 * 
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public int kthGrammar(int n, int k) {

        if (n == 1)
            return 0;

        if (k % 2 == 0)
            return kthGrammar(n - 1, k / 2) == 0 ? 1 : 0;
        else
            return kthGrammar(n - 1, (k + 1) / 2) == 0 ? 0 : 1;
    }
}