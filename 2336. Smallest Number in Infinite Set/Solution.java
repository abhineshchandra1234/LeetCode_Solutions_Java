/**
 * 2336. Smallest Number in Infinite Set
 * 
 * Intuition
 * It has straight forward solution
 * we will use min heap and add 1 to 1000 nos
 * on popSmallest we will pop the heap and return it
 * on addBack we will check if heap doesnt contain no then add it.
 * We can also solve this using TreeSet, in that all elements are sorted by
 * default.
 * 
 * Complexity
 * Time complexity:
 * addBack - O(logn)
 * 
 * popSmallest - O(1)
 * 
 * SmallestInfiniteSet - O(n)
 * 
 * Space complexity: O(n)
 */
class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++)
            pq.add(i);
    }

    public int popSmallest() {
        return pq.poll();
    }

    public void addBack(int num) {
        if (!pq.contains(num))
            pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */