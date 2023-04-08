/**
 * 133. Clone Graph
 * 
 * Intuition
 * We will solve this problem using HashMap and bfs
 * We will use bfs to traverse the nodes and find its neighs then we will add
 * these neighs to the new node.
 * HashMap will contain orginal and new node mapping
 * 
 * Approach
 * Add to root node to queue then do bfs to find its neighs
 * Add neighs to the hashmap and queue if not already present
 * Then add neighs to the new node
 * 
 * Complexity
 * Time complexity: O(V+E)
 * Space complexity: O(V+E)
 */

/*
 * BFS Code
 * 
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * public Node() {
 * val = 0;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val) {
 * val = _val;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val, ArrayList<Node> _neighbors) {
 * val = _val;
 * neighbors = _neighbors;
 * }
 * }
 */

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap();
        map.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node curr = q.poll();
                for (Node neigh : curr.neighbors) {
                    if (!map.containsKey(neigh)) {
                        map.put(neigh, new Node(neigh.val));
                        q.add(neigh);
                    }
                    map.get(curr).neighbors.add(map.get(neigh));
                }
            }
        }
        return map.get(node);
    }
}

/*
 * DFS Code
 * 
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * public Node() {
 * val = 0;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val) {
 * val = _val;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val, ArrayList<Node> _neighbors) {
 * val = _val;
 * neighbors = _neighbors;
 * }
 * }
 */

class Solution {
    HashMap<Node, Node> map = new HashMap();

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);

        map.put(node, new Node(node.val));
        for (Node neigh : node.neighbors) {
            map.get(node).neighbors.add(cloneGraph(neigh));
        }

        return map.get(node);
    }
}