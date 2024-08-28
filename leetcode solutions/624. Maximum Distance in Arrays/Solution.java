/**
 * 624. Maximum Distance in Arrays
 * 
 * Intuition
 * we are given 2d list arrays, which contain a list of many arrays sorted in
 * ascending order
 * we need to pick any two integers from two different arrays, and return max
 * distance
 * 
 * 
 * Approach
 * we will solve this using greedy approach
 * max distance will be difference of biggest and smallest of curr array ie 0th
 * element
 * or max distance can be difference of smallest and largest of curr array ie
 * nth element
 * Again biggest can be updated with the biggest of the curr array ie nth no
 * Again smallest can be updated with the smallest of the curr array ie 0th no
 * 
 * 
 * Complexity
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

class Solution {

    public int maxDistance(List<List<Integer>> arrays) {

        int smallest = arrays.get(0).get(0);
        int largest = arrays.get(0).get(arrays.get(0).size() - 1);
        int dis = 0;

        for (int i = 1; i < arrays.size(); i++) {

            int first = arrays.get(i).get(0);
            int last = arrays.get(i).get(arrays.get(i).size() - 1);

            dis = Math.max(dis, Math.abs(largest - first));
            dis = Math.max(dis, Math.abs(last - smallest));

            largest = Math.max(largest, last);
            smallest = Math.min(smallest, first);
        }

        return dis;
    }
}