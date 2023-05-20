/**
 * 399. Evaluate Division
 * 
 * Intuition
 * credits GraceMeng
 * We will solve this using directed weighted graph
 * For a/b = 2, b/c = 3, b/a = 1/2;
 * we will create a graph using all vertices
 * a--2--b, b--3--c, b--1/2--a
 * for a/c
 * the path is a--2--b, b--3--c
 * we will calcultae result by finding path between a and c node using dfs on
 * the graph and multiplying weight of edges passed.
 * here 2 * 3 = 6
 * you can see we have repeated node from a--2--b, b--1/2--a here a is already
 * visted. we will avoid this using visited set.
 * 
 * Complexity
 * Time complexity:
 * O(Q*(E+V))
 * 
 * No of queries * dfs of graph
 * 
 * Space complexity:
 * 
 * O(V + (E+V))
 * visited + graph space
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Build graph
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);
        }

        return result;
    }

    private double getPathWeight(String start, String end, Set<String> visited,
            Map<String, Map<String, Double>> graph) {

        // Rejection case
        if (!graph.containsKey(start))
            return -1.0;

        // Acception case
        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);

        visited.add(start);
        for (Map.Entry<String, Double> neig : graph.get(start).entrySet()) {
            if (!visited.contains(neig.getKey())) {
                double productWeight = getPathWeight(neig.getKey(), end, visited, graph);
                if (productWeight != -1.0)
                    return neig.getValue() * productWeight;
            }
        }
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap();
        String u, v;

        for (int i = 0; i < equations.size(); i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap());
            graph.get(v).put(u, 1 / values[i]);
        }

        return graph;
    }
}