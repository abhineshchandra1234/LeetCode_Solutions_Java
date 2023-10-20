/**
 * 341. Flatten Nested List Iterator
 * 
 * Intuition
 * 
 * The hero of this problem is NestedInteger and its three methods isInteger,
 * getInteger and getList
 * A list of NestedInteger is given in the question and we need to flatten it
 * NestedInteger will either contain an integer or a list of NestedInteger
 * we will solve this problem using recursion and an helper method that will
 * process the NestedInteger
 * In the NestedIterator method we will simply traverse the NestedInteger list
 * and pass its value to helper method for processing
 * the helper method will check if the NestedInteger value is integer using
 * isInteger, if it is fetch its value using getInteger and add to res
 * If the value is not an integer, fetch list using method getList, traverse it
 * and pass its value to the helper method
 * to implement next as visible in the question just use a var curr whose value
 * will start at 0, return res value at curr
 * to implement hasNext compare curr value with res size.
 * radhe radhe :)
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * NestedIterator - O(n), next - O(1), hasNext - O(1)
 * 
 * Space complexity: O(1)
 * 
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> flattenList = null;
    int current = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList();
        for (NestedInteger integer : nestedList) {
            helper(integer);
        }
    }

    @Override
    public Integer next() {
        return flattenList.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current < flattenList.size();
    }

    private void helper(NestedInteger value) {
        if (value.isInteger())
            flattenList.add(value.getInteger());
        else {
            for (NestedInteger integer : value.getList()) {
                helper(integer);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */