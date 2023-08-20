/**
 * 1203. Sort Items by Groups Respecting Dependencies
 * 
 * Intuition
 * 
 * we will solve this problem using topological sorting
 * Topological sorting returns a order of tasks in which we can excute it, the
 * task which has 0 dependency comes first.
 * The question is asking us to return a list of sorted groups and each group
 * contains list of sorted nodes.
 * we will first construct itemGraph and groupGraph using prev items, prev items
 * are acting as dependencies.
 * then we will obtain topological list for itemGraph and groupGraph
 * Then we will traverse items topological list and add them to proper groups.
 * In this way we will get a sorted list of items for each group
 * Then traverse group list and add items of each group to result
 * This way we are getting a list of sorted groups with sorted items.
 * 
 * Complexity
 * 
 * Time complexity:
 * 
 * O(n^2), topogical sorting, there are n^2 (prev,curr) items
 * 
 * Space complexity:
 * 
 * O(n)
 * 
 */
class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // assigning unique group id to item without group
        // for topological sorting
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId;
                groupId++;
            }
        }

        // itemGraph
        Map<Integer, List<Integer>> itemGraph = new HashMap();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; i++)
            itemGraph.put(i, new ArrayList());

        // groupGraph
        Map<Integer, List<Integer>> groupGraph = new HashMap();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; i++)
            groupGraph.put(i, new ArrayList());

        // create itemGraph & groupGraph
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                itemGraph.get(prev).add(curr);
                itemIndegree[curr]++;

                if (group[curr] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[curr]);
                    groupIndegree[group[curr]]++;
                }
            }
        }

        // topological sort nodes in graph, return an empty list if cycle exists
        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);

        if (itemOrder.isEmpty() || groupOrder.isEmpty())
            return new int[0];

        // items are sorted regardless of groups,
        // we need to add them to groups they belong
        Map<Integer, List<Integer>> orderedGroups = new HashMap();
        for (Integer item : itemOrder)
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList()).add(item);

        // concatenate sorted items from sorted group
        List<Integer> answerList = new ArrayList();
        for (int groupIndex : groupOrder)
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList()));

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer key : graph.keySet()) {
            if (indegree[key] == 0) {
                stack.add(key);
            }
        }

        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            visited.add(curr);

            for (Integer prev : graph.get(curr)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    stack.add(prev);
                }
            }
        }

        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
}