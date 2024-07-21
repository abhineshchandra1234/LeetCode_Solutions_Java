# Important Algorithms


## Kahn's algorithm (Topological Sorting)
- It is used to order vertices in a directed graph
- where there is a directed edge from vertex A to vertex B, A comes before B in the order
- The algorithm find vertices with no incoming edges, removing them from the graph and updating edges of the remaining vertices
- This process continues until all vertices are ordered

### References
- [Kahn’s algorithm for Topological Sorting](https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/)