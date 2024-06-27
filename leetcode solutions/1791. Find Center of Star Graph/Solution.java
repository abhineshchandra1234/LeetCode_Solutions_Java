/**
 * 1791. Find Center of Star Graph
 * 
 * Intuition
 * 
 * There are n nodes, marked from 1 to n
 * we are given edges array, where edge[i] = [ui, vi],there is an edge between
 * ui and vi nodes
 * we need to return the center node to which all nodes are connected.
 * In star graph all nodes will be connected to the center node
 * so center node will be present in all edges
 * so we figure out the center node using first two edges
 * If first node of first edge is present in second edge it is our answer ie
 * center node
 * If it's not, second node of first edge is our answer
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(1)
 * 
 * Space complexity: O(1)
 * 
 */
class Solution {

    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}