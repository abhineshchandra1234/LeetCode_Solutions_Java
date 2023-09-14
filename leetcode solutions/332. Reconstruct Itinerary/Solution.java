/**
 * 332. Reconstruct Itinerary
 * 
 * Intuition
 * 
 * credits StefanPochmann
 * It is a grpah problem
 * First we will create a graph by doing mapping of source and destination
 * we are using minHeap to sort destinations.
 * we are using map to create a graph
 * Then we will do DFS starting from JFK to find the valid main path
 * When there is no more path we will travel backwards and add all the sub-paths
 * to the main path.
 * 
 * Approach
 * 
 * Input: tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * stack is ["SFO"],["ATL"],["SFO"],["JFK"],["ATL"],["JFK"]
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(nlogn), sorting the destinations lexicographicaly
 * 
 * Space complexity:
 * 
 * O(n)
 * 
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> targets = new HashMap();
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}