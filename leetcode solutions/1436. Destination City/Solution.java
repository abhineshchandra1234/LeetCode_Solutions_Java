/**
 * 1436. Destination City
 * 
 * Intuition
 * 
 * credits FunBam
 * I arrived at the solution by seeing dificulty level :P
 * It is evident from the question we need to add all the stations in a set and
 * remove the source stations
 * You can further optimize it by adding only the destination stns as the ans is
 * part of it.
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
class Solution {
    public String destCity(List<List<String>> paths) {

        Set<String> set = new HashSet();
        for (List<String> l : paths)
            set.add(l.get(1));
        for (List<String> l : paths)
            set.remove(l.get(0));
        return set.iterator().next();
    }
}